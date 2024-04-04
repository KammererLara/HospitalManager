package org.lecture.UebungCamila;

public class MainBsp {
    public static void main(String[] args) {
        int nummer = 1;
        Arzt arztNo1 = new Arzt(); //Klasse: Arzt, Objekt:arztNo1
        Arzt arztNo2 = new Arzt(); //Klasse: Arzt, Objekt:arztNo2
        Arzt arztNo3 = new Arzt(); //Klasse: Arzt, Objekt:arztNo3

//        arztNo1.vorname = "Hans";
//        arztNo1.nachname = "Huber";
//        arztNo1.alter = -30;

        arztNo1.setVorname("Hans");
        arztNo1.setNachname("Huber");
        arztNo1.setAlter(-30);

//        System.out.println(arztNo1.vorname);
        System.out.println(arztNo1.getVorname());
        System.out.println(arztNo1.getGeburtsjahr());

//        ArztManagement.methodenname() -> static methoden, auf gesamte Klasse bezogen z.B. ausgabeVornamenÄrzte
//        arztNo1.methodenname() -> normalen methoden, auf einzelne Objekte bezogen z.B. getGeburtsjahr, setVorname


    }
}
