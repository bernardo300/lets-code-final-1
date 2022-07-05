import java.math.BigDecimal;

public class ContaInvestimento extends Conta{
    private BigDecimal taxaRendimento = new BigDecimal(0);
    private BigDecimal juros = new BigDecimal(0);
    private BigDecimal saldoInvestimento = new BigDecimal(0);

    public ContaInvestimento(String agencia, int conta, BigDecimal valor){
        super.setAgencia(agencia);
        super.setConta(conta);
    }

    //@Override
    public void depositar(BigDecimal valor) throws MensagemErro {           
        super.depositar(valor);
    }

    //@Override
    public void sacar(BigDecimal valor) throws MensagemErro{  
        super.sacar(valor);
    }

    public void transferir(BigDecimal valor, Conta cd) throws MensagemErro { 
        this.sacar(valor);
        cd.depositar(valor);
    }

    public BigDecimal jurosInvestimento(){
        this.saldoInvestimento = super.getSaldo();
        this.juros = this.saldoInvestimento.multiply(this.taxaRendimento);
        return this.juros;
    }

    public BigDecimal getSaldoInvestimentoSemJuros() {
        return super.getSaldo();
    }

    public BigDecimal getSaldoInvestimentoComJuros() {
        this.saldoInvestimento = super.getSaldo();
        juros = jurosInvestimento();
        this.saldoInvestimento = this.saldoInvestimento.add(juros);
        super.setSaldo(this.saldoInvestimento);
        return this.saldoInvestimento;
    }
    
    public BigDecimal getTaxaRendimento() {
        return taxaRendimento;
    }
    public void setTaxaRendimento(BigDecimal taxaRendimento) {
        this.taxaRendimento = BigDecimal.valueOf(taxaRendimento.doubleValue()/100);
    }

    public BigDecimal getJuros() {
        return this.juros;
    }
    public void setJuros(BigDecimal juros) {
        this.juros = juros;
    }

}

