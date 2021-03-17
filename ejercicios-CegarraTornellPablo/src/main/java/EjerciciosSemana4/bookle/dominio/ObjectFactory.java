package EjerciciosSemana4.bookle.dominio;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.um.bookle package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.um.bookle
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Actividad }
     * 
     */
    public Actividad createActividad() {
        return new Actividad();
    }

    /**
     * Create an instance of {@link DiaActividad }
     * 
     */
    public DiaActividad createDiaActividad() {
        return new DiaActividad();
    }

    /**
     * Create an instance of {@link Turno }
     * 
     */
    public Turno createTurno() {
        return new Turno();
    }

    /**
     * Create an instance of {@link Reserva }
     * 
     */
    public Reserva createReserva() {
        return new Reserva();
    }

}
