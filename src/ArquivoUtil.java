import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtil {

    private static final String ARQUIVO = "produtos.txt";

    public static void salvarProdutos(List<Produto> produtos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO))) {
            for (Produto p : produtos) {
                writer.println(p.getCodigo() + ";" + p.getNome() + ";" + p.getCategoria() + ";" + p.getPreco() + ";" + p.getQuantidade());
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar produtos: " + e.getMessage());
        }
    }

    public static List<Produto> carregarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        File arquivo = new File(ARQUIVO);

        if (!arquivo.exists()) {
            return produtos;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 5) {
                    String codigo = partes[0];
                    String nome = partes[1];
                    String categoria = partes[2];
                    double preco = Double.parseDouble(partes[3]);
                    int quantidade = Integer.parseInt(partes[4]);
                    produtos.add(new Produto(codigo, nome, categoria, preco, quantidade));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Erro ao carregar produtos: " + e.getMessage());
        }

        return produtos;
    }
}