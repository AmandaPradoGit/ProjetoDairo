package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    Connection con = null;
    private static Conexao instance = null;

    public Conexao(){
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Carregado com sucesso!!!");
            
        }catch (ClassNotFoundException e){
            System.out.println("O driver do Mysql não pode ser carregado!");
            e.printStackTrace();
        } 
    }
    
   
    public static Conexao getInstance() {
        if (instance == null) {
            instance = new Conexao();
        }
        return instance;
    }

    public Connection getConnection(){
        try 
        {
            if (con == null || con.isClosed()) 
            {
                con = DriverManager.getConnection("jdbc:mysql://localhost/agenda", "root", "");
                System.out.println("Conexão estabelecida");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return con;
    }

    public void destroy(){
    try{
       if (con != null && !con.isClosed()) {
           con.close();
           System.out.println("Conexão fechada");
       }
    } catch (SQLException e) {
        System.out.println("Erro ao fechar conexão: " + e.getMessage());
        e.printStackTrace();
    }

    }  
}
