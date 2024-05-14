package Controler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import DAO.LoginBean;
import Model.Login;

@WebServlet("/")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*private Jeebdd dao;

	public void init() {
		dao = new Jeebdd();
	}*/
	
    public AdminLogin() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       //this.getServletContext().getRequestDispatcher("/WEB-INF/Vue/Login.jsp").forward(request, response);
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/login":
				loginUser(request, response);
				break;
			case "/logout":
				logout(request, response);
				break;
			case "/dashboard":
				dashboard(request, response);
				break;
			case "/artiste":
				artiste(request, response);
				break;
			case "/tableau":
				tableau(request, response);
				break;
			case "/exposition":
				exposition(request, response);
				break;
			case "/transaction":
				transaction(request, response);
					break;
			case "/ajouterArtiste":
				ajouterArtiste(request, response);
					break;
			case "/ajouterTableau":
				ajouterTableau(request, response);
					break;
			case "/ajouterExposition":
				ajouterExposition(request, response);
						break;
	       case "/ajouterTransaction":
	    	   ajouterTransaction(request, response);
				break;
		default:
			listUserIndex(request, response);
			break;
		}
	} catch (SQLException ex) {
		throw new ServletException(ex);

	}
	}
	private void loginUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		LoginBean loginDao = new LoginBean();

		HttpSession session = request.getSession();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Login loginbdd = new Login();
		loginbdd.setNom(username);
		loginbdd.setMotdepasse(password);

		if (loginDao.validate(loginbdd)) {
			session.setAttribute("username", username);
			response.sendRedirect("dashboard");

		} else {
			// HttpSession session = request.getSession();
			response.sendRedirect("/WEB-INF/Vue/Login.jsp");

		}

	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		  HttpSession session = request.getSession();
	        session.removeAttribute("username");
			response.sendRedirect("/WEB-INF/Vue/Login.jsp");

	}
	
	private void listUserIndex(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Vue/Login.jsp");
			dispatcher.forward(request, response);
		
		
	}
	
	private void dashboard(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Vue/dashboard.jsp");
			dispatcher.forward(request, response);
		
		
	}

	private void artiste(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Vue/artiste.jsp");
			dispatcher.forward(request, response);
		
		
	}
	
	private void tableau(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Vue/tableau.jsp");
			dispatcher.forward(request, response);
		
		
	}
	private void exposition(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Vue/exposition.jsp");
			dispatcher.forward(request, response);
		
		
	}
	private void transaction(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Vue/transaction.jsp");
			dispatcher.forward(request, response);
		
		
	}
	private void ajouterArtiste(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Vue/ajouterArtiste.jsp");
			dispatcher.forward(request, response);
		
		
	}

	private void ajouterTableau(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Vue/ajouterTableau.jsp");
			dispatcher.forward(request, response);
		
		
	}
	private void ajouterExposition(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Vue/ajouterExposition.jsp");
			dispatcher.forward(request, response);
		
		
	}
	private void ajouterTransaction(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Vue/ajouterTransaction.jsp");
			dispatcher.forward(request, response);
		
		
	}
}
