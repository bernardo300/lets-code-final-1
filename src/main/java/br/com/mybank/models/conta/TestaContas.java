package br.com.mybank.models.conta;

import java.math.BigDecimal;

import br.com.mybank.models.cliente.ClientePessoFisica;
import br.com.mybank.models.cliente.ClientePessoaJuridica;
import br.com.mybank.models.exceptions.MensagemErro;

public class TestaContas{
    
        public static void main(String[] args) throws MensagemErro {
            BigDecimal deposito = new BigDecimal("2000.40");
            BigDecimal valorTransfer = new BigDecimal("100.00");
            BigDecimal saque = new BigDecimal("100.30");

            ContaCorrente ct = new ContaCorrente("5114", 12345, new ClientePessoFisica("Bill Gates"));
            ContaCorrente cd = new ContaCorrente("1003", 787878, new ClientePessoaJuridica("nos"));
    
            // TESTES DEPÓSITO
    
            // depositar PF e PJ 
            System.out.println(" ");
            System.out.printf("Valor do depósito: " + deposito + "  " + "valor do saque: " + saque);
    
            ct.depositar(deposito);
            System.out.println(" ");
            System.out.println("saldo após depósito PF: " + ct.getSaldo());
    

            //  TESTES PARA SAQUE

            // saque PF
            ct.setSaldo(deposito);
            ct.sacar(saque);
            System.out.println(" ");
            System.out.println("saldo após saque PF: " + ct.getSaldo());
            System.out.println(" ");

    
            // Testa saque PJ
            ct.setSaldo(deposito);
            ct.sacar(saque);
            System.out.println("saldo após saque PJ: " + ct.getSaldo());
            System.out.println(" ");

    
            //   TRANSFERÊNCIAS
    
             // Testa transferir PF
             System.out.println("valor da transferencia: " + valorTransfer);
             ct.setSaldo(deposito);
             ct.transferir(valorTransfer, cd);
             System.out.println("PF-saldo depois da transfer-origem: " + ct.getSaldo() + " saldo destino: " + cd.getSaldo());
             System.out.println(" ");

     
              //  Testa Transferir PJ
            System.out.println("valor da transferencia: " + valorTransfer);
            ct.setSaldo(deposito);
            ct.transferir(valorTransfer, cd);
            System.out.println("PJ-saldo depois da transfer-origem: " + ct.getSaldo() + " saldo destino: " + cd.getSaldo());
            System.out.println(" ");
        }
}
