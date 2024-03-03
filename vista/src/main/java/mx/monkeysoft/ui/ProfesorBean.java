/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.monkeysoft.ui;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.monkeysoft.entidad.Profesor;
import mx.monkeysoft.helper.ProfesorHelper;

/**
 *
 * @author monkeysoft
 */

@ManagedBean (name = "profesorBean")
@SessionScoped
public class ProfesorBean implements Serializable {
    private List<Profesor> profesores;
    private ProfesorHelper profesorHelper;
    
    @PostConstruct
    public void init() {
        profesorHelper = new ProfesorHelper();
        profesores = profesorHelper.getAll();
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
}
