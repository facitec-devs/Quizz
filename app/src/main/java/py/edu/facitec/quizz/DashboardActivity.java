package py.edu.facitec.quizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
    public void iniciarRonda(View view){
        Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
