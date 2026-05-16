package com.pharmacystockproject.pharmacy.model;

public class MedicineOrder {

    private String medicineName;
    private MedicineType medicineType;
    private int quantity;
    private Provider provider;
    private Branch branch;

    public MedicineOrder(String medicineName, MedicineType medicineType, int quantity, Provider provider,
            Branch branch) {
        this.medicineName = medicineName;
        this.medicineType = medicineType;
        this.quantity = quantity;
        this.provider = provider;
        this.branch = branch;
    }

    // Getter and Setters

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public MedicineType getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(MedicineType medicineType) {
        this.medicineType = medicineType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

}
