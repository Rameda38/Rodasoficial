package com.example.rodas.activity.GastosFixos;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rodas.Calculos;
import com.example.rodas.R;
import com.example.rodas.activity.PrincipalActivity;

public class gastoPneusActivity extends AppCompatActivity {
    private EditText gastoPneus;
    private Button vaiparaFim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasto_pneus);
        gastoPneus = findViewById(R.id.ed_valorTrocaPneu);
        vaiparaFim = findViewById(R.id.btt_vaiparafim);

        vaiparaFim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Double valor = Double.parseDouble(gastoPneus.getText().toString());
                    Calculos calculos = new Calculos();
                    calculos.setValorPneus(valor);
                    Toast.makeText(getApplicationContext(), "fffffff" + calculos.getValorPneus(), Toast.LENGTH_SHORT).show();
                    Intent startPrincipal = new Intent(gastoPneusActivity.this, PrincipalActivity.class);
                    ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
                    ActivityCompat.startActivity(gastoPneusActivity.this, startPrincipal, activityOptionsCompat.toBundle());
                    finish();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Erro ao preencher os dados", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}