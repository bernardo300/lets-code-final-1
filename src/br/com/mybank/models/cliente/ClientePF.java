package br.com.mybank.models.cliente;


public class ClientePF extends Cliente{
  private String cpf;

  public ClientePF(String nome) {
    super(nome);
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
  
}
