package collection;

import collection.Problema;
import java.sql.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-28T17:19:12", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Activista.class)
public class Activista_ { 

    public static volatile SingularAttribute<Activista, Date> fechaInicio;
    public static volatile SetAttribute<Activista, Problema> problemas;
    public static volatile SingularAttribute<Activista, Integer> id;
    public static volatile SingularAttribute<Activista, String> telefono;
    public static volatile SingularAttribute<Activista, String> nombre;

}