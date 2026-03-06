public class PrixTotalMarque {

    private String marque;
    private double prixTotal;

    public PrixTotalMarque(String marque, double prixTotal) {
        this.marque = marque;
        this.prixTotal = prixTotal;
    }

    public String getMarque() {
        return marque;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    @Override
    public String toString() {
        return "Prix total pour " + marque + " : " + prixTotal;
    }
}