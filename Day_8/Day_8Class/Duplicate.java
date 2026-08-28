import java.util.HashSet;
import java.util.Set;
class Duplicate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 2, 3, 6};
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        System.out.println("Duplicate elements in the array:");
        for (int value : arr) {
            if (!seen.add(value) && duplicates.add(value)) {
                System.out.println(value);
            }
        }
    }
    
}