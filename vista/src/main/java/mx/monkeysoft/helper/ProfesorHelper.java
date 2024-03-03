/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.monkeysoft.helper;

import java.io.Serializable;
import java.util.List;
import mx.monkeysoft.entidad.Profesor;
import mx.monkeysoft.integracion.ServiceFacadeLocator;

/**
 *
 * @author monkeysoft
 */
public class ProfesorHelper implements Serializable {
    
    /**
     * Metodo para obtener todas los profesores
     * llamara a la instancia de facadeProfesor
     * @return 
     */
    public List<Profesor> getAll() {
        return ServiceFacadeLocator.getInstanceFacadeProfesor().obtenerProfesores();
    }
    
    public void remove(Profesor profesor) {
        ServiceFacadeLocator.getInstanceFacadeProfesor().eliminarProfesor(profesor);
    }
}
