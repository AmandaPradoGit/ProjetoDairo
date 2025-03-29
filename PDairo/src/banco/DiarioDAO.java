package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dados.Diario;
import banco.Conexao;
import java.time.LocalDate;


public class DiarioDAO {
    private Conexao conexao;
    
    public DiarioDAO(){
        this.conexao = Conexao.getInstance();
    }
    
    public void apagarDiario(int id, int usuarioId) {
        
        String sql = "DELETE FROM diario WHERE id = ? AND usuario_id = ?";
        
        try (Connection con = conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.setInt(2, usuarioId);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }
    
    public void atualizarDiario(Diario diario, int usuarioId){
        
        String sql = "UPDATE diario SET  titulo =?, texto = ? WHERE id=? AND usuario_id = ?"; 
        
        try (Connection con = Conexao.getInstance().getConnection(); 
            PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, diario.getTitulo());  
            stmt.setString(2, diario.getTexto());   
            stmt.setInt(3, diario.getId()); 
            stmt.setInt(4, usuarioId);
            
            int rowsUpdated = stmt.executeUpdate();   
           
        if (rowsUpdated > 0) {
            
            System.out.println("Diário atualizado com sucesso!");
            
        } else {
            
            System.out.println("Nenhum diário foi atualizado.");
            
        }
        }catch (SQLException e) {
            
            System.err.println("Erro ao atualizar o diário: " + e.getMessage());
            
        }
    }
    
    public List<Diario> listarDiarios(int usuarioId) {
        
        List<Diario> diarios = new ArrayList<>();
        
        String sql = "SELECT * FROM diario WHERE usuario_id = ?";
        
        try (Connection con = conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setInt(1, usuarioId); 
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                
                diarios.add(new Diario(
                rs.getInt("id"),
                rs.getString("titulo"),
                rs.getString("texto")
            ));
                
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return diarios;
}

     public void salvarDiario(Diario diario, int usuarioId) {
         
        String sql = "INSERT INTO diario (titulo, texto, usuario_id) VALUES (?, ?, ?)";
        
        try (Connection con = Conexao.getInstance().getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, diario.getTitulo());
            stmt.setString(2, diario.getTexto());
            stmt.setInt(3, usuarioId);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
    }
     
    
    
    
}

