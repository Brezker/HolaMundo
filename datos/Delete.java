package datos;
import datos.ConexionBD;
import java.sql.*;
import java.util.Scanner;

public class Delete{
  Scanner leer = new Scanner(System.in);
  int idr;
  public void eliminar(int idr){
    try{
      ConexionBD bd = new ConexionBD();
      Connection conn = bd.getConnection();
      Statement sentencia = conn.createStatement();
      /*System.out.println("ID del registro a eliminar");
      idr = leer.nextInt();*/
      /* sentencia.executeUpdate("DELETE FROM mensaje WHERE id=" + idr); */
      sentencia.executeUpdate("CALL sp_bor("+idr+")");
      conn.close();
    } catch(SQLException e){
      System.out.print("Error! "+ e.getMessage());
    }
  }
}
