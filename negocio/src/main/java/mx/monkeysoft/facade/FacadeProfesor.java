/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.monkeysoft.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.monkeysoft.delegate.DelegateProfesor;
import mx.monkeysoft.entidad.Profesor;

/**
 *
 * @author monkeysoft
 */
@Stateless
public class FacadeProfesor {

    @PersistenceContext
    private EntityManager em;
    private final DelegateProfesor delegateProfesor;

    public FacadeProfesor() {
        this.delegateProfesor = new DelegateProfesor();
    }

    public void guardarProfesor(Profesor profesor) {
        delegateProfesor.saveProfesor(profesor);
    }
}