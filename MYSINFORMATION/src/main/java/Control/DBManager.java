package Control;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;

import Model.Utente;
public class DBManager {

	private Connection connessione;
	private Statement query;
	private String urlDB="";
	private String userDB;
	private String pwdDB;
	private ResultSet rs;
	public DBManager() throws Exception{
		urlDB="jdbc:mysql://localhost:3306/MYSINFORMATION_DB?serverTimezone=UTC";
		userDB="root";
		pwdDB=null;
		//Creazione della connessione
		//Registrazione dei Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("Registrazione driver sql effettuata");
		connessione=DriverManager.getConnection(urlDB, userDB, pwdDB);
		System.out.println("Connessione instaurata con il database MYSINFORMATIONDB");
		query = connessione.createStatement();
		
	}
	
public Utente trovaUtente(String username,String pw) throws Exception {
		Utente user = null;
		String sqlcommand = "select * from utente where username = '" + username + "' and pw = '" + pw + "'";
		rs=query.executeQuery(sqlcommand);
		while(rs.next()) {
			user = new Utente(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
		}

		System.out.println("(DBMANAGER)Letto: " +rs.getRow());
		rs.close();
		return user;
		
	}
public Utente controllaUtenteEsistente(String username,String email) throws Exception {
	Utente user = null;
	String sqlcommand = "select * from utente where username = '" + username + "' or email = '"+ email +"'";
	rs=query.executeQuery(sqlcommand);
	while(rs.next()) {
		user = new Utente(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
	}

	System.out.println("(DBMANAGER)Letto: " +rs.getRow());
	rs.close();
	return user;
	
}
public void ChiudiDB() throws Exception {
		query.close();
		connessione.close();
	}	
public int inserisciUtente(Utente user) throws Exception {
	int nrighe=0;	
	String sqlcommand1 = "insert into utente values(?,?,?,?);";
	PreparedStatement ps = connessione.prepareStatement(sqlcommand1);
	ps.setString(1, user.getNome());
	ps.setString(2, user.getEmail());
	ps.setString(3, user.getPw());
	ps.setInt(4, user.getRuolo());
	nrighe = ps.executeUpdate();
	return nrighe;
	}


}