package br.com.mybank.models.conta;

import br.com.mybank.OperacaoInvestir;
import br.com.mybank.models.cliente.Cliente;

public class ContaInvestimento  extends Conta implements OperacaoInvestir{

  public ContaInvestimento(String agencia, Cliente cliente) {
    super(agencia);
    super.cliente = cliente; 
  }

  @Override
  public void investir(double valor) {
    setValorInvestido(super.sacar(valor * 1.02));  
  }
}
