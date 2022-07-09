package br.com.mybank.models.conta;
import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.mybank.models.cliente.Cliente;
import br.com.mybank.models.cliente.ClientePessoaJuridica;

public class ContaInvestimento extends Conta{


    public ContaInvestimento(String agencia, int conta, Cliente titular){
        super(agencia, conta, titular);
    }

    private BigDecimal jurosInvestimento(){
        if(getTitular() instanceof ClientePessoaJuridica) {
            this.setTaxaRendimento(this.taxaRendimento.add(new BigDecimal(2)));
        }

        this.saldoInvestimento = super.getSaldo();
        return this.saldoInvestimento.multiply(this.taxaRendimento);
    }

    public BigDecimal investir() {
        setSaldo(getSaldo().multiply(this.taxaRendimento.divide(new BigDecimal(100))).add(getSaldo()).setScale(2,RoundingMode.DOWN));
        return getSaldo();
    }
    
    public BigDecimal getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(BigDecimal taxaRendimento) {
        this.taxaRendimento = taxaRendimento.divide(new BigDecimal(100));    
    }
}