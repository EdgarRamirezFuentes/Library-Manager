/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edgar
 */
public class ListaPrestamos {

    NodoPrestamos Primero;
    NodoPrestamos Ultimo;


    public ListaPrestamos() {
        Primero = null;
        Ultimo = null;
    }

    public void IngresarPrestamo(int Dia, String Mes, int anio, String issn, int Matricula, int Dia2, String Mes2, int anio2, int idPrestamo) {

        NodoPrestamos NuevoPrestamo = new NodoPrestamos();
        NuevoPrestamo.dia = Dia;
        NuevoPrestamo.Mes = Mes;
        NuevoPrestamo.anio = anio;
        NuevoPrestamo.issn = issn;

        NuevoPrestamo.matricula = Matricula;
        NuevoPrestamo.dia2 = Dia2;
        NuevoPrestamo.Mes2 = Mes2;
        NuevoPrestamo.anio2 = anio2;
        NuevoPrestamo.idPrestamo = idPrestamo;

        if (Primero == null) {
            Primero = NuevoPrestamo;
            Primero.Siguiente = Primero;
            Primero.Anterior = Ultimo;
            Ultimo = NuevoPrestamo;
        } else {
            Ultimo.Siguiente = NuevoPrestamo;
            NuevoPrestamo.Siguiente = Primero;
            Ultimo = NuevoPrestamo;
            Primero.Anterior = Ultimo;
        }
    }



    public void Mostrar() {
        NodoPrestamos Actual;
        Actual = Primero;
        do {

            System.out.println("");
            System.out.print("Fecha de prestamo: " + Actual.dia + " - " + Actual.Mes + " - " + Actual.anio + " Matricula: " + Actual.matricula + " Fecha de Devolucion: " + Actual.dia2 + " - " + Actual.Mes2 + " - " + Actual.anio2 + " ISSN: " + Actual.issn);
            Actual = Actual.Siguiente;
        }
        while (Actual != Primero);
    }

    public int BuscarPrestamos(int Matricula) {
        NodoPrestamos Actual;
        Actual = Primero;
        int Veces = 0;
        do {
            if (Actual.matricula == Matricula) {
                Veces = Veces + 1;
            }
            Actual = Actual.Siguiente;

        }
        while (Actual != Primero);

        return Veces;
    }

    public void MostrarPrestamosAlumno(int Matricula) {
        NodoPrestamos Actual;
        Actual = Primero;

        do {
            if (Actual.matricula == Matricula) {
                System.out.println("ID Prestamo: " + Actual.idPrestamo + " Matricula: " + Actual.matricula + " ISSN: " + Actual.issn + " Fecha de prestamo: " + Actual.dia + " - " + Actual.Mes + " - " + Actual.anio + " Fecha de entrega: " + Actual.dia2 + " - " + Actual.Mes2 + " - " + Actual.anio2);
            }
            Actual = Actual.Siguiente;
        }
        while (Actual != Primero);

    }

    public int BuscarPrestamo(int idPrestamo) {
        NodoPrestamos Actual;
        Actual = Primero;
        int Veces = 0;
        do {
            if (Actual.idPrestamo == idPrestamo) {
                Veces = Veces + 1;
            }
            Actual = Actual.Siguiente;

        }
        while (Actual != Primero);

        return Veces;
    }

    public void ModificarAlumno(int Dia, String Mes, int anio, String issn, int Matricula, int Dia2, String Mes2, int anio2, int idPrestamo) {
        NodoPrestamos Actual;
        Actual = Primero;
        do {
            if (Actual.idPrestamo == idPrestamo) {
                Actual.dia = Dia;
                Actual.Mes = Mes;
                Actual.anio = anio;
                Actual.issn = issn;

                Actual.matricula = Matricula;
                Actual.dia2 = Dia2;
                Actual.Mes2 = Mes2;
                Actual.anio2 = anio2;
            }
            Actual = Actual.Siguiente;
        }
        while (Actual != Primero);

    }

    public void MostrarDatosPrestamo(int idPrestamo) {
        NodoPrestamos Actual;
        Actual = Primero;
        do {
            if (Actual.idPrestamo == idPrestamo) {
                System.out.println("ID Prestamo: " + Actual.idPrestamo + " Matricula: " + Actual.matricula + " ISSN: " + Actual.issn + " Fecha de prestamo: " + Actual.dia + " - " + Actual.Mes + " - " + Actual.anio + " Fecha de entrega: " + Actual.dia2 + " - " + Actual.Mes2 + " - " + Actual.anio2);
                return;
            }
            Actual = Actual.Siguiente;
        }
        while (Actual != Primero);
    }
    public void EliminarPrestamo(int idPrestamo) {
        NodoPrestamos Actual, Anterior;
        Actual = Primero;
        Anterior = Ultimo;

        do {
            if (Actual.idPrestamo == idPrestamo) {
                if (Actual == Primero) {
                    Primero = Primero.Siguiente;
                    Ultimo.Siguiente = Primero;
                    Primero.Anterior = Ultimo;
                } else if (Actual == Ultimo) {
                    Ultimo = Anterior;
                    Primero.Anterior = Ultimo;
                    Ultimo.Siguiente = Primero;
                } else {
                    Anterior.Siguiente = Actual.Siguiente;
                    Actual.Siguiente.Anterior = Anterior;
                }

            }
            Anterior = Actual;
            Actual = Actual.Siguiente;
        }
        while (Actual != Primero);
    }

    public void ReporteAnual(int anio) {
        NodoPrestamos Actual;
        Actual = Primero;
        int E = 0, F = 0, M = 0, A = 0, Ma = 0, J = 0, Ju = 0, Ag = 0, S = 0, O = 0, N = 0, D = 0, aux = 0, PT = 0;

        do {
            if (anio == Actual.anio && Actual.Mes.equals("Enero")) {
                E = E + 1;
            }
            if (anio == Actual.anio && Actual.Mes.equals("Febrero")) {
                F = F + 1;
            }
            if (anio == Actual.anio && Actual.Mes.equals("Marzo")) {
                M = M + 1;
            }
            if (anio == Actual.anio && Actual.Mes.equals("Abril")) {
                A = A + 1;
            }
            if (anio == Actual.anio && Actual.Mes.equals("Mayo")) {
                Ma = Ma + 1;
            }
            if (anio == Actual.anio && Actual.Mes.equals("Junio")) {
                J = J + 1;
            }
            if (anio == Actual.anio && Actual.Mes.equals("Julio")) {
                Ju = Ju + 1;
            }
            if (anio == Actual.anio && Actual.Mes.equals("Agosto")) {
                Ag = Ag + 1;
            }
            if (anio == Actual.anio && Actual.Mes.equals("Septiembre")) {
                S = S + 1;
            }
            if (anio == Actual.anio && Actual.Mes.equals("Octubre")) {
                O = O + 1;
            }
            if (anio == Actual.anio && Actual.Mes.equals("Noviembre")) {
                N = N + 1;
            }
            if (anio == Actual.anio && Actual.Mes.equals("Diciembre")) {
                D = D + 1;
            }
            Actual = Actual.Siguiente;
        } while (Actual != Primero);

        PT = E + F + M + A + Ma + J + Ju + Ag + S + O + N + D;
        System.out.println("Reporte anual del año " + anio);
        System.out.println("");
        System.out.print("Enero | ");
        aux = E;
        while (E > 0) {

            System.out.print("=");
            E = E - 1;
        }
        System.out.print(" " + aux);
        System.out.println("");

        System.out.print("Febrero | ");
        aux = F;
        while (F > 0) {

            System.out.print("=");
            F = F - 1;
        }
        System.out.print(" " + aux);
        System.out.println("");

        System.out.print("Marzo | ");
        aux = M;
        while (M > 0) {

            System.out.print("=");
            M = M - 1;
        }
        System.out.print(" " + aux);
        System.out.println("");

        System.out.print("Abril | ");
        aux = A;
        while (A > 0) {

            System.out.print("=");
            A = A - 1;
        }
        System.out.print(" " + aux);
        System.out.println("");

        System.out.print("Mayo | ");
        aux = Ma;
        while (Ma > 0) {

            System.out.print("=");
            Ma = Ma - 1;
        }
        System.out.print(" " + aux);
        System.out.println("");

        System.out.print("Junio | ");
        aux = J;
        while (J > 0) {

            System.out.print("=");
            J = J - 1;
        }
        System.out.print(" " + aux);
        System.out.println("");

        System.out.print("Julio | ");
        aux = Ju;
        while (Ju > 0) {

            System.out.print("=");
            Ju = Ju - 1;
        }
        System.out.print(" " + aux);
        System.out.println("");

        System.out.print("Agosto | ");
        aux = Ag;
        while (Ag > 0) {

            System.out.print("=");
            Ag = Ag - 1;
        }
        System.out.print(" " + aux);
        System.out.println("");

        System.out.print("Septiembre | ");
        aux = S;
        while (S > 0) {

            System.out.print("=");
            S = S - 1;
        }
        System.out.print(" " + aux);
        System.out.println("");

        System.out.print("Octubre | ");
        aux = O;
        while (O > 0) {
            System.out.print("=");
            O = O - 1;
        }
        System.out.print(" " + aux);
        System.out.println("");

        System.out.print("Noviembre | ");
        aux = N;
        while (N > 0) {

            System.out.print("=");
            N = N - 1;
        }
        System.out.print(" " + aux);
        System.out.println("");


        System.out.print("Diciembre | ");
        aux = D;
        while (D > 0) {
            System.out.print("=");
            D = D - 1;
        }
        System.out.print(" " + aux);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Prestamos totales: " + PT);




    }

}