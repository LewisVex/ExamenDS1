/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.monkeysoft.facade;

import java.util.List;
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
    
    public Unidadaprendizaje buscar(String nombre){
        return delegateUnidadaprendizaje.buscarPorNombre(nombre);
    }
    
    public List<Unidadaprendizaje> obtenerUnidadesaprendizaje() {
        return delegateUnidadaprendizaje.obtenerUnidadesaprendizaje();
    }
    
    public void asignarProfesor(int idProfesor, int idUnidadAprendizaje){
        delegateUnidadaprendizaje.asignarProfesor(idProfesor, idUnidadAprendizaje);
    }
    
    public void deleteProfesorFromUA(int idProfesor, int idUnidadAprendizaje){
        delegateUnidadaprendizaje.removeProfesor(idProfesor, idUnidadAprendizaje);
    }
    
    public List<Unidadaprendizaje> getByProf(int idProf){
        return delegateUnidadaprendizaje.getByProf(idProf);
    }
}
