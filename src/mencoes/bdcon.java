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
		String instrucaoSQL = "INSERT INTO aluno(nome, turma, mencao1, mencao2, mencao3, mencao4, media) " + 
                                        "VALUES ('"+ n.getText().toString() +"', turma, mencao1, mencao2, mencao3, mencao4, media)";
		
		try{
			Class.forName(driverJDBC);
			conexao = DriverManager.getConnection(url, user, senha);
			
			System.out.println("Inserindo a tabela, aguarde...");
			st = conexao.createStatement();
			st.executeUpdate(instrucaoSQL);
			System.out.println("Dados inseridos com sucesso!");
			st.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println("Erro");
			e.printStackTrace();
    }
    
}
