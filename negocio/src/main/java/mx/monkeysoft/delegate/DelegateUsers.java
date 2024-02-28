/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.monkeysoft.delegate;

import java.util.List;
import mx.monkeysoft.entidad.Users;
import mx.monkeysoft.integracion.ServiceLocator;

/**
 *
 * @author monkeysoft
 */
public class DelegateUsers {
    
    /**
     * Metodo para verificar si el usuario esta registrado en la bd
     * @param contrasena 
     * @param correo
     * @return un tipo usuario si no encuntra el usuario sera null
     */
    public Users login(String contrasena, String correo){
        Users usuario = new Users();
        List<Users> usuarios = ServiceLocator.getInstanceUsersDAO().findAll();
        
        for(Users us:usuarios){
            if(us.getContrasena().equalsIgnoreCase(contrasena) && us.getCorreo().equalsIgnoreCase(correo)){
                usuario = us;
            }
        }
        return usuario;
    }
    
    /**
     * @param usuario de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    public void saveUsario(Users usuario){
        ServiceLocator.getInstanceUsersDAO().save(usuario);
    }
    
}
