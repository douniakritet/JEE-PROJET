package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import Model.Login;
public class LoginBean {

		private String jdbcURL = "jdbc:mysql://localhost:3306/art";
		private String jdbcUsername = "root";
		private String jdbcPassword = "";
		private String dbDriver = "com.mysql.jdbc.Driver";
		

		public Connection getConnection(String dbDriver)
		{
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
		
		public boolean validate(Login loginBean)
		{
			boolean status = false;
			
			Connection connection = getConnection(dbDriver);
			
//			String sql = "select * from admin where nom_admin = ? and mot_de_passe =?";
			PreparedStatement ps;
			try {
			ps = connection.prepareStatement("select * from admin where nom = ? and motdepasse =?");
			ps.setString(1, loginBean.getNom());
			ps.setString(2, loginBean.getMotdepasse());
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return status;
		}
		



}
