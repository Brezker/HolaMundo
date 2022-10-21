package negocio;
import datos.*;

import java.util.Scanner;

public class Operaciones{

   ConexionBD obj=new ConexionBD();

  public void insert(){
		Insert objI = new Insert();
		Scanner leer=new Scanner(System.in);
		System.out.println("Ingresa mensaje:");
    String msg = leer.nextLine();
	  objI.insertar(msg);
  }

  public void edit(){
		Update objU = new Update();
		Scanner leer=new Scanner(System.in);
		System.out.println("Nuevo valor: ");
    String msg = leer.nextLine();
		System.out.println("ID del registro a cambiar");
    int idr = leer.nextInt();
		objU.actualizar(msg,idr);
  }

  public void delete(){
	  Delete objD = new Delete();
	  Scanner leer=new Scanner(System.in);
	  System.out.println("ID del registro a eliminar");
    int idr = leer.nextInt();
	  objD.eliminar(idr);
  }

  public void create(){
		Create objC = new Create();
		Scanner leer=new Scanner(System.in);
		System.out.println("Ingresa nombre pal usuario:");
    String msg = leer.nextLine();
	  objC.crear(msg);
  }
   
  public void menu(){
	  Scanner leer = new Scanner(System.in);
    int dato;
    for(;;){
      System.out.println("\n--Menu--\n1. Select\n2. Insert\n3. Update\n4. Delete\n5. Create BD User\n6. Salir\n");
      dato = leer.nextInt();
      switch(dato){
        case 1:
          Select objS = new Select();
          objS.mostrar();
        break;
        case 2:
          /*Insert objI = new Insert();
          objI.insertar();*/
		      insert();
        break;
        case 3:
          /*Update objU = new Update();
          objU.actualizar();*/
		      edit();
        break;
        case 4:
          /*Delete objD = new Delete();
          objD.eliminar();*/
		      delete();
        break;
        case 5:
          /*Delete objD = new Delete();
          objD.eliminar();*/
		      create();
        break;
        default:
          System.out.println("Gracias por tu visita a la fiesta!");
          System.exit(0);
      }
    }
  }
}






