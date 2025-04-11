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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        cbCalabresa = findViewById(R.id.pizza1);
        cbPortuguesa = findViewById(R.id.pizza2);
        cbMarguerita = findViewById(R.id.pizza3);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void PassarTela(View view){
        Intent intent1 = new Intent(this, MainActivity2.class);
        Intent intent2 = new Intent(this, MainActivity3.class);

        if(cbCalabresa.isChecked())intent2.putExtra("calabresa", "calabresa");
        if(cbPortuguesa.isChecked())intent2.putExtra("portuguesa", "portuguesa");
        if(cbMarguerita.isChecked())intent2.putExtra("marguerita", "marguerita");
        startActivity(intent1);
    }

}