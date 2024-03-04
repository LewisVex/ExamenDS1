/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.monkeysoft.ui;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import mx.monkeysoft.entidad.Profesor;
import mx.monkeysoft.entidad.Unidadaprendizaje;
import mx.monkeysoft.entidad.Users;
import mx.monkeysoft.facade.FacadeProfesor;
import mx.monkeysoft.facade.FacadeUnidadaprendizaje;
import mx.monkeysoft.facade.FacadeUsers;

/**
 *
 * @author monkeysoft
 */
@ManagedBean(name = "adminBean")
@RequestScoped
public class AdminBean implements Serializable {

    private Profesor profesor;
    private Users usuario;
    private Unidadaprendizaje ua;
    private boolean isadmin;

    @PostConstruct
    public void init() {
        this.profesor = new Profesor();
        this.usuario = new Users();
        this.ua = new Unidadaprendizaje();
    }

    public String getContextPath() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        return externalContext.getRequestContextPath();
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
    
    public Unidadaprendizaje getUnidadaprendizaje(){
        return this.ua;
    }
    
    public void setUnidadaprendizaje (Unidadaprendizaje unidada){
        this.ua = unidada;
    }
    
    public void saveProfesor() throws ValidatorException {
        FacadeProfesor fp = new FacadeProfesor();
        this.profesor.setNombre(this.profesor.getNombre().toUpperCase());
        this.profesor.setApellido(this.profesor.getApellido().toUpperCase());
        this.profesor.setRfc(this.profesor.getRfc().toUpperCase());
        fp.guardarProfesor(this.profesor);
    }

    public void saveUsuario() throws Exception {
        FacadeUsers fu = new FacadeUsers();
        if (isadmin) {
            this.usuario.setRol("admin");
        } else {
            this.usuario.setRol("prof");
        }
        this.usuario.setNombreUsuario(this.profesor.getNombre());
        fu.saveUsario(this.usuario);
    }

    public String saveRegistro() {
        try {
            saveProfesor();
            saveUsuario();
            return "menuOpciones?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡Error!", "No se pudo realizar el registro, favor de revisar el formulario"));
            return null;
        }
    }
    
    public String saveUnidad(){
        try{
            FacadeUnidadaprendizaje fua = new FacadeUnidadaprendizaje();
            this.ua.setNombre(this.ua.getNombre().toUpperCase());
            fua.guardarUnidadaprendizaje(this.ua);
            return "menuOpciones?faces-redirect=true";
        }catch(Exception e){
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo realizar el registro"));
        }
        
        return null;
    }
}
