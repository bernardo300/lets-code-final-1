package br.com.mybank.projeto1;

public class ClientePessoFisica extends Cliente{
  private String cpf;

  public ClientePessoFisica(String nome) {
    super(nome);
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }  
}
