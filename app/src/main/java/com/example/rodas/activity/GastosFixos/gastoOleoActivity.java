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

import java.util.ArrayList;
import java.util.List;

public class gastoOleoActivity extends AppCompatActivity {
    private EditText valorOleo;
    private Button vaiparaPneus;
    private List<Calculos>calculos = new ArrayList<>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasto_oleo);
        valorOleo = findViewById(R.id.ed_valorTrocaDeOleo);
        vaiparaPneus = findViewById(R.id.btt_proxPneus);
        vaiparaPneus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Double valor = Double.parseDouble(valorOleo.getText().toString());

                    Bundle dados = getIntent().getExtras();
                    Float ValorCarro = dados.getFloat("ValorCarro");
                    Double Seguro = dados.getDouble("Seguro");
                    Double ipva = dados.getDouble("ipva");


                    Intent startPneus = new Intent(gastoOleoActivity.this, gastoPneusActivity.class);
                    startPneus.putExtra("ValorCarro",ValorCarro);
                    startPneus.putExtra("Seguro",Seguro);
                    startPneus.putExtra("ipva",ipva);
                    startPneus.putExtra("Oleo",valor);


                    ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
                    ActivityCompat.startActivity(gastoOleoActivity.this, startPneus, activityOptionsCompat.toBundle());
                    finish();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Erro ao preencher os dados",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
