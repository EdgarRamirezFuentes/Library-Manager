/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkgfinal.estructura.de.datos;


public class ListaLibros {
    NodoLibros Primero;
    NodoLibros Ultimo;
    String TF;
    
    public ListaLibros()
    {
        Primero= null;
        Ultimo= null;
    }
    
    public void IngresarLibro (String Titulo,String Autor,String Editorial, String issn, int inv)
    {
        
        NodoLibros NuevoLibro = new NodoLibros();
        NuevoLibro.Titulo = Titulo;
        NuevoLibro.Autor = Autor;
        NuevoLibro.Editorial = Editorial;
        NuevoLibro.issn = issn;
        NuevoLibro.inv = inv;
        
       
        
        if(Primero== null)
        {
            Primero = NuevoLibro;
            Primero.Siguiente = Primero;
            Primero.Anterior= Ultimo;
            Ultimo= NuevoLibro;
        }
        
        else 
        {
            Ultimo.Siguiente= NuevoLibro;
            NuevoLibro.Siguiente= Primero;
            Ultimo= NuevoLibro;
            Primero.Anterior= Ultimo;
        }
    }
    
    
    public void Mostrar ()
    {
        NodoLibros Actual;
        Actual = Primero;
        do
        {
            System.out.println("Titulo: "+ Actual.Titulo + " Autor: " + Actual.Autor+ " Editorial: " + Actual.Editorial + " ISSN: " + Actual.issn + " Existencia: " + Actual.inv);       
            Actual= Actual.Siguiente;
        }
        while(Actual!=Primero);
    }
    
     public int BuscarLibro (String issn)
    {
        NodoLibros Actual;
        Actual= Primero;
        int Veces=0;
         do
         {
           if(Actual.issn.equals(issn))
           {
               Veces= Veces+1;
           }
           Actual= Actual.Siguiente;
         }
        while(Actual != Primero);
   
         return Veces;
    }
     
     public void Aumentar (String issn, int inv)
    {
        NodoLibros Actual;
        Actual = Primero;
        do
        {
            if( Actual.issn.equals(issn))
            {
                Actual.inv= Actual.inv+inv;
            }
            Actual= Actual.Siguiente;
        }
        while(Actual!=Primero);
    }
     
    public void ModificarLibro(String Titulo, String Autor, String Editorial,String issn, int inventario)
    {
        NodoLibros Actual;
        Actual= Primero;
        do
        {
           if(Actual.issn.equals(issn))
           {
               Actual.Titulo = Titulo;
               Actual.Autor = Autor;
               Actual.Editorial = Editorial;
               Actual.inv= inventario;
           }
           Actual= Actual.Siguiente;
        }
        while(Actual!=Primero);
       
    }
    
    public void MostrarDatosLibro(String issn)
    {
       NodoLibros Actual;
       Actual= Primero; 
        do
        {
            if(Actual.issn.equals(issn))
            {
                  System.out.println("Titulo: "+ Actual.Titulo + " Autor: " + Actual.Autor+ " Editorial: " + Actual.Editorial + " ISSN: " + Actual.issn + " Existencia: " + Actual.inv);       
                  return;
            }
             Actual= Actual.Siguiente;
        }
        while(Actual!=Primero);
    }
    
   public int ChecarExistencia(String issn)
   {
       NodoLibros Actual;
       Actual= Primero;
       int existencia=0;
       do
        {
            if(Actual.issn.equals(issn))
            {
               existencia = Actual.inv;    
            }
             Actual= Actual.Siguiente;
        }
        while(Actual!=Primero);
    return existencia;   
   }
   
    public void  EliminarLibro (String issn)
    {
        NodoLibros Actual,Anterior;
        Actual= Primero;
        Anterior= Ultimo;
        
        do 
        {
           if(Actual.issn == issn) 
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
