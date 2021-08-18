SELECT * FROM tipo_documento;
insert into tipo_documento(id, nome) values
(1, "CI"),(2, "CIRCULAR"),(3, "OFICIO");
SELECT * FROM coordenacao;
insert into coordenacao (id, nome) values 
(1, "SISTEMAS"), (2, "REDES"), (3, "SUPORTE"), (4, "DIRECAO");
select * from perfil;
insert into usuario (id, email, nome, senha, coordenacao_id) values
(1, "root@root.com", "ROOT", "root123", 1 ),
(2, "admin@admin.com", "ADMIN", "admin123", 1 ),
(3, "tester@tester.com", "TESTER", "tester123", 3);

select * from perfil;
insert into perfil(id, nome) values
(1, "ROOT"),
(2, "ADMIN"),
(3, "TESTER");

select * from documento;

insert into documento(id, assunto, conteudo, date, destino, tipo_documento_id, usuario_id, coordenacao_id) values
(),
();

select * from usuario;
insert into usuario_perfis(usuario_id, perfis_id) values
(4, 3);

SELECT *
FROM documento
INNER JOIN tipo_documento ON documento.tipo_documento_id = tipo_documento.id
INNER join usuario on documento.usuario_id = usuario.id
where coordenacao_id = 3;