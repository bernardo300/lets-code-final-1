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

            System.out.println(" -----------------------------------------");
            System.out.println("  Informe número da agencia com 4 dígitos ");
            System.out.println(" -----------------------------------------");

            agencia = sc.next();
            System.out.println(" ----------------------------------------");
            System.out.println("Informe numero da conta");
            System.out.println(" ----------------------------------------");

            conta = Integer.valueOf(sc.next().trim());
            System.out.println("conta informada: " + conta);

            tipoCliente = Integer.toString(conta);
            tipoCliente = tipoCliente.substring(0,2);
            System.out.println("tipo de Cliente: " + tipoCliente);

            // verifica tipo de cliente
            // se conta inicia com "10" é pessoa jurídica
            System.out.println("teste do equal: " + (Objects.equals(tipoCliente, "10")));

            if(tipoCliente.equals("10")){
                System.out.println("Informe tipo de conta: 1 para Conta Corrente, 2 Conta Investimento");
                tipoConta = sc.next().trim();
           //     tipoConta = Integer.toString(tipoConta);
                if(tipoConta.equals("1") && tipoConta.equals("2")) {   
                    System.out.println("Pessoas jurídicas não podem ter conta poupança");
                    System.exit(0);
                }
                tipoCliente = "PJ";
            } else {
                System.out.println("Informe tipo de conta: 1 para Conta Corrente, 2 Conta Investimento, 3 Conta Poupança");
                tipoConta = sc.next().trim();
                if(!(tipoConta.equals("1")) && !(tipoConta.equals("2")) && !(tipoConta.equals("3")) ) {
                    System.out.println("opçao inválida");
                    System.exit(0);
                }
                tipoCliente = "PF";
                System.out.println(" tipo cliente: " + tipoCliente);
            }

            System.out.println("Informe tipo de operaçao: 1 para depósito, 2 para saque, 3 para transferência");
            operacao = sc.next().trim();
            System.out.println("informe valor a transacionar. Exemplo: 9999,99");
            valor = sc.nextBigDecimal();


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
            System.out.println(e);
        }
        finally{
            sc.close();
        }
    }

    public static void operaContaCorrente(String agencia, int conta, BigDecimal valor, String operacao, String tipoCliente) 
        throws MensagemErro {
        ContaCorrente cc = new ContaCorrente(agencia, conta, valor);
        System.out.println("entrou em CC");

        BigDecimal deposito = new BigDecimal(5000.00);    // lixo
        cc.depositar(deposito);                                // lixo

        switch(operacao){
            case "1":
                cc.depositar(valor);
                System.out.println(" saldo apos depositar: " + cc.getSaldo());
                break;
            case "2":
                switch(tipoCliente){
                    case "PJ":
                    System.out.println(" entrou em sacar PJ");     // LIXO
                        cc.sacarPJ(valor);
                        System.out.println(" saldo apos sacar PJ: " + cc.getSaldo());
                        break;
                    case "PF":
                        cc.sacarPF(valor);
                        System.out.println(" saldo apos sacar PF: " + cc.getSaldo());

                        break;
                }
                break;
            case "3":
                ContaCorrente cd = new ContaCorrente(agencia, conta, valor);
                System.out.println("valor da transferencia: " + valor);
                System.out.println("saldo depois da transfer com sacar: " + cc.getSaldo());
                cc.transferir(valor, cd);
                System.out.println(" saldo apos TRANSFER origem: " + cc.getSaldo() + " saldo do destino: " + cd.getSaldo());

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
                ci.sacar(valor);
                break;
            case "3":
                ContaCorrente cd = new ContaCorrente(agencia, conta, valor);
                System.out.println("valor da transferencia: " + valor);
                System.out.println("saldo depois da transfer com sacar: " + ci.getSaldo());
                ci.transferir(valor, cd);
                break;
        }

    }

    public static void operaContaPoupanca(String agencia, int conta, BigDecimal valor, String operacao, String tipoCliente) 
        throws MensagemErro {
        ContaPoupanca cp = new ContaPoupanca(agencia, conta, valor);
        System.out.println("entrou em CP");

        switch(operacao){
            case "1":
                cp.depositar(valor);
                break;
            case "2":
                cp.sacar(valor);
                break;
            case "3":
                ContaPoupanca cd = new ContaPoupanca(agencia, conta, valor);
                System.out.println("valor da transferencia: " + valor);
                System.out.println("saldo depois da transfer com sacar: " + cp.getSaldo());
                cp.transferir(valor, cd);
                break;
        }
    }
}
