/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.monkeysoft.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.monkeysoft.entidad.Profesor;
import mx.monkeysoft.entidad.Unidadaprendizaje;
import mx.monkeysoft.persistencia.AbstractDAO;
import mx.monkeysoft.persistencia.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author monkeysoft
 */
public class ProfesorDAO extends AbstractDAO<Integer, Profesor> {

    public List<Profesor> findProfesoresByUnidadAprendizaje(int unidadAprendizajeId) {
        String query = "SELECT p FROM Profesor p JOIN p.unidadaprendizajeList u WHERE u.id = :unidadAprendizajeId";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("unidadAprendizajeId", unidadAprendizajeId);
        return super.findManyResult(query, parameters);
    }

    public boolean registerProfesor(int idProfesor, int idUnidadAprendizaje) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean isSuccess = false;

        try {
            transaction = session.beginTransaction();
            String sql = "INSERT INTO registroProfesor (idProfesor, idUnidadAprendizaje) VALUES "
                    + "((SELECT idProfesor from Profesor p WHERE p.idProfesor = :idProfesor), "
                    + "(SELECT idUnidadAprendizaje FROM unidadAprendizaje ua WHERE ua.idUnidadAprendizaje = :idUnidadAprendizaje)"
                    + ")";
            Query query = session.createSQLQuery(sql);
            query.setParameter("idProfesor", idProfesor);
            query.setParameter("idUnidadAprendizaje", idUnidadAprendizaje);
            int result = query.executeUpdate();
            transaction.commit();

            isSuccess = result > 0;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return isSuccess;
    }

    public void deleteFromRegistroProfesor(int idProfesor, int idUnidadaprendizaje) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("DELETE FROM registroProfesor WHERE idProfesor = :profesorId AND idUnidadAprendizaje = :unidadId");
            query.setParameter("profesorId", idProfesor);
            query.setParameter("unidadId", idUnidadaprendizaje);
            query.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
