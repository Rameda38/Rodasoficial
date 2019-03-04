package com.example.rodas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rodas.R;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

public class GastosFixosActivity extends IntroActivity {

    private Button passa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       /* addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.cadastro_apresentacao)
                .build()

        );
        addSlide(new FragmentSlide.Builder()
            .background(android.R.color.white)
                .fragment(R.layout.fragment_valor_carro)
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.fragment_seguro)
                .build()

        );

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.fragment_trocade_oleo)
                .build()

        );*/
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .build()

        );
        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.white)
                .canGoForward(false)
                        .build()
                );
      }
    }
