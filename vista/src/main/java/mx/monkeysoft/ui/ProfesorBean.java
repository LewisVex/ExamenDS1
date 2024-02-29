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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mx.monkeysoft.DAO.ProfesorDAO;
import mx.monkeysoft.entidad.Profesor;

/**
 *
 * @author monkeysoft
 */

@ManagedBean (name = "profesorBean")
@ViewScoped
public class ProfesorBean implements Serializable {
    private List<Profesor> profesores;
    private ProfesorDAO profesorDAO;
    
    @PostConstruct
    public void init() {
        profesorDAO = new ProfesorDAO();
        profesores = profesorDAO.findAll();
    }

    // Getter para la lista de usuarios
    public List<Profesor> getProfesores() {
        return profesores;
    }
    
    public void eliminarProfesor(Profesor p) {
        profesores.remove(p);
        profesorDAO.delete(p);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "El profesor se eliminó correctamente"));
    }
}
