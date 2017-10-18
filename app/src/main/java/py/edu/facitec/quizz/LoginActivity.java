package py.edu.facitec.quizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText emailEditText;
    EditText passwordEditText;
    int back=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = (EditText) findViewById(R.id.editTextEmail);
        passwordEditText = (EditText) findViewById(R.id.editTextPassword);
    }

    public void acceder(View view){
        String email = emailEditText.getText().toString();

        if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Escriba un email valido");
            return;
        }
        if(passwordEditText.getText().toString().isEmpty()){
            passwordEditText.setError("Escriba su password");
            return;
        }

        //TODO acceso de usuarios
        if(emailEditText.getText().toString().equals("leodufer@gmail.com") && passwordEditText.getText().toString().equals("123")){
            //Acceder a la app
            Intent i = new Intent(LoginActivity.this,DashboardActivity.class);
            startActivity(i);
            finish();
        }else{
            //error de acceso
        }

    }

    public void registrar(View view){

    }
}
