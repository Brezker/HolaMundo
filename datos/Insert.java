package datos;
import datos.ConexionBD;
import java.sql.*;
import java.util.Scanner;

public class Insert{
  Scanner leer = new Scanner(System.in);
  String msg = null;
  
  public void insertar(String msg){
    try{
      ConexionBD bd = new ConexionBD();
      Connection conn = bd.getConnection();
      Statement sentencia = conn.createStatement();
      /* sentencia.executeUpdate("INSERT INTO mensaje VALUES(null,'"+msg+"')"); */
      sentencia.executeUpdate("CALL sp_ins('"+msg+"')");
      conn.close();
    } catch(SQLException e){
      System.out.print("Error! "+ e.getMessage());
    }
  }
}
