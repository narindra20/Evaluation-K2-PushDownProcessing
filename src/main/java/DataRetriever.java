import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {

    // QUESTION A: NOMBRE DE PIECES VENDUES PAR MARQUE
    public List<PieceVendusMarque> countNombrePiecesVendus() {

        DBConnection dbConnection = new DBConnection();
        List<PieceVendusMarque> nombre_pieces = new ArrayList<>();

        String sql = """
            SELECT m.marque,
                   SUM(v.quantite) AS nombre_pieces
            FROM modele_voiture m
            JOIN piece_auto p ON m.id = p.id_modele_voiture
            JOIN vente v ON p.id = v.id_piece_auto
            GROUP BY m.marque
        """;

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {

                MarqueEnum marque = MarqueEnum.valueOf(resultSet.getString("marque"));
                int nbr_pieces = resultSet.getInt("nombre_pieces");

                nombre_pieces.add(new PieceVendusMarque(marque, nbr_pieces));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors du calcul du nombre de pieces vendues", e);
        }

        return nombre_pieces;
    }

    //QUESTION B: NOMBRE DE PIECES VENDUES PAR MODELE(Une seule ligne)
    public PieceVendusModele coutNombrePiecesVendusModele() {

        DBConnection dbConnection = new DBConnection();

        String sql = """
        SELECT
        SUM(CASE WHEN m.modele = 'GETZ' THEN v.quantite ELSE 0 END) AS piece_getz,
        SUM(CASE WHEN m.modele = 'PRIDE' THEN v.quantite ELSE 0 END) AS piece_pride,
        SUM(CASE WHEN m.modele = 'LACETTI' THEN v.quantite ELSE 0 END) AS piece_lacetti
        FROM vente v
        JOIN piece_auto p ON v.id_piece_auto = p.id
        JOIN modele_voiture m ON p.id_modele_voiture = m.id
    """;

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery()) {

            if (resultSet.next()) {

                int getz = resultSet.getInt("piece_getz");
                int pride = resultSet.getInt("piece_pride");
                int lacetti = resultSet.getInt("piece_lacetti");

                return new PieceVendusModele(getz, pride, lacetti);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors du comptage des pieces par modele", e);
        }

        return new PieceVendusModele(0,0,0);
    }

    //QUESTION C : LE PRIX TOTAL DE PIECES VENDUS PAR LA MARQUE KIA

    public PrixTotalMarque prixTotalPiecesVendusKIA() {

        DBConnection dbConnection = new DBConnection();

        String sql = """
        SELECT SUM(p.prix * v.quantite) AS prix_total_vendus
        FROM vente v
        JOIN piece_auto p ON v.id_piece_auto = p.id
        JOIN modele_voiture m ON p.id_modele_voiture = m.id
        WHERE m.marque = 'KIA'
    """;

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                double total = rs.getDouble("prix_total_vendus");
                return new PrixTotalMarque("KIA", total);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors du calcul du prix total pour KIA", e);
        }

        return new PrixTotalMarque("KIA", 0);
    }
}