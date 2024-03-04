/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.monkeysoft.helper;

import java.io.Serializable;
import java.util.List;
import mx.monkeysoft.entidad.Unidadaprendizaje;
import mx.monkeysoft.integracion.ServiceFacadeLocator;

/**
 *
 * @author monkeysoft
 */
public class UnidadaprendizajeHelper implements Serializable {
    
    /**
     * Metodo para obtener todas las unidades de aprendizaje
     * llamara a la instancia de facadeUnidadaprendizaje
     * @return 
     */
    public List<Unidadaprendizaje> getAll() {
        return ServiceFacadeLocator.getInstanceFacadeUnidadaprendizaje().obtenerUnidadesaprendizaje();
    }
    
    public List<Unidadaprendizaje> getByProf(int idProf){
        return ServiceFacadeLocator.getInstanceFacadeUnidadaprendizaje().getByProf(idProf);
    }
}
