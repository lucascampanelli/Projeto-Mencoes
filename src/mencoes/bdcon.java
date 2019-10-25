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
    import java.sql.ResultSet;
/**
 *
 * @author Lucas Campanelli
 */
public class bdcon {
    
    static String driverJDBC = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost/mencoes?useTimezone=true&serverTimezone=UTC";
    static String user = "root";
    static String senha = "";
    
    private String nome = "";
    private String turma = "";
    private String mencao1 = "";
    private String mencao2 = "";
    private String mencao3 = "";
    private String mencao4 = "";
    private String media = "";
    
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
    
    public void GetNome(){
        try{
            Connection conexao = DriverManager.getConnection(url, user, senha);
            String query = "select nome from aluno where media = (select min(media) from aluno)";
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                this.setNome(rs.getString("nome"));
            }
            
            rs.close();
            st.close();
            conexao.close();
            
        }
        catch(Exception e){
           System.err.println("Um erro ocorreu! ");
            System.err.println(e.getMessage());
        }
    }    
    
    public void GetTurma(){
        try{
            Connection conexao = DriverManager.getConnection(url, user, senha);
            String query = "select turma from aluno where media = (select min(media) from aluno)";
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs != null && rs.next()){
                this.setTurma(rs.getString("turma"));
            }
            rs.close();
            st.close();
            conexao.close();
            
        }
        catch(Exception e){
           System.err.println("Um erro ocorreu! ");
            System.err.println(e.getMessage());
        }
    }
    
    public void GetMencao1(){
        try{
            Connection conexao = DriverManager.getConnection(url, user, senha);
            String query = "select mencao1 from aluno where media = (select min(media) from aluno)";
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs != null && rs.next()){
                this.setMencao1(rs.getString("mencao1"));
            }
            rs.close();
            st.close();
            conexao.close();
            
        }
        catch(Exception e){
           System.err.println("Um erro ocorreu! ");
            System.err.println(e.getMessage());
        }
    }
    public void GetMencao2(){
        try{
            Connection conexao = DriverManager.getConnection(url, user, senha);
            String query = "select mencao2 from aluno where media = (select min(media) from aluno)";
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs != null && rs.next()){
                this.setMencao2(rs.getString("mencao2"));
            }
            rs.close();
            st.close();
            conexao.close();
            
        }
        catch(Exception e){
           System.err.println("Um erro ocorreu! ");
            System.err.println(e.getMessage());
        }
    }
    public void GetMencao3(){
        try{
            Connection conexao = DriverManager.getConnection(url, user, senha);
            String query = "select mencao3 from aluno where media = (select min(media) from aluno)";
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs != null && rs.next()){
                this.setMencao3(rs.getString("mencao3"));
            }
            rs.close();
            st.close();
            conexao.close();
            
        }
        catch(Exception e){
           System.err.println("Um erro ocorreu! ");
            System.err.println(e.getMessage());
        }
    }
    public void GetMencao4(){
        try{
            Connection conexao = DriverManager.getConnection(url, user, senha);
            String query = "select mencao4 from aluno where media = (select min(media) from aluno)";
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs != null && rs.next()){
                this.setMencao4(rs.getString("mencao4"));
            }
            rs.close();
            st.close();
            conexao.close();
            
        }
        catch(Exception e){
           System.err.println("Um erro ocorreu! ");
            System.err.println(e.getMessage());
        }
    }
    public void GetMedia(){
        try{
            Connection conexao = DriverManager.getConnection(url, user, senha);
            String query = "select media from aluno where media = (select min(media) from aluno)";
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs != null && rs.next()){
                this.setMedia(rs.getString("media"));
            }
            rs.close();
            st.close();
            conexao.close();
            
        }
        catch(Exception e){
           System.err.println("Um erro ocorreu! ");
            System.err.println(e.getMessage());
        }
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param turma the turma to set
     */
    public void setTurma(String turma) {
        this.turma = turma;
    }

    /**
     * @param mencao1 the mencao1 to set
     */
    public void setMencao1(String mencao1) {
        this.mencao1 = mencao1;
    }

    /**
     * @param mencao2 the mencao2 to set
     */
    public void setMencao2(String mencao2) {
        this.mencao2 = mencao2;
    }

    /**
     * @param mencao3 the mencao3 to set
     */
    public void setMencao3(String mencao3) {
        this.mencao3 = mencao3;
    }

    /**
     * @param mencao4 the mencao4 to set
     */
    public void setMencao4(String mencao4) {
        this.mencao4 = mencao4;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(String media) {
        this.media = media;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the turma
     */
    public String getTurma() {
        return turma;
    }

    /**
     * @return the mencao1
     */
    public String getMencao1() {
        return mencao1;
    }

    /**
     * @return the mencao2
     */
    public String getMencao2() {
        return mencao2;
    }

    /**
     * @return the mencao3
     */
    public String getMencao3() {
        return mencao3;
    }

    /**
     * @return the mencao4
     */
    public String getMencao4() {
        return mencao4;
    }

    /**
     * @return the media
     */
    public String getMedia() {
        return media;
    }
    
}