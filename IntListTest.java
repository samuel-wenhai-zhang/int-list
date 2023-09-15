import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntListTest {
    @Test
    @DisplayName("Check constructor sets size to 0")
    void testConstructor() {
        IntList list = new IntList();
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Check add(int n)")
    void testAdd() {
        IntList list = new IntList();
        for(int i = 0; i < 50; i++) {
            list.add(i);
        }
        assertEquals(50, list.size());
        int[] EXPECTED = new int[50];
        for(int i = 0; i < 50; i++) {
            EXPECTED[i] = i;
        }
        int[] ACTUAL = list.toArray();
        assertArrayEquals(EXPECTED, ACTUAL);
    }

    @Test
    @DisplayName("Check add(int index, int n)")
    void testAdd2() {
        IntList list = new IntList();
        list.add(0);
        list.add(0, 10);
        list.add(0, 15);
        list.add(1, 20);
        list.add(2, 30);

        assertEquals(5, list.size());
        int[] EXPECTED = {15, 20, 30, 10, 0};
        int[] ACTUAL = list.toArray();
        assertArrayEquals(EXPECTED, ACTUAL);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(21, 10);
        });

         assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(-1, 10);
        });
    }

    @Test
    void testClear() {
        IntList list = new IntList();
        for(int i = 0; i < 50; i++) {
            list.add(i);
        }
        list.clear();
        assertEquals(0, list.size());

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(0);
        });

        assertEquals("[]", list.toString());

    }

    @Test
    void testContains() {
        IntList list = new IntList();
        for(int i = 0; i < 50; i++) {
            list.add(i);
        }
        assertEquals(true, list.contains(5));
        assertEquals(false, list.contains(-1));
        assertEquals(true, list.contains(49));
        assertEquals(false, list.contains(100));
    }

    @Test
    void testEquals() {
        IntList list1 = new IntList();
        for(int i = 0; i < 50; i++) {
            list1.add(i);
        }

        IntList list2 = new IntList();
        for(int i = 0; i < 55; i++) {
            list2.add(i);
        }
        for(int i = 54; i >= 50; i--) {
            list2.remove(i);
        }
        assertEquals(true, list1.equals(list2));
        
        IntList list3 = new IntList();
        for(int i = 0; i < 49; i++) {
            list3.add(i);
        }

        assertEquals(false, list1.equals(list3));

        IntList list4 = new IntList();
        for(int i = 0; i < 50; i++) {
            list4.add(i*2);
        }
        assertEquals(false, list1.equals(list4));

        
    }

    @Test
    void testGet() {
        IntList list = new IntList();
        for(int i = 0; i < 50; i++) {
            list.add(i);
        }
        assertEquals(0, list.get(0));
        assertEquals(49, list.get(49));
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-1);
        });

    }

    @Test
    void testIndexOf() {
        IntList list = new IntList();
        for(int i = 0; i < 50; i++) {
            list.add(i);
        }
        for(int i = 0; i < 50; i++) {
            list.add(i);
        }
        assertEquals(0, list.indexOf(0));
        assertEquals(49, list.indexOf(49));
        assertEquals(-1, list.indexOf(100));
    }

    @Test
    void testIsEmpty() {
        IntList list = new IntList();
        assertEquals(true, list.isEmpty());

        list.add(10);
        assertEquals(false, list.isEmpty());
    }

    @Test
    void testLastIndexOf() {
        IntList list = new IntList();
        for(int i = 0; i < 50; i++) {
            list.add(i);
        }
        for(int i = 0; i < 50; i++) {
            list.add(i);
        }
        assertEquals(50, list.lastIndexOf(0));
        assertEquals(99, list.lastIndexOf(49));
        assertEquals(-1, list.lastIndexOf(100));     
    }

    @Test
    void testRemove() {
        IntList list = new IntList();
        for(int i = 0; i < 50; i++) {
            list.add(i);
        }
        
        assertEquals(0, list.remove(0));
        assertEquals(49, list.size());
        assertEquals(1, list.remove(0));
        assertEquals(48, list.size());
        assertEquals(49, list.remove(47));
        assertEquals(47, list.size());

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(49);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(-1);
        });


    }

    @Test
    void testSet() {
        IntList list = new IntList();
        for(int i = 0; i < 50; i++) {
            list.add(i);
        }
        list.set(0, 10);
        assertEquals(10, list.get(0));

        list.set(25, 100);
        assertEquals(100, list.get(25));

        assertEquals(50, list.size());
    }

    @Test
    void testSize() {
        IntList list = new IntList();
        assertEquals(0, list.size());
        for(int i = 0; i < 50; i++) {
            assertEquals(i, list.size());
            list.add(i);
        }
        assertEquals(50, list.size());
    }

    @Test
    void testToString() {
        IntList list = new IntList();
        assertEquals("[]", list.toString());

        list.add(1);
        list.add(5);
        assertEquals("[1, 5]", list.toString());

        list.add(-10);
        assertEquals("[1, 5, -10]", list.toString());
    }

    @Test
    void testToArray() {
        IntList list = new IntList();
        for(int i = 0; i < 5; i++) {
            list.add(i);
        }
        int[] returned = list.toArray();
        returned[0] = 15;

        assertEquals(0, list.get(0));
        
        assertEquals(5, returned.length);


    }
}
