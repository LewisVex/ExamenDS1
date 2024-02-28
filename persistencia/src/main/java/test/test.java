/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.List;
import mx.monkeysoft.DAO.UsersDAO;
import mx.monkeysoft.entidad.Users;

/**
 *
 * @author monkeysoft
 */
public class test {
    public static void main(String[] args) {
        List<Users> listUsers = new ArrayList();
        UsersDAO usersDao = new UsersDAO();
        listUsers = usersDao.findAll();
        
        for(Users us : listUsers){
            System.out.println("Correo: " + us.getCorreo());
        }
    }
}
