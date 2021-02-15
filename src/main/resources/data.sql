INSERT INTO tb_cargo(descricao) VALUES('Desenvolvedor Web');
INSERT INTO tb_cargo(descricao) VALUES('Desenvolvedor Java');
INSERT INTO tb_cargo(descricao) VALUES('Desenvolvedor Android');
INSERT INTO tb_cargo(descricao) VALUES('Desenvolvedor IOS');

INSERT INTO tb_servidor(nome, matricula, data_criacao) VALUES('Marcio', 'AA01', '2021-02-14 17:10:10');
INSERT INTO tb_servidor(nome, matricula, data_criacao) VALUES('Alysson', 'AA02', '2021-02-14 18:10:10');
INSERT INTO tb_servidor(nome, matricula, data_criacao) VALUES('Amelia', 'AA03', '2021-02-14 19:10:10');
INSERT INTO tb_servidor(nome, matricula, data_criacao) VALUES('Andre', 'AA04', '2021-02-14 20:10:10');

INSERT INTO tb_servidor_list_cargos(list_servidores_id_servidor, list_cargos_id_cargo) VALUES(1, 1);
INSERT INTO tb_servidor_list_cargos(list_servidores_id_servidor, list_cargos_id_cargo) VALUES(1, 2);
INSERT INTO tb_servidor_list_cargos(list_servidores_id_servidor, list_cargos_id_cargo) VALUES(2, 1);
INSERT INTO tb_servidor_list_cargos(list_servidores_id_servidor, list_cargos_id_cargo) VALUES(2, 2);
INSERT INTO tb_servidor_list_cargos(list_servidores_id_servidor, list_cargos_id_cargo) VALUES(2, 3);
INSERT INTO tb_servidor_list_cargos(list_servidores_id_servidor, list_cargos_id_cargo) VALUES(3, 1);
INSERT INTO tb_servidor_list_cargos(list_servidores_id_servidor, list_cargos_id_cargo) VALUES(3, 2);
INSERT INTO tb_servidor_list_cargos(list_servidores_id_servidor, list_cargos_id_cargo) VALUES(4, 1);
INSERT INTO tb_servidor_list_cargos(list_servidores_id_servidor, list_cargos_id_cargo) VALUES(4, 2);