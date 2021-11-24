package main;

/**
 *
 * @author mlkwy
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {


 public static void main(String[] args) throws IOException {
     System.out.println("-------------------------------------------");
     System.out.println("Seleccione la opcion requerida \n 1. - Buscar alumno \t 3. - Borrar Alumno \n 2. - Agregar Alumno \t 4. - Salir");
     System.out.println("-------------------------------------------");
/*********************************************************************/
/**/    ArrayList<Student> studentList = new ArrayList<>();        /**/
/**/    Scanner sc1 = new Scanner(System.in);                      /**/
/**/    byte op = sc1.nextByte();                                  /**/
/**/    Student P1 = new Student();                                /**/
/*********************************************************************/

       Menu.switch1(op, P1, studentList); //Metodo para llamar el menu del programa
 }

}