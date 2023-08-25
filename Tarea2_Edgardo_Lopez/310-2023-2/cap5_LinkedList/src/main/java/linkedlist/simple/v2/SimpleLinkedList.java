/*

El asunto de esta version es utilizar curr como una referencia de tipo Nodo en
lugar de un entero que ubica las posiciones.

Objetivo: Cambiar en las funciones existentes este rol. También se removió la
función getNode para utilizar directamente curr.
 */

package linkedlist.simple.v2;

import linkedlist.List;
import java.util.NoSuchElementException;

public class SimpleLinkedList<T> implements List<T> {
    // Atributos de la lista enlazada;
    private Nodo<T> head;  // apunta el primer nodo
    private Nodo<T> tail;  // apunta al ultimo nodo
    private int size;  // cantidad de nodos

    private Nodo<T> curr;  // posición del nodo actual
    private Nodo<T> node;

    public SimpleLinkedList() {
        clear();
    }

    private boolean insertFirstNode(Nodo<T> n) {
        this.head = n;
        this.tail = n;
        this.curr = head;
        this.size++;
        return true;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
        curr = null;
    }

    @Override
    public boolean insert(T it) {

        var newNodo = new Nodo<>(it);

        // insertar primer nodo
        if (this.isEmpty()) {
            return this.insertFirstNode(newNodo);
        }

        // insertar al inicio
        else if (getNode() == head) {
            newNodo.siguiente = head;
            head = newNodo;
        }
        // insertar
        else {
            this.prev();
            var previo = getNode();
            newNodo.siguiente = previo.siguiente;
            previo.siguiente = newNodo;
            if(previo == tail){
                tail = newNodo;
            }

        }

        size++;
        return true;
    }

    @Override
    public boolean append(T it) {
        var newNode = new Nodo<>(it);

        if (this.isEmpty()) {
            return this.insertFirstNode(newNode);
        }

        tail.siguiente = newNode;
        tail = newNode;

        size++;
        return true;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        Nodo<T> oldCurr = getNode();  // guardar el valor del nodo a eliminar

        // remover el primer nodo
        if (oldCurr == head) {
            head = head.siguiente;
            curr = head;
        }
        else if (oldCurr == tail){
            prev();
            tail = getNode();
            tail.siguiente = null;
        }
        else {
            // situarse justo antes de curr
            prev();
            Nodo<T> prevNodo = getNode();
            prevNodo.siguiente = prevNodo.siguiente.siguiente;
        }
        size--;
        return oldCurr.getDato();
    }

    @Override
    public void moveToStart() {
        curr = head;
    }

    @Override
    public void moveToEnd() {
        curr = tail;
    }

    @Override
    public void prev() {
        if (curr == head) return;

       Nodo<T> Aux = head;

       while(Aux.siguiente != curr){
           Aux = Aux.siguiente;
       }
       curr = Aux;
    }

    @Override
    public void next() {
        if (curr == tail) return;

        curr = curr.siguiente;
    }

    @Override
    public int length() {
        return this.size;
    }

    @Override
    public int currPos() {
        Nodo<T> newNodo = head;
        int contador = 0;
        if(curr == head) return 0;
        else if(curr == tail) return size;
        else {
            while (newNodo != curr) {
                contador++;
                newNodo = newNodo.siguiente;
            }
            return contador;
        }
    }

    @Override
    public boolean moveToPos(int pos) {
        if (pos < 0 || pos >= size) {
            return false;
        }
        curr = head;
        for(int i = 0; i < pos; i++){
            curr = curr.siguiente;
        }

        return true;
    }

    @Override
    public boolean isAtEnd() {
        return curr == tail;
    }

    @Override
    public T getValue() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        Nodo<T> node = this.getNode();
        if (node == null) {
            throw new NullPointerException("El nodo no puede ser nulo");
        }

        return node.getDato();
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public Nodo<T> getNode() {
        return curr;
    }

    /*public void setNode(Nodo<T> node) {
        this.node = node;
    }*/


    public static class Nodo<T> {
        public T getDato() {
            return dato;
        }

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }

        @Override
        public String toString() {
            return dato.toString();
        }

        private final T dato;
        Nodo<T> siguiente;
    }
}