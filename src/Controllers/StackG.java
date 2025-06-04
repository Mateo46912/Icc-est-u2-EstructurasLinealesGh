package Controllers;

import java.util.EmptyStackException;
import Models.NodeGeneric;

public class StackG <T>{
    
    private NodeGeneric<T> top;
    private int size;

    public StackG() {
        this.top = null;
        this.size = 0;
    }

    public void push(T value) {
        NodeGeneric <T> newNodo = new NodeGeneric <T>(value);
        newNodo.setNext(top);
        top = newNodo;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = top.getValue();
        top = top.getNext();
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = top.getValue();
        return value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printStack() {
        NodeGeneric <T> aux = top;
        while (aux != null) {
            System.out.print(aux.getValue() + "|");
            aux = aux.getNext();
        }
        System.out.println();
    }

    public int size (){
        return size;
    }
    
    
    
}
