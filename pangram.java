import java.util.HashMap;
import java.util.Scanner;

class pangram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer y =  Integer.parseInt(sc.nextLine());
        for (int j = 0; j<y; j++) {
            String x = sc.nextLine();
            String xClean = x.replaceAll("[^a-zA-Z]", "").toLowerCase();
            HashMap<Character, Integer> xHash = new HashMap<>();
            for(char i = 'a'; i <='z'; i++) {
            xHash.put((Character) i, (Integer) 0);
            }
            for (char i: xClean.toCharArray()) {
                xHash.put((Character) i, xHash.get(i)+1);
            }
            char[] missing = new char[26];
            for(char i = 'a'; i <='z'; i++) { 
                if(xHash.get(i) == 0) {
                    missing[i-'a'] = i;
                }
            }
            String out = StringBuilder()"missing " missing.toString();
            System.out.println(out);
        }
        sc.close();
    }
}