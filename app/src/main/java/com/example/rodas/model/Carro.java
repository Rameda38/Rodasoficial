package com.example.rodas.model;

import com.example.rodas.config.ConfiguracaoFirebase;
import com.example.rodas.helper.Base64Custom;
import com.example.rodas.helper.DateCustom;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class Carro {
        private String Marca;
        private String Modelo;
        private String AnoFab;
        private String AnoModelo;
    public Carro() {
    }


    public void salvarCarros(){

        FirebaseAuth autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        String idUsuario = Base64Custom.codificarBase64( autenticacao.getCurrentUser().getEmail() );

        DatabaseReference firebase = ConfiguracaoFirebase.getFirebaseDatabase();
        firebase.child("OpcaoCarro")
                .child( idUsuario )
                .push()
                .setValue(this);

    }

    public Carro(String marca, String modelo, String anoFab, String anoModelo) {
        Marca = marca;
        Modelo = modelo;
        AnoFab = anoFab;
        AnoModelo = anoModelo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getAnoFab() {
        return AnoFab;
    }

    public void setAnoFab(String anoFab) {
        AnoFab = anoFab;
    }

    public String getAnoModelo() {
        return AnoModelo;
    }

    public void setAnoModelo(String anoModelo) {
        AnoModelo = anoModelo;
    }
}
