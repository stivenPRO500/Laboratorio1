import java.util.Scanner;

class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int d) {
        dato = d;
        siguiente = null;
    }
}

class ListaEnlazada {
    Nodo inicio;

    public ListaEnlazada() {
        inicio = null;
    }

    public void insertarInicio(int d) {
        Nodo nuevo = new Nodo(d);
        nuevo.siguiente = inicio;
        inicio = nuevo;
    }

    public void insertarFinal(int d) {
        Nodo nuevo = new Nodo(d);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo actual = inicio;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public void recorrer() {
        Nodo actual = inicio;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public boolean buscarElemento(int d) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.dato == d) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public boolean borrarElemento(int d) {
        if (inicio == null) {
            return false;
        }
        if (inicio.dato == d) {
            inicio = inicio.siguiente;
            return true;
        }
        Nodo anterior = inicio;
        Nodo actual = inicio.siguiente;
        while (actual != null && actual.dato != d) {
            anterior = actual;
            actual = actual.siguiente;
        }
        if (actual != null) {
            anterior.siguiente = actual.siguiente;
            return true;
        }
        return false;
    }
}

public class Main {

    static int seguir = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();
        int opcion = 0;

        while (seguir == 1){

            System.out.println("Lista enlazada");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Recorrer");
            System.out.println("4. Buscar elemento");
            System.out.println("5. Borrar un elemento");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un número para insertar al inicio: ");
                    int numInicio = sc.nextInt();
                    lista.insertarInicio(numInicio);
                    break;
                case 2:
                    System.out.print("Ingrese un número para insertar al final: ");
                    int numFinal = sc.nextInt();
                    lista.insertarFinal(numFinal);
                    break;
                case 3:
                    System.out.print("La lista es: ");
                    lista.recorrer();
                    break;
                case 4:
                    System.out.print("Ingrese un número a buscar: ");
                    int numBuscar = sc.nextInt();
                    boolean encontrado = lista.buscarElemento(numBuscar);
                    if (encontrado) {
                        System.out.println("El número " + numBuscar + " está en la lista.");
                    } else {
                        System.out.println("El número " + numBuscar + " no está en la lista");
                        break;
                    }

            }
        }

    }
}