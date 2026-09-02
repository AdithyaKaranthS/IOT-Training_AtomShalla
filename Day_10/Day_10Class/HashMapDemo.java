import java.util.HashMap;

class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        System.out.println("HashMap Contents:");
        for (String key : map.keySet()) {
            System.out.println(key + " => " + map.get(key));
        }
    }
}