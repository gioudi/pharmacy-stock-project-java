package com.pharmacystockproject.pharmacy.model;

public enum Branch {
    
    PRIMARIA("Calle de la rosa n.28"),
    SECUNDARIA("Calle Alcanzabilla n. 3");

    private final String address;

    Branch(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
