package EjerciciosSemana4.ejercicios;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import EjerciciosSemana4.acta.Acta;
import EjerciciosSemana4.acta.TipoCalificacion;

public class Ejercicio3 {
	public static void main(String[] args) throws Exception {
		// Construir el contexto JAXB para las clases anotadas

		JAXBContext contexto = JAXBContext.newInstance("EjerciciosSemana4.acta");

		Unmarshaller unmarshaller = contexto.createUnmarshaller();

		Acta acta = (Acta) unmarshaller.unmarshal(new File("xml/acta.xml"));

		List<TipoCalificacion> listaCalificaciones = acta.getCalificacion();

		for (int i = 0; i < listaCalificaciones.size(); i++) {
			Double notaAnterior = listaCalificaciones.get(i).getNota();
			if(notaAnterior <= 9.5)
				listaCalificaciones.get(i).setNota(notaAnterior + 0.5);
		}

		Marshaller marshaller = contexto.createMarshaller();
		marshaller.setProperty("jaxb.formatted.output", true);

		marshaller.marshal(acta, new File("xml/ejercicio-incrementar-nota.xml"));

		System.out.println("fin.");
	}
}
