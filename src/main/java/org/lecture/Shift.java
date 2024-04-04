package org.lecture;

import java.util.ArrayList;

public class Shift {
    private String shiftname;
    private ArrayList<Integer> weeklyPatients;

    public double getAverageNumberOfPatients () {
        return getTotalNumberOfPatients()/weeklyPatients.stream().count();
    }

    public double getTotalNumberOfPatients () {
        double sum = 0;
        for (int patients : weeklyPatients) {
            sum += patients;
        }
        return sum;
    }

    public Shift(String shiftname, ArrayList<Integer> weeklyPatients) {
        this.shiftname = shiftname;
        this.weeklyPatients = weeklyPatients;
    }

    public String getShiftname() {
        return shiftname;
    }

    public void setShiftname(String shiftname) {
        this.shiftname = shiftname;
    }

    public ArrayList<Integer> getWeeklyPatients() {
        return weeklyPatients;
    }

    public void setWeeklyPatients(ArrayList<Integer> weeklyPatients) {
        this.weeklyPatients = weeklyPatients;
    }
}
