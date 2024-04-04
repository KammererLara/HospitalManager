package org.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class FileReader {
    public static HashMap<Integer, Doctor> readDoctorList(String fileName) {
        HashMap<Integer, Doctor> doctorMap = new HashMap<>();
        Path path = Paths.get("src", "main", "resources", fileName);
        if (Files.exists(path)) {
            try (BufferedReader reader = Files.newBufferedReader(path)){
                String line;
                reader.readLine(); //titleLine
                while ((line = reader.readLine()) != null) {
                    String[] record = line.split(",");

                    int id = Integer.parseInt(record[0]);
                    String shiftname = record[3];
                    ArrayList<Integer> patientcounts = new ArrayList<>();
                    patientcounts.add(Integer.parseInt(record[4]));
                    patientcounts.add(Integer.parseInt(record[5]));
                    patientcounts.add(Integer.parseInt(record[6]));
                    Shift shift = new Shift(shiftname, patientcounts);

//                    if (!shiftList.stream().map(doctor -> doctor.id).anyMatch(doctorId -> doctorId == id)) --> bei Arraylist shiftList
                    if (!doctorMap.keySet().contains(id)) {
                        String doctorname = record[1];
                        String department = record[2];
                        ArrayList<Shift> shifts = new ArrayList<>();
                        shifts.add(shift);
                        Doctor doctor = new Doctor(id, doctorname, department, shifts);
                        doctorMap.put(id, doctor);
                    } else {
                        doctorMap.get(id).getShifts().add(shift);
                    }
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        return doctorMap;
    }
}
