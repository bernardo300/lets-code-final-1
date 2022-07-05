import java.math.BigDecimal;

public class ContaInvestimento extends Conta{
    private BigDecimal taxaRendimento = new BigDecimal(0);
    private BigDecimal juros = new BigDecimal(0);
    private BigDecimal saldoInvestimento = new BigDecimal(0);
    private String tipoCliente;

    //public ContaInvestimento(String agencia, int conta, BigDecimal valor){
    public ContaInvestimento(String agencia, int conta){
        super.setAgencia(agencia);
        super.setConta(conta);
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
        this.taxaRendimento = taxaRendimento.divide(new BigDecimal(100));    
    }

    public BigDecimal getJuros() {
        return this.juros;
    }
    public void setJuros(BigDecimal juros) {
        this.juros = juros;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
