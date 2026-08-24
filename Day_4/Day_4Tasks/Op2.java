class Op2 {
	public static void main(String[] args) {
		int a = 10;
		for (int i = 1; i <= 5; i++) {
			if (a > 10)
				a -= i;
			else
				a += i * 2;
			System.out.print(a + " ");
		}
	}
}
