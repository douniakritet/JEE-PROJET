package DAO;
import Model.Artiste;


import Model.Exposition;
import Model.Tableau;
import Model.Transaction;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import Model.Artiste;




public class Jeebdd {
	private String jdbcURL = "jdbc:mysql://localhost:3306/art?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	private String dbDriver = "com.mysql.jdbc.Driver";
	private int id;

	public Jeebdd() {
	}

	protected Connection getConnection(String dbDriver) {
		Connection connection = null;
		try {
			Class.forName(dbDriver);
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public Artiste select(int id) {
		Artiste artiste = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection(dbDriver);
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from artiste where idAr =?");) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String nom = rs.getString("nom");
				String nationalite = rs.getString("nationalite");
				Date dateNaissance = rs.getDate("dateNaissance");
				artiste = new Artiste(id,  nom,  nationalite,  dateNaissance);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return artiste;
	}

	public List<Artiste> selectAll() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Artiste> Artiste = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection(dbDriver);

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select * from artiste");) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("idAr");
				String nom = rs.getString("Nom");
				String nationalite = rs.getString("nationalite");
				Date dateNaissance = rs.getDate("dateNaissance");
				Artiste.add(new Artiste(id,  nom,  nationalite,  dateNaissance));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Artiste;
	}
	//Tableaux 
	
	public Tableau selectT(int id) {
		Tableau tableau = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection(dbDriver);
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from oeuvre where idO =?");) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int idO = rs.getInt("idO");
				int idArtiste = rs.getInt("idArtiste");
				String titre = rs.getString("titre");
				Date aneeCreation = rs.getDate("aneeCreation");
				String description = rs.getString("description");
				Double prix = rs.getDouble("prix");
				String image = rs.getString("image");

				tableau = new Tableau(idO, idArtiste,  titre,  aneeCreation,description,prix,image);

			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return tableau;
	}

	public List<Tableau> selectAllT() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Tableau> Tableau = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection(dbDriver);

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select * from oeuvre");) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int idO = rs.getInt("idO");
				int idArtiste = rs.getInt("idArtiste");
				String titre = rs.getString("titre");
				Date aneeCreation = rs.getDate("aneeCreation");
				String description = rs.getString("description");
				Double prix = rs.getDouble("prix");
				String image = rs.getString("image");
				Tableau.add(new Tableau(idO,idArtiste,titre,aneeCreation,description,prix,image));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Tableau;
	}
	
// Exposition
	public Exposition selectE(int id) {
	    Exposition exposition = null;
	    // Step 1: Establishing a Connection
	    try (Connection connection = getConnection(dbDriver);
	         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM exposition WHERE idE = ?");) {
	        preparedStatement.setInt(1, id);
	        System.out.println("Executing query: " + preparedStatement);
	        // Step 3: Execute the query
	        try (ResultSet rs = preparedStatement.executeQuery()) {
	            // Step 4: Process the ResultSet object.
	            if (rs.next()) {
	                int idE = rs.getInt("idE");
	                String nom = rs.getString("nom");
	                Date dateDebut = rs.getDate("dateDebut");
	                Date dateFin = rs.getDate("dateFin");
	                String lieu = rs.getString("lieu");
	                exposition = new Exposition(idE, nom, dateDebut, dateFin, lieu);
	            } 
	        }
	    } catch (SQLException e) {
	        printSQLException(e);
	    }
	    return exposition;
	}

	public List<Exposition> selectAllE() {
        List<Exposition> expositionList = new ArrayList<>();
        try (Connection connection = getConnection(dbDriver);
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM exposition");        		
                ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                int idE = rs.getInt("idE");
                String nom = rs.getString("nom");
                Date dateDebut = rs.getDate("dateDebut");
                Date dateFin = rs.getDate("dateFin");
                String lieu = rs.getString("lieu");
                Exposition exposition = new Exposition(idE, nom, dateDebut, dateFin, lieu);
                
                expositionList.add(exposition);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expositionList;
    }
	//Transaction
	public Transaction selectTr(int id) {
	    Transaction transaction = null;
	    // Step 1: Establishing a Connection
	    try (Connection connection = getConnection(dbDriver);
	         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM transaction WHERE idT = ?");) {
	        preparedStatement.setInt(1, id);
	        System.out.println("Executing query: " + preparedStatement);
	        // Step 3: Execute the query
	        try (ResultSet rs = preparedStatement.executeQuery()) {
	            // Step 4: Process the ResultSet object.
	            if (rs.next()) {
	            	int idT = rs.getInt("idT");
					int idOeuvre = rs.getInt("idOeuvre");
					int idExposition = rs.getInt("idExposition");
					String nomClient = rs.getString("nomClient");
					Date dateVente = rs.getDate("dateVente");
					String statut = rs.getString("statut");
					transaction = new Transaction(idT,idOeuvre,idExposition,nomClient,dateVente,statut);
	            } 
	        }
	    } catch (SQLException e) {
	        printSQLException(e);
	    }
	    return transaction;
	}
	public List<Transaction> selectAllTr() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Transaction> Transaction = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection(dbDriver);

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select * from transaction");) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int idT = rs.getInt("idT");
				int idOeuvre = rs.getInt("idOeuvre");
				int idExposition = rs.getInt("idExposition");
				String nomClient = rs.getString("nomClient");
				Date dateVente = rs.getDate("dateVente");
				String statut = rs.getString("statut");
				Transaction.add(new Transaction(idT,idOeuvre,idExposition,nomClient,dateVente,statut));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Transaction;
	}
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	
	public void insert(Artiste artiste) throws SQLException {
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection(dbDriver);
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO `artiste`(`nom`,`nationalite`,`dateNaissance`) VALUES (?,?,?)")) {
//			System.out.println("insert User:"+preparedStatement);
			preparedStatement.setString(1, artiste.getNom());
			preparedStatement.setString(2, artiste.getNationalite());
			preparedStatement.setDate(3, artiste.getDateNaissance());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			printSQLException(e);
		}

	}

	public void deleteArtiste(int idAr, String dbDriver) throws SQLException {
	    deleteAssociatedOeuvres(idAr, dbDriver); // First, delete associated oeuvres
	    String sql = "DELETE FROM artiste WHERE idAr = ?";
	    try (Connection connection = getConnection(dbDriver);
	         PreparedStatement statement = connection.prepareStatement(sql)) {
	        statement.setInt(1, idAr);
	        statement.executeUpdate();
	    }
	}

	public void deleteAssociatedOeuvres(int idAr, String dbDriver) throws SQLException {
	    String sql = "DELETE FROM oeuvre WHERE idArtiste = ?";
	    try (Connection connection = getConnection(dbDriver);
	         PreparedStatement statement = connection.prepareStatement(sql)) {
	        statement.setInt(1, idAr);
	        statement.executeUpdate();
	    }
	}

	public void deleteTableau(int idO) throws SQLException {
	    try {
	        // First, delete associated transactions
	        deleteAssociatedTransactions(idO);

	        // Then, delete the tableau
	        String sql = "DELETE FROM oeuvre WHERE idO = ?";
	        try (Connection connection = getConnection(dbDriver);
	             PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, idO);
	            int rowsAffected = statement.executeUpdate();
	            if (rowsAffected == 0) {
	                System.out.println("No tableau found with ID: " + idO);
	            } else {
	                System.out.println("Tableau with ID " + idO + " deleted successfully");
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Error deleting tableau with ID " + idO + ": " + e.getMessage());
	        throw e;
	    }
	}
	public void deleteAssociatedTransactions(int idO) throws SQLException {
	    String sql = "DELETE FROM transaction WHERE idOeuvre = ?";
	    try (Connection connection = getConnection(dbDriver);
	         PreparedStatement statement = connection.prepareStatement(sql)) {
	        statement.setInt(1, idO);
	        statement.executeUpdate();
	    }
	}
	
	
	public void deleteExposition(int idE) throws SQLException {
	    try {
	        // First, delete associated transactions
	    	deleteAssociatedTransactionswithExpositions(idE);

	        // Then, delete the tableau
	        String sql = "DELETE FROM exposition WHERE idE = ?";
	        try (Connection connection = getConnection(dbDriver);
	             PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, idE);
	            int rowsAffected = statement.executeUpdate();
	            if (rowsAffected == 0) {
	                System.out.println("No tableau found with ID: " + idE);
	            } else {
	                System.out.println("Tableau with ID " + idE + " deleted successfully");
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Error deleting tableau with ID " + idE + ": " + e.getMessage());
	        throw e;
	    }
	}
	public void deleteAssociatedTransactionswithExpositions(int idO) throws SQLException {
	    String sql = "DELETE FROM transaction WHERE idExposition = ?";
	    try (Connection connection = getConnection(dbDriver);
	         PreparedStatement statement = connection.prepareStatement(sql)) {
	        statement.setInt(1, idO);
	        statement.executeUpdate();
	    }
	}

	public void deleteTransaction(int idT) throws SQLException {
	    try {
	        // First, delete associated transactions
	       
	        // Then, delete the tableau
	        String sql = "DELETE FROM transaction WHERE idT = ?";
	        try (Connection connection = getConnection(dbDriver);
	             PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, idT);
	            int rowsAffected = statement.executeUpdate();
	            if (rowsAffected == 0) {
	                System.out.println("No transaction found with ID: " + idT);
	            } else {
	                System.out.println("transaction with ID " + idT + " deleted successfully");
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Error deleting transaction with ID " + idT + ": " + e.getMessage());
	        throw e;
	    }
	}



//insert Artiste
	
	public void insertArtiste(Artiste artiste) {
	    try (Connection connection = getConnection(dbDriver);
	         PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO artiste (nom, nationalite, dateNaissance) VALUES (?, ?, ?)")) {
	        preparedStatement.setString(1, artiste.getNom());
	        preparedStatement.setString(2, artiste.getNationalite());
	        preparedStatement.setDate(3, artiste.getDateNaissance());
	        
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        printSQLException(e);
	    }
	}

}