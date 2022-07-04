package br.com.mybank;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Scanner;

//package br.com.mybank;

public class Aplicacao {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        try {
            String tipoConta;
            String tipoCliente;
            String operacao;
            String agencia;
            int conta;
            BigDecimal valor = new BigDecimal(0);

            System.out.println("Informe número da agencia");
            agencia = sc.next();
            System.out.println("Informe numero da conta");
            conta = Integer.valueOf(sc.next().trim());
            System.out.println("conta informada: " + conta);
            System.out.println("Informe tipo de operaçao: 1 para depósito, 2 para saque, 3 para transferência");
            operacao = sc.next().trim();
            System.out.println("informe valor a transacionar. Exemplo: 9999,99");
            valor = sc.nextBigDecimal();

            tipoCliente = Integer.toString(conta);
            tipoCliente = tipoCliente.substring(0,2);
            System.out.println("tipo de Cliente: " + tipoCliente);

            // verifica tipo de cliente
            // se conta inicia com "10" é pessoa jurídica
            System.out.println("teste do equal: " + (Objects.equals(tipoCliente, "10")));

            if(tipoCliente.equals("10")){
                System.out.println("Informe tipo de conta: 1 para Conta Corrente, 2 Conta Investimento");
                tipoConta = sc.next().trim();
            //    if(tipoConta.equals("1"))
                if(tipoConta != "1" && tipoConta != "2"){   
                    System.out.println("Pessoas jurídicas não podem ter conta poupança");
                    System.exit(0);
                }
            } else {
            //    tipoCliente = "PF";
            //    String[] tp = new String[]{"1","2","3"};
                System.out.println("Informe tipo de conta: 1 para Conta Corrente, 2 Conta Investimento, 3 Conta Poupança");
                tipoConta = sc.next().trim();
                if(!(tipoConta.equals("1")) && !(tipoConta.equals("2")) && !(tipoConta.equals("3")) ) {
             //   if(tipoConta != "1" && tipoConta != "2" && tipoConta != "3"){   
                    System.out.println("opçao inválida");
                    System.exit(0);
                }
            }

            switch (tipoConta) {
                case "1":
                    operaContaCorrente(agencia, conta, valor, operacao, tipoCliente);
                    break;
                case "2":
                    operaContaInvestimento(agencia, conta, valor, operacao, tipoCliente);
                    break;
                case "3":
                    operaContaPoupanca(agencia, conta, valor, operacao,tipoCliente);
                    break;
            }
        } catch (Exception e) {
            System.out.println("erro de leitura: " + e);
        }
        finally{
            sc.close();
        }
    }

    public static void operaContaCorrente(String agencia, int conta, BigDecimal valor, String operacao, String tipoCliente) 
        throws MensagemErro {
        ContaCorrente cc = new ContaCorrente(agencia, conta, valor);
        System.out.println("entrou em CC");
        switch(operacao){
            case "1":
                cc.depositar(valor);
                break;
            case "2":
                if(tipoCliente.equals("10")){
                    cc.sacarPJ(valor);
                } else cc.sacarPF(valor);
                    cc.sacarPF(valor);
                break;
            case "3":
                ContaCorrente cd = new ContaCorrente(agencia, conta, valor);
                if(tipoCliente.equals("10")){
                    cc.sacarPJ(valor);
                } else cc.sacarPF(valor);

                cd.depositar(valor);
                break;
        }
    }

    public static void operaContaInvestimento(String agencia, int conta, BigDecimal valor,String operacao, String tipoCliente)
        throws MensagemErro {
        ContaInvestimento ci = new ContaInvestimento(agencia, conta, valor);
        System.out.println("entrou em CI");
        switch(operacao){
            case "1":
                ci.depositar(valor);
                break;
            case "2":
                 if(tipoCliente.equals("10")){
                     ci.sacar(valor);
                 } else ci.sacar(valor);
                     ci.sacar(valor);
                break;
            case "3": 
                ContaCorrente cd = new ContaCorrente(agencia, conta, valor);
                if(tipoCliente.equals("10")){
                    ci.sacar(valor);
                } else ci.sacar(valor);
                cd.depositar(valor);
                break;
        }

    }

    public static void operaContaPoupanca(String agencia, int conta, BigDecimal valor, String operacao, String tipoCliente) 
        throws MensagemErro {
        ContaPoupanca cp = new ContaPoupanca(agencia, conta, valor);
        System.out.println("entrou em CP");
        switch(operacao){
            case "1":
                cp.depositarPoupanca(valor);
                break;
            case "2":
                if(tipoCliente.equals("10")){
                    cp.sacar(valor);
                } else cp.sacar(valor);
                    cp.sacar(valor);
                break;
            case "3":
                ContaCorrente cd = new ContaCorrente(agencia, conta, valor);
                if(tipoCliente.equals("10")){
                    cp.sacar(valor);
                } else cp.sacar(valor);
                cd.depositar(valor);
                break;
        }
    }
}
