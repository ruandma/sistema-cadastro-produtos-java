import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoService {

    private List<Produto> produtos;

    public ProdutoService() {
        this.produtos = ArquivoUtil.carregarProdutos();
    }

    private void salvarEmArquivo() {
        ArquivoUtil.salvarProdutos(produtos);
    }

    public void cadastrar(String codigo, String nome, String categoria, double preco, int quantidade) {
        if (buscarPorCodigo(codigo) != null) {
            System.out.println("Erro: Já existe um produto com o código '" + codigo + "'.");
            return;
        }
        Produto novoProduto = new Produto(codigo, nome, categoria, preco, quantidade);
        produtos.add(novoProduto);
        salvarEmArquivo();
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void listarTodos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("\n=== Lista de Produtos ===");
            produtos.forEach(System.out::println);
        }
    }

    public Produto buscarPorCodigo(String codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    public List<Produto> buscarPorNome(String nome) {
        return produtos.stream()
                .filter(p -> p.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Produto> buscarPorCategoria(String categoria) {
        return produtos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }

    public void atualizar(String codigo, String nome, String categoria, double preco, int quantidade) {
        Produto p = buscarPorCodigo(codigo);
        if (p == null) {
            System.out.println("Produto com código '" + codigo + "' não encontrado.");
            return;
        }
        p.setNome(nome);
        p.setCategoria(categoria);
        p.setPreco(preco);
        p.setQuantidade(quantidade);
        salvarEmArquivo();
        System.out.println("Produto atualizado com sucesso!");
    }

    public void excluir(String codigo) {
        Produto p = buscarPorCodigo(codigo);
        if (p == null) {
            System.out.println("Produto com código '" + codigo + "' não encontrado.");
            return;
        }
        produtos.remove(p);
        salvarEmArquivo();
        System.out.println("Produto excluído com sucesso!");
    }

    public void buscarPorTermo(String termo) {
        List<Produto> resultados = new ArrayList<>();

        Produto porCodigo = buscarPorCodigo(termo);
        if (porCodigo != null) {
            resultados.add(porCodigo);
        }

        resultados.addAll(buscarPorNome(termo));
        resultados.addAll(buscarPorCategoria(termo));

        // Remove duplicatas
        resultados = resultados.stream().distinct().collect(Collectors.toList());

        if (resultados.isEmpty()) {
            System.out.println("Nenhum produto encontrado com o termo: " + termo);
        } else {
            System.out.println("\n=== Resultados da busca por '" + termo + "' ===");
            resultados.forEach(System.out::println);
        }
    }
}