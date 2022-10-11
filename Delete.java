import java.sql.*;
import java.util.Scanner;

public class Delete{
  Scanner leer = new Scanner(System.in);
  int idr;
  public void eliminar(){
    try{
      ConexionBD bd = new ConexionBD();
      ConexionBD conn = bd.getConnection();
      Statement sentencia = conn.createStatement();
      System.out.print("ID del registro a eliminar");
      idr = leer.nextInt();
      sentencia.executeUpdate("DELETE FROM mensaje WHERE id=" + idr);
      conn.close();
    } catch(SQLException e){
      System.out.print("Error! "+ e.getMessage());
    }
  }
}
