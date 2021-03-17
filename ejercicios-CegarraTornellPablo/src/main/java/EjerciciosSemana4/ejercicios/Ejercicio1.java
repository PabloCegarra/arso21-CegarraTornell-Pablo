package EjerciciosSemana4.ejercicios;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import EjerciciosSemana4.acta.Acta;
import EjerciciosSemana4.acta.TipoCalificacion;


public class Ejercicio1 {

	
	public static void main(String[] args) throws Exception {
		// Construir el contexto JAXB para las clases anotadas
		
		JAXBContext contexto = JAXBContext.newInstance("EjerciciosSemana4.acta");
		
		Unmarshaller unmarshaller = contexto.createUnmarshaller();
		
		Acta acta = (Acta) unmarshaller.unmarshal(new File("xml/acta.xml"));
		
		List<TipoCalificacion> listaCalificaciones= acta.getCalificacion();
		
		Double sumaTotal = 0.0;
		for(int i = 0; i < listaCalificaciones.size(); i++) {
			sumaTotal += listaCalificaciones.get(i).getNota();
		}
		
		System.out.println("NOTA MEDIA: " + sumaTotal / listaCalificaciones.size());
		
		System.out.println("fin.");
	}
}
