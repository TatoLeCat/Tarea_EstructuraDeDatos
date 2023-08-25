package stack;

import java.util.ArrayList;

public class StackArray<T> implements Stack<T> {
    private ArrayList<T> datos;

    @Override
    public void clear() {
        datos.clear();
    }

    @Override
    public boolean push(T it) {
        return datos.add(it);
    }

    @Override
    public T pop() {
        return datos.remove(datos.size() - 1);
    }

    @Override
    public T topValue() {
        return datos.get(datos.size() - 1);
    }

    @Override
    public int length() {
        return datos.size();
    }

    @Override
    public boolean isEmpty() {
        return datos.isEmpty();
    }
}
