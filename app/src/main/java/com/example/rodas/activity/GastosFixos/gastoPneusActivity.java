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
import com.example.rodas.activity.PrincipalActivity;

public class gastoPneusActivity extends AppCompatActivity {
    private EditText gastoPneus;
    private Button vaiparaFim;
    Calculos calculos = new Calculos();
    Double[] calculo = new Double[4];

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
                    Double Pneus = Double.parseDouble(gastoPneus.getText().toString());

                    Bundle dados = getIntent().getExtras();
                    Float ValorCarro = dados.getFloat("ValorCarro");
                    Double Seguro = dados.getDouble("Seguro");
                    Double ipva = dados.getDouble("ipva");
                    Double Oleo = dados.getDouble("Oleo");
                    /******************************************************************************************/
                    calculos.setValorCarro(ValorCarro);
                    Double CalcDepreciacao = calculos.CalculoDepreciacao();
                    calculos.setCalculoDepreciacao(CalcDepreciacao);
                    /*****************************************************************************************/
                    calculos.setIpva(ipva);
                    Double calcIpva = calculos.CalculoIpva();
                    calculos.setCalculoIpva(calcIpva);
                    /*****************************************************************************************/
                    calculos.setValorOleo(Oleo);
                    Double calcOleo = calculos.CalculoOleo();
                    calculos.setCalculoOleo(calcOleo);
                    /*******************************************************************************************/
                    calculos.setValorPneus(Pneus);
                    Double calcPneu = calculos.CalculoPneus();
                    calculos.setCalculoPneus(calcPneu);
                    /********************************************************************************************/
                    calculos.setValorSeguro(Seguro);
                    Double calcSeguro = Double.valueOf(String.valueOf(calculos.CalculoSeguro()));
                    calculos.setCalculoSeguro(calcSeguro);
                    calculos.salvarvalores();




                    Toast.makeText(getApplicationContext(), "\n" + ValorCarro + "\n" + ipva + "\n" + Oleo + "\n" + Seguro + "\n" + Pneus, Toast.LENGTH_SHORT).show();
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