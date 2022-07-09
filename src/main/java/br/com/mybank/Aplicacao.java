package br.com.mybank;

import java.math.BigDecimal;
import java.util.Scanner;

import br.com.mybank.db.MyBankDB;
import br.com.mybank.models.cliente.Cliente;
import br.com.mybank.models.cliente.ClientePessoaFisica;
import br.com.mybank.models.cliente.ClientePessoaJuridica;
import br.com.mybank.models.conta.Conta;
import br.com.mybank.models.conta.ContaCorrente;
import br.com.mybank.models.exceptions.MensagemErro;

public class Aplicacao {
    public static void main(String[] args) throws MensagemErro {
        //basePovoar();
        menuPrincipal();
    }
    public static void menuPrincipal() throws MensagemErro{
    //    clear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("___________________________________");
        System.out.println("|          __SISBB__              |");
        System.out.println("|                                 |");
        System.out.println("|1 - NOVA CONTA                   |");
        System.out.println("|2 - LOGIN                        |");
        System.out.println("|_________________________________|");
        int escolha = scanner.nextInt();
        switch(escolha){
            case 1:
                menuNovaConta();
                break;
            case 2:
                menuLogin();
                break;
            default:
                System.out.println("opcao invalida");
        }
        scanner.close();
    }

    private static void menuNovaConta() throws MensagemErro {
        clear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("___________________________________");
        System.out.println("           --SISBB--               ");

        System.out.println("Agencia da conta: ");
        String agencia = scanner.next();
        System.out.println("Numero da conta: ");
        int numero = scanner.nextInt();
        System.out.println("Nome do cliente: ");
        scanner.nextLine();
        String cliente = scanner.nextLine();
        Cliente tipoCliente = verificaTipoCliente(numero, cliente);
        ContaCorrente c = new ContaCorrente(agencia, numero, tipoCliente);
        //    ContaCorrente c = new ContaCorrente(agencia, numero, new ClientePessoaFisica(cliente));
        menuTipoConta(numero, tipoCliente);
        MyBankDB.abrirConta(c);
        scanner.close();
        menuPrincipal();
    }

    private static Cliente verificaTipoCliente(int numero, String cliente){
        String tipoConta = Integer.toString(numero);
        tipoConta = tipoConta.substring(0,2);
        Cliente tipoCliente;
        if(tipoConta.equals("10")){
            tipoCliente = new ClientePessoaJuridica(cliente);
        } else {
            tipoCliente = new ClientePessoaFisica(cliente);
        }
        return tipoCliente;
    }

    private static void menuTipoConta(int numero, Cliente tipoCliente) throws MensagemErro {
        clear();
        System.out.println("CONTA CORRENTE: 1");
        System.out.println("CONTA POUPANÇA: 2");
        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();
        if(escolha == 2 && (tipoCliente instanceof ClientePessoaJuridica)){
            System.out.println("Pessoa jurídica não pode abrir conta poupança");
            menuPrincipal();
        }
        scanner.close();
    }

    private static void menuLogin() throws MensagemErro {
        clear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Numero da conta pra logar: ");
        int numero = scanner.nextInt();
        Conta c = MyBankDB.login(numero);
        if(c != null){
            menuConta(numero);
        }
        scanner.close();
    }

    private static Conta contaDestino() {
        clear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Numero da conta de destino: ");
        int numero = scanner.nextInt();
        Conta dest = MyBankDB.login(numero);
        if(dest == null){
            System.out.println("conta inválida");
            scanner.close();
        }
        scanner.close();
        return dest;
    }

    private static void menuConta(int numero) throws MensagemErro {
        clear();
        Conta conta = MyBankDB.login(numero);
        System.out.println("DEPOSITAR   : 1");
        System.out.println("SACAR       : 2");
        System.out.println("TRANSFERIR  : 3");
        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();
        System.out.println("Informe valor no formato 9999.00");
        double infoValor = scanner.nextDouble();
        BigDecimal valor = BigDecimal.valueOf(infoValor);
        scanner.close();
        switch(escolha){
            case 1:
                menuDepositar(valor, conta);
                break;
            case 2:
                menuSacar(valor, conta);
                break;
            case 3:
                Conta dest = contaDestino();
                menuTransferir(valor, conta, dest);
                break;
            default:
                System.out.println("opcao invalida");
                break;
        }
        scanner.close();
    }
 
    private static void menuDepositar(BigDecimal valor, Conta conta) throws MensagemErro {
        conta.depositar(valor);
    }

    private static void menuSacar(BigDecimal valor, Conta conta) throws MensagemErro {
        conta.sacar(valor);
    }

    private static void menuTransferir(BigDecimal valor, Conta conta, Conta dest) throws MensagemErro {
        conta.transferir(valor, dest);
    }

 
    public static void basePovoar(){

    }
    
    private static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
