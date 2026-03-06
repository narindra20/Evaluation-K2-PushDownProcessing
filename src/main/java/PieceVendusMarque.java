public class PieceVendus {
    private MarqueEnum marqueEnum;
    private int nbr_pieces_vendus;

    public PieceVendus(MarqueEnum marqueEnum, int nbr_pieces_vendus){
        this.marqueEnum = marqueEnum;
        this.nbr_pieces_vendus = nbr_pieces_vendus;
    }

    public MarqueEnum getMarqueEnum() {
        return marqueEnum;
    }

    public void setMarqueEnum(MarqueEnum marqueEnum) {
        this.marqueEnum = marqueEnum;
    }

    public int getNbr_pieces_vendus() {
        return nbr_pieces_vendus;
    }

    public void setNbr_pieces_vendus(int nbr_pieces_vendus) {
        this.nbr_pieces_vendus = nbr_pieces_vendus;
    }

    @Override
    public String toString() {
        return "Nombre de Pieces Vendus [marque=" + marqueEnum + ", nbre_pieces_vendus=" + nbr_pieces_vendus + "]";
    }
}
