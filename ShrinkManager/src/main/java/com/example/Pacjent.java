// Pacjent.java
package com.example;

public class Pacjent {
    private String imie;
    private String nazwisko;
    private int wiek;

    public Pacjent(String imie, String nazwisko, int wiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    // gettery/settery ...

    @Override
    public String toString() {
        return String.format(
            "{ \"imie\": \"%s\", \"nazwisko\": \"%s\", \"wiek\": %d }",
            imie, nazwisko, wiek
        );
    }
}
