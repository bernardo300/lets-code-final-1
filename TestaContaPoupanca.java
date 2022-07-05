import java.math.BigDecimal;
public class TestaContaPoupanca {

    public static void main(String[] args) throws MensagemErro {
        BigDecimal deposito = new BigDecimal("2000.40");
        BigDecimal saque = new BigDecimal("1000.30");
        BigDecimal taxa = new BigDecimal(10);

        
        BigDecimal sd = new BigDecimal(0);

        ContaPoupanca ci = new ContaPoupanca("5114", 12345);

        // TESTES PARA PESSOA FÍSICA

        // Testa deposito PF
        System.out.println(" ");
        System.out.printf("Valor do depósito: " + deposito + "  " + "valor do saque: " + saque);

        ci.setTaxaRendimento(taxa);
        ci.depositar(deposito);
        sd = ci.getSaldo();
        System.out.println(" ");
        System.out.println("saldo após depósito poupança metodo depositarpoupanca " + sd);

        ci.setTaxaRendimento(taxa);
        ci.depositar(deposito);
        sd = ci.getSaldo();
        System.out.println(" ");
        System.out.println("saldo após depósito investimento com metodo depositar " + sd);

        System.out.println("valor da taxa: " + ci.getTaxaRendimento());

        ci.setTaxaRendimento(taxa);
        sd = ci.getsaldoPoupancaSemJuros();
        System.out.println(" ");
        System.out.println("saldo investimento SEM juros " + sd);

        ci.setTaxaRendimento(taxa);
        sd = ci.getsaldoPoupancaComJuros();
        System.out.println(" ");
        System.out.println("saldo investimento COM juros " + sd);

       
        ci.depositar(deposito);
        sd = ci.getJuros();
        System.out.println(" ");
        System.out.println("juros da poupança " + sd);
 
    }
}

