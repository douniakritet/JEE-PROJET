package Controler;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Model.Artiste;
import Model.Exposition;
import DAO.Jeebdd;
import DAO.LoginBean;
import Model.Login;
import Model.Tableau;
import Model.Transaction;

@WebServlet("/")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Jeebdd dao;

	public void init() {
		dao = new Jeebdd();
	}
	
    public AdminLogin() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	            	listTransaction(request, response);
	                break;
	            case "/artiste":
	                listArtiste(request, response);
	                break;
	            case "/tableau":
	                listTableau(request, response);
	                break;
	            case "/exposition":
	                listExposition(request, response);
	                break;
	            case "/transaction":
	                listTransaction(request, response);
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
	            case "/deleteArtiste":
                    deleteArtiste(request, response);
                    break;
                    
	            case "/deleteTableau":
	                deleteTableau(request, response);
	                break;
	                
	            case "/deleteExposition":
	            	deleteExposition(request, response);
	                break;
	            case "/deleteTransaction":
	            	deleteTransaction(request, response);
	                break;
	            case "/insertArtiste":
	            	insertArtiste(request, response);
		                break;
	            // Other cases
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

	/*private void artiste(HttpServletRequest request, HttpServletResponse response)
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
		
		
	}*/
	private void ajouterArtiste(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Vue/ajouterArtiste.jsp");
			dispatcher.forward(request, response);
		
		
	}
	
	private void deleteArtiste(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, IOException {
	    int idAr = Integer.parseInt(request.getParameter("idAr"));
	    String dbDriver = "com.mysql.jdbc.Driver"; // Replace with your actual database driver string
	    try {
	        dao.deleteArtiste(idAr, dbDriver); // Pass the database driver string
	        response.sendRedirect(request.getContextPath() + "/artiste");
	    } catch (SQLException e) {
	        // Handle the error case if deletion fails
	        response.sendRedirect(request.getContextPath() + "/artiste?error=deleteFailed");
	    }
	}

	private void deleteTableau(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, IOException {
	    int idO = Integer.parseInt(request.getParameter("idO"));
	    try {
	        dao.deleteTableau(idO);
	        response.sendRedirect(request.getContextPath() + "/tableau");
	    } catch (SQLException e) {
	        response.sendRedirect(request.getContextPath() + "/tableau?error=deleteFailed");
	    }
	}

	private void deleteExposition(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, IOException {
	    int idE = Integer.parseInt(request.getParameter("idE"));
	    try {
	        dao.deleteExposition(idE); // Appeler deleteExposition au lieu de deleteTableau
	        response.sendRedirect(request.getContextPath() + "/exposition");
	    } catch (SQLException e) {
	        response.sendRedirect(request.getContextPath() + "/exposition?error=deleteFailed");
	    }
	}
	private void deleteTransaction(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, IOException {
		int idT = Integer.parseInt(request.getParameter("idT")); // Assurez-vous que "idT" est le bon nom de paramètre
		dao.deleteTransaction(idT); // Assurez-vous que vous appelez la méthode deleteTransaction, car vous supprimez une transaction
	    try {
	        dao.deleteTransaction(idT);
	        response.sendRedirect(request.getContextPath() + "/transaction");
	    } catch (SQLException e) {
	        response.sendRedirect(request.getContextPath() + "/transaction?error=deleteFailed");
	    }
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
	
	private void listArtiste(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Artiste> artiste = dao.selectAll();
		request.setAttribute("Artiste", artiste);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Vue/artiste.jsp");
		dispatcher.forward(request, response);
	}
	private void listTableau(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Tableau> tableau = dao.selectAllT();
		request.setAttribute("Tableau", tableau);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Vue/tableau.jsp");
		dispatcher.forward(request, response);
	}
	private void listExposition(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, IOException, ServletException {
	    List<Exposition> exposition = dao.selectAllE();
	    request.setAttribute("Exposition", exposition);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Vue/exposition.jsp");
	    dispatcher.forward(request, response);
	}

	private void listTransaction(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Transaction> transaction = dao.selectAllTr();
		request.setAttribute("Transaction", transaction);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Vue/transaction.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertArtiste(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, IOException {
	    String nom = request.getParameter("nom");
	    String nationalite = request.getParameter("nationalite");
	    
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateNaissance = null;
	    try {
	        dateNaissance = new Date(dateFormat.parse(request.getParameter("dateNaissance")).getTime());
	    } catch (ParseException e) {
	        e.printStackTrace(); 
	    }

	    Artiste artiste = new Artiste(nom, nationalite, dateNaissance);
	    dao.insertArtiste(artiste);
	    response.sendRedirect(request.getContextPath() + "/artiste");
	}



}
