package EjerciciosSemana4.ejercicios;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;

import EjerciciosSemana4.acta.Acta;
import EjerciciosSemana4.acta.TipoDiligencia;

public class Ejercicio2 {
	
	public static void main(String[] args) throws Exception {
		// Construir el contexto JAXB para las clases anotadas
		
		JAXBContext contexto = JAXBContext.newInstance("EjerciciosSemana4.acta");
		
		Unmarshaller unmarshaller = contexto.createUnmarshaller();
		
		Acta acta = (Acta) unmarshaller.unmarshal(new File("xml/acta.xml"));
		
		List<TipoDiligencia> listaDiligencias= acta.getDiligencia();
		
		int contadorDiligencias = 0;
		for(int i = 0; i < listaDiligencias.size(); i++) {
			XMLGregorianCalendar fecha = listaDiligencias.get(i).getFecha();
			Calendar fechaCalendario =  fecha.toGregorianCalendar();
			Calendar fechaMesAnterior = Calendar.getInstance();
			fechaMesAnterior.setTime(new Date());
			fechaMesAnterior.add(Calendar.MONTH, -1);
			if(fechaCalendario.after(fechaMesAnterior))
				contadorDiligencias++;
		}
		
	
		System.out.println("NUMERO DE DILIGENCIAS CONTADAS: "+ contadorDiligencias);
		System.out.println("\nfin.");
	}

}
