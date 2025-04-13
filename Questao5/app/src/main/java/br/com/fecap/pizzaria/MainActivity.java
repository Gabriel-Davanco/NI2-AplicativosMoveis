package br.com.fecap.pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private CheckBox cbCalabresa;
    private CheckBox cbPortuguesa;
    private CheckBox cbMarguerita;
    private int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        cbCalabresa = findViewById(R.id.pizza1);
        cbPortuguesa = findViewById(R.id.pizza2);
        cbMarguerita = findViewById(R.id.pizza3);
        total = 0;

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void PassarTela(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        StringBuilder sabores = new StringBuilder();

        if (!cbCalabresa.isChecked() && !cbPortuguesa.isChecked() && !cbMarguerita.isChecked()) {
            cbCalabresa.setError("Selecione pelo menos um sabor de pizza");
            cbPortuguesa.setError("Selecione pelo menos um sabor de pizza");
            cbMarguerita.setError("Selecione pelo menos um sabor de pizza");

        } else {
            if (cbCalabresa.isChecked()) {
                sabores.append("Calabresa, ");
                total += 5;
            }
            if (cbPortuguesa.isChecked()) {
                sabores.append("Portuguesa, ");
                total += 7;
            }
            if (cbMarguerita.isChecked()) {
                sabores.append("Marguerita, ");
                total += 4;
            }

            // Remove a última vírgula e espaço
            if (sabores.length() > 2) {
                sabores.setLength(sabores.length() - 2);
            }
            intent.putExtra("sabores", sabores.toString());
            intent.putExtra("total", String.valueOf(total));
            startActivity(intent);
        }
    }

}