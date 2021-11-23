package TestDB;

import java.sql.*;

public class MainApp {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/facultate";
		Statement sql;
		ResultSet rs;
		Connection con = DriverManager.getConnection(url, "root", "");
		sql = con.createStatement();
		rs = sql.executeQuery("select * from discipline");
		while (rs.next())
			System.out.println("codDisciplina=" + rs.getInt("codDisciplina") + ", Disciplina= " +
		rs.getString("Disciplina") + ",An_Studiu=" + rs.getInt("An_Studiu"));
		con.close();
		sql.close();
		rs.close();
	}
}
