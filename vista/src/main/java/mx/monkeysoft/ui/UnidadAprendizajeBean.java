/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.monkeysoft.ui;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import mx.monkeysoft.entidad.Profesor;
import mx.monkeysoft.helper.UnidadaprendizajeHelper;
import mx.monkeysoft.entidad.Unidadaprendizaje;
import mx.monkeysoft.facade.FacadeUnidadaprendizaje;
import mx.monkeysoft.helper.ProfesorHelper;

/**
 *
 * @author monkeysoft
 */
@ManagedBean(name = "unidadAprendizajeBean")
@SessionScoped
public class UnidadAprendizajeBean implements Serializable {

    private UnidadaprendizajeHelper unidadHelper;
    private List<Unidadaprendizaje> unidades;
    private Unidadaprendizaje unidadAprendizaje;
    private List<Profesor> profesores;
    private int profidasignar;

    private ProfesorHelper profesorHelper;

    @PostConstruct
    public void init() {
        unidadHelper = new UnidadaprendizajeHelper();
        unidades = unidadHelper.getAll();
        unidadAprendizaje = new Unidadaprendizaje();
        profesorHelper = new ProfesorHelper();
        profesores = null;
    }
    
    public void validate() throws IOException {
    if (profesores == null) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect(externalContext.getRequestContextPath() + "/ua/consulta.xhtml");
    }
}

    public List<Unidadaprendizaje> getUnidades() {
        refreshUnidades();
        return unidades;
    }

    public void refreshUnidades() {
        unidades = unidadHelper.getAll();
    }

    //Este método consigue los profesores inscritos a las UA
    public String viewUnidadAprendizaje(Unidadaprendizaje unidad) {
        this.unidadAprendizaje = unidad;
        profesores = profesorHelper.getAll(this.unidadAprendizaje.getIdUnidadAprendizaje());
        return "/ua/profesores";
    }

    public int getProfidasignar() {
        return this.profidasignar;
    }

    public void setProfidasignar(int id) {
        this.profidasignar = id;
    }

    public Unidadaprendizaje getUnidadAprendizaje() {
        return unidadAprendizaje;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    //Este método debería regresar los profesores no inscritos a la UA
    public List<Profesor> getProfesoresDisponibles() {
        List<Profesor> profesoresDisponibles = profesorHelper.getStandard();
        if (this.profesores != null) {
            profesoresDisponibles.removeAll(profesores);
        }
        return profesoresDisponibles;
    }

    //Este método debería eliminar los profesores de una UA específica, no borrarlos de la BD sino eliminarlos de RegistroProfesor.
    public void removeProfesor(Profesor profe) {
        FacadeUnidadaprendizaje fua = new FacadeUnidadaprendizaje();
        fua.deleteProfesorFromUA(profe.getIdProfesor(), this.unidadAprendizaje.getIdUnidadAprendizaje());
    }

    public void asignarUnidad() {
        FacadeUnidadaprendizaje fua = new FacadeUnidadaprendizaje();
        fua.asignarProfesor(this.profidasignar, this.unidadAprendizaje.getIdUnidadAprendizaje());
    }
}
