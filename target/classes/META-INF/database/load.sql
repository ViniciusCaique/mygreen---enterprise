

INSERT INTO T_G_CLIMA (clima, descricao, temperatura) VALUES ('Muitas nuvens', 'Nublado', 17)
INSERT INTO T_G_CLIMA (clima, descricao, temperatura) VALUES ('Ensolarado', 'Calor', 23)
INSERT INTO T_G_CLIMA (clima, descricao, temperatura) VALUES ('Chuvoso', 'Frio', 10)


INSERT INTO T_G_PLANTA(planta, descricao, tipo) VALUES ('Alface', 'A alface é uma planta herbácea, com um caule diminuto ao qual se prendem as folhas', 'Comestível')
INSERT INTO T_G_PLANTA(planta, descricao, tipo) VALUES ('amoreira', 'A amoreira é um árvore decídua, cujo fruto, a amora, é apreciado no mundo todo. Seu porte é médio, alcançando de 4 a 12 metros de altura.', 'Comestível')
INSERT INTO T_G_PLANTA(planta, descricao, tipo) VALUES ('Limoeira', 'O limoeiro, Citrus limon, é uma planta relativamente pequena e de copa arredondada', 'Comestível')

INSERT INTO T_G_USUARIO(nome, email, senha) VALUES('Fernando', 'Fernando@gmail.com', 'rM74%7^Ocnv%')
INSERT INTO T_G_USUARIO(nome, email, senha) VALUES('Cesar', 'Cesar@gmail.com', 'w4B0!u4bA%&^')
INSERT INTO T_G_USUARIO(nome, email, senha) VALUES('Carlos', 'Carlos@gmail.com', 'dK13z%w6$zXY')


INSERT INTO T_G_CLIMA_ADEQUADO(turno, duracao, id_clima, id_planta) VALUES('Manhã', TO_DATE('2023-03-05', 'YYYY-MM-DD'), 1, 2)
INSERT INTO T_G_CLIMA_ADEQUADO(turno, duracao, id_clima, id_planta) VALUES('Noite', TO_DATE('2022-07-17', 'YYYY-MM-DD'), 3, 1)
INSERT INTO T_G_CLIMA_ADEQUADO(turno, duracao, id_clima, id_planta) VALUES('Tarde', TO_DATE('2021-09-13', 'YYYY-MM-DD'), 2, 3)

INSERT INTO T_G_PLANTACAO(dataPlantacao, quantidadeAgua, fertilizante, id_usuario, id_planta) VALUES(TO_DATE('2022-08-05', 'YYYY-MM-DD'), 70, 1, 1, 2)
INSERT INTO T_G_PLANTACAO(dataPlantacao, quantidadeAgua, fertilizante, id_usuario, id_planta) VALUES(TO_DATE('2021-08-05', 'YYYY-MM-DD'), 100, 0, 1, 2)
INSERT INTO T_G_PLANTACAO(dataPlantacao, quantidadeAgua, fertilizante, id_usuario, id_planta) VALUES(TO_DATE('2023-03-05', 'YYYY-MM-DD'), 80, 0, 1, 2)
