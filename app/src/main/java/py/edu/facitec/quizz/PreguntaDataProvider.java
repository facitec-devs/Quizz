package py.edu.facitec.quizz;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class PreguntaDataProvider {




    public static void getPreguntas(ActivityViewManager view){
        final ActivityViewManager mview = view;
        RestAdapter restAdapter = new RestAdapter
                                        .Builder()
                                        .setEndpoint("http://quizz-web.herokuapp.com/")
                                        .build();

        PreguntaService service = restAdapter.create(PreguntaService.class);

        service.getPreguntas(new Callback<List<Pregunta>>() {
            @Override
            public void success(List<Pregunta> preguntas, Response response) {
                Log.i("RESULT",preguntas.toString());
                mview.onResultSuccess(preguntas);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("RESULT",error.getLocalizedMessage());
            }
        });
    }

}
