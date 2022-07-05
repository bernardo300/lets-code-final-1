import java.math.BigDecimal;

public class ContaPoupanca extends Conta{
    private BigDecimal taxaRendimento = new BigDecimal(0);
    private BigDecimal juros = new BigDecimal(0);
    private BigDecimal saldoPoupanca = new BigDecimal(0);


    public ContaPoupanca(String agencia, int conta, BigDecimal valor){
        super.setAgencia(agencia);
        super.setConta(conta);
    }

    public void sacarPoupanca(BigDecimal valor) throws MensagemErro {
        super.sacar(valor);
    }

    public void depositarPoupanca(BigDecimal valor) throws MensagemErro{  
        super.depositar(valor);
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
        this.taxaRendimento = BigDecimal.valueOf(taxa.doubleValue()/100);
    }
    public BigDecimal getJuros() {
        return this.juros;
    }
    public void setJuros(BigDecimal juros) {
        this.juros = juros;
    }
}