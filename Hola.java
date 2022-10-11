import java.util.Scanner;
public class Hola{
  public static void main(String asdf[]) {
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
          Select objI = new Select();
          objS.insertar();
        break;
        case 3:
          Select objU = new Select();
          objS.actualizar();
        break;
        case 4:
          Select objD = new Select();
          objS.eliminar();
        break;
        default:
          System.out.println("Gracias por tu visita a la fiesta!");
      }
    }while(dato!=5);
    /* System.out.println("Mostrar el Hola Mundo"); */
    /* Select obj = new Select(); */
    /* obj.mostrar(); */
  }
}
