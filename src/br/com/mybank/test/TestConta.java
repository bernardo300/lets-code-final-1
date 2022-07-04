package br.com.mybank.test;

import br.com.mybank.models.cliente.ClientePF;
import br.com.mybank.models.cliente.ClientePJ;
import br.com.mybank.models.conta.ContaCorrente;
import br.com.mybank.models.conta.ContaPoupanca;

public class TestConta {
  
  public static void main(String[] args) {
    ContaCorrente c = new ContaCorrente("01", new ClientePJ("Kennedy"));
    ContaCorrente c1 = new ContaCorrente("02", new ClientePF("Gabriel"));
    //ContaPoupanca p = new ContaPoupanca("03", new ClientePF("Filho"));

    c.depositar(500);
    c.sacar(200);

    //c.tranferir(c1, 200);
    //c1.tranferir(c, 100);
    //c1.tranferir(p, 50);
    //p.sacar(30);
    System.out.println(c.getSaldo());
    //System.out.println(c1.consultaSaldo());
    //System.out.println(p.consultaSaldo());
  }
}
