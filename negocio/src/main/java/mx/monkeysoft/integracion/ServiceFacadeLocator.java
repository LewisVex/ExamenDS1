/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.monkeysoft.integracion;

import mx.monkeysoft.facade.FacadeProfesor;
import mx.monkeysoft.facade.FacadeUsers;
import mx.monkeysoft.facade.FacadeUnidadaprendizaje;

/**
 *
 * @author monkeysoft
 */
public class ServiceFacadeLocator {

    private static FacadeProfesor facadeProfesor;
    private static FacadeUsers facadeUsuario;
    private static FacadeUnidadaprendizaje facadeUnidadaprendizaje;

    public static FacadeProfesor getInstanceFacadeProfesor() {
        if (facadeProfesor == null) {
            facadeProfesor = new FacadeProfesor();
            return facadeProfesor;
        }
        return facadeProfesor;
    }

    public static FacadeUsers getInstanceFacadeUsers() {
        if (facadeUsuario == null) {
            facadeUsuario = new FacadeUsers();
            return facadeUsuario;
        }
        return facadeUsuario;
    }
    
    public static FacadeUnidadaprendizaje getInstanceFacadeUnidadaprendizaje(){
        if(facadeUnidadaprendizaje == null){
            facadeUnidadaprendizaje = new FacadeUnidadaprendizaje();
            return facadeUnidadaprendizaje;
        }
        return facadeUnidadaprendizaje;
    }
}
