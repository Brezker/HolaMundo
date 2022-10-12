package datos;
// import java.util.Scanner;
import java.sql.*;
public class ConexionBD {
  Connection conn = null;
  public ConexionBD() {
    String url = "jdbc:mysql://localhost:3306/saludos";
    String user = "root", password = "root";
    try {
      conn = DriverManager.getConnection(url,user,password);
    } catch (SQLException e) {
      System.out.print("Error! " + e.getMessage());
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
