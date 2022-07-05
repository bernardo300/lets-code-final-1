public class ClientePJ extends Cliente{
    private String cnpj;
  
    public ClientePJ(String nome) {
      super.setNome(nome);
    }
  
    public String getCnpj() {
      return cnpj;
    }
  
    public void setCnpj(String cnpj) {
      this.cnpj = cnpj;
    }
}