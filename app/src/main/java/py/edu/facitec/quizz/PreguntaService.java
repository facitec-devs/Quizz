package py.edu.facitec.quizz;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by virux on 18/10/17.
 */

interface PreguntaService {
    @GET("/pregunta")
    void getPreguntas(Callback<List<Pregunta>> callback);
}
