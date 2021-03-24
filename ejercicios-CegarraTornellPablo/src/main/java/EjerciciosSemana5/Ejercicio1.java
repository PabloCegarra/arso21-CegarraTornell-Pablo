package EjerciciosSemana5;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ejercicio1 {
	
	public static void main(String[] args) throws Exception {
		
		
		// 1. Obtener una factoría
		DocumentBuilderFactory factoriaDOM = DocumentBuilderFactory.newInstance();

		// 2. Pedir a la factoría la construcción del analizador
		DocumentBuilder analizador = factoriaDOM.newDocumentBuilder();

		// 3. Analizar el documento
		Document documento = analizador.parse("xml/bookle-actividad.xml");

		/** XPath **/
		
		// 1. Obtener la factoría
		XPathFactory factoria = XPathFactory.newInstance();
		
		// 2. Construir el evaluador XPath
		XPath xpath = factoria.newXPath();

		/** Consultas XPath 
			Las fechas de los días de la agenda.
			El horario de los turnos de un día concreto de la agenda (elige un día que esté en el documento).
			El horario de los turnos que tienen reserva.
			El email de las reservas.
			Las fechas de la agenda de un mes concreto (por ejemplo, abril de 2021).
			El primer turno de todos los días de la agenda.
			El último turno de todos los días de la agenda.
		 **/
		
		//Las fechas de los días de la agenda.
		XPathExpression consulta = xpath.compile("/actividad/agenda/fecha"); 
		//El horario de los turnos de un día concreto de la agenda (elige un día que esté en el documento).
		consulta = xpath.compile("/actividad/agenda/turno[2]/horario");
		
		//El horario de los turnos que tienen reserva.
		consulta = xpath.compile("/actividad/agenda/turno/reserva/../horario");
		
		//El email de las reservas.
		consulta = xpath.compile("/actividad/agenda/turno/reserva/email");
		
		//El primer turno de todos los días de la agenda.
		consulta = xpath.compile("/actividad/agenda/turno[1]");
		
		//El último turno de todos los días de la agenda.
		consulta = xpath.compile("/actividad/agenda/turno[last()]");
		
		
		NodeList resultado = (NodeList) consulta.evaluate(
				documento, XPathConstants.NODESET);
		
		
		// Recorro los resultados
		for (int i = 0; i < resultado.getLength(); i++) {
			
			Node nodo = resultado.item(i);
			
			System.out.println("Nodo: " + nodo.getNodeName());
			System.out.println("Contenido: " + nodo.getTextContent());
			
			
		}
		
		
		
		System.out.println("fin.");
	}

}
