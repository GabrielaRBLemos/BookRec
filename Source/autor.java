public class autor {
    String id;
    String nome;
    String pais;
    String nascimento;
    Boolean IsAlive;
    public autor(String nome, String pais, String nascimento, Boolean estado, String id){
      this.id = id;
      this.nome = nome;
      this.pais = pais;
      this.nascimento = nascimento;
      this.estado = estado;

    }
  
    public String getId() {
      return id;
    }
    public void setId(String id) {
      this.id = id;
    }
    public String getNome() {
      return nome;
    }
    public void setNome(String nome) {
      this.nome = nome;
    }
    public String getPais() {
      return pais;
    }
    public void setPais(String pais) {
      this.pais = pais;
    }
    public String getNascimento() {
      return nascimento;
    }
    public void setNascimento(String nascimento) {
      this.nascimento = nascimento;
    }
    public Boolean getEstado() {
      return estado;
    }
    public void setEstado(Boolean estado) {
      this.estado = estado;
    }
}
