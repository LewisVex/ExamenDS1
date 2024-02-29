/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.monkeysoft.ui;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.monkeysoft.entidad.Users;
import mx.monkeysoft.helper.LoginHelper;

/**
 *
 * @author monkeysoft
 */
@ManagedBean(name = "loginUI")
@SessionScoped
public class LoginBeanUI implements Serializable{
    private LoginHelper loginHelper;
    private Users usuario;
    
    public LoginBeanUI() {
        loginHelper = new LoginHelper();
    }
    
    /**
     * Metodo postconstructor todo lo que este dentro de este metodo
     * sera la primero que haga cuando cargue la pagina
     */
    @PostConstruct
    public void init(){
        usuario= new Users();
    }

     public String login() throws IOException{
        // cambiar URL de la página de inicio dependiendo si es admin o profesor
        String appURL = "/profesores/consulta?faces-redirect=true";
        // los atributos de usuario vienen del xhtml 
        Users us= new Users();
        us = loginHelper.Login(usuario.getCorreo(), usuario.getContrasena());
        if(us != null && us.getIdUsuario()!=null){
            // asigno el usuario encontrado al usuario de esta clase para que 
            // se muestre correctamente en la pagina de informacion
            usuario=us;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bien:", "Bien"));
            return appURL;
            
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario o contraseña incorrecta:", "Intente de nuevo"));          
        }
        
        return null;
    }

    
    /* getters y setters*/

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }
    
    
    
    
    
    
    
    

    

    
}
