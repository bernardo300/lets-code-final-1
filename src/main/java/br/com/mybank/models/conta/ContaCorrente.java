package br.com.mybank.models.conta;
import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.mybank.interfaces.OperacaoConsultaSaldo;
import br.com.mybank.interfaces.OperacaoInvestir;
import br.com.mybank.models.cliente.Cliente;
import br.com.mybank.models.cliente.ClientePessoaFisica;
import br.com.mybank.models.exceptions.MensagemErro;

public class ContaCorrente extends Conta implements OperacaoConsultaSaldo, OperacaoInvestir{
    public ContaCorrente(String agencia, int conta, Cliente titular){
        super(agencia, conta, titular);
    }

    public void sacar(BigDecimal valor) throws MensagemErro{
        if(getTitular() instanceof ClientePessoaFisica) {
            super.sacar(valor);
        } else {
            super.taxa = calculaValorTaxa(valor);
            valor = valor.add(this.taxa);
            super.sacar(valor);
        }
    }

    private BigDecimal calculaValorTaxa(BigDecimal valor){  
        return valor.multiply(this.taxa.divide(new BigDecimal(100)));
    }

    @Override
    public BigDecimal investir() {   
        return  getSaldo().multiply(this.taxaRendimento.divide(new BigDecimal(100))).add(getSaldo()).setScale(2,RoundingMode.DOWN);
    }

    @Override
    public BigDecimal consultarSaldo() {
        return getSaldo();
    }
}