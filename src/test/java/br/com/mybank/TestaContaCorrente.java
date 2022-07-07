package br.com.mybank;
import java.math.BigDecimal;

import br.com.mybank.models.cliente.ClientePessoFisica;
import br.com.mybank.models.cliente.ClientePessoaJuridica;
import br.com.mybank.models.conta.ContaCorrente;
import br.com.mybank.models.exceptions.MensagemErro;

public class TestaContaCorrente {

    public static void main(String[] args) throws MensagemErro {
        BigDecimal deposito = new BigDecimal("2000.40");
        BigDecimal valorTransfer = new BigDecimal("100.00");
        BigDecimal saque = new BigDecimal("200.30");
        BigDecimal taxa = new BigDecimal(10);
        String ageDestino = "1003" ;
        int contaDestino = 787878;

        BigDecimal sd = new BigDecimal(0);
        BigDecimal sdd = new BigDecimal(0);


        ContaCorrente ct = new ContaCorrente("5114", 12345, new ClientePessoFisica("Bill Gates"));
        ContaCorrente cd = new ContaCorrente(ageDestino, contaDestino, new ClientePessoaJuridica("nos"));

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
        ct.sacar(saque);
        sd = ct.getSaldo();
        System.out.println(" ");
        System.out.println("saldo após saque PF: " + sd);
        

        //set e get titular
        System.out.println("O titular é: " + ct.getTitular());
        

        //  TESTES PARA PESSOA JURÍDICA

        // Testa saque PJ
         ct.setTaxa(taxa);
         ct.sacar(saque);

         System.out.println("o valor da taxa para sq e transfer: " + ct.calculaValorTaxa(saque));

        // testa depositar 
         ct.setTaxa(taxa);
         ct.depositar(deposito);
         ct.depositar(deposito);
         sd = ct.getSaldo();
         System.out.println("saldo após depósito de PJ - 54: " + sd);

        //  System.exit(0);   //saída

        //   TRANSFERENCIAS

         // Testa transferir PF
         System.out.println("valor da transferencia: " + valorTransfer);
         ct.sacar(valorTransfer);
         System.out.println("saldo depois da transfer com sacar: " + ct.getSaldo());
         cd.depositar(valorTransfer);
         sd = ct.getSaldo();
         sdd = cd.getSaldo();
         System.out.println(" ");
         System.out.println("saldo após transfer com depositar: " + sdd);
 
        //  Testa transferir PJ
         System.out.println("valor da transferencia: " + valorTransfer);
         ct.sacar(valorTransfer);
         System.out.println("saldo depois da transfer com sacar: " + ct.getSaldo());
         cd.depositar(valorTransfer);
         sd = ct.getSaldo();
         sdd = cd.getSaldo();
         System.out.println(" ");
         System.out.println("saldo após transfer com depositar: " + sdd);
 
    }
}
