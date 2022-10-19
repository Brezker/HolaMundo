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
	/*System.out.print("Ingresa un mensaje para registrarlo: ");
	String msg=leer.nextLine();*/
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
   
   public void menu(){
	Scanner leer = new Scanner(System.in);
    int dato;
    do{
      System.out.println("\n--Menu--\n1. Select\n2. Insert\n3. Update\n4. Delete\n5. Salir\n");
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
        default:
          System.out.println("Gracias por tu visita a la fiesta!");
      }
    }while(dato!=5);
	   
	   
	   
	/*Scanner leer=new Scanner(System.in);
	
	int menu = 0;
	
	do {
		
		System.out.println("Selecciona una opcion (solo digite el numero): ");
		System.out.println("Opcion 1: Registrar un nuevo mensaje");
		System.out.println("Opcion 2: Modificar un mensaje");
		System.out.println("Opcion 3: Eliminar un mensaje");
		System.out.println("Opcion 4: Mostrar todos los mensajes registrados");
		
		int seleccion = leer.nextInt();
		
		switch (seleccion) {
                case 1:
                    registrar();
                    break;

                case 2:
                    edicion();
                    break;

                case 3:
                    eliminar();
                    break;

                case 4:
                    obj.mostrar();
                    break;
		}
		System.out.println("Si desea continuar escriba 1, si no desea continuar escriba 0");
        menu = leer.nextInt();
	} while (menu == 1);*/
	
	
	//System.out.println("Hola bro, que accion quieres hacer hoy?: ");
	//System.out.println("Para insertar un dato presiona 1");
	//System.out.println("Para cambiar un dato presiona 2");
	//System.out.println("O quieres eliminar un dato?, presiona 3");
	//int hacer=leer.nextInt();
	//if(hacer == 1){
	//	registrar();
	//}
	//if(hacer == 2){
	//	edicion();
	//}
	//if(hacer == 3){
	//	eliminar();
	//}
  }
}






