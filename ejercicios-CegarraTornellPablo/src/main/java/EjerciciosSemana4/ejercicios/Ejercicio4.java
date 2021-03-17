package EjerciciosSemana4.ejercicios;

import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import EjerciciosSemana4.acta.Acta;
import EjerciciosSemana4.acta.TipoCalificacion;
import EjerciciosSemana4.acta.TipoDiligencia;

public class Ejercicio4 {

	
	public static void main(String[] args) throws Exception {
		// Construir el contexto JAXB para las clases anotadas

		JAXBContext contexto = JAXBContext.newInstance("EjerciciosSemana4.acta");


		Acta acta = new Acta();
		
		//CONVOCATORIA
		acta.setConvocatoria("febrero");
		
		//CURSO
		GregorianCalendar calendar = new GregorianCalendar();
		XMLGregorianCalendar xmlCalendario = null;
		Date date = new Date();
		calendar.setTime(date);		
        xmlCalendario = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        acta.setCurso(xmlCalendario);
        
        //CALIFICACIONES
        
        TipoCalificacion calificacion1 = new TipoCalificacion();
        calificacion1.setNif("23322156M");
        calificacion1.setNota(10);
        acta.getCalificacion().add(calificacion1);
        
        TipoCalificacion calificacion2 = new TipoCalificacion();
        calificacion2.setNif("13322156M");
        calificacion2.setNombre("Pepe");
        calificacion2.setNota(8);
        acta.getCalificacion().add(calificacion2);
        
        //DILIGENCIA
        
        TipoDiligencia diligencia1 = new TipoDiligencia();
		XMLGregorianCalendar xmlCalendarioDiligencia = null;
		GregorianCalendar calendario = new GregorianCalendar();
        xmlCalendarioDiligencia = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendario);
        diligencia1.setFecha(xmlCalendarioDiligencia);
        
        diligencia1.setNif("13322156M");

        diligencia1.setNota(9.0);
        
        acta.getDiligencia().add(diligencia1);
        


		Marshaller marshaller = contexto.createMarshaller();
		marshaller.setProperty("jaxb.formatted.output", true);

		marshaller.marshal(acta, new File("xml/ejercicio-crearActa.xml"));

		System.out.println("fin.");
	}
}
