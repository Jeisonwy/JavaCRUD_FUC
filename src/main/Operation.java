package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mlkwy
 */
    
public class Operation {
    

    
    //Metodo para agregar un alumno a la base de datos
    
    public static void addData(ArrayList<Student> studentList) throws IOException{
        
     
            File fileData = new File("Alumnos.dat");
            FileWriter fileWriter = new FileWriter(fileData.getAbsoluteFile(),true);
            BufferedWriter bufferFile = new  BufferedWriter(fileWriter);
            
        try{
            
            for(Student person : studentList) {
                bufferFile.write(person.getEnrollment()+","+person.getName()+","+person.getFirlastName()+","+person.getSeclastName()+","+person.getCarreerKey()+","+person.getGenre());
                bufferFile.write("\n");}
                bufferFile.close();
                System.out.println("Se ha agregado a la base de datos con exito");
            
         
        }catch(IOException badEntrace) {
            System.out.println("Error consulte al administrador");
            
        }}
    
    //metodo para crear un estudiante nuevo

    public static void createList(Student P1, ArrayList<Student> studentList) throws IOException{
        
         
                            System.out.println("Ingrese el numero de matricula");
                    Scanner sc2 = new Scanner(System.in);
                        P1.setEnrollment(sc2.nextInt());
                            System.out.println("Ingrese el nombre del estudiante");
                    Scanner sc3 = new Scanner(System.in);
                        P1.setName(sc3.nextLine().toUpperCase());
                    Scanner sc4 = new Scanner(System.in);
                            System.out.println("Ingrese el primer apellido");
                        P1.setFirlastName(sc4.nextLine().toUpperCase());
                    Scanner sc5 = new Scanner(System.in);
                            System.out.println("Ingrese el segundo apellido");
                        P1.setSeclastName(sc5.nextLine().toUpperCase());
                    Scanner sc6 = new Scanner(System.in);
                            System.out.println("Ingrese el identificador de la carrera");
                        P1.setCarreerKey(sc6.nextLine().toUpperCase());
                            System.out.println("Ingrese el genero del alumno");
                    Scanner sc7 = new Scanner(System.in);
                        P1.setGenre(sc7.nextLine().toUpperCase());
                        
                    
                        studentList.add(P1);
                        Operation.addData(studentList);
                        studentList.clear();
                    

                    
    }

    //metodo para buscar un usuario por matricula
    
    public static void findUserByEnrollment(String finder1, byte error){

            try(BufferedReader bufferedFile = new BufferedReader(new FileReader("Alumnos.dat"))){
            String student;
            byte it = 0;
            while ((student = bufferedFile.readLine()) != null && it == 0){
            
            String user = student;
            ArrayList<String> itemsData = new  ArrayList<String>(Arrays.asList(user.split(",")));

            
            
            if(itemsData.get(0).equals(finder1)){
                System.out.println("Usuario encontrado: "+itemsData);
                it = 1 ;
                error = 0;
            }else{
                itemsData.clear();}
            }
            bufferedFile.close();
            }
            
            catch (IOException e) {
                System.out.println("No se ha podido leer el archivo.");
                e.printStackTrace();}
                System.out.println("-------------------------------------------------");
                
             if(error ==1){
                 System.out.println("El usuario no se encuentra registrado en la base de datos");}
    }
    
    public static void findUserByCarreerKey(String finder2, byte error2){
                                               
         try(BufferedReader bufferedFile = new BufferedReader(new FileReader("Alumnos.dat"))){
            String student;
            byte it = 0;
            while ((student = bufferedFile.readLine()) != null){
            
            
            String user = student;
            ArrayList<String> itemsData = new  ArrayList<String>(Arrays.asList(user.split(",")));
       
            
       
            if(itemsData.get(4).equals(finder2)){
                System.out.println(itemsData);
                
                error2 = 0;
            }else{
                itemsData.clear();}
            }
            bufferedFile.close();
            }
            
            catch (IOException e) {
                System.out.println("No se ha podido leer el archivo.");
                e.printStackTrace();}
                System.out.println("-------------------------------------------------");
                
             if(error2 ==1){
                 System.out.println("La clave de la carrera es invalida");}
    }
    
    
    public static void findUsersByGenre(String finder3, byte error3){
                                                   
    try(BufferedReader bufferedFile = new BufferedReader(new FileReader("Alumnos.dat"))){
            String student;
            byte it = 0;
            while ((student = bufferedFile.readLine()) != null){
            
            
            String user = student;
            ArrayList<String> itemsData = new  ArrayList<String>(Arrays.asList(user.split(",")));
       
            
       
            if(itemsData.get(5).equals(finder3)){
                System.out.println(itemsData);
                
                error3 = 0;
            }else{
                itemsData.clear();}
            }
            bufferedFile.close();
            }
            
            catch (IOException e) {
                System.out.println("No se ha podido leer el archivo.");
                e.printStackTrace();}
                System.out.println("-------------------------------------------------");
                
             if(error3 ==1){
                 System.out.println("Entrada invalida");}
    }
    
    public static void showAllUsers(){
    
                System.out.println("MOSTRAR TODOS LOS ELEMENTOS\n");
                System.out.println("-------------------------------------------------"); 

        try(BufferedReader br = new BufferedReader(new FileReader("Alumnos.dat"))){
            
                String student;
            while ((student = br.readLine()) != null) {
                System.out.println(student);
                }}
        
        
        catch (IOException e) {
                System.out.println("No se ha podido leer el archivo.");
                e.printStackTrace();}
                System.out.println("-------------------------------------------------");
    }
    
    public static void userDelete(String deleteUser, String student, String list1, File fileData){
                                             
             try(BufferedReader bufferedFile = new BufferedReader(new FileReader("Alumnos.dat"))){
         ArrayList<String> itemsData1 = new  ArrayList<String>();
    
 
            while ((student = bufferedFile.readLine()) != null){
                
            String user = student;
            itemsData1 = new  ArrayList<String>(Arrays.asList(user.split(",")));
            if(itemsData1.get(0).equals(deleteUser)){
                System.out.println("");}else{
            list1 =list1+itemsData1.toString();
            }
     
            }}catch(IOException e){System.out.println("ERROR");}
     
        
         
            
            
        try{
            fileData.delete();
                FileWriter fileWriter = new FileWriter(fileData.getAbsoluteFile(),true);
                BufferedWriter bufferFile = new  BufferedWriter(fileWriter);
   
                    
                    
      
             
                bufferFile.write(list1.replace("]","\n").replace("[","").replace(" ",""));
                bufferFile.close();
                System.out.println("Se ha actualizado la base de datos con exito");
            
         
        }catch(IOException badEntrace) {
            System.out.println("Error consulte al administrador");
            
        }
     
       
     
                
           
     
        
            
        
}
}
    

    

    


