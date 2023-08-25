/*
En este caso se usa un Nodo con doble enlace: uno que apunta al siguiente y
otro al anterior.

Reutilizar los métodos existentes pensando en mantener en las operaciones de
inserción y remoción ambos enlaces.
 */
package linkedlist.doble;

import linkedlist.List;

import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
    // Atributos de la lista enlazada;
    private Nodo<T> head;  // apunta el primer nodo
    private Nodo<T> tail;  // apunta al ultimo nodo
    private int size;  // cantidad de nodos

    private Nodo<T> curr;  // posicion del nodo actual

    public LinkedList() {
        clear();
    }

    private boolean insertFirstNode(Nodo<T> n) {
        this.head = n;
        this.tail = n;
        this.size++;
        this.curr = head;
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
        if (getNode() == head) {
            head.previo = head;
            head = newNodo;
        }
        // insertar nodos al final
        else if(getNode() == tail) {
            tail.siguiente = newNodo;
            tail = newNodo;
        }
        //insertar detras del curr
        else {

            newNodo = curr.previo;
            curr.previo.previo = newNodo;
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

        tail.siguiente = newNode.previo;
        tail = newNode;

        size++;
        return true;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (this.isEmpty())
            throw new NoSuchElementException();

        Nodo<T> removeNode = getNode();  // guardar el valor del nodo a eliminar

        // remover el primer nodo
        if (removeNode == head) {
            head = head.siguiente;
            head.previo = null;
        }
        // remover el ultimo nodo
        else if (removeNode == tail) {
            tail = tail.previo;
            tail.siguiente = null;
        }
        else {
            curr.previo = curr.siguiente;
            curr = curr.siguiente;

        }
        size--;
        return removeNode.getDato();
    }

    @Override
    public void moveToStart() {curr = head;}

    @Override
    public void moveToEnd() {curr = tail;}

    @Override
    public void prev() {
        if (curr == head) return;

        curr = curr.previo;
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
        int poss = 0;
        Nodo<T> auxiliar = head;
        if(curr == tail)return size;

        else if(curr == head)return 0;

        else{

            while(auxiliar != curr ) {
                poss++;
                auxiliar = auxiliar.siguiente;
            }
            poss++;
            return poss;
        }
    }

    @Override
    public boolean moveToPos(int pos) {
        if (pos < 0 || pos >= size) {
            return false;
        }

        int currPos = currPos();
        if (currPos < pos) {
            while (currPos < pos) {
                curr = curr.siguiente;
                currPos++;
            }
        }
        else {
            while (currPos > pos) {
                curr = curr.previo;
                currPos--;
            }
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

        return this.getNode().getDato();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Nodo<T> getNode() {
        if (this.isEmpty()) return  null;
        Nodo<T> aux;

        for (aux = head; aux != null; aux = aux.siguiente) {
            if (aux == curr) break;
        }
        return curr;
    }
    public static class Nodo<T> {
        public T getDato() {
            return dato;
        }

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
            this.previo = null;
        }

        @Override
        public String toString() {
            return dato.toString();
        }

        private final T dato;
        Nodo<T> siguiente;  // enlace al siguiente nodo
        Nodo<T> previo;  // enlace al nodo previo
    }
}
