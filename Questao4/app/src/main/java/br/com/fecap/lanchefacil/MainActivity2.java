package br.com.fecap.lanchefacil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private TextView etNome;
    private Button btnConcluir;
    private String strNome;
    private RadioButton rbCheddar, rbSalada, rbPicles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        btnConcluir = findViewById(R.id.btnConcluir);
        etNome = findViewById(R.id.etNome);
        rbCheddar = findViewById(R.id.rbCheddar);
        rbSalada = findViewById(R.id.rbSalada);
        rbPicles = findViewById(R.id.rbPicles);

        btnConcluir.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity3.class);
            strNome = etNome.getText().toString();

            intent.putExtra("nome", strNome);
            if(rbCheddar.isChecked()) intent.putExtra("lanche", "Duplo cheddar bacon extra");
            if(rbSalada.isChecked()) intent.putExtra("lanche", "Super mega x-saladão");
            if(rbPicles.isChecked()) intent.putExtra("lanche", "Triplo picles nojentãp");
            startActivity(intent);
            finish();
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}