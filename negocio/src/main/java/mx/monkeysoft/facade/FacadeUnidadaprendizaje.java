/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.monkeysoft.facade;

import mx.monkeysoft.delegate.DelegateUnidadaprendizaje;
import mx.monkeysoft.entidad.Unidadaprendizaje;

/**
 *
 * @author monkeysoft
 */
public class FacadeUnidadaprendizaje {
    private final DelegateUnidadaprendizaje delegateUnidadaprendizaje;
    
    public FacadeUnidadaprendizaje(){
        this.delegateUnidadaprendizaje = new DelegateUnidadaprendizaje();
    }
    
    public void guardarUnidadaprendizaje(Unidadaprendizaje UA){
        delegateUnidadaprendizaje.saveUnidadaprendizaje(UA);
    }
}
