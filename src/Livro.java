public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private boolean disponivel;

    public Livro(int id, String titulo, String autor, int anoPublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        String status = disponivel ? "Disponível" : "Emprestado";
        return String.format("[%d] %s - %s (%d) | %s", id, titulo, autor, anoPublicacao, status);
    }

    // Converte o livro para uma linha de texto, usada para salvar em arquivo
    public String paraLinhaArquivo() {
        return id + ";" + titulo + ";" + autor + ";" + anoPublicacao + ";" + disponivel;
    }

    // Recria um objeto Livro a partir de uma linha lida do arquivo
    public static Livro deLinhaArquivo(String linha) {
        String[] partes = linha.split(";");
        Livro livro = new Livro(
                Integer.parseInt(partes[0]),
                partes[1],
                partes[2],
                Integer.parseInt(partes[3])
        );
        livro.setDisponivel(Boolean.parseBoolean(partes[4]));
        return livro;
    }
}