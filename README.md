# Sistema de Biblioteca — Java

Sistema de gerenciamento de biblioteca via linha de comando (CLI), desenvolvido em Java puro, utilizando orientação a objetos, coleções e persistência de dados em arquivo.

## Funcionalidades

- Cadastrar livros (título, autor, ano de publicação)
- Listar todos os livros cadastrados
- Buscar livro por título
- Registrar empréstimo de um livro
- Registrar devolução de um livro
- Remover livro do acervo
- Os dados são salvos automaticamente em um arquivo de texto (`livros.txt`), preservando o estado entre execuções

## Tecnologias e conceitos utilizados

- Java (JDK)
- Programação Orientada a Objetos (classes, encapsulamento)
- Collections Framework (`ArrayList`)
- Manipulação de arquivos (`java.io`: `BufferedReader`, `FileWriter`)
- Entrada de dados via `Scanner`

## Como executar o projeto

1. Clone o repositório:
```bash
   git clone https://github.com/273137-creator/sistema-biblioteca-java.git
```
2. Abra a pasta no IntelliJ IDEA (ou outra IDE de sua preferência)
3. Execute a classe `Main.java`

## Estrutura do projeto

```
src/
├── Livro.java        -> representa um livro (atributos e conversão para/de arquivo)
├── Biblioteca.java    -> lógica de negócio (cadastrar, listar, emprestar, devolver, remover)
└── Main.java          -> menu interativo via terminal
```


## Próximos passos (melhorias futuras)

- Migrar a persistência de arquivo texto para um banco de dados MySQL
- Adicionar cadastro de usuários/membros da biblioteca
- Validar duplicidade de livros

---
Projeto desenvolvido por Matheus da Silva Gomes como parte dos estudos em Engenharia de Software.