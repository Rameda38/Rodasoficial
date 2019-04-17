package com.example.rodas.activity.GastosFixos;

import android.annotation.TargetApi;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.DateIntervalInfo;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.rodas.activity.PrincipalActivity;
import com.example.rodas.model.Calculos;
import com.example.rodas.R;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.Duration;

public class ValorCarroActivity extends AppCompatActivity {
    private EditText valorCarro;
    private Button vaiparaSeguro;
    private Switch sw_aluguel;
    Calculos calculos = new Calculos();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valor_carro);
        valorCarro = findViewById(R.id.ed_valorCarro);
        vaiparaSeguro = findViewById(R.id.btt_vaiparaSeguro);
        sw_aluguel = findViewById(R.id.sw_alugap);
        final int diasParaOFimDoaAno = CalculoDiasParaoFimDoAno();
       // calculos.setDiasFimAno(diasParaOFimDoaAno);

        vaiparaSeguro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    float valor = Float.parseFloat(valorCarro.getText().toString());

                    if (sw_aluguel.isChecked()) {
                        Intent startfinal = new Intent(getApplicationContext(), PrincipalActivity.class);
                        double aluguel = valor;

                        calculos.setAluguel(aluguel);
                        calculos.setDiasFimAno(diasParaOFimDoaAno);

                        double calculoaluguel = calculos.calculoAluguel();
                        calculos.setCalculoAluguel(calculoaluguel);
                        calculos.salvarvalores();


                        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
                        ActivityCompat.startActivity(ValorCarroActivity.this, startfinal,
                                activityOptionsCompat.toBundle());

                    } else {
                        Intent startSeguro = new Intent(getApplicationContext(), SeguroActivity.class);

                        startSeguro.putExtra("i", "dfdfdfdfdfddfdf");
                        startSeguro.putExtra("valor", valor);
                        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
                        ActivityCompat.startActivity(ValorCarroActivity.this,
                                startSeguro, activityOptionsCompat.toBundle());

                    }


                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Erro ao preencher os dados", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
    private int  CalculoDiasParaoFimDoAno() {
        /**
         * VER JEITO DE PEGAR ANO DINAMICAMENTE
         */

        Calendar fimdoano = Calendar.getInstance();
        fimdoano.set(Calendar.YEAR,2019);
        fimdoano.set(Calendar.MONTH,12);
        fimdoano.set(Calendar.DAY_OF_MONTH,31);
        Calendar hoje = Calendar.getInstance();
        long diasParaOFimDoAno = hoje.getTime().getTime() - fimdoano.getTime().getTime();
        long finm = (TimeUnit.MILLISECONDS.toDays(diasParaOFimDoAno)*((-1))-30);
       int fim = (int) Integer.parseInt (String.valueOf(finm));
       return fim;

    }
}
