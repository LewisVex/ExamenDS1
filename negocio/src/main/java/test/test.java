/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import mx.monkeysoft.entidad.Users;
import mx.monkeysoft.integracion.ServiceFacadeLocator;

/**
 *
 * @author monkeysoft
 */
public class test {
    public static void main(String[] args) {
        Users usuario = new Users();
        
        usuario = ServiceFacadeLocator.getInstanceFacadeUsers().login("contra123","francisco.reyes.parra@uabc.edu.mx");
        
        if(usuario.getIdUsuario() != null){
            System.out.println("Login exitoso con el correo: " + usuario.getCorreo());
        }else{
            System.out.println("No se encontro registro");
        }
    }
}
