package com.pharmacystockproject.pharmacy.model;

public enum MedicineType {
    ANALGÉSICO("Analgésico"),
    ANALÉPTICO("Analéptico"),
    ANESTÉSICO("Anestésico"),
    ANTIÁCIDO("Antiácido"),
    ANTIDEPRESIVO("Antidepresivo"),
    ANTIBIÓTICO("Antibiótico");

    private final String displayName;

    MedicineType(String displayName) {
        this.displayName = displayName;
    }

    @Override

    public String toString() {
        return displayName;
    }
}
