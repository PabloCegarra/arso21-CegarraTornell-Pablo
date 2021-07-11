package encuestas.modelo;

import java.util.LinkedList;
import java.util.List;

import org.bson.codecs.pojo.annotations.BsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Opcion {

	private String texto;
	private List<String> votos = new LinkedList<>();
	
		public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<String> getVotos() {
		return votos;
	}

	public void setVotos(List<String> votos) {
		this.votos = votos;
	}

	@BsonIgnore
	public int getNumeroVotos() {
		return votos.size();
	}
}
