package encuestas.graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import encuestas.servicio.ServicioEncuestas;
import repositorio.EntidadNoEncontrada;
import repositorio.RepositorioException;

public class Mutation implements GraphQLRootResolver {

	public String crearEncuesta(String titulo) throws RepositorioException {

		return ServicioEncuestas.getInstancia().create(titulo);
	}

	public String borrarEncuesta(String id) throws RepositorioException, EntidadNoEncontrada {

		 ServicioEncuestas.getInstancia().remove(id);
		 return id +" borrado.";
	}
	
	public String votar(String id, int opcion, String usuario) throws RepositorioException, EntidadNoEncontrada {

		 ServicioEncuestas.getInstancia().votar(id, opcion, usuario);
		 
		 return usuario +" vota en la opción "+ opcion;
	}

}
