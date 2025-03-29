package dados;

public class Planner {
    private String plano;
    private String diaSemana;
    private int usuarioId; 

   
    public Planner(String plano, String diaSemana, int usuarioId) {
        this.plano = plano;
        this.diaSemana = diaSemana;
        this.usuarioId = usuarioId;
    }

    public Planner() {
    }

    
    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "Planner{" +
                "plano='" + plano + '\'' +
                ", diaSemana='" + diaSemana + '\'' +
                ", usuarioId=" + usuarioId +
                '}';
    }
}
