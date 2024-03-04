/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.monkeysoft.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.monkeysoft.entidad.Unidadaprendizaje;
import mx.monkeysoft.persistencia.AbstractDAO;

/**
 *
 * @author monkeysoft
 */
public class UnidadaprendizajeDAO extends AbstractDAO<Integer, Unidadaprendizaje> {

    public List<Unidadaprendizaje> findUnidadByProf(int idProfesor) {
        String query = "SELECT u FROM Unidadaprendizaje u JOIN u.profesorList p WHERE p.idProfesor = :idProfesor";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("idProfesor", idProfesor);
        return super.findManyResult(query, parameters);
    }
}
