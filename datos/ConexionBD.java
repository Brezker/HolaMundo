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
	      st.execute("CREATE DATABASE saludos");
	      st.execute("use saludos");
	      st.execute("CREATE TABLE mensaje(id INT PRIMARY KEY AUTO_INCREMENT, nom VARCHAR(30) NOT NULL)");
	      st.execute("INSERT INTO mensaje VALUES(null, 'Hola mundo'), (null, 'Ni hao')");
	      
        st.executeUpdate("CREATE PROCEDURE sp_ins(nm VARCHAR(30)) BEGIN INSERT INTO mensaje VALUES(NULL,nm); END ");
        st.executeUpdate("CREATE PROCEDURE sp_mos() BEGIN SELECT * FROM mensaje; END ");
        st.executeUpdate("CREATE PROCEDURE sp_bor(nm INT) BEGIN DELETE FROM mensaje WHERE id=nm; END ");
        st.executeUpdate("CREATE PROCEDURE sp_act(nm INT, tx VARCHAR(30)) BEGIN UPDATE mensaje SET nom=tx where id=nm; END ");
        /* st.executeUpdate("CREATE PROCEDURE sp_() BEGIN ; END "); */
        
        //Create User
        /* st.executeUpdate("CREATE USER jul@localhost IDENTIFIED BY '123'"); */
        /* st.executeUpdate("GRANT SELECT, INSERT, UPDATE, DELETE, EXECUTE ON mensaje.* TO jul@localhost"); */
        /* st.executeUpdate("FLUSH PRIVILEGES"); */

	      /* String user = "jul", password = "123"; */

        System.out.println("Creando...");
        System.out.println("BD creada ingresando al sistema");
	      /* objCDB.createdb(); */
        exist = false;
      }
    } catch (SQLException ex) {
      //JOptionPane.showMessageDialog(main, "La base de datos no existe.");
      /* System.out.println("No existe la BD"); */
      /*System.out.println("BD creada"); */
      exist = false;
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
