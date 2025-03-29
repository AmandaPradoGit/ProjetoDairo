package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dados.Cadastro;

public class UsuarioDAO {

    Connection con = null;
    
    public boolean atualizarEmail(Integer usuarioId, String novoEmail) {
        
        Connection con = null;
        PreparedStatement stmt = null;
        boolean sucesso = false;

        try {
        
            con = Conexao.getInstance().getConnection();
            String sql = "UPDATE usuario SET email = ? WHERE id = ?";
        
            stmt = con.prepareStatement(sql);
            stmt.setString(1, novoEmail);
            stmt.setInt(2, usuarioId);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                sucesso = true;
                System.out.println("Email atualizado com sucesso.");
            } else {
                System.out.println("Nenhum usuário encontrado com o id: " + usuarioId);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o email: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return sucesso;
    }
    
    public boolean atualizarSenha(Integer usuarioId, String novaSenha) {
        Connection con = null;
        PreparedStatement stmt = null;
        boolean sucesso = false;

        try {
            con = Conexao.getInstance().getConnection();
            String sql = "UPDATE usuario SET senha = ? WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, novaSenha);
            stmt.setInt(2, usuarioId);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                sucesso = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar a senha: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return sucesso;
    }
    
    public String buscarEmailUsuario(Integer usuarioId) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String email = null;

        try {
            con = Conexao.getInstance().getConnection();
            String sql = "SELECT email FROM usuario WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, usuarioId); 
        
            rs = stmt.executeQuery();

            if (rs != null && rs.next()) {  
                email = rs.getString("email");  
            } else {
                System.out.println("Nenhum usuário encontrado com o id: " + usuarioId);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar email do usuário: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return email;  
    }
    
    public String buscarNomeUsuario(Integer usuarioId) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String nome = null;

        try {
            con = Conexao.getInstance().getConnection();
            String sql = "SELECT nome FROM usuario WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, usuarioId);  
        
            rs = stmt.executeQuery();

            if (rs != null && rs.next()) {  
                nome = rs.getString("nome");  
            } else {
                System.out.println("Nenhum usuário encontrado com o id: " + usuarioId);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar nome do usuário: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return nome;  
    }

    public boolean esquecerSenha(String email, String novaSenha) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Conexao.getInstance().getConnection();
            String sql = "UPDATE usuario SET senha = ? WHERE email = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, novaSenha);  
            stmt.setString(2, email);      

            int rowsAffected = stmt.executeUpdate();  

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar a senha: " + e.getMessage());
            return false;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }
    
    public boolean excluirUsuario(Cadastro cadastro) {
    Connection con = null;
    PreparedStatement stmt = null;
    boolean sucesso = false;

    try {
        con = Conexao.getInstance().getConnection();
        String sqlVerificacao = "SELECT COUNT(*) FROM usuario WHERE email = ? AND senha = ?";
        stmt = con.prepareStatement(sqlVerificacao);
        stmt.setString(1, cadastro.getEmail());
        stmt.setString(2, cadastro.getSenha());

        ResultSet rs = stmt.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            System.out.println("Usuário encontrado. Excluindo...");
            String sqlDeletar = "DELETE FROM usuario WHERE email = ? AND senha = ?";
            stmt = con.prepareStatement(sqlDeletar);
            stmt.setString(1, cadastro.getEmail());
            stmt.setString(2, cadastro.getSenha());

            int rowsAffected = stmt.executeUpdate();
            sucesso = rowsAffected > 0;  
            System.out.println("Linhas afetadas: " + rowsAffected);
        } else {
            System.out.println("Usuário não encontrado ou dados incorretos.");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao excluir o usuário: " + e.getMessage());
    } finally {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar recursos: " + e.getMessage());
        }
    }

    return sucesso;
}
    
    public Integer inserirUsuario(Cadastro cadastro) {
        System.out.println("Inserir Pessoa");

        con = Conexao.getInstance().getConnection();
        System.out.println("Conectado e pronto para inserir");

        PreparedStatement stmt = null;
        Integer usuarioId = null;
        
        try {
            String sql = "INSERT INTO usuario(nome, email, senha) VALUES (?, ?, ?)";
            stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, cadastro.getNome());
            stmt.setString(2, cadastro.getEmail());
            stmt.setString(3, cadastro.getSenha());

            System.out.println("SQL: " + sql);
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
            ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                usuarioId = generatedKeys.getInt(1);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar: " + e.getMessage());
            }
        }
        return usuarioId;
    }
    
    public boolean verificarEmailExistente(String email) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean existe = false;  

        try {
            
            con = Conexao.getInstance().getConnection();

            
            String sql = "SELECT COUNT(*) FROM usuario WHERE email = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, email);  

            rs = stmt.executeQuery();

            
            if (rs != null && rs.next()) {
                int count = rs.getInt(1);  
                if (count > 0) {
                    existe = true;  
                }
            } else {
                System.out.println("Nenhum usuário encontrado com o e-mail: " + email);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar o e-mail: " + e.getMessage());
        } finally {
            
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return existe;  
}
    
    public Integer verificarUsuario(Cadastro cadastro) {
        System.out.println("Verificar Usuario");
        
        con = Conexao.getInstance().getConnection();
        System.out.println("Conectado e pronto para verificar");

        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            String sql = "SELECT id FROM usuario WHERE email = ? AND senha = ?";
            stmt = con.prepareStatement(sql);

           
            stmt.setString(1, cadastro.getEmail());
            stmt.setString(2, cadastro.getSenha());

            System.out.println("SQL: " + stmt);
            rs = stmt.executeQuery();

            
            if (rs.next()) {
                return rs.getInt("id");
            } else {
                return null; 
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar: " + e.getMessage());
            }
        }
    }
    
   
    public boolean verificarSenhaAtual(Integer usuarioId, String senhaAtual) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean senhaValida = false;

        try {
            con = Conexao.getInstance().getConnection();
            String sql = "SELECT senha FROM usuario WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, usuarioId);
        
            rs = stmt.executeQuery();

            if (rs != null && rs.next()) {
                String senhaNoBanco = rs.getString("senha");

           
                if (senhaNoBanco.equals(senhaAtual)) {
                    senhaValida = true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar a senha atual: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return senhaValida;
    }

}