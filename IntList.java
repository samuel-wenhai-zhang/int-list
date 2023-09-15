import java.util.Arrays;

/**
 * An implementation of the List ADT using
 * an integer array.
 * 
 * @author Samuel Zhang
 */


public class IntList {

    private int[] data;  
    private int size;

    /**
     * Constructs an empty IntList with an initial capacity of ten
     */
    public IntList() {
        data = new int[10];
        size = 0;
    }

    /**
     * Constructs an empty IntList with the specified initial capacity
     * @param initialCapacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity is negative
     */
    public IntList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        else {
            data = new int[initialCapacity];
            size = 0;
        }
    }

    
    /** 
     * Appends the specified integer to the end of this list 
     * @param n integer to be appended to this list
     * @return boolean true
     */
    public boolean add(int n) {
        add(size, n);
        return true;
    }

    
    /**
     * Inserts the specified integer at the specified position in this list
     * @param index index at which the specified integer is to be inserted
     * @param n integer to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add(int index, int n) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index);
        }
        
        if (size == data.length) {
            data = Arrays.copyOf(data, size * 2);
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = n;
        size++;
    }

    /**
     * Removes all of the elements from this list
     */
    public void clear() { 
        size = 0;
    }

    
    /** 
     * Returns true if this list contains the specified integer.
     * @param n integer whose presence in this list is to be tested
     * @return true if this list contains the specified integer
     */
    public boolean contains(int n) {
        for (int i = 0; i < size; i++) {
            if (data[i] == n) {
                return true;
            }
        }
        return false;
    }

    
    /** 
     * Returns the integer at the specified position in this list.
     * @param index index of the integer to return
     * @return the integer at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        return data[index];
    }

    
    /** 
     * Returns the index of the first occurrence of the specified integer in this list, or -1 if this list does not contain the integer. 
     * @param n integer to search for
     * @return int the index of the first occurrence of the specified integer in this list, or -1 if this list does not contain the integer
     */
    public int indexOf(int n) {
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified integer in this list, or -1 if this list does not contain the integer. 
     * @param n the integer to search for
     * @return the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    public int lastIndexOf(int n) {
        return -1;
    }
    
    /** 
     * Returns true if this list contains no elements
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        return false;
    }

    /** 
     * Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices). Returns the element that was removed from the list.
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException - if the index is out of range
     */
    public int remove(int index) {
        return -1;
    }

    /** 
     * Replaces the integer at the specified position in this list with the specified integer
     * @param index index of the element to replace
     * @param n integer to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundException if the index is out of range
     */
    public int set(int index, int n) {
        return -1;
    }

    /**
     * Compares the specified IntList for equality.  Returns true if and only if both lists have the same size and all corresponding pairs of integers in the tow lists are equal.
     * @param o the other IntList to be compared for equality
     * @return true if the specified IntList is equal to this IntList
     */
    public boolean equals(IntList o) {
        return false;
    }
    
    /** 
     * Returns the number of elements in this list. If this list contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     * @return the number of elements in this list
     */
    public int size() {
        return -1;
    }

    /**
     * Returns an array containing all of the integers in this list in proper sequence.
     * @return an array containing the integers of this list
     */
    public int[] toArray() {
        return null;
    }
    
    /**
     * Returns a string representation of this IntList. The string representation consists of a list of the integers in the order they are indexed, enclosed in square brackets ("[]")
     * @return a String representation of this IntList.
     */
    public String toString() {
        return "";
    }


}