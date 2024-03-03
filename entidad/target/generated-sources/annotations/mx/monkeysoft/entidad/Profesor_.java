package mx.monkeysoft.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.monkeysoft.entidad.Unidadaprendizaje;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-02T08:49:46")
@StaticMetamodel(Profesor.class)
public class Profesor_ { 

    public static volatile ListAttribute<Profesor, Unidadaprendizaje> unidadaprendizajeList;
    public static volatile SingularAttribute<Profesor, Integer> idProfesor;
    public static volatile SingularAttribute<Profesor, String> apellido;
    public static volatile SingularAttribute<Profesor, String> nombre;
    public static volatile SingularAttribute<Profesor, String> rfc;

}