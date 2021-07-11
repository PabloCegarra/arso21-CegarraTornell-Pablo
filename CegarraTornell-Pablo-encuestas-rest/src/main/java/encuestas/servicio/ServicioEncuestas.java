package encuestas.servicio;

import java.time.LocalDateTime;

import encuestas.modelo.Encuesta;
import encuestas.modelo.EncuestaResumen;
import encuestas.modelo.ListadoEncuestas;
import encuestas.modelo.Opcion;
import encuestas.repositorio.FactoriaRepositorioEncuestas;
import encuestas.repositorio.RepositorioEncuestas;
import repositorio.EntidadNoEncontrada;
import repositorio.RepositorioException;

public class ServicioEncuestas implements IServicioEncuestas {

	private RepositorioEncuestas repositorio = FactoriaRepositorioEncuestas.getRepositorio();
	
	/** Patrón Singleton **/
	
	private static ServicioEncuestas instancia;

	private ServicioEncuestas() {
		
	}
	
	public static ServicioEncuestas getInstancia() {

		if (instancia == null)
			instancia = new ServicioEncuestas();

		return instancia;
	}
	
	
	@Override
	public String create(Encuesta encuesta) throws RepositorioException {
		
		validateEncuesta(encuesta);
		String id = repositorio.add(encuesta);
		
		return id;
	}

	@Override
	public boolean haVotado(String id, String usuario) throws RepositorioException, EntidadNoEncontrada {
		
		if (usuario == null || usuario.isEmpty())
			throw new IllegalArgumentException("usuario: no debe ser nulo ni vacio");
		
		Encuesta encuesta = repositorio.getById(id);
		
		return encuesta.getOpciones().stream().anyMatch(opcion -> opcion.getVotos().contains(usuario));
		
	}

	@Override
	public boolean votar(String id, int opcion, String usuario) throws RepositorioException, EntidadNoEncontrada {
				
		Encuesta encuesta = repositorio.getById(id);
		
		if (opcion < 1 || opcion > encuesta.getOpciones().size() )
			throw new IllegalArgumentException("opcion: indice no valido");
		
		if (usuario == null || usuario.isEmpty())
			throw new IllegalArgumentException("usuario: no debe ser nulo ni vacio");
	
		if (haVotado(id, usuario))
			throw new IllegalArgumentException("usuario: ya ha votado");
		
		LocalDateTime ahora = LocalDateTime.now();
		
		if (ahora.isBefore(encuesta.getFechaApertura()) || ahora.isAfter(encuesta.getFechaCierre()))
			throw new IllegalArgumentException("la encuesta no esta abierta");
		// FIXME: estrictamente debería ser una excepcion de estado IllegalStateException
		
		int indice = opcion - 1; // desde 0
		encuesta.getOpciones().get(indice).getVotos().add(usuario);
		
		repositorio.update(encuesta);
		return true;
	}

	@Override
	public Encuesta getById(String id) throws RepositorioException, EntidadNoEncontrada {
		
		return repositorio.getById(id);
	}

	@Override
	public void remove(String id) throws RepositorioException, EntidadNoEncontrada {
		
		Encuesta encuesta = repositorio.getById(id);
		
		repositorio.delete(encuesta);
		
	}

	@Override
	public ListadoEncuestas getListadoResumen() throws RepositorioException, EntidadNoEncontrada {
		
		ListadoEncuestas listado = new ListadoEncuestas();
		
		for (String id : repositorio.getIds()) {
			Encuesta encuesta = repositorio.getById(id);
			
			EncuestaResumen resumen = new EncuestaResumen();
			resumen.setId(id);
			resumen.setTitulo(encuesta.getTitulo());
			
			listado.getEncuestas().add(resumen);
		}
		
		return listado;
	}
	
	protected void validateEncuesta(Encuesta encuesta) throws IllegalArgumentException {
		
		if(encuesta.getTitulo() == null || encuesta.getTitulo().isBlank()) {
			throw new IllegalArgumentException("La encuesta no tiene titulo");
		}
		
		if(encuesta.getFechaApertura() == null) {
			throw new IllegalArgumentException("La encuesta no tiene fecha de apertura");
		}
		
		if(encuesta.getFechaCierre() == null) {
			throw new IllegalArgumentException("La encuesta no tiene fecha de cierre");
		}
		
		if(!encuesta.getFechaCierre().isAfter(encuesta.getFechaApertura())) {
			throw new IllegalArgumentException("La fecha cierre de encuesta debe ser posterior a fecha de apertura");
		}	
		
		if(encuesta.getNumeroOpciones() < 2) {
			throw new IllegalArgumentException("La encuesta no puede tener solo una opcion");
		}
		
		for(Opcion o: encuesta.getOpciones()) {
			
			if(o.getTexto() == null || o.getTexto().isBlank()) {
				throw new IllegalArgumentException("La opcion no tiene titulo");
			}
			
			if(o.getVotos() == null) {
				throw new IllegalArgumentException("La lista de votos no esta inicializada");
			}
		}
	}

}
