/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.monkeysoft.ui;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import mx.monkeysoft.entidad.Profesor;
import mx.monkeysoft.entidad.Users;
import mx.monkeysoft.facade.FacadeProfesor;
import mx.monkeysoft.facade.FacadeUsers;

/**
 *
 * @author monkeysoft
 */
@ManagedBean(name = "adminBean")
@ViewScoped
public class AdminBean implements Serializable {

    private Profesor profesor;
    private Users usuario;
    private boolean isadmin;

    @PostConstruct
    public void init() {
        this.profesor = new Profesor();
        this.usuario = new Users();
    }

    public boolean getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    // Getters and setters for 'profesor'
    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }

    public void saveProfesor() throws Exception {
        FacadeProfesor fp = new FacadeProfesor();
        fp.guardarProfesor(this.profesor);
    }

    public String getContextPath() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        return externalContext.getRequestContextPath();
    }

    public void saveUsuario() throws Exception {
        FacadeUsers fu = new FacadeUsers();
        if (isadmin) {
            this.usuario.setRol("admin");
        } else {
            this.usuario.setRol("prof");
        }
        fu.saveUsario(this.usuario);
    }
}
