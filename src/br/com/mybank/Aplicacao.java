package br.com.mybank;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Scanner;

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
            BigDecimal taxaRendimento = new BigDecimal(0);
            BigDecimal taxaSaque = new BigDecimal(0.5);


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
                if(tipoConta.equals("1"))
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
                    operaContaCorrente(agencia, conta, valor, operacao);
                    break;
                case "2":
                    operaContaInvestimento(agencia, conta, valor, operacao);
                    break;
                case "3":
                    operaContaPoupanca(agencia, conta, valor, operacao);
                    break;
            }
        } catch (Exception e) {
            System.out.println("erro de leitura: " + e);
        }
        finally{
            sc.close();
        }
    }

    public static void operaContaCorrente(String agencia, int conta, BigDecimal valor, String operacao) throws SaldoInsuficienteException {
        ContaCorrente cc = new ContaCorrente(agencia, conta, valor);
        System.out.println("entrou em CC");
        switch(operacao){
            case "1":
                cc.depositarPF(valor);
                break;
            case "2":
                cc.sacarPF(valor);
                break;
            case "3":
            //        cc.transferir(valor, destino);
                cc.sacarPF(valor);
            case "4":
            //    cc.setTaxa(taxaSaque);
                break;
        }
    }

    public static void operaContaInvestimento(String agencia, int conta, BigDecimal valor,String operacao) throws SaldoInsuficienteException {
        ContaInvestimento ci = new ContaInvestimento(agencia, conta, valor);
        System.out.println("entrou em CI");
        switch(operacao){
            case "1":
                ci.depositarInvestimento(valor);
                break;
            case "2":
                ci.sacarInvestimento(valor);
                break;
            case "3": 
            //    ci.setTaxaRendimento(taxaRendimento);
                break;
        }

    }

    public static void operaContaPoupanca(String agencia, int conta, BigDecimal valor, String operacao) throws SaldoInsuficienteException {
        ContaPoupanca cp = new ContaPoupanca(agencia, conta, valor);
        System.out.println("entrou em CP");
        switch(operacao){
            case "1":
                cp.depositarPoupanca(valor);
                break;
            case "2":
                cp.sacarPoupanca(valor);
                break;
            case "3": 
            //    cp.setTaxaRendimento(taxaRendimento);
                break;
        }

    }

}
