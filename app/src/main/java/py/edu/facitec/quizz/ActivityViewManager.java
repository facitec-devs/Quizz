package py.edu.facitec.quizz;

import java.util.List;

/**
 * Created by virux on 18/10/17.
 */

public interface ActivityViewManager {
    void onResultSuccess(List<Pregunta> preguntas);
    void onResultFailure(String error);
}
