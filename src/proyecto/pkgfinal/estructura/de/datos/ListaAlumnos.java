/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkgfinal.estructura.de.datos;

/**
 *
 * @author Edgar
 */
public class ListaAlumnos {
    NodoAlumnos Primero;
    NodoAlumnos Ultimo;
    
      public ListaAlumnos()
    {
        Primero= null;
        Ultimo= null;
    }
      
       public void IngresarAlumno (String Nombre, int Matricula, int Semestre, String Carrera)
    {
        
        NodoAlumnos NuevoAlumno = new NodoAlumnos();
        NuevoAlumno.Nombre = Nombre;
        NuevoAlumno.Matricula = Matricula;
        NuevoAlumno.Semestre = Semestre;
        NuevoAlumno.Carrera = Carrera;
        
        
       
        
        if(Primero== null)
        {
            Primero = NuevoAlumno;
            Primero.Siguiente = Primero;
            Primero.Anterior= Ultimo;
            Ultimo= NuevoAlumno;
        }
        
        else 
        {
            Ultimo.Siguiente= NuevoAlumno;
            NuevoAlumno.Siguiente= Primero;
            Ultimo= NuevoAlumno;
            Primero.Anterior= Ultimo;
        }
    }
    
    
    public void Mostrar ()
    {
        NodoAlumnos Actual;
        Actual = Primero;
        do
        {
            System.out.println("Nombre: "+ Actual.Nombre + " Matricula: " + Actual.Matricula + " Semestre: " + Actual.Semestre + " Carrera: " + Actual.Carrera);       
            Actual= Actual.Siguiente;
        }
        while(Actual!=Primero);
    }
    
    public int BuscarAlumno (int Matricula)
    {
        NodoAlumnos Actual;
        Actual= Primero;
        int Veces=0;
         do
         {
             if(Actual.Matricula == Matricula)
                     {
                        Veces = Veces+1; 
                     }
             Actual = Actual.Siguiente;
         
             
         }
        while(Actual != Primero);
   
         return Veces;
    }
    
    public void ModificarAlumno(String Nombre, int Matricula, int Semestre, String Carrera)
    {
        NodoAlumnos Actual;
        Actual= Primero;
        do
        {
            if(Actual.Matricula == Matricula)
            {
                Actual.Matricula= Matricula;
                Actual.Nombre = Nombre;
                Actual.Semestre= Semestre;
                Actual.Carrera = Carrera; 
            }
             Actual=Actual.Siguiente;
        }
        while(Actual!=Primero);
       
    }
    
    public void MostrarDatosAlumno(int Matricula)
    {
       NodoAlumnos Actual;
       Actual= Primero; 
        do
        {
            if(Actual.Matricula== Matricula)
            {
                 System.out.println( "Nombre: "+ Actual.Nombre + " Matricula: " + Actual.Matricula + " Semestre: " + Actual.Semestre + " Carrera: " + Actual.Carrera);       
            }
             Actual= Actual.Siguiente;
        }
        while(Actual!=Primero);
    }
    
    public void  EliminarAlumno (int Matricula)
    {
        NodoAlumnos Actual,Anterior;
        Actual= Primero;
        Anterior= Ultimo;
        
        do 
        {
           if(Actual.Matricula == Matricula) 
           {
             if(Actual==Primero)
             {
                 Primero = Primero.Siguiente;
                 Ultimo.Siguiente= Primero;
                 Primero.Anterior = Ultimo;
             }
             else if(Actual == Ultimo)
             {
               Ultimo= Anterior;
               Primero.Anterior= Ultimo;
               Ultimo.Siguiente=Primero;
             }
             else
             {
                 Anterior.Siguiente = Actual.Siguiente;
                 Actual.Siguiente.Anterior=Anterior;
             }
        
           }
           Anterior= Actual;
           Actual= Actual.Siguiente;
        }
        while(Actual!=Primero);
    }
}
