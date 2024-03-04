/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.monkeysoft.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.monkeysoft.entidad.Profesor;
import mx.monkeysoft.entidad.Unidadaprendizaje;
import mx.monkeysoft.helper.ProfesorHelper;
import mx.monkeysoft.helper.UnidadaprendizajeHelper;

/**
 *
 * @author monkeysoft
 */

@ManagedBean (name = "profesorBean")
@SessionScoped
public class ProfesorBean implements Serializable {
    private List<Profesor> profesores;
    private ProfesorHelper profesorHelper;
    private Profesor prof;
    private List<Unidadaprendizaje> unidades;
    private UnidadaprendizajeHelper uah;
    
    @PostConstruct
    public void init() {
        profesorHelper = new ProfesorHelper();
        profesores = profesorHelper.getStandard();
        uah = new UnidadaprendizajeHelper();
    }
    
    public Profesor getProf(){
        return this.prof;
    }
    
    public void setProf(Profesor profe){
        this.prof = profe;
    }
    
    public List<Unidadaprendizaje> getUnidades(){
        refreshProfesor();
        return this.unidades;
    }
    
    
    // Getter para la lista de usuarios
    public List<Profesor> getProfesores() {
        return profesores;
    }
    
    public void eliminarProfesor(Profesor p) {
        profesores.remove(p);
        profesorHelper.remove(p);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "El profesor se eliminó correctamente"));
    }
    
    public String viewProfesorUnidades(Profesor p){
        this.prof = p;
        this.unidades = uah.getByProf(this.prof.getIdProfesor());
        return "/profesores/unidades";
    }
    
    public void refreshProfesor() {
        this.unidades = uah.getByProf(this.prof.getIdProfesor());
    }
}
