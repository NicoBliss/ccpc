package icpc1;

import java.util.Scanner;

class F {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int vowelsNoY = 0;
        int vowelsWithY = 0;

        for (int index = 0; index < input.length(); index++) {
            char c = input.charAt(index);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y') {
                if (c == 'y') {
                    vowelsWithY += 1;
                } else {
                    vowelsWithY += 1;
                    vowelsNoY += 1;
                }
            }
        }
        sc.close();
        System.out.println(vowelsNoY + " " + vowelsWithY);
    }
}
