package  com.pharmacystockproject.pharmacy.model;




public enum MedicineType {
    ANALGESICO("Analgesico"),
    ANALEPTICO("Analeptico"),
    ANESTESICO("Anestesico"),
    ANTIACIDO("Antiacido"),
    ANTIDEPRESIVO("Antidepresivo"),
    ANTIBIOTICO("Antibiotico");


    private final String displayName;


    MedicineType(String displayName) {
        this.displayName = displayName;
    }


    @Override

    public String toString(){
        return displayName;
    }
}
