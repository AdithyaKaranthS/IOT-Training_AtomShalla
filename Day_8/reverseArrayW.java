class reverseArrayW {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int i = 0;
        System.out.println("Original array:");
        while (i < arr.length) {
            System.out.print(arr[i] + " ");
            i++;
        }

        System.out.println("\nReversed array:");
        i = arr.length - 1;
        while (i >= 0) {
            System.out.print(arr[i] + " ");
            i--;
        }
    }
}
