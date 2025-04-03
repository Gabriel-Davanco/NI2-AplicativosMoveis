package br.com.fecapapp.percentualsalario;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView txtResultado;
    private RadioGroup radioGroup;
    private RadioButton rb40, rb45, rb50;
    private EditText etSalario;
    private double doubleSalario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtResultado = findViewById(R.id.txtResultado);
        radioGroup = findViewById(R.id.rbGroup);
        rb40 = findViewById(R.id.rb40);
        rb45 = findViewById(R.id.rb45);
        rb50 = findViewById(R.id.rb50);
        etSalario = findViewById(R.id.editTxtSalario);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcular(View view){
        String strSalario = etSalario.getText().toString();
        doubleSalario = Double.parseDouble(strSalario);

        if(rb40.isChecked()) doubleSalario += doubleSalario*0.4;
        if(rb45.isChecked()) doubleSalario += doubleSalario*0.45;
        if(rb50.isChecked()) doubleSalario += doubleSalario*0.5;

        DecimalFormat df = new DecimalFormat("#,##0.00");
        strSalario = df.format(doubleSalario);
        txtResultado.setText("R$ " + strSalario);

    }

    public void limpar(View view){
        radioGroup.clearCheck();
        etSalario.setText("");
        txtResultado.setText("---");
    }
}