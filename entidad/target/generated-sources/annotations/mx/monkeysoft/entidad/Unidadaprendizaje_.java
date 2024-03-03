package mx.monkeysoft.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.monkeysoft.entidad.Profesor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-02T21:34:25")
@StaticMetamodel(Unidadaprendizaje.class)
public class Unidadaprendizaje_ { 

    public static volatile SingularAttribute<Unidadaprendizaje, Integer> idUnidadAprendizaje;
    public static volatile SingularAttribute<Unidadaprendizaje, Integer> horasLab;
    public static volatile SingularAttribute<Unidadaprendizaje, Integer> horasClase;
    public static volatile ListAttribute<Unidadaprendizaje, Profesor> profesorList;
    public static volatile SingularAttribute<Unidadaprendizaje, String> nombre;
    public static volatile SingularAttribute<Unidadaprendizaje, Integer> horasTaller;

}