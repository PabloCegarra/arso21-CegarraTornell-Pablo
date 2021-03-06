package EjerciciosSemana4.bookle.dominio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
* <p>Clase Java para reserva complex type.
* 
* <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
* 
* <pre>
* &lt;complexType name="reserva"&gt;
*   &lt;complexContent&gt;
*     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
*       &lt;sequence&gt;
*         &lt;element name="alumno" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
*         &lt;element name="email" type="{http://www.um.es/bookle}tipo_email" minOccurs="0"/&gt;
*       &lt;/sequence&gt;
*     &lt;/restriction&gt;
*   &lt;/complexContent&gt;
* &lt;/complexType&gt;
* </pre>
* 
* 
*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reserva", propOrder = {
   "alumno",
   "email"
})
public class Reserva {

   @XmlElement(required = true)
   protected String alumno;
   protected String email;

   /**
    * Obtiene el valor de la propiedad alumno.
    * 
    * @return
    *     possible object is
    *     {@link String }
    *     
    */
   public String getAlumno() {
       return alumno;
   }

   /**
    * Define el valor de la propiedad alumno.
    * 
    * @param value
    *     allowed object is
    *     {@link String }
    *     
    */
   public void setAlumno(String value) {
       this.alumno = value;
   }

   /**
    * Obtiene el valor de la propiedad email.
    * 
    * @return
    *     possible object is
    *     {@link String }
    *     
    */
   public String getEmail() {
       return email;
   }

   /**
    * Define el valor de la propiedad email.
    * 
    * @param value
    *     allowed object is
    *     {@link String }
    *     
    */
   public void setEmail(String value) {
       this.email = value;
   }

}
