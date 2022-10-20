package datos;
import negocio.*;
import java.sql.*;
public class Crear_BD {
  Connection conn = null;
  
  public Crear_BD() {
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root", password = "";
    try {
      conn = DriverManager.getConnection(url,user,password);
      //crear bd
      Statement stmt = conn.createStatement();
     stmt.execute("create database saludos");
     stmt.execute("use saludos");
     stmt.executeUpdate("CREATE TABLE IF NOT EXISTS mensaje(id INT PRIMARY KEY AUTO_INCREMENT, nom VARCHAR(30) NOT NULL)");
     
    } catch (SQLException e) {
      System.out.print("Error! " + e.getMessage());
    }
    }
    
    public void alma_cena2(){
  try{
      Statement sentencia = conn.createStatement();
      sentencia.executeUpdate("create procedure nv_men(nm varchar(30)) begin insert into mensaje values(null,nm); END ");
      sentencia.executeUpdate("create procedure del_men(nm varchar(30)) begin DELETE FROM mensaje WHERE id=nm; END ");
      sentencia.executeUpdate("create procedure ver_t_men() begin SELECT * FROM mensaje; END ");
      sentencia.executeUpdate("create procedure corrije_men(nm varchar(30),idr int) begin UPDATE mensaje SET nom =nm WHERE id=idr; END "); 
      /*/crear ususario 2 tipos todos y el otro solo algunas
      sentencia.executeUpdate("create user dylan@localhost IDENTIFIED BY '123'");
      sentencia.executeUpdate("GRANT SELECT, INSERT, EXECUTE ON mensaje.* TO  dylan@localhost");
      
     /*/ 

      
      conn.close();
    } catch(SQLException e){
      System.out.print("Error! "+ e.getMessage());
    }
  }//sql_sen
    
    
  }
