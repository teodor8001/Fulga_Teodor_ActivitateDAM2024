package com.example.proiectfacultate;

import android.os.Parcel;
import android.os.Parcelable;

public class Masina implements Parcelable {
    private String brand;
    private String model;
    private int caiPutere;
    private boolean isSport;

    public Masina() {
        this.brand = "none";
        this.model = "none";
        this.caiPutere = 0;
        this.isSport = false;
    }

    public Masina(String brand, boolean isSport, int caiPutere, String model) {
        this.brand = brand;
        this.isSport = isSport;
        this.caiPutere = caiPutere;
        this.model = model;
    }

    protected Masina(Parcel in) {
        brand = in.readString();
        model = in.readString();
        caiPutere = in.readInt();
        isSport = in.readByte() != 0; // boolean este scris ca byte
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(brand);
        dest.writeString(model);
        dest.writeInt(caiPutere);
        dest.writeByte((byte) (isSport ? 1 : 0)); // boolean scris ca byte
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Masina> CREATOR = new Creator<Masina>() {
        @Override
        public Masina createFromParcel(Parcel in) {
            return new Masina(in);
        }

        @Override
        public Masina[] newArray(int size) {
            return new Masina[size];
        }
    };

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCaiPutere() {
        return caiPutere;
    }

    public void setCaiPutere(int caiPutere) {
        this.caiPutere = caiPutere;
    }

    public boolean isSport() {
        return isSport;
    }

    public void setSport(boolean sport) {
        isSport = sport;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Masina{");
        sb.append("brand='").append(brand).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", caiPutere=").append(caiPutere);
        sb.append(", isSport=").append(isSport);
        sb.append('}');
        return sb.toString();
    }
}
