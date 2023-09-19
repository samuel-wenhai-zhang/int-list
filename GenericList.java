import java.util.Arrays;

/**
 * An implementation of the List ADT using
 * an element array.
 *
 * @author Samuel Zhang
 */


public class GenericList<E> {

    private E[] data;
    private int size;

    /**
     * Constructs an empty GenericList with an initial capacity of ten
     */
    public GenericList() {
        data = (E[]) new Object[10];
        size = 0;
    }

    /**
     * Constructs an empty GenericList with the specified initial capacity
     * @param initialCapacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity is negative
     */
    public GenericList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        else {
            data = (E[]) new Object[initialCapacity];
            size = 0;
        }
    }


    /**
     * Appends the specified element to the end of this list
     * @param e element to be appended to this list
     * @return boolean true
     */
    public boolean add(E e) {
        add(size, e);
        return true;
    }


    /**
     * Inserts the specified element at the specified position in this list
     * @param index index at which the specified element is to be inserted
     * @param e element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index);
        }

        if (size == data.length) {
            data = Arrays.copyOf(data, size * 2);
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = e;
        if (size != Integer.MAX_VALUE) {
            size++;
        }
    }

    /**
     * Removes all of the elements from this list
     */
    public void clear() {
        size = 0;
    }


    /**
     * Returns true if this list contains the specified element.
     * @param e element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    public boolean contains(E e) {
        return indexOf(e) != -1;
    }


    /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        return data[index];
    }


    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
     * @param e element to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (e == null) {
                if (data[i] == null) {
                    return i;
                }
            }
            else if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
     * @param e element to search for
     * @return the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    public int lastIndexOf(E e) {
        for (int i = size - 1; i >= 0; i--) {
            if (e == null) {
                if (data[i] == null) {
                    return i;
                }
            }
            else if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns true if this list contains no elements
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices). Returns the element that was removed from the list.
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException - if the index is out of range
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        E element = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return element;
    }

    /**
     * Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices). Returns the element that was removed from the list.
     * @param e element to be removed from this list, if present
     * @return true if this list contained the specified element
     * @throws IndexOutOfBoundsException - if the index is out of range
     */
    public boolean remove(E e) {
        int index = indexOf(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Replaces the element at the specified position in this list with the specified element
     * @param index index of the element to replace
     * @param e element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundException if the index is out of range
     */
    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        E element = data[index];
        data[index] = e;
        return element;
    }

    /**
     * Compares the specified GenericList for equality.  Returns true if and only if both lists have the same size and all corresponding pairs of elements in the two lists are equal.
     * @param o the other GenericList to be compared for equality
     * @return true if the specified GenericList is equal to this GenericList
     */
    public boolean equals(GenericList<E> o) {
        if (size != o.size) {
            return false;
        }
        else {
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    if (o.data[i] != null) {
                        return false;
                    }
                }
                else if (!data[i].equals(o.data[i])) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Returns the number of elements in this list. If this list contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence.
     * @return an array containing the elements of this list
     */
    public E[] toArray() {
        return Arrays.copyOf(data, size);
    }

    /**
     * Returns a string representation of this GenericList. The string representation consists of a list of the elements in the order they are indexed, enclosed in square brackets ("[]")
     * @return a String representation of this GenericList.
     */
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += data[i];
            if (i != size - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
}