package Model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3303/dbagenda?useSSL=false&useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password ="alnkle621";

	
	private Connection conectar() {
		
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password );
			return con;
		} catch (Exception e) {
			System.out.println(e);
			
			return null;
			// TODO: handle exception
		}
	}
	
	 
	
	public void inserirPessoal(JavaBeans beans) {
		
		String sql = "INSERT INTO contatos (nome, fone, email) values (?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, beans.getNome());
			pst.setString(2, beans.getFone());
			pst.setString(3, beans.getEmail());
			
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public ArrayList<JavaBeans> listarContatos(){
		//Arraylist para salvar os dados do banco 
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		
		String read = "select * from contatos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			//Guarda temporariamente os valores do banco de dados 
			ResultSet res = pst.executeQuery();
			//While para ler todos os dados do banco 
			while(res.next()){
				String idcon = res.getString(1);
				String nome = res.getString(2);
				String fone = res.getString(3);
				String email = res.getString(4);
				//Adicioando ao arraylist 
				contatos.add(new JavaBeans(idcon,nome,fone,email) );
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			// TODO: handle exception
			return null;}
	}
	
	public void selecionarConato(JavaBeans contato) {
		String read2 = "select *  from contatos where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2); 
		    pst.setString(1, contato.getIdcon());
		    ResultSet rs = pst.executeQuery();
		    while ( rs.next()) {
				 contato.setIdcon(rs.getString(1));
				 contato.setNome(rs.getString(2));
				 contato.setFone(rs.getString(3));
				 contato.setEmail(rs.getString(4));
		    }
		    con.close();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}	
		
	public void uptadeContato(JavaBeans contato) {
		String uptade = "uptade contatos set nome=?,fone=?,email=? where idcon=?";
	
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(uptade);
			ResultSet rs = pst.executeQuery();
			
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon());
			
			rs.close();
			pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void deletarContato(JavaBeans contato) {
		String delete ="delete from contatos where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	
}
