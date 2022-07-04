package br.com.mybank.db;

import java.util.ArrayList;

import br.com.mybank.models.conta.Conta;

public class MyBankDB {
    private static ArrayList<Conta> myDataBase = new ArrayList<Conta>();

    public static void abrirConta(Conta conta){
        if(myDataBase.contains(conta)){
            throw new RuntimeException("Conta ja existe");
        }
        myDataBase.add(conta);
    }

    public static Conta login(String numero){
        
        for (int i = 0; i < myDataBase.size(); i++) {
            if(myDataBase.get(i).getNumeroConta().equals(numero)){
                return myDataBase.get(i);
            }
        }
        throw new RuntimeException("Conta nao encontrada");
    }
}
