package ar.edu.unlu.poo.ListaEnlazadaSimple;

public class Nodo {

    private int elemento;

    private Nodo siguiente;

    public Nodo(int elemento){
        this.elemento = elemento;
    }


    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public int getElemento() {
        return elemento;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    public Nodo getSiguiente() {
        return siguiente;
    }

    public void eliminarSiguiente() {
        this.siguiente = null;
    }
}
