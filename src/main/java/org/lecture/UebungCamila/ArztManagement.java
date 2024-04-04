package org.lecture.UebungCamila;

import org.lecture.UebungCamila.Arzt;

import java.util.List;

public class ArztManagement {
    public static void ausgabeVornamenÄrzte (List<Arzt> ärzte) {
        for (Arzt arzt : ärzte) {
            System.out.println(arzt.getVorname());
        }
    }
}
