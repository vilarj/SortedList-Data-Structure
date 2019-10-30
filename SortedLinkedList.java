
import java.util.LinkedList;

public abstract class SortedLinkedList <T extends Comparable <? super T>> implements SortedListInterface <T>{
	private LinkedList <T> list;

	public SortedLinkedList() {
		list = new LinkedList<>();
	}

	public T remove (int givenPosition) {
		return list.remove (givenPosition);
	}

	public void clear() {
		list.clear();
	}

	@SuppressWarnings("unchecked")
	public T getEntry(int givenPosition) {
		return ((SortedListInterface<T>) list).getEntry(givenPosition);
	}

	public Object[] toArray() {
		return list.toArray();
	}

	public boolean contains(T anEntry) {
		return list.contains(anEntry);
	}
	
	@SuppressWarnings("unchecked")
	public int getLength() {
		return ((SortedListInterface<T>) list).getLength();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void addEntry(T newEntry) {
		int position = getPosition (newEntry);
		if (position < 0)
			position = -position -1;
		list.add(position, newEntry);
	}

	public boolean remove(T givenEntry) {
		boolean result = false;
		int position = getPosition(givenEntry);

		if (position > 0){
			list.remove(position);
			result = true;
		} 
		return result;
	}
	
	private int getPosition(T givenEntry) {
		int position = 0;
		int length = getLength();
		
		while ( (position < length) && (givenEntry.compareTo(getEntry(position)) > 0) ){
			position++;
		} 

		if ( (position >= length) || (givenEntry.compareTo(getEntry(position)) != 0) ){
			position = -position; // anEntry is not in list
		} 
		return position;
	} 
}
