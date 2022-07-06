package br.com.mybank.projeto1;
import java.math.BigDecimal;

public class ContaCorrente extends Conta{
    private BigDecimal limite = new BigDecimal(0);
    private BigDecimal taxa = new BigDecimal(0.5);
    private BigDecimal valor = new BigDecimal(0);
    private BigDecimal valorTaxa = new BigDecimal(0);

//    public ContaCorrente(String agencia, int conta, BigDecimal valor){
    public ContaCorrente(String agencia, int conta, Cliente titular){
        super(agencia, conta, titular);
    }

    public void sacar(BigDecimal valor) throws MensagemErro{
        if(getTitular() instanceof ClientePessoFisica) {                // falta passar tipoCliente via Cliente via setTipoCliente
            super.sacar(valor);
        } else {
            valorTaxa = calculaValorTaxa(valor);
            this.valor = valor.add(valorTaxa);
            super.sacar(this.valor);
        }
    }

    public BigDecimal calculaValorTaxa(BigDecimal valor){  
        this.valorTaxa = valor.multiply(this.taxa.divide(new BigDecimal(100)));  
        return this.valorTaxa;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }
}