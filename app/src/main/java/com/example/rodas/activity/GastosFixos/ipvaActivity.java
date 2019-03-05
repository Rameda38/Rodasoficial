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

import com.example.rodas.model.Calculos;
import com.example.rodas.R;

public class ipvaActivity extends AppCompatActivity {
    private EditText valorIpva;
    private Button vaiparaOleo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipva);
        valorIpva = findViewById(R.id.ed_valorIpva);
        vaiparaOleo = findViewById(R.id.btt_proxOleo);
        vaiparaOleo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Double valor = Double.parseDouble(valorIpva.getText().toString());

                    Bundle dados = getIntent().getExtras();

                    float ValorCarro = dados.getFloat("ValorCarro");
                    double Seguro = dados.getDouble("Seguro");

                    Intent startOleo = new Intent(ipvaActivity.this, gastoOleoActivity.class);
                    startOleo.putExtra("ValorCarro",ValorCarro);
                    startOleo.putExtra("Seguro",Seguro);
                    startOleo.putExtra("ipva",valor);


                    ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation
                            (getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
                    ActivityCompat.startActivity(ipvaActivity.this, startOleo,
                            activityOptionsCompat.toBundle());
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Erro ao preencher os dados",
                            Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}
