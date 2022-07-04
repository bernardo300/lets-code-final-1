package br.com.mybank.models.conta;

import br.com.mybank.interfaces.OperacaoConsulta;
import br.com.mybank.interfaces.OperacaoInvestir;
import br.com.mybank.models.cliente.Cliente;
import br.com.mybank.models.cliente.ClientePF;
import br.com.mybank.models.cliente.ClientePJ;
public class ContaPoupanca extends Conta implements OperacaoConsulta, OperacaoInvestir{

  public ContaPoupanca(String numero, ClientePF cliente) {
    super(numero);
    super.cliente = cliente;  
  }

  @Override
  public void investir(double valor) {
    setValorInvestido(super.sacar(valor));
    
  }

  @Override
  public double consultaSaldo() {
    return this.saldo;
  }
  
}
