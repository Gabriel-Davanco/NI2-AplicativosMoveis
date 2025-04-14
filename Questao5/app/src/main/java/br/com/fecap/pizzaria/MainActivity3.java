package br.com.fecap.pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    private TextView txtFinal;
    private Button btnVoltar;
    private String pagamento;
    private String totalPedido;
    private String tamanho;
    private String sabores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        txtFinal = findViewById(R.id.txtNome);
        btnVoltar = findViewById(R.id.btnVoltar);

        Bundle bundle = getIntent().getExtras();
        pagamento = bundle.getString("pagamento");
        tamanho = bundle.getString("tamanho");
        sabores = bundle.getString("sabores");
        totalPedido = bundle.getString("total");

      txtFinal.setText("Obrigado por comprar sua pizza " + tamanho + " de " + sabores + ". O valor total do pedido foi de R$" + totalPedido + ".00, e a forma de pagamento escolhida foi o " + pagamento + ".");
      // txtFinal.setText(totalPedido); //debug

        btnVoltar.setOnClickListener(view ->{
            Intent intent = new Intent(this, MainActivity.class);
            finish();
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}