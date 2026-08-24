class Op1 {
   public static void main(String[] args) {
      int x = 5;
      for (int i = 1; i <= 4; i++) {
         if (x % 2 == 1)
            x += i;
         else
            x -= i;
         System.out.print(x + " ");
      }
   }
}