package dados;

public class Cadastro {
    private String nome, email, senha;
    private int id; 
    
    public Cadastro(){
    this.nome= null;
    this.email=  null;
    this.senha = null;

    }
    
    public Cadastro(String nome, String email, String senha, int id)
    {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
    