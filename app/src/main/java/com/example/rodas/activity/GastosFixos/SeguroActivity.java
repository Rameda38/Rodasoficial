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

public class SeguroActivity extends AppCompatActivity {
    private EditText ValorSeguro;
    private Button vaiparaipva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguro);
        ValorSeguro = findViewById(R.id.ed_valorSeguroMes);
        vaiparaipva = findViewById(R.id.btt_proxIpva);


        vaiparaipva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Double valor = Double.parseDouble(ValorSeguro.getText().toString());

                    Bundle dados = getIntent().getExtras();
                    String DFdfd = dados.getString("i");
                   float valorCarro = dados.getFloat("valor");


                    Intent startIpva = new Intent(SeguroActivity.this, ipvaActivity.class);

                    startIpva.putExtra("ValorCarro",valorCarro);
                    startIpva.putExtra("Seguro",valor);

                    ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
                    ActivityCompat.startActivity(SeguroActivity.this, startIpva, activityOptionsCompat.toBundle());
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Erro ao preencher os dados", Toast.LENGTH_SHORT).show();
                }

            }
        });
      }
}
