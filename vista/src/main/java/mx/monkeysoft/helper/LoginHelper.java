/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.monkeysoft.helper;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import mx.monkeysoft.entidad.Profesor;
import mx.monkeysoft.entidad.Users;
import mx.monkeysoft.integracion.ServiceFacadeLocator;

/**
 *
 * @author monkeysoft
 */
public class LoginHelper implements Serializable{
    

    /**
     * Metodo para hacer login llamara a la instancia de usuarioFacade
     * @param correo
     * @param password
     * @return 
     */
    public Users Login(String correo, String password){
        return ServiceFacadeLocator.getInstanceFacadeUsers().login(password, correo);
    }
    
    
    
}
