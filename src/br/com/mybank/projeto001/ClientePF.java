public class ClientePF extends Cliente{
    private String cpf;
  
    public ClientePF(String nome) {
      super.setNome(nome);;
    }
  
    public String getCpf() {
      return cpf;
    }
  
    public void setCpf(String cpf) {
      this.cpf = cpf;
    }
    
}