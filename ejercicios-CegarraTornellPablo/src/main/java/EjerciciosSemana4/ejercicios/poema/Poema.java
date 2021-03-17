package EjerciciosSemana4.ejercicios.poema;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "poema")
public class Poema {
	
    @XmlAttribute(name = "fecha", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String fecha;

    @XmlAttribute(name = "lugar", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String lugar;
    
    @XmlElement(required = true)
    protected String titulo;
    
    @XmlElement(required = true)
    protected List<String> verso;
    
    
    public String getFecha() {
		return fecha;
	}
    public String getLugar() {
		return lugar;
	}
    public String getTitulo() {
		return titulo;
	}
    public List<String> getVerso() {
		return verso;
	}
    public void setFecha(String fecha) {
		this.fecha = fecha;
	}
    public void setLugar(String lugar) {
		this.lugar = lugar;
	}
    public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
    public void setVerso(List<String> verso) {
		this.verso = verso;
	}
    
	
}
