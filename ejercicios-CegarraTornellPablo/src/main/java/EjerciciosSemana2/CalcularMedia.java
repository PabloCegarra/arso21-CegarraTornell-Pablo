package EjerciciosSemana2;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class CalcularMedia {

	public static void main(String[] args) throws Exception {

		
		Double sumaTotal= new Double(0);
		Integer totalCalificaciones = new Integer(0);
		// 1. Obtener una factoría
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();

		// 2. Pedir a la factoría la construcción del analizador
		DocumentBuilder analizador = factoria.newDocumentBuilder();

		// 3. Analizar el documento
		Document documento = analizador.parse("xml/acta.xml");


		//Nos quedamos con todas las calificaciones
		NodeList elementos = documento.getElementsByTagName("calificacion");
		totalCalificaciones = elementos.getLength();
		//Recorremos las calificaciones sumando las notas de cada una
		for (int i = 0; i < totalCalificaciones ; i++) {
			Element elemento = (Element) elementos.item(i);
			//Añadimos la nota parcial a la suma total
			sumaTotal += Double.parseDouble(elemento.getElementsByTagName("nota").item(0).getTextContent());
		}	
		//Mostramos la media de las calificaciones
		System.out.println("Nota media de las calificaciones: " + sumaTotal / totalCalificaciones);
		
		System.out.println("fin.");
	}
}
