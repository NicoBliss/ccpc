package icpc1;

import java.util.Scanner;
import java.util.ArrayList;

class H {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] initial_nums = sc.nextLine().split(" ");
        sc.close();
        long picosNeeded = Long.parseLong(initial_nums[0]);
        long maxPicoPerPill = Long.parseLong(initial_nums[1]);
        long maxPills = Long.parseLong(initial_nums[2]);

        long numPrescriptions = 0;
        long minDays;
        if (picosNeeded % maxPicoPerPill == 0) {
            minDays = picosNeeded / maxPicoPerPill;
        } else {
            minDays = picosNeeded / maxPicoPerPill + 1;
        }
        long minDose;
        if (picosNeeded % maxPills == 0) {
            minDose = picosNeeded / maxPills;
        } else {
            minDose = picosNeeded / maxPills + 1;
        }
        long maxDays = Long.min(maxPills, (int) Math.sqrt(picosNeeded));
        long maxDose = 0;
        if (Math.pow(((int) (Math.sqrt(picosNeeded))), 2) == picosNeeded) {
            maxDose = Long.min(maxPicoPerPill, (int) Math.sqrt(picosNeeded) - 1);
        } else {
            maxDose = Long.min(maxPicoPerPill, (int) Math.sqrt(picosNeeded));
        }

        ArrayList<Long> list = new ArrayList<>();

        for (long dosage = minDose; dosage <= maxDose; dosage++) {
            if (picosNeeded % dosage == 0) {
                list.add(dosage);
                numPrescriptions++;
            }
        }

        for (long perDay = maxDays; perDay >= minDays; perDay--) {
            if (picosNeeded % perDay == 0) {
                list.add(picosNeeded / perDay);
                numPrescriptions++;
            }
        }

        System.out.println(numPrescriptions);

        for (long x : list) {
            System.out.println(x);
        }
    }
}
