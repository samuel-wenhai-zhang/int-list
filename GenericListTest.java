import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class GenericListTest {
    private static String[] words = {"test","a","this",null,"math","word",null, "free","hornet","run","actual","same",null};
    @Test
    @DisplayName("Check constructor sets size to 0")
    void testConstructor() {
        GenericList<String> list = new GenericList<String>();
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Check add(E e)")
    void testAdd() {
        GenericList<String> list = new GenericList<String>();
        for(int j = 0; j < 5; j++) {
            for(int i = 0; i < words.length; i++) {
                list.add(words[i]);
            }
        }
        assertEquals(65, list.size());        
    }

    @Test
    @DisplayName("Check add(int index, E e)")
    void testAdd2() {
        GenericList<String> list = new GenericList<String>();
        for(int i = 0; i < words.length; i++) {
                list.add(words[i]);
        }
        list.add(0, "first");
        list.add(5, "second");
        list.add(list.size(), "last");

        assertEquals(16, list.size());
        assertEquals("first", list.get(0));
        assertEquals("math", list.get(6));
        assertEquals("second", list.get(5));
        assertEquals(null, list.get(4));
        assertEquals("last", list.get(list.size()-1));

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(21, "test");
        });

         assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(-1, "error");
        });
    }

    @Test
    void testClear() {
        GenericList<String> list = new GenericList<String>();
        for(int i = 0; i < 50; i++) {
            list.add("a");
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
        GenericList<Integer> list = new GenericList<Integer>();
        for(int i = 0; i < 50; i++) {
            list.add(i);
        }
        assertEquals(true, list.contains(5));
        assertEquals(false, list.contains(-1));
        assertEquals(true, list.contains(49));
        assertEquals(false, list.contains(100));

        GenericList<String> list2 = new GenericList<String>();
        for(int i = 0; i < words.length; i++) {
                list2.add(words[i]);
        }
        assertEquals(true, list2.contains("hornet"));
        assertEquals(true, list2.contains(null));
        assertEquals(false,list2.contains("flour"));
        assertEquals(false,list2.contains("hornets"));

    }

    @Test
    void testEquals() {
        
        GenericList<String> list1 = new GenericList<String>();
        for(int i = 0; i < words.length; i++) {
                list1.add(words[i]);
        }

        GenericList<String> list2 = new GenericList<String>();
        for(int i = 0; i < words.length; i++) {
                list2.add(words[i]);
        }
        
        assertEquals(true, list1.equals(list2));
        
        GenericList<String> list3 = new GenericList<String>();
        for(int i = words.length-1; i >=0; i--) {
                list3.add(words[i]);
        }

        assertEquals(false, list1.equals(list3));
    }

    @Test
    void testGet() {
        GenericList<String> list = new GenericList<String>();
        for(int i = 0; i < words.length; i++) {
                list.add(words[i]);
        }
        assertEquals("test", list.get(0));
        assertEquals(null, list.get(12));
        assertEquals("hornet", list.get(8));
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(13);
        });

    }

    @Test
    void testIndexOf() {
        GenericList<String> list = new GenericList<String>();
        for(int i = 0; i < words.length; i++) {
                list.add(words[i]);
        }
       
        assertEquals(0, list.indexOf("test"));
        assertEquals(3, list.indexOf(null));
        assertEquals(11, list.indexOf("same"));
        assertEquals(-1, list.indexOf("flour"));
    }

    @Test
    void testIsEmpty() {
        GenericList<String> list = new GenericList<String>();
        assertEquals(true, list.isEmpty());

        list.add("word");
        assertEquals(false, list.isEmpty());
    }

    @Test
    void testLastIndexOf() {
        GenericList<String> list = new GenericList<String>();
        for(int i = 0; i < words.length; i++) {
                list.add(words[i]);
        }
        list.add("hornet");
        list.add(5, "test");
        
        assertEquals(13, list.lastIndexOf(null));
        assertEquals(14, list.lastIndexOf("hornet"));
        assertEquals(5, list.lastIndexOf("test"));
        assertEquals(-1, list.lastIndexOf("flour"));     
    }

    @Test
    void testRemove1() {
        GenericList<String> list = new GenericList<String>();
        for(int i = 0; i < words.length; i++) {
                list.add(words[i]);
        }
        
        assertEquals("test", list.remove(0));
        assertEquals(12, list.size());
        assertEquals("a", list.remove(0));
        assertEquals(11, list.size());
        assertEquals(null, list.remove(4));
        assertEquals(10, list.size());

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(10);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(-1);
        });


    }

    
    @Test
    void testRemove2() {
        GenericList<String> list = new GenericList<String>();
        for(int i = 0; i < words.length; i++) {
                list.add(words[i]);
        }
        
        assertEquals(true, list.remove("test"));
        assertEquals(12, list.size());
        assertEquals(true, list.remove("hornet"));
        assertEquals(11, list.size());
        assertEquals(true, list.remove(null));
        assertEquals(10, list.size());
        assertEquals(false, list.remove("flour"));
    }

    @Test
    void testSet() {
        GenericList<String> list = new GenericList<String>();
        for(int i = 0; i < words.length; i++) {
                list.add(words[i]);
        }
        list.set(0, "fun");
        assertEquals("fun", list.get(0));

        list.set(10, null);
        assertEquals(null, list.get(10));

        assertEquals(13, list.size());
    }

    @Test
    void testSize() {
        GenericList<String> list = new GenericList<String>();
        for(int i = 0; i < words.length; i++) {
                list.add(words[i]);
        }
        assertEquals(13, list.size());
    }

    @Test
    void testToString() {
        GenericList<String> list = new GenericList<String>();
        for(int i = 0; i < words.length; i++) {
                list.add(words[i]);
        }

        assertEquals("[test, a, this, null, math, word, null, free, hornet, run, actual, same, null]", list.toString());
    }

    @Test
    void testToArray() {
        GenericList<String> list = new GenericList<String>();
        for(int i = 0; i < words.length; i++) {
                list.add(words[i]);
        }
        Object[] returned = list.toArray();
        returned[0] = "shouldn't change";

        assertEquals("test", list.get(0));
        
        assertEquals(13, returned.length);


    }
}
