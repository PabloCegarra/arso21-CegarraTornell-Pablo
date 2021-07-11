package encuestas.retrofit.encuesta;

import encuestas.modelo.Encuesta;
import encuestas.rest.Listado;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EncuestaRestClient {

	@POST("encuestas")
	Call<Void> createEncuesta(@Body Encuesta encuesta);
	
	@GET("encuestas/{id}")
	Call<Encuesta> getEncuesta(@Path("id") String id);
	
	@GET("encuestas")
	Call<Listado> getListado();
	
	@FormUrlEncoded
	@POST("encuestas/{id}/opcion/{opcion}")	
	Call<Void> votarEncuesta(@Path("id") String id,
			@Path("opcion") int opcion, @Field("usuario") String usuario);
}
