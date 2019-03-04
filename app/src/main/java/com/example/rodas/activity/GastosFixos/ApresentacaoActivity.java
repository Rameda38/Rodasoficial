package com.example.rodas.activity.GastosFixos;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rodas.R;

public class ApresentacaoActivity extends AppCompatActivity {
    private Button vaiparaValorDocarro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apresentacao);
        vaiparaValorDocarro = findViewById(R.id.btt_prox_ValorCArro);

        vaiparaValorDocarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent startValorCArro = new Intent(ApresentacaoActivity.this, ValorCarroActivity.class);
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
                ActivityCompat.startActivity(ApresentacaoActivity.this, startValorCArro, activityOptionsCompat.toBundle());
                finish();

            }
        });




    }
}
