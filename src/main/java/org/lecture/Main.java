package org.lecture;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HospitalManager hospitalManager =
                new HospitalManager(FileReader.readDoctorList("hospital_management_data.csv"));
        Scanner scanner = SingletonScanner.getInstance();

        String menu = """
                Hello User, please choose your option:
                1. Show all doctors with their departments
                2. Show all doctors with their departments, shift and average number of patients
                3. Write a report with all doctors and their departments, shifts and average number of patients
                4. Show the average and total number of patients of a certain doctorTests and shift
                5. Add a new doctorTests
                6. Create statistics for average number of patients per department, per doctorTests and per shift
                Please choose your option here:
                """;

        boolean runProgram = true;
        while (runProgram == true) {
            System.out.println(menu);
            String option = scanner.nextLine();
            switch (option) {
                case "1" -> hospitalManager.showAllDoctorsAndDepartments();
                case "2" ->hospitalManager.showAllAverageNumberOfPatients();
                case "3" ->hospitalManager.writeReport("hospital_report.txt");
                case "4" -> {
                    System.out.println("Select one of the following IDs:\n");
                    boolean first = true;
                    for (int doctorId : hospitalManager.getDoctorMap().keySet()) {
                        if (!first)
                            System.out.print(", ");
                        System.out.print(doctorId);
                        first = false;
                    }
                    System.out.println();
                    hospitalManager.printAverageAndTotalNumberOfPatientsForDoctor(scanner.nextInt());
                    scanner.nextLine();
                }
                case "5" -> hospitalManager.addDoctor();
                case "6" -> {
                    System.out.println("""
                            Please choose your selected statistics:
                            1. Average number of patients for departments
                            2. Average number of patients for shifts
                            3. Average number of patients for doctors
                            """);
                    var chosenStatistics = scanner.nextInt();
                    scanner.nextLine();
                    switch (chosenStatistics) {
                        case 1 -> hospitalManager.printAverageNumberOfPatientsPerDepartment();
                        case 2 -> hospitalManager.printAverageNumberOfPatientsPerShift();
                        case 3 -> hospitalManager.printAverageNumberOfPatientsPerDoctor();
                    }
                }
                case "9" -> runProgram = false;
            }
        }
    }
}