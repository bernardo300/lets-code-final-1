package br.com.mybank;

import java.util.Scanner;

import br.com.mybank.models.conta.Conta;

public class Aplicacao {
  public static void main(String[] args) {

        //basePovoar();
        menuPrincipal();

    }
    public static void menuPrincipal(){
        clear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("NOVA CONTA - 1");
        System.out.println("LOGIN - 2");
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
        System.out.println("Agencia: ");
        System.out.println("Numero da conta: ");
    }

    private static void menuLogin() {
        clear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Numero da conta pra logar: ");
        String escolha3 = scanner.next();
    }

    private static void menuConta(String numero) {
        clear();
        System.out.println("DEPOSITAR :  1");
        System.out.println("TRANSFERIR  : 2");
        Scanner scanner = new Scanner(System.in);

    }
 

    private static void menuDepositar(double valor) {
    }

    private static void menuTransferi(double valor, Conta conta) {
    }

 
    public static void basePovoar(){

    }
    private static void clear(){
      System.out.print("\033[H\033[2J");
      System.out.flush();
    }
}
