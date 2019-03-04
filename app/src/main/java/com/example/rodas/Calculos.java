package com.example.rodas;

public class Calculos {

    //atributos
    private double ipva;
    private double ValorCarro;
    private double valorSeguro;
    private double valorOleo;
    private double valorPneus;
    private double prestacao;


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
