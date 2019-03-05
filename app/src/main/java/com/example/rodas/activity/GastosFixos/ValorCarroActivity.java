package com.example.rodas.activity.GastosFixos;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.rodas.model.Calculos;
import com.example.rodas.R;

public class ValorCarroActivity extends AppCompatActivity {
    private EditText valorCarro;
    private Button vaiparaSeguro;
    private Switch sw_aluguel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valor_carro);
        valorCarro = findViewById(R.id.ed_valorCarro);
        vaiparaSeguro = findViewById(R.id.btt_vaiparaSeguro);
        sw_aluguel = findViewById(R.id.sw_alugap);



        vaiparaSeguro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    float valor = Float.parseFloat(valorCarro.getText().toString());

                    Intent startSeguro = new Intent(getApplicationContext(), SeguroActivity.class);

                    startSeguro.putExtra("i","dfdfdfdfdfddfdf");
                    startSeguro.putExtra("valor",valor);

                    ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
                    ActivityCompat.startActivity(ValorCarroActivity.this, startSeguro, activityOptionsCompat.toBundle());

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Erro ao preencher os dados",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
