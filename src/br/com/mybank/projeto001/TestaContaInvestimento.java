import java.math.BigDecimal;

public class TestaContaInvestimento {

    public static void main(String[] args) throws MensagemErro {

        BigDecimal deposito = new BigDecimal("5000.40");
        BigDecimal valorTransfer = new BigDecimal("100.00");
        BigDecimal saque = new BigDecimal("200.30");
        BigDecimal taxa = new BigDecimal(10);

        BigDecimal sd = new BigDecimal(0);
        BigDecimal sdd = new BigDecimal(0);

        ContaInvestimento ci = new ContaInvestimento("5114", 12345, deposito);
        ContaCorrente cd = new ContaCorrente("1003", 787878, valorTransfer);


        // TESTES PARA PESSOA FÍSICA

        // Testa deposito PF e PJ
        ci.setTipoCliente("PJ");
        cd.setTipoCliente("PJ");
        
        System.out.println(" ");
        System.out.printf("Valor do depósito: " + deposito + "  " + "valor do saque: " + saque);

        ci.setTaxaRendimento(taxa);
        ci.depositar(deposito);
        sd = ci.getSaldo();
        System.out.println(" ");
        System.out.println("saldo após depósito investimento: " + sd);

        System.out.println("valor da taxa: " + ci.getTaxaRendimento());
        ci.setTaxaRendimento(taxa);
        sd = ci.getSaldoInvestimentoSemJuros();
        System.out.println(" ");
        System.out.println("saldo investimento SEM juros " + sd);

        ci.setTaxaRendimento(taxa);
        sd = ci.getSaldoInvestimentoComJuros();
        System.out.println(" ");
        System.out.println("saldo investimento com juros " + sd);

       
        sd = ci.getJuros();
        System.out.println(" ");
        System.out.println("juros do investimento " + sd);

        // TESTA TRANSFERENCIA
         System.out.println("valor da transferencia para PF: " + valorTransfer);
         ci.transferir(valorTransfer, cd);
         sd = ci.getSaldo();
         sdd = cd.getSaldo();
         System.out.println(" ");
         System.out.println("saldo após transfer com depositar: origem: " + sd + " saldodestino: " + sdd);
 
    }
}

