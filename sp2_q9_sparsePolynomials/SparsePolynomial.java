package cs6301.g12.Implementation_of_Advanced_Data_Structures_and_Algorithms.sp2_q9_sparsePolynomials;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class SparsePolynomial {
	
	public static <T> T next(Iterator<T> itr) {

		return itr.hasNext() ? itr.next() : null;
	}

	public static LinkedList<Node> generatePolynomial(Scanner in) {
		System.out.println("Enter the number of terms in the polynomial");
		int m = in.nextInt();
		System.out.println("Enter coeff first, followed by power");
		LinkedList<Node> poly = new LinkedList<Node>();
		for (int i = 0; i < m; i++) {
			Node n = new Node(in.nextInt(), in.nextInt());
			poly.add(n);
		}
		return poly;
	}

	public static LinkedList<Node> add(LinkedList<Node> firstPoly, LinkedList<Node> secPoly) {
		LinkedList<Node> resultPoly = new LinkedList<Node>();
		Iterator<Node> firstPolyIterator = firstPoly.iterator();
		Iterator<Node> secPolyIterator = secPoly.iterator();
		Node firstPolyNode = next(firstPolyIterator);
		Node secPolyNode = next(secPolyIterator);
		while (firstPolyNode != null && secPolyNode != null) {
			if (firstPolyNode.getExponent() > secPolyNode.getExponent()) {
				resultPoly.add(secPolyNode);
				secPolyNode = next(secPolyIterator);
			} else if (firstPolyNode.getExponent() < secPolyNode.getExponent()) {
				resultPoly.add(firstPolyNode);
				firstPolyNode = next(firstPolyIterator);
			} else {
				resultPoly
						.add(new Node(firstPolyNode.getCoeff() + secPolyNode.getCoeff(), firstPolyNode.getExponent()));
				firstPolyNode = next(firstPolyIterator);
				secPolyNode = next(secPolyIterator);
			}
		}
		while (firstPolyNode != null) {
			resultPoly.add(firstPolyNode);
			firstPolyNode = next(firstPolyIterator);
		}
		while (secPolyNode != null) {
			resultPoly.add(secPolyNode);
			secPolyNode = next(firstPolyIterator);
		}
		return resultPoly;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		LinkedList<Node> firstPoly = generatePolynomial(in);
		System.out.println("1. add\n2. multiply\n3. evaluate");
		int c = in.nextInt();
		if (c == 1) {
			System.out.println("Enter the second polynomial");
			LinkedList<Node> secPoly = generatePolynomial(in);
			System.out.println(add(firstPoly, secPoly));
		}

	}

}
