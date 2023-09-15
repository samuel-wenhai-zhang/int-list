[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=11891443)
# IntList Documentation

## `public class IntList`

An implementation of the List ADT using an integer array.

 * **Author:** Your Name

## `public IntList()`

Constructs an empty IntList with an initial capacity of ten

## `public IntList(int initialCapacity)`

Constructs an empty IntList with the specified initial capacity

 * **Parameters:** `initialCapacity` — the initial capacity of the list
 * **Exceptions:** `IllegalArgumentException` — if the specified initial capacity is negative

## `public boolean add(int n)`

Appends the specified integer to the end of this list

 * **Parameters:** `n` — integer to be appended to this list
 * **Returns:** boolean true

## `public void add(int index, int n)`

Inserts the specified integer at the specified position in this list

 * **Parameters:**
   * `index` — index at which the specified integer is to be inserted
   * `n` — integer to be inserted
 * **Exceptions:** `IndexOutOfBoundsException` — if the index is out of range

## `public void clear()`

Removes all of the elements from this list

## `public boolean contains(int n)`

Returns true if this list contains the specified integer.

 * **Parameters:** `n` — integer whose presence in this list is to be tested
 * **Returns:** true if this list contains the specified integer

## `public int get(int index)`

Returns the integer at the specified position in this list.

 * **Parameters:** `index` — index of the integer to return
 * **Returns:** the integer at the specified position in this list
 * **Exceptions:** `IndexOutOfBoundsException` — if the index is out of range

## `public int indexOf(int n)`

Returns the index of the first occurrence of the specified integer in this list, or -1 if this list does not contain the integer.

 * **Parameters:** `n` — integer to search for
 * **Returns:** int the index of the first occurrence of the specified integer in this list, or -1 if this list does not contain the integer

## `public int lastIndexOf(int n)`

Returns the index of the last occurrence of the specified integer in this list, or -1 if this list does not contain the integer.

 * **Parameters:** `n` — the integer to search for
 * **Returns:** the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element

## `public boolean isEmpty()`

Returns true if this list contains no elements

 * **Returns:** true if this list contains no elements

## `public int remove(int index)`

Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices). Returns the element that was removed from the list.

 * **Parameters:** `index` — the index of the element to be removed
 * **Returns:** the element previously at the specified position
 * **Exceptions:** `IndexOutOfBoundsException` — - if the index is out of range

## `public int set(int index, int n)`

Replaces the integer at the specified position in this list with the specified integer

 * **Parameters:**
   * `index` — index of the element to replace
   * `n` — integer to be stored at the specified position
 * **Returns:** the element previously at the specified position
 * **Exceptions:** `IndexOutOfBoundException` — if the index is out of range

## `public boolean equals(IntList o)`

Compares the specified IntList for equality. Returns true if and only if both lists have the same size and all corresponding pairs of integers in the tow lists are equal.

 * **Parameters:** `o` — the other IntList to be compared for equality
 * **Returns:** true if the specified IntList is equal to this IntList

## `public int size()`

Returns the number of elements in this list. If this list contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.

 * **Returns:** the number of elements in this list

## `public int[] toArray()`

Returns an array containing all of the integers in this list in proper sequence.

 * **Returns:** an array containing the integers of this list

## `public String toString()`

Returns a string representation of this IntList. The string representation consists of a list of the integers in the order they are indexed, enclosed in square brackets ("[]")

 * **Returns:** a String representation of this IntList.
