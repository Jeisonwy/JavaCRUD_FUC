
package main;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


public class Menu {
    
    
    
    
        public static void switch1(byte op, Student P1,ArrayList<Student> studentList) throws IOException{
            
            String menuLine = "\nSeleccione la opcion requerida \n 1. - Buscar alumno \t 3. - Borrar Alumno \n 2. - Agregar Alumno \t 4. - Salir";
            String consoleDec = "***********************";
            DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
            Date date = new Date();
      while(op<=3 && op>=1){
           switch(op){
           
            case(1):
                System.out.println(consoleDec+"Modo buscar alumno"+consoleDec);
                System.out.println("Seleccione la clave por la que desea buscar\n1.Buscar por Matricula\n2.Buscar por carrera\n3.Buscar por sexo\n4.Mostrar todo");
                Scanner scOp3 = new Scanner(System.in);
                    byte op2 = scOp3.nextByte();
            
                    Menu.switch2(op2, P1, studentList);
            
                    
        System.out.print("\033[H\033[2J");
        System.out.flush();
                System.out.println(menuLine);
                Scanner scOp0 = new Scanner(System.in);
                op = scOp0.nextByte();
               
                break;
            case(2):
                
                System.out.println(consoleDec+"Modo agregar alumno"+consoleDec);
                   
                Operation.createList(P1, studentList);
                
                
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
                System.out.println(menuLine);
                Scanner scOp2 = new Scanner(System.in);
                op = scOp2.nextByte();
                
                
                break;
            case(3):
                System.out.println(consoleDec+"Modo borrar alumno"+consoleDec+"\nIngrese el numero de matricula que dessea eliminar"); 
                Scanner scOp4 = new Scanner(System.in);
                String deleteUser = scOp4.nextLine();
                String student =("");
                String list1 = ("");
                File fileData = new File("Alumnos.dat");
                
                Operation.userDelete(deleteUser, student, list1, fileData);
                
        System.out.print("\033[H\033[2J");
        System.out.flush();   
        
                System.out.println(menuLine);
                Scanner scOp5 = new Scanner(System.in);
                op = scOp5.nextByte();
                break;
            default:
                System.out.println("Opcion invalida");break;
               
       }
          
    }
     if(op>4 || op<1){
          System.out.println("Valor fuera de rango");
      }else{
       System.out.println("Hasta la proxima \nSesion finalizada: "+dateFormat.format(date));}
}

        
        //Menu de las opciones de buscar alumno y mostrar la lista completa de alumnos
        
        
public static void switch2(byte op2, Student P1,ArrayList<Student> studentList) throws IOException{
    String consoleDec = "***********************";

    switch(op2){
        
        // BUSCAR POR MATRICULA IMPRIME UN UNICO ESTUDIANTE CON EL NUMERO DE MATRICULA QUE LO IDENTIFICA
        
            case(1):
                System.out.println("BUSCADOR POR MATRICULA"+consoleDec+"Ingrese el numero de matricula a buscar"+consoleDec);

                Scanner f1 = new Scanner(System.in);
                String finder1 = f1.nextLine();
                byte error = 1;
            
                Operation.findUserByEnrollment(finder1,error);
            
            break;
            
        // BUSCAR POR CARRERA IMPRIME TODOS LOS ESTUDIANTES QUE COINCIDAN CON LA CLAVE DE LA CARRERA
            case(2):
                System.out.print("BUSCADOR POR CARRERA"+consoleDec+"Ingrese clave de carrera"+consoleDec+"\nClaves actuales:\nING_IND\tIngenieria industrial");
                System.out.println("\nING_TEL\tIngenieria Telecomunicaciones\nING_ELE\tIngenieria electrica");
                Scanner f2 = new Scanner(System.in);
                String finder2 = f2.nextLine().toUpperCase();
                byte error2 = 1;
                
                Operation.findUserByCarreerKey(finder2, error2);
                
            break;
            
        // BUSCADOR DE ALUMNOS POR SEXO, MOSTRARA TODOS LOS USUARIOS MASCULINOS O LOS USUARIOS FEMENINOS
            case(3):
                System.out.println("BUSCADOR POR SEXO \n F o M");
                
                
            Scanner f3 = new Scanner(System.in);
            String finder3 = f3.nextLine().toUpperCase();
            byte error3 = 1;
            
            Operation.findUsersByGenre(finder3, error3);
            
            break;
            case(4):
                
                Operation.showAllUsers();
                
            break;
            default:
                System.out.println("Valor fuera de rango");
    }}}