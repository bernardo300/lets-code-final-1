package br.com.mybank.models.conta;
import java.math.BigDecimal;

import br.com.mybank.models.cliente.ClientePessoaFisica;
import br.com.mybank.interfaces.ConsultaSaldo;


public class ContaPoupanca extends Conta implements ConsultaSaldo {
    private BigDecimal taxaRendimento = new BigDecimal(0);
    private BigDecimal juros = new BigDecimal(0);
    private BigDecimal saldoPoupanca = new BigDecimal(0);

    //public ContaPoupanca(String agencia, int conta, BigDecimal valor){
        public ContaPoupanca(String agencia, int conta, ClientePessoaFisica titular){
            super(agencia, conta, titular);
        }

    public BigDecimal jurosPoupanca(){
        this.saldoPoupanca = super.getSaldo();
        this.juros = this.saldoPoupanca.multiply(this.taxaRendimento);
        return this.juros;
    }

    public BigDecimal getsaldoPoupancaComJuros() {
        this.saldoPoupanca = this.saldoPoupanca.add(jurosPoupanca());
        return saldoPoupanca;
    }

    public BigDecimal getsaldoPoupancaSemJuros() {
        return super.getSaldo();
    }
    
    public BigDecimal getTaxaRendimento() {
        return taxaRendimento;
    }
    public void setTaxaRendimento(BigDecimal taxa) {
        this.taxaRendimento = taxaRendimento.divide(new BigDecimal(100));   
    }
    public BigDecimal getJuros() {
        return this.juros;
    }
    public void setJuros(BigDecimal juros) {
        this.juros = juros;
    }
    public BigDecimal consultarSaldo(){
        return super.getSaldo();
    }
}
