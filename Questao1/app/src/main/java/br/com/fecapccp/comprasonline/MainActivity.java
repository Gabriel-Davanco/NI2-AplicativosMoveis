package br.com.fecapccp.comprasonline;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView txtResultado;
    private CheckBox cbArroz, cbLeite, cbCarne, cbFeijao, cbCoca;
    private double prcArroz, prcLeite, prcCarne, prcFeijao, prcCoca;
    private double soma = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtResultado = findViewById(R.id.txtResultado);

        cbArroz = findViewById(R.id.cbArroz);
        cbLeite = findViewById(R.id.cbLeite);
        cbCarne = findViewById(R.id.cbCarne);
        cbFeijao = findViewById(R.id.cbFeijao);
        cbCoca = findViewById(R.id.cbCoca);

        prcArroz = 2.69;
        prcLeite = 2.7;
        prcCarne = 16.7;
        prcFeijao = 3.38;
        prcCoca = 3;

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcular(View view){
        String txtSoma;
        if(cbArroz.isChecked()) soma += prcArroz;
        if(cbLeite.isChecked()) soma += prcLeite;
        if(cbCarne.isChecked()) soma += prcCarne;
        if(cbFeijao.isChecked()) soma += prcFeijao;
        if(cbCoca.isChecked()) soma += prcCoca;

        DecimalFormat df = new DecimalFormat("#,##0.00");
        txtSoma = df.format(soma);
        txtResultado.setText("R$ " + txtSoma);
    }

    public void limpar(View view){
        soma = 0.00;
        cbArroz.setChecked(false);
        cbLeite.setChecked(false);
        cbCarne.setChecked(false);
        cbFeijao.setChecked(false);
        cbCoca.setChecked(false);
        txtResultado.setText("R$ 0.00");
    }
}