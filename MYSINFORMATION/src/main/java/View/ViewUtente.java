package View;

import java.io.IOException;
import java.io.ObjectInputFilter.Config;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import Control.ControllerFakeFight;
import Control.ControllerUtente;
import Model.Notizia;
import Model.Utente;

/**
 * Servlet implementation class GestoreUtente
 */
@WebServlet("/ViewUtente")
public class ViewUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUtente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("qui");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		//Prendo il comando dell'utente
		String userAction = request.getParameter("UserAction");
		//System.out.println(userAction);
		System.out.println(userAction);
		switch(userAction) {
		case "login": 
			//Recupero campi inseriti
			Utente user = null;
			user = richiestaLogin(request);
			//se l'utente è stato trovato
			if( user != null) 
			{
				System.out.println(user.toString());
				request.getSession().setAttribute("isLogged", true);
				response.sendRedirect("index.jsp");
			}
			else 
			{
				System.out.println("Non trovato");
			}
			break;
		case "Registra":
			int esito = richiestaReg(request); 
			System.out.println(esito);
			break;
		case "verifica":
			System.out.println("qui");
			invioNotizia(request);
		}
		
		
	}
public Utente richiestaLogin(HttpServletRequest request) {
	Utente user = null;
	String username = request.getParameter("username");
	String pw = request.getParameter("pw");
	ControllerUtente log = new ControllerUtente();
	try {
		//Invio dati inseriti alla classe che fa il login e ricevo l'utente corrispondente
		user = log.effettuaLogin(username, pw);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return user;
}

public int richiestaReg(HttpServletRequest request) {
	int esito = 0;
	//recupero dati dal form
	String username = request.getParameter("username");
	String pw = request.getParameter("pw");
	String email = request.getParameter("email");
	String ruolo = request.getParameter("ruolo");
	
	//creazione utente
	Utente user = new Utente(username, email, pw, Integer.parseInt(ruolo));
	ControllerUtente reg = new ControllerUtente();
	esito = reg.registraUtente(user);
	return esito;
}

public Notizia invioNotizia(HttpServletRequest request) {
	Notizia notizia;
	notizia = new Notizia(request.getParameter("testo"), null, 0 , request.getParameter("fonte"));
	System.out.println(notizia.toString());
	ControllerFakeFight conff = new ControllerFakeFight();
	conff.ricezioneNotizia(notizia);
	return notizia;
}
}
