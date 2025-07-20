package hashing;

public class SimpleHashTable {
	private static class Node {
		int key;
		int value;
		Node next;

		Node(int key, int value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	private final int capacity;
	private final Node[] buckets;
	private int size = 0;

	public SimpleHashTable(int capacity) {
		this.capacity = capacity;
		buckets = new Node[capacity];
	}

	private int hash(int key) {
		int h = key % capacity;
		return h;
	}

	public void put(int key, int value) {
		int idx = hash(key);
		for (Node n = buckets[idx]; n != null; n = n.next) {
			if (n.key == key) {
				n.value = value;
				return;
			}
		}
		Node newNode = new Node(key, value, null);
		if (buckets[idx] == null) {
			buckets[idx] = newNode;
		} else {
			Node tail = buckets[idx];
			while (tail.next != null) {
				tail = tail.next;
			}
			tail.next = newNode;
		}
		size++;
	}

	public int get(int key) {
		int idx = hash(key);
		for (Node n = buckets[idx]; n != null; n = n.next) {
			if (n.key == key)
				return n.value;
		}
		return -1;
	}

	public boolean remove(int key) {
		int idx = hash(key);
		Node prev = null;
		for (Node n = buckets[idx]; n != null; prev = n, n = n.next) {
			if (n.key == key) {
				if (prev == null)
					buckets[idx] = n.next;
				else
					prev.next = n.next;
				size--;
				return true;
			}
		}
		return false;
	}

	public void printTable() {
		System.out.println("HashTable");
		for (int i = 0; i < capacity; i++) {
			System.out.print(i + ": ");
			Node n = buckets[i];
			if (n == null) {
				System.out.println("empty");
			} else {
				while (n != null) {
					System.out.print(n.key + "=" + n.value);
					if (n.next != null)
						System.out.print(" -> ");
					n = n.next;
				}
				System.out.println();
			}
		}
		System.out.println("Total " + size);
	}

	public static void main(String[] args) {
		SimpleHashTable ht = new SimpleHashTable(7);
		ht.put(22, 100);
		ht.put(31, 200);
		ht.put(67, 300);
		ht.put(36, 400);
		ht.put(29, 500);
		ht.put(60, 600);
		ht.printTable();
		System.out.println(ht.get(22));
		System.out.println(ht.remove(22));
		System.out.println(ht.remove(6));
		ht.printTable();
	}
}
