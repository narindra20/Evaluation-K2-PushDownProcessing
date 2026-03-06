CREATE TYPE marque_enum AS ENUM ('KIA', 'HYUNDAI', 'DAEWOO');

CREATE TYPE modele_enum AS ENUM ('GETZ', 'PRIDE', 'LACETTI');

CREATE TABLE Modele_voiture (
    id SERIAL PRIMARY KEY,
    marque marque_enum NOT NULL,
    modele modele_enum NOT NULL
);

CREATE TABLE Piece_auto (
    id SERIAL PRIMARY KEY,
    id_modele_voiture INT NOT NULL REFERENCES Modele_voiture(id) ON DELETE CASCADE,
    numero_serie VARCHAR(50) UNIQUE NOT NULL,
    prix NUMERIC(10,2) NOT NULL
);

CREATE TABLE Vente (
    id SERIAL PRIMARY KEY,
    id_piece_auto INT NOT NULL REFERENCES Piece_auto(id) ON DELETE CASCADE,
    quantite INT NOT NULL CHECK (quantite > 0)
);

SELECT m.marque,
SUM(v.quantite) AS nombre_pieces
FROM modele_voiture m
JOIN piece_auto p ON m.id = p.id_modele_voiture
JOIN vente v ON p.id = v.id_piece_auto
GROUP BY m.marque;

SELECT
SUM(CASE WHEN m.modele = 'GETZ' THEN v.quantite ELSE 0 END) AS piece_getz,
SUM(CASE WHEN m.modele = 'PRIDE' THEN v.quantite ELSE 0 END) AS piece_pride,
SUM(CASE WHEN m.modele = 'LACETTI' THEN v.quantite ELSE 0 END) AS piece_lacetti
FROM vente v
JOIN piece_auto p ON v.id_piece_auto = p.id
JOIN modele_voiture m ON p.id_modele_voiture = m.id;

SELECT SUM(p.prix * v.quantite) AS prix_total_vendus
FROM vente v
JOIN piece_auto p ON v.id_piece_auto = p.id
JOIN modele_voiture m ON p.id_modele_voiture = m.id
WHERE m.marque = 'KIA';