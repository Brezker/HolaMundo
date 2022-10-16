package datos;
// import java.util.Scanner;
import java.sql.*;
public class ConexionBD {
  Connection conn = null;
  public void checkdb() {
    
    boolean exist = false;
    try {
      
      String url = "jdbc:mysql://localhost:3306/saludos";
      String user = "root", password = "root";
      try {
        conn = DriverManager.getConnection(url,user,password);
      } catch (SQLException e) {
        System.out.print("Error! " + e.getMessage());
      }

      Statement st = null;
      st = conn.createStatement();
      String sql = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = 'saludos'";
      ResultSet rs = st.executeQuery(sql);

      if (rs.next()) {
        //JOptionPane.showMessageDialog(main, "La base de datos existe.");
        exist = true;
      }
    } catch (SQLException ex) {
      //JOptionPane.showMessageDialog(main, "La base de datos no existe.");
      exist = false;
    }
	
    if(exist = false){
		try{
		  ConexionBD bd = new ConexionBD();
		  Connection conn = bd.getConnection();
		  Statement sentencia = conn.createStatement();
		  sentencia.executeUpdate("CREATE DATABASE saludos");
		  sentencia.executeUpdate("use saludos");
		  sentencia.executeUpdate("CREATE TABLE mensaje(id INT PRIMARY KEY AUTO_INCREMENT, nom VARCHAR(30) NOT NULL)");
		  sentencia.executeUpdate("INSERT INTO mensaje VALUES(null, 'Hola mundo'), (null, 'Ni hao')");
		  
		  /* conn.close(); */
		} catch(SQLException e){
		  System.out.print("Error! "+ e.getMessage());
		}
    } else {
      //System.out.println("Existe la BD");
    }

  }
  public Connection getConnection() {
    return this.conn;
  }
  public void desconectarBD() {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        System.out.print("Error de desconexion! " + e.getMessage());
      }
    }
  }
    /*
    Scanner leer = new Scanner(System.in);
    System.out.print("Escribe tu saludo: ");
    String msg = leer.nextLine();
    System.out.print("--> " + msg);
    */
}
