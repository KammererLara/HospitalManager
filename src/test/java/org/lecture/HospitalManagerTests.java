package org.lecture;

import org.junit.jupiter.api.*;

import java.io.*;
import java.util.HashMap;

public class HospitalManagerTests {
    private HospitalManager hospitalManager;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void prepareTests() {
        hospitalManager = new HospitalManager(createDoctorMap());
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void showAllDoctorsAndDepartments() {
        String expectedOutput = """
        Dr. Muster - Cardiology
        Dr. Dorfer - Dermatology
        Dr. Mueller - Cardiology
        """;
        hospitalManager.showAllDoctorsAndDepartments();
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void showAllAverageNumberOfPatients() {
        String expectedOutput = """
                Doctor: Dr. Muster
                Department: Cardiology
                Shift: Morning
                Average Patients: 3,00
                                
                Shift: Afternoon
                Average Patients: 4,00
                                
                Shift: Night
                Average Patients: 5,00
                                
                Doctor: Dr. Dorfer
                Department: Dermatology
                Shift: Morning
                Average Patients: 7,00
                                
                Shift: Afternoon
                Average Patients: 8,00
                                
                Shift: Night
                Average Patients: 9,00
                                
                Doctor: Dr. Mueller
                Department: Cardiology
                Shift: Morning
                Average Patients: 24,00
                                
                Shift: Afternoon
                Average Patients: 25,00
                                
                Shift: Night
                Average Patients: 26,00
                                
                """;
        hospitalManager.showAllAverageNumberOfPatients();
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    //TODO
//    @Test
//    public void writeReport() {
//        String expectedOutput = """
//                Doctor: Dr. Muster
//                Department: Cardiology
//                Shift: Morning
//                Average Patients: 3,00
//
//                Shift: Afternoon
//                Average Patients: 4,00
//
//                Shift: Night
//                Average Patients: 5,00
//
//                Doctor: Dr. Dorfer
//                Department: Dermatology
//                Shift: Morning
//                Average Patients: 7,00
//
//                Shift: Afternoon
//                Average Patients: 8,00
//
//                Shift: Night
//                Average Patients: 9,00
//
//                Doctor: Dr. Mueller
//                Department: Cardiology
//                Shift: Morning
//                Average Patients: 24,00
//
//                Shift: Afternoon
//                Average Patients: 25,00
//
//                Shift: Night
//                Average Patients: 26,00
//
//                """;
//        String filename = "test.txt";
//        hospitalManager.writeReport(filename);
//        Path path = Paths.get("src", "main", "resources", filename);
//
//        Assertions.assertEquals(expectedOutput,);
//    }

    @Test
    public void printAverageAndTotalNumberOfPatientsForDoctor() {
        String expectedOutput = """
                Doctor: Dr. Dorfer
                Durchschnittliche Patienten je Schicht: 8,00
                Gesamte Patienten: 72
                        
                """;
        hospitalManager.printAverageAndTotalNumberOfPatientsForDoctor(2);
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    //TODO?
//    @Test
//    public void addDoctor() {
//        Assertions.assertEquals(3, hospitalManager.getDoctorMap().size());
//
//        hospitalManager.addDoctor();
//    }

    @Test
    public void printAverageNumberOfPatientsPerDepartment() {
        String expectedOutput = """
                Dermatology : 8,00 patients on average per week
                Cardiology : 14,50 patients on average per week
                """;
        hospitalManager.printAverageNumberOfPatientsPerDepartment();
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void printAverageNumberOfPatientsPerShift() {
        String expectedOutput = """
                Afternoon : 12,33 patients on average per week
                        
                Night : 13,33 patients on average per week
                        
                Morning : 11,33 patients on average per week
                        
                """;
        hospitalManager.printAverageNumberOfPatientsPerShift();
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void printAverageNumberOfPatientsPerDoctor() {
        String expectedOutput = """
                Dr. Muster : 4,00 patients on average per week
                        
                Dr. Dorfer : 8,00 patients on average per week
                        
                Dr. Mueller : 25,00 patients on average per week
                        
                """;
        hospitalManager.printAverageNumberOfPatientsPerDoctor();
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    private static HashMap<Integer, Doctor> createDoctorMap() {
        HashMap<Integer, Doctor> doctors = new HashMap<>();
        doctors.put(1,
                DoctorTests.createDoctor(1, "Dr. Muster", "Cardiology",
                        ShiftTests.createShift("Morning", 2, 3, 4),
                        ShiftTests.createShift("Afternoon", 3, 4, 5),
                        ShiftTests.createShift("Night", 4, 5, 6)));
        doctors.put(2,
                DoctorTests.createDoctor(2, "Dr. Dorfer", "Dermatology",
                        ShiftTests.createShift("Morning", 6, 7, 8),
                        ShiftTests.createShift("Afternoon", 7, 8, 9),
                        ShiftTests.createShift("Night", 8, 9, 10)));
        doctors.put(3,
                DoctorTests.createDoctor(3, "Dr. Mueller", "Cardiology",
                        ShiftTests.createShift("Morning", 23, 24, 25),
                        ShiftTests.createShift("Afternoon", 24, 25, 26),
                        ShiftTests.createShift("Night", 25, 26, 27)));
        return doctors;
    }

}
