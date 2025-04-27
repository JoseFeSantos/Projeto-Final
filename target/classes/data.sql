-- Inserindo Estados do Brasil
INSERT INTO estado (nome, sigla) VALUES ('Acre', 'AC');
INSERT INTO estado (nome, sigla) VALUES ('Alagoas', 'AL');
INSERT INTO estado (nome, sigla) VALUES ('Amapá', 'AP');
INSERT INTO estado (nome, sigla) VALUES ('Amazonas', 'AM');
INSERT INTO estado (nome, sigla) VALUES ('Bahia', 'BA');
INSERT INTO estado (nome, sigla) VALUES ('Ceará', 'CE');
INSERT INTO estado (nome, sigla) VALUES ('Distrito Federal', 'DF');
INSERT INTO estado (nome, sigla) VALUES ('Espírito Santo', 'ES');
INSERT INTO estado (nome, sigla) VALUES ('Goiás', 'GO');
INSERT INTO estado (nome, sigla) VALUES ('Maranhão', 'MA');
INSERT INTO estado (nome, sigla) VALUES ('Mato Grosso', 'MT');
INSERT INTO estado (nome, sigla) VALUES ('Mato Grosso do Sul', 'MS');
INSERT INTO estado (nome, sigla) VALUES ('Minas Gerais', 'MG');
INSERT INTO estado (nome, sigla) VALUES ('Pará', 'PA');
INSERT INTO estado (nome, sigla) VALUES ('Paraíba', 'PB');
INSERT INTO estado (nome, sigla) VALUES ('Paraná', 'PR');
INSERT INTO estado (nome, sigla) VALUES ('Pernambuco', 'PE');
INSERT INTO estado (nome, sigla) VALUES ('Piauí', 'PI');
INSERT INTO estado (nome, sigla) VALUES ('Rio de Janeiro', 'RJ');
INSERT INTO estado (nome, sigla) VALUES ('Rio Grande do Norte', 'RN');
INSERT INTO estado (nome, sigla) VALUES ('Rio Grande do Sul', 'RS');
INSERT INTO estado (nome, sigla) VALUES ('Rondônia', 'RO');
INSERT INTO estado (nome, sigla) VALUES ('Roraima', 'RR');
INSERT INTO estado (nome, sigla) VALUES ('Santa Catarina', 'SC');
INSERT INTO estado (nome, sigla) VALUES ('São Paulo', 'SP');
INSERT INTO estado (nome, sigla) VALUES ('Sergipe', 'SE');
INSERT INTO estado (nome, sigla) VALUES ('Tocantins', 'TO');

-- Inserindo Capitais dos Estados do Brasil
INSERT INTO cidade (nome, estado_id) VALUES ('Rio Branco', 1);
INSERT INTO cidade (nome, estado_id) VALUES ('Maceió', 2);
INSERT INTO cidade (nome, estado_id) VALUES ('Macapá', 3);
INSERT INTO cidade (nome, estado_id) VALUES ('Manaus', 4);
INSERT INTO cidade (nome, estado_id) VALUES ('Salvador', 5);
INSERT INTO cidade (nome, estado_id) VALUES ('Fortaleza', 6);
INSERT INTO cidade (nome, estado_id) VALUES ('Brasília', 7);
INSERT INTO cidade (nome, estado_id) VALUES ('Vitória', 8);
INSERT INTO cidade (nome, estado_id) VALUES ('Goiânia', 9);
INSERT INTO cidade (nome, estado_id) VALUES ('São Luís', 10);
INSERT INTO cidade (nome, estado_id) VALUES ('Cuiabá', 11);
INSERT INTO cidade (nome, estado_id) VALUES ('Campo Grande', 12);
INSERT INTO cidade (nome, estado_id) VALUES ('Belo Horizonte', 13);
INSERT INTO cidade (nome, estado_id) VALUES ('Belém', 14);
INSERT INTO cidade (nome, estado_id) VALUES ('João Pessoa', 15);
INSERT INTO cidade (nome, estado_id) VALUES ('Curitiba', 16);
INSERT INTO cidade (nome, estado_id) VALUES ('Recife', 17);
INSERT INTO cidade (nome, estado_id) VALUES ('Teresina', 18);
INSERT INTO cidade (nome, estado_id) VALUES ('Rio de Janeiro', 19);
INSERT INTO cidade (nome, estado_id) VALUES ('Natal', 20);
INSERT INTO cidade (nome, estado_id) VALUES ('Porto Alegre', 21);
INSERT INTO cidade (nome, estado_id) VALUES ('Porto Velho', 22);
INSERT INTO cidade (nome, estado_id) VALUES ('Boa Vista', 23);
INSERT INTO cidade (nome, estado_id) VALUES ('Florianópolis', 24);
INSERT INTO cidade (nome, estado_id) VALUES ('São Paulo', 25);
INSERT INTO cidade (nome, estado_id) VALUES ('Aracaju', 26);
INSERT INTO cidade (nome, estado_id) VALUES ('Palmas', 27);

--Dados Bancarios
INSERT INTO banco (codigobanco, nomebanco) VALUES (1, 'Banco do Brasil');
INSERT INTO banco (codigobanco, nomebanco) VALUES (33, 'Banco Santander (Brasil)');
INSERT INTO banco (codigobanco, nomebanco) VALUES (104, 'Caixa Econômica Federal');
INSERT INTO banco (codigobanco, nomebanco) VALUES (237, 'Banco Bradesco');
INSERT INTO banco (codigobanco, nomebanco) VALUES (341, 'Itaú Unibanco');
INSERT INTO banco (codigobanco, nomebanco) VALUES (260, 'Nubank');
INSERT INTO banco (codigobanco, nomebanco) VALUES (77, 'Banco Inter');
INSERT INTO banco (codigobanco, nomebanco) VALUES (655, 'Banco Votorantim');
INSERT INTO banco (codigobanco, nomebanco) VALUES (422, 'Banco Safra');
INSERT INTO banco (codigobanco, nomebanco) VALUES (208, 'BTG Pactual');

--CLIENTES
-- Cliente 1 (Masculino, São Paulo/SP)
INSERT INTO cliente (nome, sexo, cpf, email, telefone, datadenascimento, cep, logradouro, bairro, cidade_id, estado_id)
VALUES ('João Carlos Silva', 'MASCULINO', '123.456.789-09', 'joao.silva@email.com', '(11) 98765-4321', '1985-05-15', '01310-100', 'Avenida Paulista', 'Bela Vista', 25, 25);

-- Cliente 2 (Feminino, Rio de Janeiro/RJ)
INSERT INTO cliente (nome, sexo, cpf, email, telefone, datadenascimento, cep, logradouro, bairro, cidade_id, estado_id)
VALUES ('Maria Oliveira Santos', 'FEMININO', '987.654.321-00', 'maria.santos@email.com', '(21) 99876-5432', '1990-08-22', '20040-010', 'Rua do Ouvidor', 'Centro', 19, 19);

-- Cliente 3 (Masculino, Minas Gerais/MG)
INSERT INTO cliente (nome, sexo, cpf, email, telefone, datadenascimento, cep, logradouro, bairro, cidade_id, estado_id)
VALUES ('Carlos Eduardo Pereira', 'MASCULINO', '456.789.123-45', 'carlos.pereira@email.com', '(31) 98765-1234', '1978-11-30', '30120-010', 'Avenida Afonso Pena', 'Funcionários', 13, 13);

-- Cliente 4 (Feminino, Bahia/BA)
INSERT INTO cliente (nome, sexo, cpf, email, telefone, datadenascimento, cep, logradouro, bairro, cidade_id, estado_id)
VALUES ('Ana Claudia Souza', 'FEMININO', '789.123.456-78', 'ana.souza@email.com', '(71) 98765-6789', '1995-03-10', '40010-010', 'Avenida Sete de Setembro', 'Comércio', 5, 5);

-- Cliente 5 (Feminino, Paraná/PR)
INSERT INTO cliente (nome, sexo, cpf, email, telefone, datadenascimento, cep, logradouro, bairro, cidade_id, estado_id)
VALUES ('Patricia Lima Costa', 'FEMININO', '321.654.987-32', 'patricia.costa@email.com', '(41) 98765-9876', '1988-07-18', '80010-010', 'Rua XV de Novembro', 'Centro', 16, 16);

-- Cliente 6 (Masculino, Pernambuco/PE)
INSERT INTO cliente (nome, sexo, cpf, email, telefone, datadenascimento, cep, logradouro, bairro, cidade_id, estado_id)
VALUES ('Ricardo Almeida Santos', 'MASCULINO', '654.321.987-65', 'ricardo.santos@email.com', '(81) 98765-3456', '1992-09-25', '50010-010', 'Avenida Conde da Boa Vista', 'São José', 17, 17);

-- Cliente 7 (Feminino, Rio Grande do Sul/RS)
INSERT INTO cliente (nome, sexo, cpf, email, telefone, datadenascimento, cep, logradouro, bairro, cidade_id, estado_id)
VALUES ('Fernanda Rocha Oliveira', 'FEMININO', '147.258.369-14', 'fernanda.oliveira@email.com', '(51) 98765-7412', '1980-12-05', '90010-010', 'Avenida Borges de Medeiros', 'Centro Histórico', 21, 21);

-- Cliente 8 (Masculino, Ceará/CE)
INSERT INTO cliente (nome, sexo, cpf, email, telefone, datadenascimento, cep, logradouro, bairro, cidade_id, estado_id)
VALUES ('Lucas Mendes Costa', 'MASCULINO', '258.369.147-25', 'lucas.costa@email.com', '(85) 98765-8523', '1998-04-12', '60010-010', 'Avenida Dom Manuel', 'Centro', 6, 6);

-- Cliente 9 (Feminino, Santa Catarina/SC)
INSERT INTO cliente (nome, sexo, cpf, email, telefone, datadenascimento, cep, logradouro, bairro, cidade_id, estado_id)
VALUES ('Amanda Torres Silva', 'FEMININO', '369.147.258-36', 'amanda.silva@email.com', '(48) 98765-9632', '1987-06-20', '88010-010', 'Rua Felipe Schmidt', 'Centro', 24, 24);

-- Cliente 10 (Masculino, Goiás/GO)
INSERT INTO cliente (nome, sexo, cpf, email, telefone, datadenascimento, cep, logradouro, bairro, cidade_id, estado_id)
VALUES ('Roberto Nunes Alves', 'MASCULINO', '951.753.852-96', 'roberto.alves@email.com', '(62) 98765-1597', '1975-01-15', '74010-010', 'Avenida Goiás', 'Setor Central', 9, 9);

--COLABORADORES
-- Colaborador 1 (São Paulo/SP - Itaú)
INSERT INTO colaborador (nome, cpf, email, telefone, datadenascimento, dadosbancarios_id, agencia, conta, tipoconta, cep, logradouro, bairro, cidade_id, estado_id)
VALUES ('Lucas Oliveira', 12345678901, 'lucas.oliveira@empresa.com', '(11) 98765-1234', '1988-07-15', 341, 1234, 567890, 'CORRENTE', '01310-000', 'Avenida Paulista', 'Bela Vista', 25, 25);

-- Colaborador 2 (Rio de Janeiro/RJ - Bradesco)
INSERT INTO colaborador (nome, cpf, email, telefone, datadenascimento, dadosbancarios_id, agencia, conta, tipoconta, cep, logradouro, bairro, cidade_id, estado_id)
VALUES ('Fernanda Santos', 98765432109, 'fernanda.santos@empresa.com', '(21) 99876-5432', '1992-05-22', 237, 4567, 123456, 'POUPANCA', '20040-010', 'Rua do Ouvidor', 'Centro', 19, 19);

-- Colaborador 3 (Minas Gerais/MG - Banco do Brasil)
INSERT INTO colaborador (nome, cpf, email, telefone, datadenascimento, dadosbancarios_id, agencia, conta, tipoconta, cep, logradouro, bairro, cidade_id, estado_id)
VALUES ('Ricardo Pereira', 45678912345, 'ricardo.pereira@empresa.com', '(31) 98765-6789', '1985-11-30', 1, 7890, 345678, 'CORRENTE', '30120-010', 'Avenida Afonso Pena', 'Funcionários', 13, 13);

-- Colaborador 4 (Bahia/BA - Nubank)
INSERT INTO colaborador (nome, cpf, email, telefone, datadenascimento, dadosbancarios_id, agencia, conta, tipoconta, cep, logradouro, bairro, cidade_id, estado_id)
VALUES ('Amanda Costa', 78912345678, 'amanda.costa@empresa.com', '(71) 98765-9012', '1990-03-10', 260, 1234, 789012, 'CORRENTE', '40010-010', 'Avenida Sete de Setembro', 'Comércio', 5, 5);

-- Colaborador 5 (Paraná/PR - Santander)
INSERT INTO colaborador (nome, cpf, email, telefone, datadenascimento, dadosbancarios_id, agencia, conta, tipoconta, cep, logradouro, bairro, cidade_id, estado_id)
VALUES ('Roberto Almeida', 32165498732, 'roberto.almeida@empresa.com', '(41) 98765-3456', '1987-09-18', 33, 5678, 901234, 'SALARIO', '80010-010', 'Rua XV de Novembro', 'Centro', 16, 16);

-- Colaborador 6 (Pernambuco/PE - Caixa Econômica)
INSERT INTO colaborador (nome, cpf, email, telefone, datadenascimento, dadosbancarios_id, agencia, conta, tipoconta, cep, logradouro, bairro, cidade_id, estado_id)
VALUES ('Patricia Souza', 65432198765, 'patricia.souza@empresa.com', '(81) 98765-7890', '1995-12-25', 104, 9012, 567890, 'CORRENTE', '50010-010', 'Avenida Conde da Boa Vista', 'São José', 17, 17);

-- Colaborador 7 (Rio Grande do Sul/RS - Banco Inter)
INSERT INTO colaborador (nome, cpf, email, telefone, datadenascimento, dadosbancarios_id, agencia, conta, tipoconta, cep, logradouro, bairro, cidade_id, estado_id)
VALUES ('Carlos Mendes', 14725836914, 'carlos.mendes@empresa.com', '(51) 98765-2345', '1980-02-05', 77, 3456, 123456, 'POUPANCA', '90010-010', 'Avenida Borges de Medeiros', 'Centro Histórico', 21, 21);

-- Colaborador 8 (Ceará/CE - Banco Safra)
INSERT INTO colaborador (nome, cpf, email, telefone, datadenascimento, dadosbancarios_id, agencia, conta, tipoconta, cep, logradouro, bairro, cidade_id, estado_id)
VALUES ('Juliana Rocha', 25836914725, 'juliana.rocha@empresa.com', '(85) 98765-6789', '1998-06-12', 422, 7890, 345678, 'CORRENTE', '60010-010', 'Avenida Dom Manuel', 'Centro', 6, 6);

-- Colaborador 9 (Santa Catarina/SC - BTG Pactual)
INSERT INTO colaborador (nome, cpf, email, telefone, datadenascimento, dadosbancarios_id, agencia, conta, tipoconta, cep, logradouro, bairro, cidade_id, estado_id)
VALUES ('Gabriel Torres', 36914725836, 'gabriel.torres@empresa.com', '(48) 98765-0123', '1987-04-20', 208, 1234, 789012, 'SALARIO', '88010-010', 'Rua Felipe Schmidt', 'Centro', 24, 24);

-- Colaborador 10 (Goiás/GO - Votorantim)
INSERT INTO colaborador (nome, cpf, email, telefone, datadenascimento, dadosbancarios_id, agencia, conta, tipoconta, cep, logradouro, bairro, cidade_id, estado_id)
VALUES ('Ana Nunes', 95175385296, 'ana.nunes@empresa.com', '(62) 98765-4567', '1975-08-15', 655, 5678, 901234, 'CORRENTE', '74010-010', 'Avenida Goiás', 'Setor Central', 9, 9);

--CATEGORIA DE SERVIÇO
-- Categoria 1: Serviços de Informática
INSERT INTO categoriaservico (nome) VALUES ('Informática');

-- Categoria 2: Serviços Elétricos
INSERT INTO categoriaservico (nome) VALUES ('Serviços Elétricos');

-- Categoria 3: Serviços de Construção
INSERT INTO categoriaservico (nome) VALUES ('Construção');

-- Categoria 4: Serviços Automotivos
INSERT INTO categoriaservico (nome) VALUES ('Automotores');

-- Categoria 5: Serviços de Beleza
INSERT INTO categoriaservico (nome) VALUES ('Beleza');

-- Categoria 6: Serviços de Limpeza
INSERT INTO categoriaservico (nome) VALUES ('Limpeza');

-- Categoria 7: Serviços de Saúde
INSERT INTO categoriaservico (nome) VALUES ('Saúde');

-- Categoria 8: Serviços de Educação
INSERT INTO categoriaservico (nome) VALUES ('Educação');

-- Categoria 9: Serviços de Consultoria
INSERT INTO categoriaservico (nome) VALUES ('Consultoria');

-- Categoria 10: Serviços de Entregas
INSERT INTO categoriaservico (nome) VALUES ('Entregas');