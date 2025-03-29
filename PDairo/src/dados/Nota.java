package dados;

public class Nota {
    private String texto, titulo;
    private int id;

    public Nota(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }
    public Nota(int id,String titulo, String texto){
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}