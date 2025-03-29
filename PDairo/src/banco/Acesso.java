package banco;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import dados.Entrar;

public class Acesso { 
    Connection con = null; 
    
    public Integer verificarAcesso(Entrar entrar) {
        con = Conexao.getInstance().getConnection();
        System.out.println("Conectado e verificando acesso"); 
        PreparedStatement stmt = null; 
        
        Integer usuarioId = null;
        
        try { 
            String sql = "SELECT id FROM usuario WHERE email= ? AND senha = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, entrar.getEmail());
            stmt.setString(2, entrar.getSenha());
            ResultSet res = stmt.executeQuery();
            if(res.next()){
                 usuarioId = res.getInt("id");
            }
        } catch (SQLException e) { 
            System.out.println("Erro ao verificar Acesso"+ e.getMessage());
          
        } finally {
            try { 
                if (stmt != null) stmt.close();
                if(con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar: " + e.getMessage());
            }
        }
        return usuarioId;
    }
}