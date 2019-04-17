package com.example.rodas.model;

import com.example.rodas.config.ConfiguracaoFirebase;
import com.example.rodas.helper.Base64Custom;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Calculos {

    //atributos
    private double ipva;
    private double valorCarro;
    private double valorSeguro;
    private double valorOleo;
    private double valorPneus;
    private double prestacao;
    private double aluguel;
    private int diasFimAno;
    private double calculoAluguel, CalculoPneus, CalculoDepreciacao, CalculoIpva, CalculoOleo,CalculoSeguro;


    public void salvarvalores() {
        FirebaseAuth autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        String idUsuario = Base64Custom.codificarBase64(autenticacao.getCurrentUser().getEmail());
        DatabaseReference firebase = ConfiguracaoFirebase.getFirebaseDatabase();
        firebase.child("ValoresFixos")
                .child(idUsuario)
                .push()
                .setValue(this);
    }

    //Construtor
    public Calculos() {
    }
    //get set

    public double getCalculoSeguro() {
        return CalculoSeguro;
    }

    public void setCalculoSeguro(double calculoSeguro) {
        CalculoSeguro = calculoSeguro;
    }

    public double getCalculoPneus() {
        return CalculoPneus;
    }

    public void setCalculoPneus(double calculoPneus) {
        CalculoPneus = calculoPneus;
    }

    public double getCalculoDepreciacao() {
        return CalculoDepreciacao;
    }

    public void setCalculoDepreciacao(double calculoDepreciacao) {
        CalculoDepreciacao = calculoDepreciacao;
    }

    public double getCalculoIpva() {
        return CalculoIpva;
    }

    public void setCalculoIpva(double calculoIpva) {
        CalculoIpva = calculoIpva;
    }

    public double getCalculoOleo() {
        return CalculoOleo;
    }

    public void setCalculoOleo(double calculoOleo) {
        CalculoOleo = calculoOleo;
    }

    public double getCalculoAluguel() {
        return calculoAluguel;
    }

    public void setCalculoAluguel(double calculoAluguel) {
        this.calculoAluguel = calculoAluguel;
    }

    public int getDiasFimAno() {
        return diasFimAno;
    }

    public void setDiasFimAno(int diasFimAno) {
        this.diasFimAno = diasFimAno;
    }


    public double getAluguel() {
        return aluguel;
    }

    public void setAluguel(double aluguel) {
        this.aluguel = aluguel;
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
        return valorCarro;
    }

    public void setValorCarro(double valorCarro) {
        valorCarro = valorCarro;
    }


    public Calculos(double valorCarro) {
        valorCarro = valorCarro;
    }

    public double getIpva() {
        return ipva;
    }

    public void setIpva(double ipva) {
        this.ipva = ipva;
    }


    //metodos
    private int CalculoDiasParaoFimDoMes() {
        /**
         * VER JEITO DE MUDAR MES DINAMICAMENTE
         * **/
        Calendar fimdoano = Calendar.getInstance();
        fimdoano.set(Calendar.YEAR, 2019);
        fimdoano.set(Calendar.MONTH, 3);
        fimdoano.set(Calendar.DAY_OF_MONTH, 31);
        Calendar hoje = Calendar.getInstance();
        long diasParaOFimDoAno = hoje.getTime().getTime() - fimdoano.getTime().getTime();
        long finm = (TimeUnit.MILLISECONDS.toDays(diasParaOFimDoAno) * ((-1)) - 30);
        int fim = (int) Integer.parseInt(String.valueOf(finm));
        return fim;

    }
    public  Double CalculoSeguro(){
        Double gastoSeguro = valorSeguro/diasFimAno;
        return gastoSeguro;
    }

    public Double CalculoPneus() {
        Double gastoPneusDia = valorPneus / diasFimAno;
        return gastoPneusDia;
    }

    public Double CalculoOleo() {
        Double gastoOleo = valorOleo / diasFimAno;
        return gastoOleo;
    }

    public Double CalculoIpva() {
        Double gastoIpva = ipva / diasFimAno;
        return gastoIpva;
    }

    public Double calculoAluguel() {
        Double gastoAluguel = aluguel / CalculoDiasParaoFimDoMes();
        return gastoAluguel;

    }

    public double CalculoDepreciacao() {
        Double depreciacao = ((valorCarro * 0.087) / diasFimAno);
        return depreciacao;
    }

}
