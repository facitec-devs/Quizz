package py.edu.facitec.quizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ActivityViewManager{

    RadioButton radioButtonA;
    RadioButton radioButtonB;
    RadioButton radioButtonC;
    TextView textViewPregunta;
    RadioGroup radioGroup;
    Button buttonConfirmar;
    Pregunta pregunta;
    List<Pregunta> preguntas;
    List<ImageView> scoreImageView = new ArrayList<>();
    int position = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioButtonA = (RadioButton)findViewById(R.id.radioButtonA);
        radioButtonB = (RadioButton)findViewById(R.id.radioButtonB);
        radioButtonC = (RadioButton)findViewById(R.id.radioButtonC);
        textViewPregunta = (TextView) findViewById(R.id.textViewPregunta);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        buttonConfirmar = (Button)findViewById(R.id.buttonConfirmar);
        scoreImageView.add((ImageView)findViewById(R.id.imageView0));
        scoreImageView.add((ImageView)findViewById(R.id.imageView1));
        scoreImageView.add((ImageView)findViewById(R.id.imageView2));
        scoreImageView.add((ImageView)findViewById(R.id.imageView3));
        scoreImageView.add((ImageView)findViewById(R.id.imageView4));
        scoreImageView.add((ImageView)findViewById(R.id.imageView5));
        scoreImageView.add((ImageView)findViewById(R.id.imageView6));
        scoreImageView.add((ImageView)findViewById(R.id.imageView7));
        scoreImageView.add((ImageView)findViewById(R.id.imageView8));
        scoreImageView.add((ImageView)findViewById(R.id.imageView9));

    }


    @Override
    protected void onStart() {
        super.onStart();
        PreguntaDataProvider.getPreguntas(MainActivity.this);
    }
    public void confirmar(View v){
        if(!radioButtonA.isChecked()&&!radioButtonB.isChecked()&&!radioButtonC.isChecked()){
            Toast.makeText(this,getString(R.string.error_seleccion),Toast.LENGTH_SHORT).show();
        }else{
            if(radioButtonA.isChecked() && pregunta.getOpciones().get(0).isCorrecto()){
                score++;
                scoreImageView.get(position-1).setImageResource(android.R.drawable.presence_online);
            }else if(radioButtonB.isChecked() && pregunta.getOpciones().get(1).isCorrecto()){
                score++;
                scoreImageView.get(position-1).setImageResource(android.R.drawable.presence_online);
            }else if(radioButtonC.isChecked() && pregunta.getOpciones().get(2).isCorrecto()){
                score++;
                scoreImageView.get(position-1).setImageResource(android.R.drawable.presence_online);
            }
            else{
                scoreImageView.get(position-1).setImageResource(android.R.drawable.ic_delete);
            }
            scoreImageView.get(position-1).setVisibility(View.VISIBLE);
            nextPregunta();
        }


    }

    public void nextPregunta(){
        if(position >= 10){
            textViewPregunta.setText("Finish. You score is "+score);
            radioGroup.setVisibility(View.INVISIBLE);
            buttonConfirmar.setEnabled(false);
            return;
        }else{
            pregunta = preguntas.get(position);
        }
        textViewPregunta.setText(pregunta.getTexto());
        radioButtonA.setText(pregunta.getOpciones().get(0).getTexto());
        radioButtonB.setText(pregunta.getOpciones().get(1).getTexto());
        radioButtonC.setText(pregunta.getOpciones().get(2).getTexto());
        radioGroup.clearCheck();
        position++;
    }

    public void onResultSuccess(List<Pregunta> preguntas){
        this.preguntas = preguntas;
        score=0;
        nextPregunta();
    }
    
    @Override
    public void onResultFailure(String error) {
        //TODO fail result implement
    }

}
