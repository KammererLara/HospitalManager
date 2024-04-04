package org.lecture.UebungCamila;

import java.util.List;

public class Arzt {
    //Attribute: vorname, nachname, abteilung
    private String vorname;
    private String nachname;
    private String abteilung;
    private int alter;

    public int getGeburtsjahr () {
        int geburtsjahr = 2024-alter; //geburtsjahr = Variable
        return geburtsjahr;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(String abteilung) {
        this.abteilung = abteilung;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        if (alter > 0) {
            this.alter = alter;
        }
    }
}
