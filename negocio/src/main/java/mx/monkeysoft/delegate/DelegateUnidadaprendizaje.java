/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.monkeysoft.delegate;

import mx.monkeysoft.entidad.Unidadaprendizaje;
import mx.monkeysoft.integracion.ServiceLocator;

/**
 *
 * @author monkeysoft
 */
public class DelegateUnidadaprendizaje {
    
    /**
     *
     * @param UA 
     */
    public void saveUnidadaprendizaje (Unidadaprendizaje UA){
        ServiceLocator.getInstanceUnidadaprendizajeDAO().save(UA);
    }
}
