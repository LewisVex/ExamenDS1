/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.monkeysoft.facade;

import mx.monkeysoft.delegate.DelegateUsers;
import mx.monkeysoft.entidad.Users;

/**
 *
 * @author monkeysoft
 */
public class FacadeUsers {
    
    private final DelegateUsers delegateUser;

    public FacadeUsers() {
        this.delegateUser = new DelegateUsers();
    }
    
     /**
     * Metodo para verificar si el usuario esta registrado en la bd
     * @param password 
     * @param correo
     * @return Regresa usuario si el correo y contrasena con correctos
     */
    public Users login(String password, String correo){
        return delegateUser.login(password, correo);
    }
    
    /**
     * Metodo de ejemplo para guardar Usuario
     * @param usuario de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    public void saveUsario(Users usuario){
        delegateUser.saveUsario(usuario);
    }
    
}
