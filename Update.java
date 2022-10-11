import java.sql.*;
import java.util.Scanner;

public class Update{
  Scanner leer = new Scanner(System.in);
  String msg = null;
  int idr;
  public void actualizar(){
    try{
      ConexionBD bd = new ConexionBD();
      Connection conn = bd.getConnection();
      Statement sentencia = conn.createStatement();
      System.out.println("Nuevo valor: ");
      msg = leer.nextLine();
      System.out.println("ID del registro a cambiar");
      idr = leer.nextInt();
      sentencia.executeUpdate("UPDATE mensaje SET nom = '"+ msg +"' WHERE id="+idr);
      conn.close();
    } catch(SQLException e){
      System.out.print("Error! "+ e.getMessage());
    }
  }
}
