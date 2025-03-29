package dados;

public class Entrar {
    private String email, senha;
    private static Entrar instance;
    
    public Entrar(){
        this.email=null;
        this.senha=null;
    }
    public Entrar(String email, String senha){
        this.email= email;
        this.senha = senha;
    }
    public static Entrar getInstance() {
        if (instance == null) {
            instance = new Entrar(); 
        } 
        return instance; 
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

