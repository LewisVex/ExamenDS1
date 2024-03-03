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
import mx.monkeysoft.persistencia.AbstractDAO;

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

}
