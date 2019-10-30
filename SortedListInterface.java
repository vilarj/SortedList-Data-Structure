
public interface SortedListInterface<T extends Comparable <? super T>> {
	// Adds an entry at the end
	public void addEntry(T anEntry);
	// Removes an entry at the given position
	public T remove(int givenPosition);
	// Removes a specified entry if it is in the list
	public boolean removeEntry(T givenEntry);
	// Removes all entries
	public void clear();
	// Retrieves the entry at a given position
	public T getEntry(int givenPosition);
	// Retrieves all entries in their current order
	public Object[] toArray();
	// Sees whether a list contains the given entry
	public boolean contains(T anEntry);
	// Gets the number of entries in the list
	public int getLength();
	// Sees whether the list is empty
	public boolean isEmpty();
}
