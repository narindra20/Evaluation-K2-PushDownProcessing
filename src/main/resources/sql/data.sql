INSERT INTO Modele_voiture (marque, modele) VALUES
('KIA', 'GETZ'),
('HYUNDAI', 'PRIDE'),
('DAEWOO', 'LACETTI'),
('KIA', 'PRIDE'),
('HYUNDAI', 'GETZ');

INSERT INTO Piece_auto (id_modele_voiture, numero_serie, prix) VALUES
(1, 'SERIE-KG001', 120.50),
(2, 'SERIE-HP002', 85.00),
(3, 'SERIE-DL003', 200.75),
(4, 'SERIE-KP004', 150.00),
(5, 'SERIE-HG005', 95.25);

INSERT INTO Vente (id_piece_auto, quantite) VALUES
(1, 3),
(2, 5),
(3, 2),
(1, 1),
(5, 4);