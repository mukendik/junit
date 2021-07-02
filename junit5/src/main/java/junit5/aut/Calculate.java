package junit5.aut;

public class Calculate {
	
	public static Integer add(int i, int j) {
		return i + j;
	}

	public static Integer devide(int i, int j) {
		if (j==0)
			throw new ArithmeticException("Infinity");
		return  (i/j);
	}

	public static Integer  multiple(int i, int j) {
		return i*j;
	}
}
