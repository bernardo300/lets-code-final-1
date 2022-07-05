import java.math.BigDecimal;

public class ContaCorrente extends Conta{
    private BigDecimal limite = new BigDecimal(0);
    private BigDecimal taxa = new BigDecimal(0.5);
    private BigDecimal valor = new BigDecimal(0);
    private BigDecimal valorTaxa = new BigDecimal(0);

    public ContaCorrente(String agencia, int conta, BigDecimal valor){
        super.setAgencia(agencia);
        super.setConta(conta);
    }

    //@Override
    public void depositar(BigDecimal valor) throws MensagemErro{    
        System.out.println(("valor dentro do deposito: " + valor));
        super.depositar(valor);
    }

    public void sacarPF(BigDecimal valor) throws MensagemErro{
        super.sacar(valor);
    }

    public void sacarPJ(BigDecimal valor) throws MensagemErro{
        valorTaxa = calculaValorTaxa(valor);
        System.out.println(("taxa e valor dentro do sacarPJ: " + valorTaxa + " " + valor));
        this.valor = valor.add(valorTaxa);
        super.sacar(this.valor);
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