class ArrayMin{
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int min = findMin(arr);
        System.out.println("The minimum value in the array is: " + min);
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}