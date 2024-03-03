/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.monkeysoft.delegate;

import java.util.List;
import mx.monkeysoft.entidad.Profesor;
import mx.monkeysoft.integracion.ServiceLocator;

/**
 *
 * @author monkeysoft
 */
public class DelegateProfesor {

    /**
     * @param profesor de tipo usuario con id 0 para que se cree un id nuevo
     */
    public void saveProfesor(Profesor profesor) {
        ServiceLocator.getInstanceProfesorDao().save(profesor);
    }

    public List<Profesor> getProfesores(int id) {
        return ServiceLocator.getInstanceProfesorDao().findProfesoresByUnidadAprendizaje(id);
    }

    public void removeProfesor(Profesor profesor) {
        ServiceLocator.getInstanceProfesorDao().delete(profesor);
    }
    
    public List<Profesor> getProfesoresStandard(){
        return ServiceLocator.getInstanceProfesorDao().findAll();
    }
}
