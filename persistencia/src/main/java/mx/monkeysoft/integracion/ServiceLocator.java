/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.monkeysoft.integracion;

import mx.monkeysoft.DAO.ProfesorDAO;
import mx.monkeysoft.DAO.UsersDAO;
import mx.monkeysoft.DAO.UnidadaprendizajeDAO;

/**
 *
 * @author monkeysoft
 */
public class ServiceLocator {

    private static ProfesorDAO profesorDAO;
    private static UsersDAO usuarioDAO;
    private static UnidadaprendizajeDAO unidadaprendizajeDAO;

    /**
     * se crea la instancia para profesorDAO si esta no existe
     *
     * @return
     */
    public static ProfesorDAO getInstanceProfesorDao() {
        if (profesorDAO == null) {
            profesorDAO = new ProfesorDAO();
            return profesorDAO;
        }
        return profesorDAO;
    }

    /**
     * se crea la instancia de usersDAO si esta no existe
     *
     * @return
     */
    public static UsersDAO getInstanceUsersDAO() {
        if (usuarioDAO == null) {
            usuarioDAO = new UsersDAO();
            return usuarioDAO;
        }
        return usuarioDAO;
    }

    /**
     * se crea lainstancia de unidadaprendizajeDAO si ésta no existe
     *
     * @return
     */
    public static UnidadaprendizajeDAO getInstanceUnidadaprendizajeDAO() {
        if (unidadaprendizajeDAO == null) {
            unidadaprendizajeDAO = new UnidadaprendizajeDAO();
            return unidadaprendizajeDAO;
        }
        return unidadaprendizajeDAO;
    }

}
