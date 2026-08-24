class ReverseArr {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("Original array:");
        for (int number : arr) System.out.print(number + " ");

        for (int start = 0, end = arr.length - 1; start < end; start++, end--) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }

        System.out.println("Reversed array:");
        for (int number : arr) System.out.print(number + " ");
    }
}