package icpc1;

import java.util.Scanner;
import java.util.Arrays;

class G {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] initial_nums = sc.nextLine().split(" ");
        int num_probs = Integer.parseInt(initial_nums[0]);
        int[] problem_lines = new int[num_probs];
        int total_lines = 5 * Integer.parseInt(initial_nums[1]);

        for (int i = 0; i < num_probs; i++) {
            problem_lines[i] = Integer.parseInt(sc.nextLine());
        }
        Arrays.sort(problem_lines);

        int numAbleToSolve = 0;
        for (int index = 0; index < problem_lines.length && total_lines - problem_lines[index] >= 0; index++) {
            numAbleToSolve++;
            total_lines -= problem_lines[index];
        }

        System.out.println(numAbleToSolve);
        sc.close();
    }
}
