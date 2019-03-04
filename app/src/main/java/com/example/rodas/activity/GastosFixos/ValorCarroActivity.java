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

public class ValorCarroActivity extends AppCompatActivity {
    private EditText valorCarro;
    private Button vaiparaSeguro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valor_carro);
        valorCarro = findViewById(R.id.ed_valorCarro);
        vaiparaSeguro = findViewById(R.id.btt_vaiparaSeguro);


        final Intent enviaparaCalculo = new Intent(this, Calculos.class);


        vaiparaSeguro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Double valor = Double.parseDouble(valorCarro.getText().toString());
                    enviaparaCalculo.putExtra("Valor do Carro", valor);

                    Calculos calculos = new Calculos();
                    calculos.setValorCarro(valor);
                    Toast.makeText(getApplicationContext(), "fffffff" + calculos.getValorCarro(), Toast.LENGTH_SHORT).show();
                    Intent startSeguro = new Intent(ValorCarroActivity.this, SeguroActivity.class);
                    ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
                    ActivityCompat.startActivity(ValorCarroActivity.this, startSeguro, activityOptionsCompat.toBundle());
                    finish();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Erro ao preencher os dados",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
