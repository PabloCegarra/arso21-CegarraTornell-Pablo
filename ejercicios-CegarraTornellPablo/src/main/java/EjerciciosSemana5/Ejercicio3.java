package EjerciciosSemana5;

import java.io.FileReader;
import java.io.InputStreamReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Ejercicio3 {

	public static void main(String[] args) throws Exception {
		InputStreamReader fuente = new FileReader("json/Ejercicio2.json");
		JsonReader jsonReader = Json.createReader(fuente);
		JsonObject obj = jsonReader.readObject();

		// Obtenemos el array de notas
		Integer sumaNota = 0;

		JsonArray actas = obj.getJsonArray("acta");
		for (JsonObject acta : actas.getValuesAs(JsonObject.class)) {
			JsonArray calificacion = acta.getJsonArray("calificacion");
			//JsonObject nota = calificacion.get(0);
			System.out.println(calificacion.getString(0));
        	//Integer nota = acta.getInt("nota");

			//System.out.println(nota);
		}
	}

}
