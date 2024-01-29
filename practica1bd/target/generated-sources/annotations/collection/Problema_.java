package collection;

import collection.Activista;
import collection.Cliente;
import collection.Problema.Estado;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-28T17:19:12", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Problema.class)
public class Problema_ { 

    public static volatile SingularAttribute<Problema, Estado> estado;
    public static volatile SingularAttribute<Problema, Date> fechaInicio;
    public static volatile SetAttribute<Problema, Activista> activistas;
    public static volatile SingularAttribute<Problema, Integer> id;
    public static volatile SingularAttribute<Problema, Cliente> clienteProblema;
    public static volatile SingularAttribute<Problema, String> nombre;
    public static volatile SingularAttribute<Problema, Date> fechaFin;

}