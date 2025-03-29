package dados;
import java.time.LocalDate;
import java.util.Date;

public class Compromisso {
    private int id;
    private String descricao;
    private LocalDate data;
    
    public Compromisso(int id, LocalDate data, String descricao){
        this.id = id;
        this.data = data;
        this.descricao = descricao;
    }
    public Compromisso(LocalDate data, String descricao){
        this.data = data;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
}
