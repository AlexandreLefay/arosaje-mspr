INSERT INTO user (code_postal, numero, rue, ville, first_name, last_name, mail, password, phone, pseudo)
VALUES
    ('75001', '10', 'Rue de Rivoli', 'Paris', 'Alice', 'Dubois', 'alice.dubois@example.com', 'password123', '0123456781', 'alice01'),
    ('69002', '25', 'Rue de la République', 'Lyon', 'Bruno', 'Leroy', 'bruno.leroy@example.com', 'password456', '0123456782', 'bruno69'),
    ('13003', '40', 'La Canebière', 'Marseille', 'Clara', 'Martin', 'clara.martin@example.com', 'password789', '0123456783', 'claramars'),
    ('31000', '55', 'Rue de Metz', 'Toulouse', 'David', 'Bernard', 'david.bernard@example.com', 'password101', '0123456784', 'david31'),
    ('33000', '70', 'Rue Sainte-Catherine', 'Bordeaux', 'Eva', 'Petit', 'eva.petit@example.com', 'password202', '0123456785', 'eva33');

INSERT INTO plant (id_user, description, name)
VALUES
    (1, 'Petite plante verte adaptée aux espaces intérieurs', 'Ficus'),
    (1, 'Plante grasse nécessitant de l\'attention', 'Cactus'),
    (2, 'Fleur colorée parfaite pour les jardins', 'Tulipe'),
    (3, 'Arbuste à fleurs idéal pour les haies', 'Hortensia'),
    (4, 'Plante d\'intérieur à grandes feuilles', 'Monstera'),
    (4, 'Plante aromatique pour la cuisine', 'Basilic'),
    (5, 'Fleur élégante et délicate', 'Orchidée'),
    (5, 'Plante grimpante à fleurs', 'Clématite');