package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import dados.Compromisso;
import java.util.Date;

public class CalendarioDAO {
    private Conexao conexao;
    
    public CalendarioDAO(){
        this.conexao = conexao;
    }
     public void adicionarCompromisso(Compromisso compromisso, int usuarioId) {
         
        String sql = "INSERT INTO calendario (data, descricao, usuario_id) VALUES (?, ?, ?)";
        
        try (Connection con = Conexao.getInstance().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setDate(1, java.sql.Date.valueOf(compromisso.getData()));
            stmt.setString(2, compromisso.getDescricao());
            stmt.setInt(3, usuarioId);
            
            stmt.executeUpdate();
            System.out.println("Compromisso adicionado com sucesso!");
            
        } catch (SQLException e) {
            
            System.err.println("Erro ao adicionar compromisso: " + e.getMessage());
            e.printStackTrace();
            
        }
    }
    
     public void apagarCompromisso(int id, int usuarioId) {
         
        String sql = "DELETE FROM calendario WHERE id = ? AND usuario_id = ?";
        
        try (Connection con = conexao.getInstance().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.setInt(2, usuarioId);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
    }
    public void atualizarCompromisso(Compromisso compromisso, int usuarioId){
        
        String sql = "UPDATE calendario SET  data =?, descricao = ? WHERE id=? AND usuario_id = ?"; 
        
        try (Connection con = Conexao.getInstance().getConnection(); 
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
             stmt.setDate(1, java.sql.Date.valueOf(compromisso.getData()));
             stmt.setString(2, compromisso.getDescricao());
             stmt.setInt(3, compromisso.getId());
             stmt.setInt(4, usuarioId);
             
             int rowsUpdated = stmt.executeUpdate();   
           
        if (rowsUpdated > 0) {
            System.out.println("Compromisso atualizado com sucesso!");
        } else {
            System.out.println("Nenhum compromisso foi atualizado.");
        }
        }catch (SQLException e) {
            
            System.err.println("Erro ao atualizar o compromisso: " + e.getMessage());
            
        }
    }

    public List<Compromisso> buscarCompromissosPorData(LocalDate data, int usuarioId) {
        
        String sql = "SELECT * FROM calendario WHERE data = ? AND usuario_id = ?";
        
        List<Compromisso> compromissos = new ArrayList<>();
        
        try (Connection con = Conexao.getInstance().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setDate(1, java.sql.Date.valueOf(data));
            stmt.setInt(2, usuarioId);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                
                compromissos.add(new Compromisso(
                        rs.getInt("id"),
                        rs.getDate("data").toLocalDate(),
                        rs.getString("descricao")
                ));
                
            }
        } catch (SQLException e) {
            
            System.err.println("Erro ao buscar compromissos: " + e.getMessage());
            e.printStackTrace();
            
        }
        return compromissos;
    }
  }
