/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mx.monkeysoft.DAO.ProfesorDAO;
import mx.monkeysoft.DAO.UnidadaprendizajeDAO;
import mx.monkeysoft.entidad.Profesor;
import mx.monkeysoft.entidad.Unidadaprendizaje;
import mx.monkeysoft.integracion.ServiceFacadeLocator;

/**
 *
 * @author monkeysoft
 */

@ManagedBean (name = "busquedaBean")
@ViewScoped
public class BusquedaBean implements Serializable {
    private Unidadaprendizaje unidadDeAprendizaje;
    private Unidadaprendizaje ua;
    private List<Profesor> profesores;
    
    @PostConstruct
    public void init() {
        unidadDeAprendizaje = new Unidadaprendizaje();
    }
    
    public void buscar() throws IOException{
        /*El input del usuario es asignado ya al nombre de unidadAprendizaje
        Se crea un objeto ua en el cual se regresa la unidadDeAprendizaje que concuerde con el nombre
        de unidadDeAprendizaje, o sea, el que haya ingresado el usuario*/
        ua = ServiceFacadeLocator.getInstanceFacadeUnidadaprendizaje().buscar(unidadDeAprendizaje.getNombre());
        /*Si el usa no es null, significa que si se encontró una unidad de aprendizaje
        con dicho nombre, se redirecciona a la página con dicha unidad */
        if(ua != null){
            unidadDeAprendizaje = ua;
            profesores = ua.getProfesorList();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "SE ENCONTRO!!!!", "Intente de nuevo"));          
        } else {
            unidadDeAprendizaje = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No se encontro una Unidad de Aprendizaje con ese nombre.", "Intente de nuevo"));          
        }
    }
    
    public void setUnidadDeAprendizaje(Unidadaprendizaje uda){
        this.unidadDeAprendizaje = uda;
    }
    
    public Unidadaprendizaje getUnidadDeAprendizaje(){
        return unidadDeAprendizaje;
    }
}
