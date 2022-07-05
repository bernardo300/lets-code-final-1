import java.math.BigDecimal;

public class TestaContas {

    public static void main(String[] args) throws MensagemErro {
        BigDecimal deposito = new BigDecimal("2000.40");
        BigDecimal saque = new BigDecimal("1000.30");
        BigDecimal taxa = new BigDecimal(1);
        String ageDestino = "1003" ;
        int contaDestino = 787878;

        BigDecimal sd = new BigDecimal(0);
        BigDecimal sdd = new BigDecimal(0);


        ContaCorrente ct = new ContaCorrente("5114", 12345, deposito);
        ContaCorrente cd = new ContaCorrente(ageDestino, contaDestino, deposito);

        // TESTES PARA PESSOA FÍSICA

        // Testa deposito PF
        System.out.println(" ");
        System.out.printf("Valor do depósito: " + deposito + "  " + "valor do saque: " + saque);

        ct.depositar(deposito);
        sd = ct.getSaldo();
        System.out.println(" ");
        System.out.println("saldo após depósito PF: " + sd);

        // Testa saque PF
        ct.setTaxa(taxa);
        ct.sacarPF(saque);
        sd = ct.getSaldo();
        System.out.println(" ");
        System.out.println("saldo após saque PF: " + sd);

        //set e get titular
        ct.setTitular("Bill Gates");
        System.out.println("O titular é: " + ct.getTitular());
        

        //  TESTES PARA PESSOA JURÍDICA
         // Testa saque PJ
         ct.setTaxa(taxa);
         ct.sacarPJ(saque);

         System.out.println("o valor da taxa para sq e transfer: " + ct.calculaValorTaxa(saque));

         sd = ct.getSaldo();
         sdd = cd.getSaldo();
         System.out.println(" ");
         System.out.println("saldo após saque PJ: " + sd);
         System.out.println("saldo da conta destino PJ: " + sdd);

    }
}
