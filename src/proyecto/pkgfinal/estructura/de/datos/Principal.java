/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkgfinal.estructura.de.datos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Edgar
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        /* Sistema de Administración de préstamo de libros
        Justice League:
        Edgar Alejandro Ramírez Fuentes (The Flash)
        Jordan Geovanny Vazquez Arteaga (Batman)
        Erik Mora (Aquaman)
        Giussepe Lorenzana García (Superman)
       */
        //BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedReader Cadena = new BufferedReader (new InputStreamReader(System.in));
        Scanner  Teclado = new Scanner (System.in);
        int idPrestamo=0,opc=0,inv= 0, menu= 1, Matricula=0,Existencia=0, Semestre= 0, dia=0, dia2=0, anio= 0,anio2=0, lp= 0, aux=0;
        String Titulo, Autor, Editorial, issn, Nombre, Carrera, Mes, Mes2;
        ListaLibros ListaL = new ListaLibros();
        ListaAlumnos ListaA = new ListaAlumnos();
        ListaPrestamos ListaP = new ListaPrestamos();
        ListaA.IngresarAlumno("Edgar Alejandro Ramírez Fuentes", 2014131046 , 3, "Computación");
        ListaP.IngresarPrestamo(12, "Agosto", 2018, "P-1", 2014131046, 19, "Agosto", 2018, 1);
        ListaL.IngresarLibro("Programar en Java", "Alguien :v", "ESIME Culiacan", "P-1", 3);
        do
        {   
        System.out.println("Sistema de Administracion de prestamos de libros");
          
        System.out.println("Menú");
         
        System.out.println("1.- Agregar Alumno");
           
        System.out.println("2.- Agregar Libro");
         
        System.out.println("3.- Agregar Prestamo");
        
        System.out.println("4.- Modificar Alumno");
        
        System.out.println("5.- Modificar Libro");
        
        System.out.println("6.- Modificar Prestamo");
        
        System.out.println("7.- Buscar Alumno");
        
        System.out.println("8.- Buscar Libro ");
        
        System.out.println("9.- Buscar Prestamo");
         
        System.out.println("10.- Elimninar Alumno");
         
        System.out.println("11.- Eliminar Libro"); 
        
        System.out.println("12.- Eliminar Prestamo");
        
        System.out.println("13.- Mostrar todos los alumnos");
        
        System.out.println("14.- Mostrar todos los libros");
        
        System.out.println("15- Mostrar todos los prestamos");
        
        System.out.println("16.- Reporte Anual");
        
        System.out.println("17.- Salir");
        
        opc = Teclado.nextInt();
        switch (opc)
        {
            case 1:
                  for (int i=0; i < 8; i++)
                {
               System.out.println("");
                }
                  

                System.out.println("Agregar Alumno");
                System.out.print("Matricula: ");
                Matricula = Teclado.nextInt();
                aux = ListaA.BuscarAlumno(Matricula);
                if (aux>0)
                {
                    System.out.println("El alumno ya ha sido registrado");
                    ListaA.MostrarDatosAlumno(Matricula);
                }
                else
                {
            
               
                System.out.print("Nombre: ");
                 Nombre= Cadena.readLine();
                System.out.print("Semestre: ");
                Semestre = Teclado.nextInt();
                System.out.print("Carrera: ");
                Carrera = Cadena.readLine();
                ListaA.IngresarAlumno(Nombre, Matricula, Semestre, Carrera);
                
                }
                 System.out.println("Presione 1 para regresar al menu o cualquier tecla para salir");
                 menu = Teclado.nextInt();
                break;
            case 2:
               for (int i=0; i < 8; i++)
                {
               System.out.println("");
                }
                System.out.println("Agregar Libro");
                System.out.print("ISSN: ");
                issn = Cadena.readLine();
                aux= ListaL.BuscarLibro(issn);
                if(aux == 0)
               {
                System.out.print("Titulo: ");
                Titulo= Cadena.readLine();
                System.out.print("Autor: ");
                Autor = Cadena.readLine();
                System.out.print("Editorial: ");
                Editorial = Cadena.readLine();
               
                System.out.print("Existencia: ");
                inv = Teclado.nextInt();
                ListaL.IngresarLibro(Titulo, Autor, Editorial, issn, inv);
               }
               else
                {
                        System.out.println("El libro ya existe cuantos libros vas a añadir? ");
                        inv = Teclado.nextInt();
                        ListaL.Aumentar(issn,inv);
                }
                 for (int i=0; i < 5; i++)

                {
               System.out.println("");
                }
              
                System.out.println("Presione 1 para regresar al menu o cualquier tecla para salir");
                menu = Teclado.nextInt();
              
                    break;
            case 3:
                  for (int i=0; i < 8; i++)
                {
               System.out.println("");
                }
                
                System.out.println("Prestamo de libros");      
                System.out.print("Matricula: ");
                Matricula = Teclado.nextInt();
                aux= ListaA.BuscarAlumno(Matricula);
                
                if(aux>0)
                {
                aux= ListaP.BuscarPrestamos(Matricula);
                
                if(aux<3)
                {
                System.out.print("ISSN: ");
                issn = Cadena.readLine();
                aux= ListaL.BuscarLibro(issn);
                Existencia= ListaL.ChecarExistencia(issn);
                 if(aux>0 && Existencia>0)
                {
                System.out.print("ID Prestamo: ");
                idPrestamo= Teclado.nextInt();
                aux = ListaP.BuscarPrestamo(idPrestamo);
                if(aux==0)
                {
                System.out.println("Ingresa la Fecha de Prestamo (Ej. Dia: 21  Mes: Septiembre Año: 2016");
                System.out.print("Dia: ");
                dia = Teclado.nextInt();
                System.out.print("Mes ");
                Mes = Cadena.readLine();
                System.out.print("Año ");
                anio = Teclado.nextInt();
                dia2= dia+7;           
                Mes2 = Mes; 
                anio2 = anio;
                ListaP.IngresarPrestamo(dia, Mes, anio, issn, Matricula, dia2, Mes2, anio2, idPrestamo);     
                }
                else
                {
                    System.out.println("Ese ID ya existe");
                }
                }
                else
                {   if(aux==0)
                    System.out.println("Este libro no existe");  
                   else
                    System.out.println("No hay libros para prestar");
                }
                
                }
                
                else
                {
                    System.out.println("Ya no puede pedir más libro, llegó al límite");
                    System.out.println("Estos son sus prestamos");
                    ListaP.MostrarPrestamosAlumno(Matricula);
                }
                }
                else
                {
                    System.out.println("El alumno no existe");
                }
                       
                System.out.println("");
                 System.out.println("Presione 1 para regresar al menu o cualquier tecla para salir");
                menu = Teclado.nextInt(); 
                
                
                break;
            case 4:
                for (int i=0; i < 8; i++)
                {
               System.out.println("");
                }
                System.out.println("Modificar alumno");
                System.out.print("Ingresa la matricula del alumno: ");
                Matricula = Teclado.nextInt();
                aux= ListaA.BuscarAlumno(Matricula);
                if(aux>0)
                {
                    System.out.println("Datos Actuales:");
                    ListaA.MostrarDatosAlumno(Matricula);
                    System.out.println("Ingresa los nuevos datos del alumno: ");
                    System.out.print("Nombre: ");
                    Nombre= Cadena.readLine();
                    System.out.print("Semestre: ");
                    Semestre = Teclado.nextInt();
                    System.out.print("Carrera: ");
                    Carrera = Cadena.readLine();
                    ListaA.ModificarAlumno(Nombre, Matricula, Semestre, Carrera);
                    
                }
                else
                {
                    System.out.println("Este alumno no está registrado");
                }
               
                break;
                
            case 5:
                for (int i=0; i < 8; i++)
                {
               System.out.println("");
                }
                System.out.println("Modificar libro");
                System.out.print("Ingresa el ISSN del libro: ");
                issn = Cadena.readLine();
                aux= ListaL.BuscarLibro(issn);
               
                if(aux>0)
                {
                    
                    System.out.println("Datos Actuales:");
                    ListaL.MostrarDatosLibro(issn);
                    System.out.println("Ingresa los nuevos datos del libro: ");
                    System.out.print("Titulo: ");
                     Titulo= Cadena.readLine();
                     System.out.print("Autor: ");
                     Autor = Cadena.readLine();
                     System.out.print("Editorial: ");
                     Editorial = Cadena.readLine();
                     System.out.print("Existencia: ");
                     inv = Teclado.nextInt();
                     ListaL.ModificarLibro(Titulo, Autor, Editorial, issn, inv);
                 
                    
                }
                else
                {
                    System.out.println("Este alumno no está registrado");
                }
                break;
                
                case 6: 
                     for (int i=0; i < 8; i++)
                {
               System.out.println("");
                }
                System.out.println("Modificar prestamos");
                System.out.print("Ingresa el ID del prestamo: ");
                idPrestamo = Teclado.nextInt();
                aux= ListaP.BuscarPrestamo(idPrestamo);
               
                if(aux>0)
                {
                    
                System.out.println("Datos Actuales:");
                ListaP.MostrarDatosPrestamo(idPrestamo);
                System.out.println("Ingresa los nuevos datos del prestamo: ");
                 
                System.out.print("Matricula: ");
                Matricula = Teclado.nextInt();
                aux= ListaA.BuscarAlumno(Matricula);
                
                if(aux>0)
                {
                aux= ListaP.BuscarPrestamos(Matricula);
                
                if(aux<3)
                {
                System.out.print("ISSN: ");
                issn = Cadena.readLine();
                aux= ListaL.BuscarLibro(issn);
                Existencia= ListaL.ChecarExistencia(issn);
                 if(aux>0 && Existencia>0)
                {
                
                System.out.println("Ingresa la Fecha de Prestamo (Ej. Dia: 21  Mes: Septiembre Año: 2016");
                System.out.print("Dia: ");
                dia = Teclado.nextInt();
                System.out.print("Mes ");
                Mes = Cadena.readLine();
                System.out.print("Año ");
                anio = Teclado.nextInt();
                dia2= dia+7;           
                Mes2 = Mes; 
                anio2 = anio;
                ListaP.ModificarAlumno(dia, Mes, anio, issn, Matricula, dia2, Mes2, anio2, idPrestamo);
                
                
                }
                else
                {   if(aux==0)
                    System.out.println("Este libro no existe");  
                   else
                    System.out.println("No hay libros para prestar");
                }
                
                }
                
                else
                {
                    System.out.println("Ya no puede pedir más libro, llegó al límite");
                    System.out.println("Estos son sus prestamos");
                    ListaP.MostrarPrestamosAlumno(Matricula);
                }
                }
                else
                {
                    System.out.println("Este alumno no está registrado");
                }
                 
                    
                }
                else
                {
                    System.out.println("Este ID no está registrado");
                }
                break;
                
                case 7:
                     for (int i=0; i < 8; i++)
                {
               System.out.println("");
                }
                System.out.print("Ingresa la matricula del alumno: ");
                Matricula= Teclado.nextInt();
                aux = ListaA.BuscarAlumno(Matricula);
                if(aux>0)
                {
                ListaA.MostrarDatosAlumno(Matricula);
                }
                else
                {
                    System.out.println("El alumno no está registrado");
                }
                break;
            
            
                
                        
            case 8:
                 for (int i=0; i < 8; i++)
                {
               System.out.println("");
                }
               System.out.print("Ingresa el ISSN del libro: ");
               issn = Cadena.readLine();
                aux = ListaL.BuscarLibro(issn);
                if(aux>0)
                {
                ListaL.MostrarDatosLibro(issn);
                }
                else
                {
                    System.out.println("El libro no está registrado");
                }
                break;
            case 9: 
                 for (int i=0; i < 8; i++)
                {
               System.out.println("");
                }
                 System.out.print("Ingresa el ID del Prestamo: ");
                 idPrestamo= Teclado.nextInt();
                aux = ListaP.BuscarPrestamo(idPrestamo);
                if(aux>0)
                {
                ListaP.MostrarDatosPrestamo(idPrestamo);
                }
                else
                {
                    System.out.println("El prestamo no está registrado");
                }
                break;
                
            case 10:
                 for (int i=0; i < 8; i++)
                {
               System.out.println("");
                }
                System.out.println("Ingresa la matricula del alumno: ");
                Matricula= Teclado.nextInt();
                aux= ListaA.BuscarAlumno(Matricula);
                if(aux>0)
                {
                ListaA.EliminarAlumno(Matricula);
                }
                else
                {
                    System.out.println("El alumno no está registrado");
                }
                break;
                 case 11: 
                      for (int i=0; i < 8; i++)
                {
               System.out.println("");
                }
               System.out.println("Ingresa el ISSN del libro: ");
                issn = Cadena.readLine();
                aux= ListaL.BuscarLibro(issn);
                if(aux>0)
                {
                ListaL.EliminarLibro(issn);
                }
                else
                {
                    System.out.println("El libro no está registrado");
                }
                break;
                 case 12: 
                      for (int i=0; i < 8; i++)
                {
               System.out.println("");
                }
                 System.out.println("Ingresa el ID del prestamo: ");
                idPrestamo= Teclado.nextInt();
                aux= ListaP.BuscarPrestamo(idPrestamo);
                if(aux>0)
                {
                ListaP.EliminarPrestamo(idPrestamo);
                }
                else
                {
                    System.out.println("El prestamo no está registrado");
                }
                break;
                 case 13:
                     ListaA.Mostrar();
                     break;
                 case 14:
                     ListaL.Mostrar();
                     break;
                 case 15: 
                     ListaP.Mostrar();
                     break;
                 case 16:
                     System.out.print("Ingresa el año del reporte: ");
                     anio= Teclado.nextInt();
                     ListaP.ReporteAnual(anio);
                     
                     break;
                     
                 case 17:
                     System.out.close();
                     break;
                   
            
        }
        
        }
        while(menu==1);
       ListaL.Mostrar();
                         
    }
    
}
