import java.util.List;

public class Main {
    public static void main(String[] args) {

        DataRetriever dataRetriever = new DataRetriever();

        // QUESTION A: NOMBRE DE PIECES VENDUES
        System.out.println("\n=== QUESTION A: Nombre de pieces vendues par marque ===");

        List<PieceVendusMarque> piecesVendus = dataRetriever.countNombrePiecesVendus();

        System.out.println("Nombre de pieces vendues par marque :");

        for (PieceVendusMarque piece : piecesVendus) {
            System.out.println(piece.getMarqueEnum() + " | " + piece.getNbr_pieces_vendus());
        }

        //QUESTION B: NOMBRE DE PIECES VENDUES PAR MODELE(Une seule ligne)
        System.out.println("\n=== QUESTION B: Nombre de pieces vendues par modèle ===");
        PieceVendusModele piecesModele = dataRetriever.coutNombrePiecesVendusModele();

        System.out.println("GETZ | " + piecesModele.getGetz());
        System.out.println("PRIDE | " + piecesModele.getPride());
        System.out.println("LACETTI | " + piecesModele.getLacetti());

        //QUESTION C : LE PRIX TOTAL DE PIECES VENDUS PAR LA MARQUE KIA
        System.out.println("\n=== QUESTION C: Le prix total de pièces vendus pour la marque KIA  ===");
        PrixTotalMarque totalKIA = dataRetriever.prixTotalPiecesVendusKIA();
        System.out.println(totalKIA);
    }
}