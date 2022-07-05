public abstract class Cliente {
    private String nome;
    private String tipoCliente;
      
    public Cliente(String nome, String tipoCliente ){
      this.nome = nome;
      this.tipoCliente = tipoCliente;
    }
  
    public String getNome() {
      return nome;
    }
  
    public void setNome(String nome) {
      this.nome = nome;
    }

    public String getTipoCliente() {
        return this.tipoCliente;
    }
    
    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}