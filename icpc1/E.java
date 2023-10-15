package icpc1;

import java.util.Scanner;

class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_teams = Integer.parseInt(sc.nextLine());
        String[] nextline;
        Integer[][] bounds = new Integer[num_teams][2];
        Integer[][] pruned_bounds = new Integer[num_teams][2];
        for (int i = 0; i < num_teams; i++) {
            nextline = sc.nextLine().split(" ");
            bounds[i][0] = Integer.parseInt(nextline[0]) - 1;
            bounds[i][1] = Integer.parseInt(nextline[1]) - 1;
        }
        sc.close();
        for (int i = 0; i < num_teams; i++) {
            for (int j = bounds[i][0]; j <= i; j++) {
                if (j == i) {
                    pruned_bounds[i][0] = j;
                } else if (bounds[j][1] < i) {
                    pruned_bounds[i][0] = j - 1;
                    break;
                }
            }
            for (int j = bounds[i][1]; j >= i; j--) {
                if (j == i) {
                    pruned_bounds[i][1] = j;
                } else if (bounds[j][1] > i) {
                    pruned_bounds[i][1] = j + 1;
                    break;
                }
            }
        }
        int num_possible_teams_down = 0;
        for (int i = 0; i < num_teams; i++) {
            if ((pruned_bounds[i][1] - i) < 3) {
                continue;
            } else {
                num_possible_teams_down += 1;
                i += 2;
            }
        }
        int num_possible_teams_up = 0;
        for (int i = num_teams - 1; i >= 0; i--) {
            if ((pruned_bounds[i][0] - i) < 3) {
                continue;
            } else {
                num_possible_teams_down += 1;
                i -= 2;
            }
        }
        System.out.println(Integer.max(num_possible_teams_down, num_possible_teams_up));
    }
}
