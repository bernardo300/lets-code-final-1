import java.math.BigDecimal;
public class TestaContaPoupanca {

    public static void main(String[] args) throws MensagemErro {
        BigDecimal deposito = new BigDecimal("5000.40");
        BigDecimal valorTransfer = new BigDecimal("100.00");
        BigDecimal saque = new BigDecimal("200.30");
        BigDecimal taxa = new BigDecimal(10);

        BigDecimal sd = new BigDecimal(0);
        BigDecimal sdd = new BigDecimal(0);

        ContaPoupanca cp = new ContaPoupanca("5114", 12345, deposito);
        ContaCorrente cd = new ContaCorrente("1003", 787878, valorTransfer);

        // TESTES PARA PESSOA FÍSICA

        // Testa deposito PF e PJ
        System.out.println(" ");
        System.out.printf("Valor do depósito: " + deposito + "  " + "valor do saque: " + saque);

        cp.setTaxaRendimento(taxa);
        cp.depositar(deposito);
        sd = cp.getSaldo();
        System.out.println(" ");
        System.out.println("saldo após depósito poupança: " + sd);
        System.out.println(" ");
        System.out.println("valor da taxa: " + cp.getTaxaRendimento());

        System.out.println(" ");
        cp.setTaxaRendimento(taxa);
        sd = cp.getsaldoPoupancaSemJuros();
        System.out.println(" ");
        System.out.println("saldo investimento SEM juros " + sd);

        System.out.println(" ");
        cp.setTaxaRendimento(taxa);
        sd = cp.getsaldoPoupancaComJuros();
        System.out.println(" ");
        System.out.println("saldo investimento COM juros " + sd);

        sd = cp.getJuros();
        System.out.println(" ");
        System.out.println("juros da poupança " + sd);

         // TESTA TRANSFERENCIA
         System.out.println("valor da transferencia para PF: " + valorTransfer);
         cp.transferir(valorTransfer, cd);
         sd = cp.getSaldo();
         sdd = cd.getSaldo();
         System.out.println(" ");
         System.out.println("saldo após transfer com depositar: origem: " + sd + " saldodestino: " + sdd);
 
    }
}

