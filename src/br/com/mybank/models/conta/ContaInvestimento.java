package br.com.mybank.models.conta;

import br.com.mybank.interfaces.OperacaoInvestir;
import br.com.mybank.models.cliente.Cliente;

public class ContaInvestimento  extends Conta implements OperacaoInvestir{

  public ContaInvestimento(String numero, Cliente cliente) {
    super(numero);
    super.cliente = cliente; 
  }

  @Override
  public void investir(double valor) {
    setValorInvestido(super.sacar(valor * 1.02));  
  }
}
