package icpc1;

import java.util.HashMap;
import java.util.Scanner;

class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] initial_nums = sc.nextLine().split(" ");
        String[] nextline;
        Integer num_teams = Integer.parseInt(initial_nums[0]);
        Integer num_advancing_teams = Integer.parseInt(initial_nums[1]);
        Integer school_limit = Integer.parseInt(initial_nums[2]);
        Integer[][] team_list = new Integer[num_teams][2];
        Integer[] passing = new Integer[num_teams];
        HashMap<Integer, Integer> school_remaining = new HashMap<>();
        for (int counter = 0; counter < num_teams; counter++) {
            nextline = sc.nextLine().split(" ");
            // id
            team_list[counter][0] = Integer.parseInt(nextline[0]);
            // school
            team_list[counter][1] = Integer.parseInt(nextline[1]);

            passing[counter] = 0;
        }
        sc.close();
        for (int counter = 0; counter < num_teams; counter++) {
            if (num_advancing_teams <= 0) {
                break;
            }
            if (school_remaining.get(team_list[counter][1]) != null) {
                if (school_remaining.get(team_list[counter][1]) > 0) {
                    passing[counter] = team_list[counter][0];
                    team_list[counter][0] = 0;
                    school_remaining.put(team_list[counter][1], school_remaining.get(team_list[counter][1]) - 1);
                    num_advancing_teams -= 1;
                }
            } else {
                passing[counter] = team_list[counter][0];
                team_list[counter][0] = 0;
                school_remaining.put(team_list[counter][1], school_limit - 1);
                num_advancing_teams -= 1;
            }
        }
        for (int counter = 0; counter < num_teams; counter++) {
            if (num_advancing_teams <= 0) {
                break;
            } else if (team_list[counter][0] == 0) {
                continue;
            } else {
                passing[counter] = team_list[counter][0];
                num_advancing_teams -= 1;
            }
        }

        for (int counter = 0; counter < num_teams; counter++) {
            if (passing[counter] != 0) {
                System.out.println(passing[counter]);
            }
        }
    }
}