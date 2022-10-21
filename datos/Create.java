package datos;
import datos.ConexionBD;
import java.sql.*;
import java.util.Scanner;

public class Create{
  Scanner leer = new Scanner(System.in);
  String msg = null;
  
  public void crear(String msg){
    try{
      ConexionBD bd = new ConexionBD();
      Connection conn = bd.getConnection();
      Statement sentencia = conn.createStatement();
      /* sentencia.executeUpdate("INSERT INTO mensaje VALUES(null,'"+msg+"')"); */
      sentencia.executeUpdate("CREATE USER "+msg+"@localhost IDENTIFIED BY '123'");
      sentencia.executeUpdate("GRANT SELECT, INSERT, UPDATE, DELETE, EXECUTE ON mensaje.* TO "+msg+"@localhost");
      sentencia.executeUpdate("FLUSH PRIVILEGES");
      conn.close();
    } catch(SQLException e){
      System.out.print("Error! "+ e.getMessage());
    }
  }
}
