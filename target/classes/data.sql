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

-- Inserindo Pessoas (Clientes e Colaboradores) para cada capital
-- Rio Branco (AC)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('João Silva', 'M', '68999999999', 12345678901, '1990-01-01', 'Centro', 'Rua A', '69900000', 1, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Maria Oliveira', 'F', '68988888888', 98765432101, '1985-05-15', 'Base', 'Rua B', '69900001', 1, 'ATIVO', 'COLABORADOR');

-- Maceió (AL)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Carlos Souza', 'M', '82999999999', 23456789012, '1988-07-20', 'Ponta Verde', 'Rua C', '57000000', 2, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Ana Costa', 'F', '82888888888', 87654321098, '1992-11-30', 'Jatiúca', 'Rua D', '57000001', 2, 'ATIVO', 'COLABORADOR');

-- Macapá (AP)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Pedro Alves', 'M', '96999999999', 34567890123, '1980-03-25', 'Central', 'Rua E', '68900000', 3, 'ATIVO', 'CLIENTE');
VALUES ('Fernanda Lima', 'F', '96888888888', 76543210987, '1995-09-12', 'Trem', 'Rua F', '68900001', 3, 'ATIVO', 'COLABORADOR');
VALUES ('Lucas Mendes', 'M', '92999999999', 45678901234, '1991-04-18', 'Centro', 'Rua G', '69000000', 4, 'ATIVO', 'CLIENTE');
VALUES ('Juliana Rocha', 'F', '92888888888', 65432109876, '1987-12-05', 'Adrianópolis', 'Rua H', '69000001', 4, 'ATIVO', 'COLABORADOR');

-- Salvador (BA)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Rafael Santos', 'M', '71999999999', 56789012345, '1983-08-22', 'Barra', 'Rua I', '40000000', 5, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Patrícia Almeida', 'F', '71888888888', 54321098765, '1990-02-14', 'Pituba', 'Rua J', '40000001', 5, 'ATIVO', 'COLABORADOR');

-- Fortaleza (CE)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Marcos Oliveira', 'M', '85999999999', 67890123456, '1986-06-30', 'Meireles', 'Rua K', '60000000', 6, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Camila Fernandes', 'F', '85888888888', 43210987654, '1993-10-25', 'Aldeota', 'Rua L', '60000001', 6, 'ATIVO', 'COLABORADOR');

-- Brasília (DF)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Gustavo Lima', 'M', '61999999999', 78901234567, '1984-05-12', 'Asa Sul', 'Rua M', '70000000', 7, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Isabela Martins', 'F', '61888888888', 32109876543, '1991-07-08', 'Asa Norte', 'Rua N', '70000001', 7, 'ATIVO', 'COLABORADOR');

-- Vitória (ES)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Roberto Alves', 'M', '27999999999', 89012345678, '1982-09-17', 'Praia do Canto', 'Rua O', '29000000', 8, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Tatiane Souza', 'F', '27888888888', 21098765432, '1994-03-03', 'Jardim da Penha', 'Rua P', '29000001', 8, 'ATIVO', 'COLABORADOR');

-- Goiânia (GO)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Daniel Costa', 'M', '62999999999', 90123456789, '1989-11-20', 'Setor Bueno', 'Rua Q', '74000000', 9, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Larissa Mendes', 'F', '62888888888', 10987654321, '1996-04-15', 'Setor Marista', 'Rua R', '74000001', 9, 'ATIVO', 'COLABORADOR');

-- São Luís (MA)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Felipe Rocha', 'M', '98999999999', 01234567890, '1981-12-10', 'Renascença', 'Rua S', '65000000', 10, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Vanessa Lima', 'F', '98888888888', 09876543210, '1997-08-22', 'São Francisco', 'Rua T', '65000001', 10, 'ATIVO', 'COLABORADOR');

-- Cuiabá (MT)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Bruno Oliveira', 'M', '65999999999', 12345098765, '1987-02-28', 'Jardim Cuiabá', 'Rua U', '78000000', 11, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Amanda Santos', 'F', '65888888888', 98765012345, '1993-06-14', 'Jardim dos Ipês', 'Rua V', '78000001', 11, 'ATIVO', 'COLABORADOR');

-- Campo Grande (MS)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Ricardo Almeida', 'M', '67999999999', 23456109876, '1985-01-05', 'Centro', 'Rua W', '79000000', 12, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Carolina Fernandes', 'F', '67888888888', 87654123456, '1990-09-30', 'Jardim dos Estados', 'Rua X', '79000001', 12, 'ATIVO', 'COLABORADOR');

-- Belo Horizonte (MG)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Eduardo Lima', 'M', '31999999999', 34567210987, '1983-07-12', 'Savassi', 'Rua Y', '30000000', 13, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Bianca Rocha', 'F', '31888888888', 76543219876, '1995-03-25', 'Lourdes', 'Rua Z', '30000001', 13, 'ATIVO', 'COLABORADOR');

-- Belém (PA)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Marcelo Alves', 'M', '91999999999', 45678321098, '1980-04-18', 'Nazaré', 'Rua AA', '66000000', 14, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Fernanda Costa', 'F', '91888888888', 65432198765, '1992-12-08', 'Umarizal', 'Rua AB', '66000001', 14, 'ATIVO', 'COLABORADOR');

-- João Pessoa (PB)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Thiago Mendes', 'M', '83999999999', 56789432109, '1988-10-22', 'Manaíra', 'Rua AC', '58000000', 15, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Gabriela Oliveira', 'F', '83888888888', 54321987654, '1994-05-17', 'Tambaú', 'Rua AD', '58000001', 15, 'ATIVO', 'COLABORADOR');

-- Curitiba (PR)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Leonardo Souza', 'M', '41999999999', 67890543210, '1986-03-14', 'Batel', 'Rua AE', '80000000', 16, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Mariana Almeida', 'F', '41888888888', 43210987654, '1991-08-29', 'Centro Cívico', 'Rua AF', '80000001', 16, 'ATIVO', 'COLABORADOR');

-- Recife (PE)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Rodrigo Lima', 'M', '81999999999', 78901654321, '1984-09-03', 'Boa Viagem', 'Rua AG', '50000000', 17, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Luciana Fernandes', 'F', '81888888888', 32109876543, '1996-02-12', 'Pina', 'Rua AH', '50000001', 17, 'ATIVO', 'COLABORADOR');

-- Teresina (PI)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Paulo Santos', 'M', '86999999999', 89012765432, '1982-11-25', 'Centro', 'Rua AI', '64000000', 18, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Aline Rocha', 'F', '86888888888', 21098765432, '1993-07-18', 'Jóquei', 'Rua AJ', '64000001', 18, 'ATIVO', 'COLABORADOR');

-- Rio de Janeiro (RJ)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Vinicius Alves', 'M', '21999999999', 90123876543, '1989-06-07', 'Copacabana', 'Rua AK', '22000000', 19, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Patrícia Lima', 'F', '21888888888', 10987654321, '1995-01-22', 'Ipanema', 'Rua AL', '22000001', 19, 'ATIVO', 'COLABORADOR');

-- Natal (RN)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Fábio Costa', 'M', '84999999999', 01234987654, '1981-04-30', 'Ponta Negra', 'Rua AM', '59000000', 20, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Fábio Costa', 'M', '77944555425', 14515457872, '1981-04-30', 'Ponta Negra', 'Rua AM', '59000000', 20, 'ATIVO', 'CLIENTE');

-- Porto Velho (RO)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Marcos Rocha', 'M', '69999999999', 12345678901, '1985-07-18', 'Centro', 'Rua AP', '76800000', 22, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Fernanda Alves', 'F', '69888888888', 98765432101, '1990-11-25', 'Nova Porto Velho', 'Rua AQ', '76800001', 22, 'ATIVO', 'COLABORADOR');

-- Boa Vista (RR)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Ricardo Lima', 'M', '95999999999', 23456789012, '1988-09-30', 'Centro', 'Rua AR', '69300000', 23, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Camila Nascimento', 'F', '95888888888', 87654321098, '1993-04-15', 'Mecejana', 'Rua AS', '69300001', 23, 'ATIVO', 'COLABORADOR');

-- Florianópolis (SC)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Gustavo Rocha', 'M', '48999999999', 34567890123, '1982-12-20', 'Centro', 'Rua AT', '88000000', 24, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Isabela Almeida', 'F', '48888888888', 76543210987, '1995-08-10', 'Trindade', 'Rua AU', '88000001', 24, 'ATIVO', 'COLABORADOR');

-- Aracaju (SE)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Felipe Souza', 'M', '79999999999', 45678901234, '1980-05-25', 'Centro', 'Rua AV', '49000000', 25, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Vanessa Costa', 'F', '79888888888', 65432109876, '1992-10-12', 'Jardins', 'Rua AW', '49000001', 25, 'ATIVO', 'COLABORADOR');

-- Palmas (TO)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Bruno Mendes', 'M', '63999999999', 56789012345, '1987-02-18', 'Centro', 'Rua AX', '77000000', 26, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Amanda Rocha', 'F', '63888888888', 43210987654, '1994-07-22', 'Plano Diretor Norte', 'Rua AY', '77000001', 26, 'ATIVO', 'COLABORADOR');

-- São Paulo (SP)
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Leonardo Alves', 'M', '11999999999', 67890123456, '1986-03-14', 'Centro', 'Rua AZ', '01000000', 27, 'ATIVO', 'CLIENTE');
INSERT INTO pessoa (nome, sexo, telefone, cpf, dataDeNascimento, bairro, logradouro, cep, cidade_id, status, tipo)
VALUES ('Mariana Lima', 'F', '11888888888', 32109876543, '1991-08-29', 'Moema', 'Rua BA', '01000001', 27, 'ATIVO', 'COLABORADOR');