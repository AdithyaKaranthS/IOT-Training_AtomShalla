import java.util.*;

class HackerRank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.next());
        }

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String value = iterator.next();

            if (!value.matches("[0-9]+")) {
                System.out.println(value);
            }
        }

        sc.close();
    }
}