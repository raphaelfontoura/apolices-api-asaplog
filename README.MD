# Projeto de demonstração ApoliceAsap

> Sistema API Rest utilizando Java 11, SpringBoot, MongoDB e React com Bootstrap para teste prático de desenvolvimento de sistemas.

### Tecnologias

![](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![](https://img.shields.io/badge/TypeScript-007ACC?style=for-the-badge&logo=typescript&logoColor=white)

![](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)
![](https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white)

![](https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white)

----

### Rodando o projeto.
1. Primeiro rode o MongoDB utiliando o Docker:
```bash
$ docker run -d -p 27017:27017 -v /data/db --name mongo1 mongo:4.4.3-bionic
```
2. Entre na pasta backend e execute o projeto spring.
```bash
$ ./mvnw spring-boot:run
```

3. Com outro terminal, acesse a pasta do frontend e instale as dependências:
```bash
$ yarn install
```

4. Após a conclusão da instalação, execute o projeto com o comando:
```bash
$ yarn start
```

Acesse o browser no localhost:3000 e navegue nas opções clientes e apolices.

Espero que se divirta tanto quanto me diverti (mesmo com algumas dores de cabeça :laughing: ).