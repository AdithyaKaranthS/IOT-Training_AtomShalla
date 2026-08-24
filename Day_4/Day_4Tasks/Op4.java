class Op4 {
	public static void main(String[] args) {
		int n = 20;
		while (n > 5) {
			if (n % 3 == 0)
				n -= 4;
			else
				n -= 3;
			System.out.print(n + " ");
		}
	}
}