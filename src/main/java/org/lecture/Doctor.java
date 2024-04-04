package org.lecture;

import java.util.ArrayList;

public class Doctor {
    private int id;
    private String name;
    private String department;
    private ArrayList<Shift> shifts;

    public double getAverageNumberOfPatients () {
        double sum = 0;
        int count = 0;
        for (Shift shift : shifts) {
            for (int patients : shift.getWeeklyPatients()) {
                sum += patients;
                count++;
            }
        }
        return sum / count;
    }

    public int getTotalNumberOfPatients () {
        int sum = 0;
        for (Shift shift : shifts) {
            for (int patients : shift.getWeeklyPatients()) {
                sum += patients;
            }
        }
        return sum;
    }

    public Doctor(int id, String name, String department, ArrayList<Shift> shifts) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.shifts = shifts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ArrayList<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(ArrayList<Shift> shifts) {
        this.shifts = shifts;
    }
}
