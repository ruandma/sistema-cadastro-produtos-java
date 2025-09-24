public class Produto {
    private String codigo;
    private String nome;
    private String categoria;
    private double preco;
    private int quantidade;

    public Produto(String codigo, String nome, String categoria, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters
    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }

    // Setters
    public void setNome(String nome) { this.nome = nome; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setPreco(double preco) { this.preco = preco; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    @Override
    public String toString() {
        return "Código: " + codigo + " | Nome: " + nome + " | Categoria: " + categoria + 
               " | Preço: R$" + String.format("%.2f", preco) + " | Estoque: " + quantidade;
    }
}