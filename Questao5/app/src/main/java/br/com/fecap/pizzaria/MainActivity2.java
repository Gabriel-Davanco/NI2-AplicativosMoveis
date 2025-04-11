package br.com.fecap.pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private RadioButton rbTamanho1;
    private RadioButton rbTamanho2;
    private RadioButton rbTamanho3;
    private RadioButton rbPagamento1;
    private RadioButton rbPagamento2;
    private Button btnConcluir2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        rbTamanho1 = findViewById(R.id.rbTamanho1);
        rbTamanho2 = findViewById(R.id.rbTamanho2);
        rbTamanho3 = findViewById(R.id.rbTamanho3);
        rbPagamento1 = findViewById(R.id.rbPagamento1);
        rbPagamento2 = findViewById(R.id.rbPagamento2);
        btnConcluir2 = findViewById(R.id.btnContinuar2);

        btnConcluir2.setOnClickListener(view->{
            Intent intent = new Intent(this, MainActivity3.class);
            if(rbTamanho1.isChecked()) intent.putExtra("pequeno", "pequeno");
            else if(rbTamanho2.isChecked()) intent.putExtra("medio", "médio");
            else if(rbTamanho3.isChecked()) intent.putExtra("grande", "grande");

            if(rbPagamento1.isChecked()) intent.putExtra("cartao", "cartão");
            if(rbPagamento2.isChecked()) intent.putExtra("dinheiro", "dinheiro");

            startActivity(intent);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}