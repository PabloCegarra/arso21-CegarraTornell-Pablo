package EjerciciosSemana2;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ModificarActa {

	public static void main(String[] args) throws Exception {

		
		// 1. Obtener una factoría
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();

		// 2. Pedir a la factoría la construcción del analizador
		DocumentBuilder analizador = factoria.newDocumentBuilder();

		// 3. Analizar el documento
		Document documento = analizador.parse("xml/acta2.xml");


		//Nos quedamos con todas las calificaciones
		NodeList elementos = documento.getElementsByTagName("calificacion");
		
		//Recorremos las calificaciones quedandonos con las notas de cada una
		for (int i = 0; i < elementos.getLength() ; i++) {
			Element elemento = (Element) elementos.item(i);
			//Nos quedamos con la nota actual para adicionarle 0.5 y guardarla
			Double notaActual = Double.parseDouble(elemento.getElementsByTagName("nota").item(0).getTextContent());
			elemento.getElementsByTagName("nota").item(0).setTextContent(String.valueOf(notaActual + 0.5));
		}	
			
		
		
		// Guardar los cambios
		
		// 1. Construye la factoría de transformación y obtiene un 
		// transformador
		TransformerFactory tFactoria = TransformerFactory.newInstance(); 
		Transformer transformacion = tFactoria.newTransformer();
		
		// 2. Establece la entrada, como un árbol DOM 
		
		Source input = new DOMSource(documento);
		
		// 3. Establece la salida, un fichero en disco 
		Result output = new StreamResult("xml/acta-modificado.xml");
		// 4. Aplica la transformación 
		
		transformacion.transform(input, output);
		
		System.out.println("fin.");
	}
}
