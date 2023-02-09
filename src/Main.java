import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> userPhones = new MyHashMap<>();
        userPhones.put("Alex" , 340);
        userPhones.put("Edi" , 456);
        userPhones.put("Alina" , 123);
        userPhones.put("Daria" , 777);
        userPhones.put("Victoria" , 985);
        System.out.println("userPhones = " + userPhones);
        userPhones.remove("Daria");
        System.out.println("userPhones = " + userPhones);
        System.out.println("userPhones.get(\"Victoria\") = " + userPhones.get("Victoria"));
        //userPhones.clear();
       // System.out.println("userPhones = " + userPhones);
        System.out.println("userPhones.size() = " + userPhones.size());


    }

}

