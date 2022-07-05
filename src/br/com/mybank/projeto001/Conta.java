import java.math.BigDecimal;

public abstract class Conta {
    private BigDecimal saldo = new BigDecimal(0);
    private int conta = 0;
    private String agencia;
    private String titular;
    private String tipoCliente;

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
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

}