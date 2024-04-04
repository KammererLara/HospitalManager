package org.lecture;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DoctorTests {
    @Test

    public void getAverageNumberOfPatients() {
        var doctor = createStandardDoctor();
        Assertions.assertEquals(4, doctor.getAverageNumberOfPatients());
    }

    @Test
    public void getTotalNumberOfPatients() {
        var doctor = createStandardDoctor();
        Assertions.assertEquals(36, doctor.getTotalNumberOfPatients());
    }

    private static Doctor createStandardDoctor() {
        return createDoctor(1, "Max Muster", "Cardiology",
                ShiftTests.createShift("Morning", 2, 3, 4),
                ShiftTests.createShift("Afternoon", 3, 4, 5),
                ShiftTests.createShift("Night", 4, 5, 6));
    }

    public static Doctor createDoctor(int id, String name, String department, Shift... shifts) {
        ArrayList<Shift> shiftList = new ArrayList<>();
        for (Shift shift : shifts) {
            shiftList.add(shift);
        }
        return new Doctor(id, name, department, shiftList);
    }
}
