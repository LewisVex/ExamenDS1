/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.monkeysoft.ui;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import mx.monkeysoft.DAO.ProfesorDAO;
import mx.monkeysoft.DAO.UnidadaprendizajeDAO;
import mx.monkeysoft.entidad.Profesor;

/**
 *
 * @author monkeysoft
 */
@ManagedBean(name = "adminBean")
@ViewScoped
public class AdminBean {
    private Profesor profesor;
    
    @PostConstruct
    public void init() {
        profesor = new Profesor();
    }

    // Getters and setters for 'profesor'
    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    public String saveProfesor() {
        try {
            ProfesorDAO pDAO = new ProfesorDAO();
            pDAO.save(this.profesor);
        } catch (Exception e) {
            return e.toString();
        }
        return "success";
    }   

}
