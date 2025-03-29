package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dados.Planner;

public class PlannerDAO {
    
    public void adicionarPlanner(String plano, String diaSemana, int usuarioId) throws SQLException, ClassNotFoundException {
        
        if (!verificarUsuarioId(usuarioId)) {
            throw new IllegalArgumentException("Usuário não encontrado: " + usuarioId);
        }

        String sql = "INSERT INTO planner(Plano, dia_semana, usuario_id) VALUES (?, ?, ?)";
        
        try (Connection con = Conexao.getInstance().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, plano);
            stmt.setString(2, diaSemana);
            stmt.setInt(3, usuarioId);
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao adicionar plano: " + e.getMessage());
            throw e;
            
        }
    }
    
    public void atualizarPlanner(String oldPlano, String newPlano, String diaSemana, int usuarioId) throws SQLException, ClassNotFoundException { 
        
         if (!verificarUsuarioId(usuarioId)) {
            throw new IllegalArgumentException("Usuário não encontrado: " + usuarioId);
        }

        String sql = "UPDATE planner SET Plano = ? WHERE Plano = ? AND dia_semana = ? AND usuario_id = ?";
        
        try (Connection con = Conexao.getInstance().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, newPlano);
            stmt.setString(2, oldPlano);
            stmt.setString(3, diaSemana);
            stmt.setInt(4, usuarioId);
            
            stmt.executeUpdate();
        }
    }
    
    public List<String> buscarPlanner(String diaSemana, int usuarioId) throws SQLException, ClassNotFoundException {
        
          if (!verificarUsuarioId(usuarioId)) {
            throw new IllegalArgumentException("Usuário não encontrado: " + usuarioId);
        }

        List<String> planos = new ArrayList<>();
        
        String sql = "SELECT plano FROM planner WHERE dia_semana = ? AND usuario_id = ?";
        
        try (Connection con = Conexao.getInstance().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, diaSemana);
            stmt.setInt(2, usuarioId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    planos.add(rs.getString("plano"));
                }
            }
        } catch (SQLException e) {
            
            System.out.println("Erro ao buscar plano para " + diaSemana + ": " + e.getMessage());
            throw e;
            
        }
        return planos;
    }
    
    public void deletarPlanner(String plano, String diaSemana, int usuarioId) throws SQLException, ClassNotFoundException {
        
         if (!verificarUsuarioId(usuarioId)) {
            throw new IllegalArgumentException("Usuário não encontrado: " + usuarioId);
        }

        String sql = "DELETE FROM planner WHERE Plano = ? AND dia_semana = ? AND usuario_id = ?";
        
        try (Connection con = Conexao.getInstance().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, plano);
            stmt.setString(2, diaSemana);
            stmt.setInt(3, usuarioId);
            
            stmt.executeUpdate();
        }
    }

    public boolean verificarUsuarioId(int usuarioId) throws SQLException {
        
        String sql = "SELECT COUNT(*) FROM usuario WHERE id = ?";
        
        try (Connection con = Conexao.getInstance().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setInt(1, usuarioId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0; 
                }
            }
        } catch (SQLException e) {
            
            System.out.println("Erro ao verificar usuario_id: " + e.getMessage());
            throw e;
            
        }
        return false;
    }
    
    
   
    
    
} 