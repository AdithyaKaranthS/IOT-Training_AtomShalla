class Op3 {
	public static void main(String[] args) {
		int x = 1;
		for (int i = 1; i <= 5; i++) {
			if (i % 2 == 0)
				x *= 2;
			else
				x += i;
			System.out.print(x + " ");
		}
	}
}