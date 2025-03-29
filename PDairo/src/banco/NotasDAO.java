package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dados.Nota;
import java.time.LocalDate;


public class NotasDAO {
    private Conexao conexao;
    
    public NotasDAO(){
        this.conexao = Conexao.getInstance();
    }
    
    public void apagarNotas(int id, int usuarioId) {
        
        String sql = "DELETE FROM notas WHERE id = ? AND usuario_id = ?";
        
        try (Connection con = conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.setInt(2, usuarioId);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
    }
    
    public void atualizarNotas(Nota notas, int usuarioId){
        
        String sql = "UPDATE notas SET  titulo =?, texto = ? WHERE id=? AND usuario_id= ?"; 
        
        try (Connection con = Conexao.getInstance().getConnection(); 
            PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, notas.getTitulo());  
            stmt.setString(2, notas.getTexto());   
            stmt.setInt(3, notas.getId()); 
            stmt.setInt(4, usuarioId);
            
            int rowsUpdated = stmt.executeUpdate();   
           
        if (rowsUpdated > 0) {
            
            System.out.println("Nota atualizada com sucesso!");
            
        } else {
            
            System.out.println("Nenhum nota foi atualizada.");
            
        }
        }catch (SQLException e) {
            
            System.err.println("Erro ao atualizar nota: " + e.getMessage());
            
        }
    }
    
    public List<Nota> listarNotas(int usuarioId) {
        
        List<Nota> notas = new ArrayList<>();
        
        String sql = "SELECT * FROM notas WHERE usuario_id = ?";
        
        try (Connection con = conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setInt(1, usuarioId);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                
                notas.add(new Nota(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("texto")
                ));
                
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
        return notas;
    }
    
     public void salvarNotas(Nota notas, int usuarioId) {
         
        String sql = "INSERT INTO notas (titulo, texto, usuario_id) VALUES (?, ?, ?)";
        
        try (Connection con = Conexao.getInstance().getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, notas.getTitulo());
            stmt.setString(2, notas.getTexto());
            stmt.setInt(3, usuarioId);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
    }
     
    
    
    

}