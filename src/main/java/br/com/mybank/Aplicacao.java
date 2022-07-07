package br.com.mybank;

import java.util.Scanner;

import br.com.mybank.db.MyBankDB;
import br.com.mybank.models.cliente.ClientePessoaFisica;
import br.com.mybank.models.conta.Conta;
import br.com.mybank.models.conta.ContaCorrente;

public class Aplicacao {
    public static void main(String[] args) {
        //basePovoar();
        menuPrincipal();
    }
    public static void menuPrincipal(){
        clear();
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
    }

    private static void menuNovaConta() {
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
        ContaCorrente c = new ContaCorrente(agencia, numero, new ClientePessoaFisica(cliente));
        MyBankDB.abrirConta(c);
        menuPrincipal();
    }

    private static void menuLogin() {
        clear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Numero da conta pra logar: ");
        int numero = scanner.nextInt();
        Conta c = MyBankDB.login(numero);
        if(c != null){
            menuConta(numero);
        }
    }

    private static void menuConta(int numero) {
        clear();
        Conta conta = MyBankDB.login(numero);
        System.out.println("DEPOSITAR :  1");
        System.out.println("TRANSFERIR  : 2");
        Scanner scanner = new Scanner(System.in);

    }
 

    private static void menuDepositar(double valor) {
    }

    private static void menuTransferir(double valor, Conta conta) {
    }

 
    public static void basePovoar(){

    }
    
    private static void clear(){
      System.out.print("\033[H\033[2J");
      System.out.flush();
    }
}
