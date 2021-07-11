package encuestas.graphql;


import com.coxautodev.graphql.tools.GraphQLRootResolver;

import encuestas.modelo.Encuesta;
import encuestas.modelo.ListadoEncuestas;
import encuestas.servicio.ServicioEncuestas;
import repositorio.EntidadNoEncontrada;
import repositorio.RepositorioException;

public class Query implements GraphQLRootResolver {
    
    public Encuesta findById(String id) throws RepositorioException, EntidadNoEncontrada {
        return ServicioEncuestas.getInstancia().getById(id);
    }
    
    public ListadoEncuestas listadoResumen() throws RepositorioException, EntidadNoEncontrada {
        return ServicioEncuestas.getInstancia().getListadoResumen();
    }
    
    public Boolean haVotado(String id, String usuario) throws RepositorioException, EntidadNoEncontrada {
        return ServicioEncuestas.getInstancia().haVotado(id, usuario);
    }
    
}