-- INSERT INTO T_USER (id, name, email, password, username) VALUES (1, 'Mateus', 'mateus@nebula', 1234, 'Mateus');

-- ALTER SEQUENCE T_USER_ID_SEQ RESTART WITH 2;

-- INSERT INTO T_PROFILE (id, description) VALUES (1, 'Admin');

-- ALTER SEQUENCE T_PROFILE_SEQ RESTART WITH 2;


INSERT INTO T_USER (ID, NAME, USERNAME, PASSWORD, EMAIL) VALUES (1, 'Mateus', 'Mateus', '1234','mateus@nebula');

ALTER SEQUENCE T_USER_ID_SEQ RESTART WITH 2;

INSERT INTO T_PROFILE (ID, DESCRIPTION) VALUES (1, 'Administrador');
INSERT INTO T_PROFILE (ID, DESCRIPTION) VALUES (2, 'Gerente');
INSERT INTO T_PROFILE (ID, DESCRIPTION) VALUES (3, 'Cliente');



ALTER SEQUENCE T_PROFILE_SEQ RESTART WITH 4;