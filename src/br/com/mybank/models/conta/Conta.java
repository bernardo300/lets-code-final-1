package br.com.mybank.models.conta;

import br.com.mybank.models.cliente.Cliente;
import br.com.mybank.models.cliente.ClientePJ;

public abstract class Conta{
  private String agencia;
  private String numeroConta;
  protected double saldo; 
  protected Cliente cliente;
  private double valorInvestido;
  
  public Conta(String numero){
    this.numeroConta = numero;
  }

  public Cliente getCliente() {
    return cliente;
  }
  
  public String getAgencia() {
    return agencia;
  }

  public void setAgencia(String agencia) {
    this.agencia = agencia;
  }

  public String getNumeroConta() {
    return numeroConta;
  }

  public void setNumeroConta(String numeroConta) {
    this.numeroConta = numeroConta;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  protected double getValorInvestido() {
    return valorInvestido;
  }

  protected void setValorInvestido(double valorInvestido) {
    this.valorInvestido = valorInvestido;
  }


  public double depositar(double valor){
      this.saldo += valor;
      return valor;
  }

  public double sacar(double valor){
    if(this.cliente instanceof ClientePJ){
      valor *= 1.005;
    }
    
    if(this.saldo >= valor){
      this.saldo -= valor;
    }
    return valor;
  }

  public void tranferir(Conta conta,double valor){
    if(this.saldo >= valor){
      this.sacar(valor);
      conta.depositar(valor);
    }
  }

  @Override
  public String toString() {
    return "Numero: " + this.numeroConta + "Cliente: " + this.cliente.getNome();
  }

  @Override
  public boolean equals(Object obj) {
    Conta c = (Conta) obj;
    return this.numeroConta == c.getNumeroConta();
  }
}
