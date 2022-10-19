package datos;
// import java.util.Scanner;
import java.sql.*;
public class ConexionBD {
  Connection conn = null;
  public ConexionBD() {
    
    boolean exist = false;
    try {
      
      String url = "jdbc:mysql://localhost:3306/";
      String url2 = "jdbc:mysql://localhost:3306/saludos";
      String user = "root", password = "root";
      try {
        conn = DriverManager.getConnection(url,user,password);
      } catch (SQLException e) {
        System.out.print("Errorx! " + e.getMessage());
      }

      Statement st = null;
      st = conn.createStatement();
      String sql = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = 'saludos'";
      ResultSet rs = st.executeQuery(sql);

      if (rs.next()) {
        //JOptionPane.showMessageDialog(main, "La base de datos existe.");
        /* System.out.println("Existe la BD"); */
        try {
          conn = DriverManager.getConnection(url2,user,password);
        } catch (SQLException e) {
          System.out.println("No existe la BD");
          
          /* st.executeQuery("CREATE DATABASE saludos"); */
          System.out.println("BD creada");
          exist = false;
          System.out.print("Errorer! " + e.getMessage());
        }
        exist = true;
      } else {
        System.out.println("No existe la BD");
        /* CreateDB objCDB = new CreateDB(); */
	      st.execute("CREATE DATABASE saludos");
	      st.execute("use saludos");
	      st.execute("CREATE TABLE mensaje(id INT PRIMARY KEY AUTO_INCREMENT, nom VARCHAR(30) NOT NULL)");
	      st.execute("INSERT INTO mensaje VALUES(null, 'Hola mundo'), (null, 'Ni hao')");

	      /* objCDB.createdb(); */
        exist = false;
      }
    } catch (SQLException ex) {
      //JOptionPane.showMessageDialog(main, "La base de datos no existe.");
      /* System.out.println("No existe la BD"); */
      /* st.executeQuery("CREATE DATABASE saludos"); */
      /* System.out.println("BD creada"); */
      exist = false;
    }
	
  /*   if(exist = false){ */
		/* try{ */
		/*   ConexionBD bd = new ConexionBD(); */
		/*   Connection conn = bd.getConnection(); */
		/*   Statement sentencia = conn.createStatement(); */
		/*   sentencia.executeUpdate("CREATE DATABASE saludos"); */
		/*   sentencia.executeUpdate("use saludos"); */
		/*   sentencia.executeUpdate("CREATE TABLE mensaje(id INT PRIMARY KEY AUTO_INCREMENT, nom VARCHAR(30) NOT NULL)"); */
		/*   sentencia.executeUpdate("INSERT INTO mensaje VALUES(null, 'Hola mundo'), (null, 'Ni hao')"); */
		/*    */
		/* conn.close(); */
		/* } catch(SQLException e){ */
		/*   System.out.print("Errores! "+ e.getMessage()); */
		/* } */
  /*   } else { */
  /*     System.out.println("Existe la BD"); */
  /*   } */

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
