package br.com.mybank.models.conta;

import br.com.mybank.OperacaoConsulta;
import br.com.mybank.OperacaoInvestir;
import br.com.mybank.models.cliente.Cliente;
import br.com.mybank.models.cliente.ClientePJ;
public class ContaPoupanca extends Conta implements OperacaoConsulta, OperacaoInvestir{

  public ContaPoupanca(String agencia, Cliente cliente) {
    super(agencia);
    if(cliente instanceof ClientePJ){
      throw new RuntimeException("Pessoa juridica nao pode abrir poupanca");
    }
    
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
