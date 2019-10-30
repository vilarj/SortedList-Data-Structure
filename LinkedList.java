
public class LinkedList<T> {
	private Node firstNode;
	private int numberOfEntries;

	public LinkedList() {
		firstNode = null;
		numberOfEntries = 0;
	}

	public void add (T newEntry){
		Node toInsert = new Node(newEntry, null);
		Node curNode, nextNode;
		numberOfEntries ++;

		if (firstNode == null) {
			firstNode = toInsert;
			return;
		}
		curNode = firstNode;
		
		for (nextNode = curNode.getNext(); nextNode != null; ) {
			curNode = nextNode;
			nextNode = curNode.getNext();
		}
		curNode.setNext (toInsert);  
	}

	public void add(int newPosition, T newEntry) {
		if(newPosition < 0 || newPosition > getLength()) {
			throw new IndexOutOfBoundsException();
		}
		
		Node insert = new Node (newEntry, null);
		numberOfEntries++;

		if(newPosition == 0) {
			insert.setNext(firstNode);
			firstNode = insert;
		}

		int pos = 1; 
		Node before = firstNode;
		
		for (Node after = firstNode.getNext(); after != null; ) {
			if (pos == newPosition) { 
				before.setNext (insert);
				insert.setNext (after);
				return;
			}
			before = after;
			after = after.getNext();
			pos++;	
		}
		before.setNext (insert);
	}

	private int getLength() {
		return numberOfEntries;
	}

	public T remove (int givenPosition){
		if (isEmpty())
			throw new NullPointerException();
		if (givenPosition < 0 || givenPosition >= getLength())
			throw new IndexOutOfBoundsException();
		
		T dataItem = firstNode.getData();
		numberOfEntries --;        
		
		if (givenPosition == 0)
			firstNode = firstNode.getNext();
		else {
			int idx = 0;
			Node nextNode = firstNode;

			for (Node currNode = firstNode; nextNode != null; currNode = nextNode) {
				idx ++;
				nextNode = currNode.getNext();

				if (idx == givenPosition) {
					assert (nextNode != null);
					dataItem = nextNode.getData();
					currNode.setNext(nextNode.getNext());
					break;
				} 
			}
		}
		return dataItem;
	}

	private boolean isEmpty() {
		return (firstNode == null);
	}

	public T getEntry (int givenPosition) {
		if (givenPosition < 0 || givenPosition >= getLength())
			throw new IndexOutOfBoundsException();
		int count = 0;
		
		for (Node curr = firstNode; curr != null; curr = curr.getNext()) {
			if (count == givenPosition)
				return curr.getData();
			count ++;
		}
		return null;
	}

	public Object[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		int index = 0;
		
		for (Node currNode = firstNode; currNode != null; currNode = currNode.getNext()) {
			result[index] = currNode.getData();
			index ++;
		}
		return result;
	}

	private class Node {
		private T data;
		private Node next;

		public Node(T data, Node next) {this.data = data;this.next = next;}
		public T getData() {return data;}
		public Node getNext() {return next;}
		public void setNext(Node next) {this.next = next;}
	}
}
