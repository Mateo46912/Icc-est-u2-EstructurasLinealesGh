package Controllers;

import java.util.EmptyStackException;

import Models.NodeGeneric;

public class QueueG<T> {

    private NodeGeneric<T> primero; // head - front
    private NodeGeneric<T> ultimo; // back - rear - tail
    private int size;

    public QueueG() {
        this.primero = null;
        this.ultimo = null;
        this.size = 0;
    }

    public void add(T value) {
        NodeGeneric<T> newNode = new NodeGeneric<T>(value);
        if (isEmpty()) {
            primero = newNode;
            ultimo = newNode;
        } else {
            ultimo.setNext(newNode);
            ultimo = newNode;
        }
        size++;
    }

    public T remove() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T aux = primero.getValue();
        primero = primero.getNext();
        size--;
        return aux;
    }

    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return primero.getValue();
    }

    public boolean isEmpty() {
        return primero == null;
    }

    public int size() {
        return size;
    }

    public void printCola() {
        NodeGeneric<T> aux = primero;
        while (aux != null) {
            System.out.print(aux.getValue() + "|");
            aux = aux.getNext();
        }
        System.out.println();
    }

    public T findByname(String clave) {
        NodeGeneric<T> aux = primero;
        while (aux != null) {
            if (aux.getValue().toString().equalsIgnoreCase(clave)) {
                return aux.getValue(); 
            }
            aux = aux.getNext(); 
        }
        return null; 
    }

}
