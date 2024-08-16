package ar.edu.unlu.poo.ListaEnlazadaSimple;

public class ListaEnlazadaSimple {
    private int longitud;
    private Nodo cabeza;
    public ListaEnlazadaSimple() {
        this.cabeza = null;
        this.longitud = 0;
    }

    public boolean isEmpty() {
        return this.cabeza == null;
    }
    //Agregar al final
    public void agregar(Nodo nuevo) {
        if(this.isEmpty()) {
            this.cabeza = nuevo;
        } else {
            Nodo recorrer = this.cabeza;
            while(recorrer.getSiguiente() != null) {
                recorrer = recorrer.getSiguiente();
            }
            recorrer.setSiguiente(nuevo);
        }
        this.longitud++;
    }
    //Insertar
    public void insertar(Nodo nuevo, int posicion) {

        if(posicion > longitud){
            System.out.println("La posición pedida excede la longitud de la Lista.");
            System.out.println("Si está intentando insertar al final de la lista, utilice el método 'agregar'");
        } else if(posicion == 1) {
            nuevo.setSiguiente(cabeza);
            this.cabeza = nuevo;
        } else {
            Nodo recorrer = this.cabeza;
            Nodo anterior = recorrer;
            for (int i = 1; i < posicion; i++) {
                anterior = recorrer;
                recorrer = recorrer.getSiguiente();
            }
            anterior.setSiguiente(nuevo);
            nuevo.setSiguiente(recorrer);
        }
    }

    //Eliminar por posición
    public void eliminarPos(int posicion) {
        Nodo recorrer = this.cabeza;
        Nodo anterior = this.cabeza;
        if(longitud > posicion) {
            for (int i = 1; i < posicion; i++) {
                anterior = recorrer;
                recorrer = recorrer.getSiguiente();
            }
            anterior = recorrer.getSiguiente();
            this.longitud--;
        } else if(longitud == posicion) {
            while(recorrer.getSiguiente() != null) {
                anterior = recorrer;
                recorrer = recorrer.getSiguiente();
            }
            anterior.eliminarSiguiente();
            this.longitud--;
        } else {
            System.out.println("La posicion es mayor a la longitud de la Lista.");
        }
    }
    //Eliminar por valor (todas las apariciones)
    public void eliminarValor(int valor) {
        if(cabeza.getElemento() == valor) {
            this.cabeza = cabeza.getSiguiente();
            this.longitud--;
        }
        Nodo recorrer = this.cabeza;
        Nodo anterior;
        while(recorrer.getSiguiente() != null) {
            anterior = recorrer;
            recorrer = recorrer.getSiguiente();
            if (recorrer.getElemento() == valor) {
                anterior.setSiguiente(recorrer.getSiguiente());
                this.longitud--;
            }
        }
    }
    //Eliminar primera iteración
    public void eliminarPrimeraIteracion(int valor) {
        boolean encontrado = false;
        if(cabeza.getElemento() == valor) {
            this.cabeza = cabeza.getSiguiente();
            this.longitud--;
        } else {
            Nodo recorrer = this.cabeza;
            Nodo anterior;
            while(recorrer.getSiguiente() != null && !encontrado) {
                anterior = recorrer;
                recorrer = recorrer.getSiguiente();
                if (recorrer.getElemento() == valor) {
                    anterior.setSiguiente(recorrer.getSiguiente());
                    this.longitud--;
                    encontrado = true;
                }
            }
        }
    }
    //Buscar por Posicion return valor
    public int buscarPorPosicion(int posicion) {
        Nodo recorrer = this.cabeza;
        int resultado = -1;
        if(posicion > longitud){
            System.out.println("La posicion ingresada excede a la longitud de la lista.");
        } else {
            for (int i = 1; i < posicion; i++) {
                recorrer = recorrer.getSiguiente();
            }
            resultado = recorrer.getElemento();
        }
        return resultado;
    }

    //Buscar por valor return posicion
    public int buscarPorValor(int valor) {
        Nodo recorrer = this.cabeza;
        int resultado = -1;
        int i=0;
        while(recorrer.getSiguiente() != null ){ //o mientras resultado == -1
            i++;
            if(recorrer.getElemento() == valor){
                resultado = i;
            }
            recorrer = recorrer.getSiguiente();
        }
        return resultado;
    }
    //La lista lee to-do
    public void leerTodo(){
        Nodo recorrer = this.cabeza;
        System.out.println("Los elementos de la lista son: ");
        for (int i = 1; i < longitud; i++) {
            System.out.printf("%d, ", recorrer.getElemento());
            recorrer = recorrer.getSiguiente();
        }
        System.out.printf("%d.", recorrer.getElemento());
    }

}
