class Num_Of_1 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 0, 1};
        int count = 0;

        for (int num : arr) {
            if (num == 1) {
                count++;
            }
        }
        System.out.println("Number of 1s in the array is: " + count);
    }
}
