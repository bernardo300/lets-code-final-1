package br.com.mybank.models.conta;

import br.com.mybank.OperacaoConsulta;
import br.com.mybank.OperacaoInvestir;
import br.com.mybank.models.cliente.Cliente;

public class ContaCorrente  extends Conta implements OperacaoConsulta, OperacaoInvestir{

  public ContaCorrente(String agencia, Cliente cliente) {
    super(agencia);
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
