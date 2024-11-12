package com.example.pregatire_lucrare_3;

public class Firma {
    private String nume;
    private String adresa;
    private int profit;
    private int cheltuieli;
    private boolean isProfitabil;
    private float rating;

    public Firma(String nume, String adresa, int profit, int cheltuieli, boolean isProfitabil) {
        this.nume = nume;
        this.adresa = adresa;
        this.profit = profit;
        this.cheltuieli = cheltuieli;
        this.isProfitabil = isProfitabil;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public int getCheltuieli() {
        return cheltuieli;
    }

    public void setCheltuieli(int cheltuieli) {
        this.cheltuieli = cheltuieli;
    }

    public boolean isProfitabil() {
        return isProfitabil;
    }

    public void setProfitabil(boolean profitabil) {
        this.isProfitabil = profitabil;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Firma{");
        sb.append("nume='").append(nume).append('\'');
        sb.append(", adresa='").append(adresa).append('\'');
        sb.append(", profit=").append(profit);
        sb.append(", cheltuieli=").append(cheltuieli);
        sb.append(", isProfitabil=").append(isProfitabil);
        sb.append(", rating=").append(rating);
        sb.append('}');
        return sb.toString();
    }
}
