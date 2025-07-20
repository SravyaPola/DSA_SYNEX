package linkedlist;

public class AddPolynomials {

	static class Node {
		int coeff;
		int exp;
		Node next;

		Node() {

		}

		Node(int coeff, int exp) {
			this.coeff = coeff;
			this.exp = exp;
			this.next = null;
		}
	}

	private static Node add(Node poly1, Node poly2) {
		Node result = new Node();
		Node current = result;
		while (poly1 != null && poly2 != null) {
			if (poly1.exp == poly2.exp) {
				current.next = new Node(poly1.coeff + poly2.coeff, poly1.exp);
				poly1 = poly1.next;
				poly2 = poly2.next;
			} else if (poly1.exp > poly2.exp) {
				current.next = new Node(poly1.coeff, poly1.exp);
				poly1 = poly1.next;
			} else {
				current.next = new Node(poly2.coeff, poly2.exp);
				poly2 = poly2.next;
			}
			current = current.next;
		}
		Node rest = (poly1 != null ? poly1 : poly2);
		while (rest != null) {
			current.next = new Node(rest.coeff, rest.exp);
			rest = rest.next;
			current = current.next;
		}
		return result.next;
	}

	public static void main(String[] args) {

		// Polynomial -1 : 4x^5 + 5x^4 + 2x^3 + 3x^2 + 7x
		Node poly1 = new Node(4, 5);
		poly1.next = new Node(5, 4);
		poly1.next.next = new Node(2, 3);
		poly1.next.next.next = new Node(3, 2);
		poly1.next.next.next.next = new Node(7, 1);

		// Polynomial -2 : 9x^6 + 6x^4 + 3x^2
		Node poly2 = new Node(9, 6);
		poly2.next = new Node(6, 4);
		poly2.next.next = new Node(3, 2);

		System.out.print("Poly1: ");
		printPoly(poly1);
		System.out.print("Poly2: ");
		printPoly(poly2);

		Node sum = add(poly1, poly2);
		System.out.print("Sum: ");
		printPoly(sum);

	}

	public static void printPoly(Node poly) {
		while (poly != null) {
			System.out.print(poly.coeff + "x^" + poly.exp);
			if (poly.next != null)
				System.out.print(" + ");
			poly = poly.next;
		}
		System.out.println();
	}

}
