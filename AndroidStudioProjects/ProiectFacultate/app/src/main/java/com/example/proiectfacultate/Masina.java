package com.example.proiectfacultate;

public class Masina {
    private String brand;
    private String model;
    private int caiPutere;
    private int dimensiuneMotor;
    private boolean isSport;
    private int anFabricatie;

    public Masina() {
        this.brand = "none";
        this.model = "none";
        this.caiPutere = 0;
        this.dimensiuneMotor = 0;
        this.isSport = false;
        this.anFabricatie = 0;
    }

    public Masina(String brand, boolean isSport, int caiPutere, String model) {
        this.brand = brand;
        this.isSport = isSport;
        this.caiPutere = caiPutere;
        this.model = model;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Masina{");
        sb.append("brand='").append(brand).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", caiPutere=").append(caiPutere);
        sb.append(", dimensiuneMotor=").append(dimensiuneMotor);
        sb.append(", isSport=").append(isSport);
        sb.append(", anFabricatie=").append(anFabricatie);
        sb.append('}');
        return sb.toString();
    }
}
