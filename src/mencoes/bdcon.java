/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mencoes;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.Statement;
/**
 *
 * @author Lucas Campanelli
 */
public class bdcon {
    
    static String driverJDBC = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost/mencoes?useTimezone=true&serverTimezone=UTC";
    static String user = "root";
    static String senha = "";
    
    public void conn(){
                  try{
                    System.out.println("Carregando o driver JDBC...");
                    Class.forName(driverJDBC);
                    System.out.println("Driver carregado com sucesso!");
		}catch(Exception e) {
                    System.out.println("Falha no carregamento.");
		}
		
		try {
                    System.out.println("Conectando ao banco...");
                    Connection conexao = DriverManager.getConnection(url, user, senha);
                    System.out.println("Conexão Efetuada com sucesso!");
		}catch(Exception e) {
                    System.out.println("Falha na conexão.");
		}
    }
    
    public void insert(String n, String turma, String mencao1, String mencao2, String mencao3, String mencao4){
                Connection conexao = null;
		Connection con = conexao;
		Statement st = null;
                int m1 = 0, m2 = 0, m3 = 0, m4 = 0;
                if(mencao1.equals("MB")){
                    m1 = 10;
                }
                if(mencao2.equals("MB")){
                    m2 = 10;
                }
                if(mencao3.equals("MB")){
                    m3 = 10;
                }
                if(mencao4.equals("MB")){
                    m4 = 10;
                }
                
                if(mencao1.equals("B")){
                    m1 = 7;
                }
                if(mencao2.equals("B")){
                    m2 = 7;
                }
                if(mencao3.equals("B")){
                    m3 = 7;
                }
                if(mencao4.equals("B")){
                    m4 = 7;
                }
                
                if(mencao1.equals("R")){
                    m1 = 5;
                }
                if(mencao2.equals("R")){
                    m2 = 5;
                }
                if(mencao3.equals("R")){
                    m3 = 5;
                }
                if(mencao4.equals("R")){
                    m4 = 5;
                }
                
                if(mencao1.equals("I")){
                    m1 = 0;
                }
                if(mencao2.equals("I")){
                    m2 = 0;
                }
                if(mencao3.equals("I")){
                    m3 = 0;
                }
                if(mencao4.equals("I")){
                    m4 = 0;
                }
                
                float media = (m1 + m2 + m3 + m4)/4;
		String instrucaoSQL = "INSERT INTO aluno(nome, turma, mencao1, mencao2, mencao3, mencao4, media) " + 
                                        "VALUES ('"+n+"', '"+turma+"', '"+mencao1+"', '"+mencao2+"', '"+mencao3+"', '"+mencao4+"', '"+media+"')";
		
		try{
			Class.forName(driverJDBC);
			conexao = DriverManager.getConnection(url, user, senha);
			
			System.out.println("Cadastrando aluno...");
			st = conexao.createStatement();
			st.executeUpdate(instrucaoSQL);
			System.out.println("Aluno cadastrado com sucesso!");
			st.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println("Erro!");
			e.printStackTrace();
    }
    
}
}