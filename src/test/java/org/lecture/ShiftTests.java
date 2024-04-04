package org.lecture;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ShiftTests {
    @Test
    public void getAverageNumberOfPatients() {
        var shift = createStandardShift();
        Assertions.assertEquals(3, shift.getAverageNumberOfPatients());
    }

    @Test
    public void getTotalNumberOfPatients() {
        var shift = createStandardShift();
        Assertions.assertEquals(3, shift.getTotalNumberOfPatients());
    }

    private static Shift createStandardShift() {
        return createShift("Morning",2,3,4);
    }

    public static Shift createShift(String name, int patientsA, int patientsB, int patientsC) {
        ArrayList<Integer> numberOfPatients = new ArrayList<>();
        numberOfPatients.add(patientsA);
        numberOfPatients.add(patientsB);
        numberOfPatients.add(patientsC);
        return new Shift(name, numberOfPatients);
    }
}
