package linkedlist.doble;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList<Integer> lista;
    @BeforeEach
    void setUp() {
        lista = new LinkedList<>();
    }


    @Test
    void testListaVacia() {
        assertEquals(0, lista.length());
        assertThrowsExactly(NoSuchElementException.class,
                () -> {
                    lista.getValue();
                });
        assertThrowsExactly(NoSuchElementException.class,
                () -> {
                    lista.remove();
                });
    }

    @Test
    void testAppendVarios() {
        lista.append(10);
        lista.append(20);
        lista.append(30);

        assertEquals(3, lista.length());
        lista.moveToPos(0);
        assertEquals(10, lista.getValue());

        lista.moveToPos(1);
        assertEquals(20, lista.getValue());

        lista.moveToPos(2);
        assertEquals(30, lista.getValue());
    }

    @Test
    void testInsertRemoveVarios() {
        lista.append(10);  // < |10 >
        lista.moveToStart();
        lista.insert(20);  // < 20 |10 >
        lista.moveToEnd();
        lista.insert(30);  // < 20 10 |30>
        lista.prev();
        lista.insert(40);  // < 20 10 40 |30>


        assertEquals(4, lista.length());

        lista.moveToEnd();
        assertEquals(30, lista.getValue());

        lista.moveToStart();
        assertEquals(20, lista.getValue());

        lista.next();
        assertEquals(10, lista.getValue());

        lista.next();
        assertEquals(40, lista.getValue());

        lista.moveToStart();
        assertEquals(20, lista.remove());  // < |10, 40, 30 >
        assertEquals(3, lista.length());
        lista.moveToEnd();
        assertEquals(30, lista.remove());  // < |10, 40 >
        assertEquals(2, lista.length());
        assertEquals(10, lista.remove());  // <|40 >
        assertEquals(1, lista.length());
        assertEquals(40, lista.remove());  // < >
        assertEquals(0, lista.length());

    }



}