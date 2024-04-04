package org.lecture;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HospitalManager {
    private HashMap<Integer, Doctor> doctorMap;

    public void showAllDoctorsAndDepartments () {
        for (Doctor doctor: doctorMap.values()) {
            System.out.printf("%s - %s\n", doctor.getName(), doctor.getDepartment());
        }
    }

    public void showAllAverageNumberOfPatients () {
        System.out.print(getAllDoctorsDepartmentsShiftsAndAverageNumbersOfPatients());
    }

    public void writeReport(String fileName) {
        Path path = Paths.get("src", "main", "resources", fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(path)){
            writer.write(getAllDoctorsDepartmentsShiftsAndAverageNumbersOfPatients());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void printAverageAndTotalNumberOfPatientsForDoctor (int doctorId) {
        System.out.printf("Doctor: %s\nDurchschnittliche Patienten je Schicht: %.2f\nGesamte Patienten: %d\n\n",
                doctorMap.get(doctorId).getName(),
                doctorMap.get(doctorId).getAverageNumberOfPatients(),
                doctorMap.get(doctorId).getTotalNumberOfPatients());
    }

    public void addDoctor () {
        Scanner scanner = SingletonScanner.getInstance();
        System.out.println("Please insert your Doctor's name:");
        String doctorName = scanner.nextLine();
        System.out.println("Please insert his/her department:");
        String department = scanner.nextLine();

        ArrayList<Shift> shifts = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("Please insert your Shift:");
            String shift = scanner.nextLine();
            System.out.println("Please insert the first number of Patients:");
            ArrayList<Integer> numberOfPatients = new ArrayList<>();
            numberOfPatients.add(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Next Number of Patients for same shift:");
            numberOfPatients.add(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Last Number of Patients for same shift:");
            numberOfPatients.add(scanner.nextInt());
            scanner.nextLine();
            shifts.add(new Shift(shift, numberOfPatients));
        }

        int i = 1;
        boolean added = false;
        while (!added) {
            if (!doctorMap.keySet().contains(i)) {
                doctorMap.put(i, new Doctor(i, doctorName, department, shifts));
                added = true;
                System.out.println("Your Doctor has been added");
            }
            i++;
        }
    }

    public void printAverageNumberOfPatientsPerDepartment() {
        HashMap<String, Double> departments = new HashMap<>();
        for (Doctor doctor : doctorMap.values()) {
            if (!departments.containsKey(doctor.getDepartment()))
                departments.put(doctor.getDepartment(), 0.0);
        }
        for (String department : departments.keySet()) {
            double sum = 0;
            int count = 0;
            for (Doctor doctor : doctorMap.values()) {
                if (doctor.getDepartment().equals(department)) {
                    sum += doctor.getAverageNumberOfPatients();
                    count++;
                }
            }
            System.out.printf("%s : %.2f patients on average per week\n",
                    department, sum/count);
        }
    }

    public void printAverageNumberOfPatientsPerShift() {
        HashMap<String, Double> shifts = new HashMap<>();
        for (Doctor doctor : doctorMap.values()) {
            for (Shift shift : doctor.getShifts()) {
                if (!shifts.containsKey(shift.getShiftname()))
                    shifts.put(shift.getShiftname(), 0.0);
            }
        }
        for (String shift : shifts.keySet()) {
            double sum = 0;
            int count = 0;
            for (Doctor doctor : doctorMap.values()) {
                for (Shift doctorsShift : doctor.getShifts()) {
                    if (doctorsShift.getShiftname().equals(shift)) {
                        sum += doctorsShift.getAverageNumberOfPatients();
                        count++;
                    }
                }
            }
            System.out.printf("%s : %.2f patients on average per week\n\n",
                    shift, sum/count);
        }
    }

    public void printAverageNumberOfPatientsPerDoctor() {
        for (Doctor doctor : doctorMap.values()) {
            System.out.printf("%s : %.2f patients on average per week\n\n",
                    doctor.getName(), doctor.getAverageNumberOfPatients());
        }
    }

    private String getAllDoctorsDepartmentsShiftsAndAverageNumbersOfPatients () {
        String output = "";
        for (Doctor doctor: doctorMap.values()) {
            output += String.format("Doctor: %s\nDepartment: %s\n", doctor.getName(), doctor.getDepartment());
            for (Shift shift : doctor.getShifts()) {
                output += String.format("Shift: %s\nAverage Patients: %.2f\n\n",
                        shift.getShiftname(), shift.getAverageNumberOfPatients());
            }
        }
        return output;
    }

    public HospitalManager(HashMap<Integer, Doctor> doctorMap) {
        this.doctorMap = doctorMap;
    }

    public HashMap<Integer, Doctor> getDoctorMap() {
        return doctorMap;
    }

    public void setDoctorMap(HashMap<Integer, Doctor> doctorMap) {
        this.doctorMap = doctorMap;
    }
}
