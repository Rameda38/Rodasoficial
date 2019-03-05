package com.example.rodas.model;

import com.example.rodas.config.ConfiguracaoFirebase;
import com.example.rodas.helper.Base64Custom;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class Calculos {

    //atributos
    private double ipva;
    private double ValorCarro;
    private double valorSeguro;
    private double valorOleo;
    private double valorPneus;
    private double prestacao;

    public void salvarvalores(){
        FirebaseAuth autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        String idUsuario = Base64Custom.codificarBase64( autenticacao.getCurrentUser().getEmail() );

        DatabaseReference firebase = ConfiguracaoFirebase.getFirebaseDatabase();
        firebase.child("VAloresFixos")
                .child( idUsuario )
                .push()
                .setValue(this);

    }



    public double getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public double getValorOleo() {
        return valorOleo;
    }

    public void setValorOleo(double valorOleo) {
        this.valorOleo = valorOleo;
    }

    public double getValorPneus() {
        return valorPneus;
    }

    public void setValorPneus(double valorPneus) {
        this.valorPneus = valorPneus;
    }

    public double getPrestacao() {
        return prestacao;
    }

    public void setPrestacao(double prestacao) {
        this.prestacao = prestacao;
    }

    public double getValorCarro() {
        return ValorCarro;
    }

    public void setValorCarro(double valorCarro) {
        ValorCarro = valorCarro;
    }


    public Calculos() {
    }

    public Calculos(double valorCarro) {
        ValorCarro = valorCarro;
    }

    public double getIpva() {
        return ipva;
    }

    public void setIpva(double ipva) {
        this.ipva = ipva;
    }

    //metodos
   private void  CalculoDepreciacao() {


    }


}
