package datos;
import datos.ConexionBD;
import java.sql.*;

public class CreateDB{
  public void createdb() {
    try{
      ConexionBD bd = new ConexionBD();
      Connection conn = bd.getConnection();
      Statement sentencia = conn.createStatement();
      sentencia.executeUpdate("CREATE DATABASE saludos);
      conn.close();
    } catch(SQLException e){
      System.out.print("Error Creating DB! "+ e.getMessage());
    } 
  }
}
