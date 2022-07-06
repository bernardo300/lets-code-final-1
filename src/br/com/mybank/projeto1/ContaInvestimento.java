package br.com.mybank.projeto1;
import java.math.BigDecimal;

public class ContaInvestimento extends Conta{
    private BigDecimal taxaRendimento = new BigDecimal(0);
    private BigDecimal juros = new BigDecimal(0);
    private BigDecimal saldoInvestimento = new BigDecimal(0);

    public ContaInvestimento(String agencia, int conta, Cliente titular){
        super(agencia, conta, titular);
    }

    public BigDecimal jurosInvestimento(){
        if(getTitular() instanceof ClientePessoaJuridica) {
            this.setTaxaRendimento(this.taxaRendimento = this.taxaRendimento.add(new BigDecimal(2)));
        }
        this.saldoInvestimento = super.getSaldo();
        this.juros = this.saldoInvestimento.multiply(this.taxaRendimento);
        return this.juros;
    }

    @Override
    public BigDecimal getSaldo(){
    //public BigDecimal getSaldoInvestimentoComJuros() {
        this.saldoInvestimento = super.getSaldo();
        juros = jurosInvestimento();
        this.saldoInvestimento = this.saldoInvestimento.add(juros);
        super.setSaldo(this.saldoInvestimento);
        return super.getSaldo();
    }
    
    public BigDecimal getTaxaRendimento() {
        return taxaRendimento;
    }
    public void setTaxaRendimento(BigDecimal taxaRendimento) {
        this.taxaRendimento = taxaRendimento.divide(new BigDecimal(100));    
    }

    public BigDecimal getJuros() {
        return this.juros;
    }
    public void setJuros(BigDecimal juros) {
        this.juros = juros;
    }
}

