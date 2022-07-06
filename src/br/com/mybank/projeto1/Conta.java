package br.com.mybank.projeto1;
import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Conta {
    private BigDecimal saldo = new BigDecimal(0);
    private int conta = 0;
    private String agencia;
    private Cliente titular;

    public Conta(String agencia, int conta, Cliente titular){
        this.agencia = agencia;
        this.conta = conta;
        this.titular = titular;
    }


    public void sacar(BigDecimal valor) throws MensagemErro {
        if (saldo.compareTo(valor) == 1 || saldo.compareTo(valor) == 0) {
            saldo = saldo.subtract(valor);
        } else {
            System.out.println("saldo insuficiente");
            throw new MensagemErro("Saldo: " + this.saldo + ", Valor: " + valor);
        }
    }

    public void depositar(BigDecimal valor) throws MensagemErro {
        saldo = saldo.add(valor);
    }
    
    public void transferir(BigDecimal valor, Conta cd) throws MensagemErro { 
        this.sacar(valor);
        cd.depositar(valor);
    }
    
    public BigDecimal getSaldo() {
        this.saldo = saldo.setScale(2, RoundingMode.DOWN);
        return saldo;
    }
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    public int getConta() {
        return conta;
    }
    public void setConta(int conta) {
        this.conta = conta;
    }
    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Cliente getTitular() {
        return this.titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

}