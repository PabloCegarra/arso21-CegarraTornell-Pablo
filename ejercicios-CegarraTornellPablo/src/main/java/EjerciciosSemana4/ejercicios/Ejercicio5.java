package EjerciciosSemana4.ejercicios;

import java.io.File;
import java.util.LinkedList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import EjerciciosSemana4.ejercicios.poema.Poema;

public class Ejercicio5 {
	public static void main(String[] args) throws Exception {
		// Construir el contexto JAXB para las clases anotadas

		JAXBContext contexto = JAXBContext.newInstance(Poema.class);


		Poema poema = new Poema();

		poema.setFecha("Abril de 1915");
		poema.setLugar("Granada");
		poema.setTitulo("Alba");
		poema.setVerso(new LinkedList<String>());
		poema.getVerso().add("Mi corazón oprimido");
		poema.getVerso().add("siente junto a la alborada");
		poema.getVerso().add("el dolor de sus amores");
		poema.getVerso().add("y el sueño de las distancias.");
        


		Marshaller marshaller = contexto.createMarshaller();
		marshaller.setProperty("jaxb.formatted.output", true);

		marshaller.marshal(poema, new File("xml/ejercicio-crearPoema.xml"));

		System.out.println("fin.");
	}
}
