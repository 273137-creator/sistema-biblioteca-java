import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private static final String ARQUIVO = "livros.txt";
    private int proximoId = 1;

    public Biblioteca() {
        carregarDeArquivo();
    }

    public void adicionarLivro(String titulo, String autor, int ano) {
        Livro novo = new Livro(proximoId, titulo, autor, ano);
        livros.add(novo);
        proximoId++;
        salvarEmArquivo();
        System.out.println("Livro cadastrado com sucesso!");
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado ainda.");
            return;
        }
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    public void buscarPorTitulo(String termo) {
        boolean encontrou = false;
        for (Livro livro : livros) {
            if (livro.getTitulo().toLowerCase().contains(termo.toLowerCase())) {
                System.out.println(livro);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum livro encontrado com esse título.");
        }
    }

    public void emprestarLivro(int id) {
        Livro livro = buscarPorId(id);
        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }
        if (!livro.isDisponivel()) {
            System.out.println("Esse livro já está emprestado.");
            return;
        }
        livro.setDisponivel(false);
        salvarEmArquivo();
        System.out.println("Empréstimo registrado: " + livro.getTitulo());
    }

    public void devolverLivro(int id) {
        Livro livro = buscarPorId(id);
        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }
        livro.setDisponivel(true);
        salvarEmArquivo();
        System.out.println("Devolução registrada: " + livro.getTitulo());
    }

    public void removerLivro(int id) {
        Livro livro = buscarPorId(id);
        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }
        livros.remove(livro);
        salvarEmArquivo();
        System.out.println("Livro removido.");
    }

    private Livro buscarPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    private void salvarEmArquivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO))) {
            for (Livro livro : livros) {
                writer.println(livro.paraLinhaArquivo());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    private void carregarDeArquivo() {
        File arquivo = new File(ARQUIVO);
        if (!arquivo.exists()) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.isBlank()) continue;
                Livro livro = Livro.deLinhaArquivo(linha);
                livros.add(livro);
                if (livro.getId() >= proximoId) {
                    proximoId = livro.getId() + 1;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
        }
    }
}