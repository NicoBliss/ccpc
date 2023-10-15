package icpc1;

import java.util.Scanner;
import java.util.ArrayList;

class L {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] initial_nums = sc.nextLine().split(" ");

        int min = Integer.parseInt(initial_nums[1]);
        int max = Integer.parseInt(initial_nums[2]);

        int num_days = Integer.parseInt(initial_nums[0]) - 1;
        int[] days = new int[num_days];

        boolean minFound = false;
        boolean maxFound = false;

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < num_days; i++) {
            days[i] = Integer.parseInt(sc.nextLine());
        }

        sc.close();

        for (int index = 0; index < days.length; index++) {
            if (days[index] == max) {
                maxFound = true;
            }
            if (days[index] == min) {
                minFound = true;
            }

        }

        if (!maxFound && !minFound) {
            list.add(-1);
        } else if (!maxFound) {
            list.add(max);
        } else if (!minFound) {
            list.add(min);
        } else {
            for (int i = min; i <= max; i++) {
                list.add(i);
            }
        }

        for (int x : list) {
            System.out.println(x);
        }
    }
}
