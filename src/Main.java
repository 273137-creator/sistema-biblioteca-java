import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE BIBLIOTECA =====");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Listar todos os livros");
            System.out.println("3. Buscar livro por título");
            System.out.println("4. Emprestar livro");
            System.out.println("5. Devolver livro");
            System.out.println("6. Remover livro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = lerInteiro(scanner);

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ano de publicação: ");
                    int ano = lerInteiro(scanner);
                    biblioteca.adicionarLivro(titulo, autor, ano);
                    break;

                case 2:
                    biblioteca.listarLivros();
                    break;

                case 3:
                    System.out.print("Digite parte do título: ");
                    String termo = scanner.nextLine();
                    biblioteca.buscarPorTitulo(termo);
                    break;

                case 4:
                    System.out.print("ID do livro para emprestar: ");
                    int idEmprestimo = lerInteiro(scanner);
                    biblioteca.emprestarLivro(idEmprestimo);
                    break;

                case 5:
                    System.out.print("ID do livro para devolver: ");
                    int idDevolucao = lerInteiro(scanner);
                    biblioteca.devolverLivro(idDevolucao);
                    break;

                case 6:
                    System.out.print("ID do livro para remover: ");
                    int idRemover = lerInteiro(scanner);
                    biblioteca.removerLivro(idRemover);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static int lerInteiro(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Digite um número válido: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // limpa a quebra de linha pendente
        return valor;
    }
}