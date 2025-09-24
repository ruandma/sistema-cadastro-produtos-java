import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProdutoService service = new ProdutoService();
        int opcao = -1;

        do {
            System.out.println("\n==================================================");
            System.out.println("         SISTEMA DE CADASTRO DE PRODUTOS");
            System.out.println("==================================================");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Listar todos os produtos");
            System.out.println("3. Buscar por código, nome ou categoria");
            System.out.println("4. Atualizar produto");
            System.out.println("5. Excluir produto");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarProduto(sc, service);
                    break;
                case 2:
                    service.listarTodos();
                    break;
                case 3:
                    System.out.print("Digite o termo de busca (código, nome ou categoria): ");
                    String termo = sc.nextLine().trim();
                    if (termo.isEmpty()) {
                        System.out.println("Termo de busca não pode ser vazio.");
                    } else {
                        service.buscarPorTermo(termo);
                    }
                    break;
                case 4:
                    atualizarProduto(sc, service);
                    break;
                case 5:
                    excluirProduto(sc, service);
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        sc.close();
    }

    private static void cadastrarProduto(Scanner sc, ProdutoService service) {
        System.out.print("Código do produto: ");
        String codigo = sc.nextLine().trim();
        if (codigo.isEmpty()) {
            System.out.println("Código não pode ser vazio.");
            return;
        }

        System.out.print("Nome do produto: ");
        String nome = sc.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("Nome não pode ser vazio.");
            return;
        }

        System.out.print("Categoria: ");
        String categoria = sc.nextLine().trim();
        if (categoria.isEmpty()) {
            System.out.println("Categoria não pode ser vazia.");
            return;
        }

        System.out.print("Preço (ex: 19.90): ");
        double preco;
        try {
            preco = Double.parseDouble(sc.nextLine().trim());
            if (preco < 0) {
                System.out.println("Preço não pode ser negativo.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Preço inválido.");
            return;
        }

        System.out.print("Quantidade em estoque: ");
        int quantidade;
        try {
            quantidade = Integer.parseInt(sc.nextLine().trim());
            if (quantidade < 0) {
                System.out.println("Quantidade não pode ser negativa.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Quantidade inválida.");
            return;
        }

        service.cadastrar(codigo, nome, categoria, preco, quantidade);
    }

    private static void atualizarProduto(Scanner sc, ProdutoService service) {
        System.out.print("Digite o código do produto a ser atualizado: ");
        String codigo = sc.nextLine().trim();
        if (codigo.isEmpty()) {
            System.out.println("Código não pode ser vazio.");
            return;
        }

        if (service.buscarPorCodigo(codigo) == null) {
            System.out.println("Produto com código '" + codigo + "' não encontrado.");
            return;
        }

        System.out.print("Novo nome: ");
        String nome = sc.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("Nome não pode ser vazio.");
            return;
        }

        System.out.print("Nova categoria: ");
        String categoria = sc.nextLine().trim();
        if (categoria.isEmpty()) {
            System.out.println("Categoria não pode ser vazia.");
            return;
        }

        System.out.print("Novo preço: ");
        double preco;
        try {
            preco = Double.parseDouble(sc.nextLine().trim());
            if (preco < 0) {
                System.out.println("Preço não pode ser negativo.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Preço inválido.");
            return;
        }

        System.out.print("Nova quantidade: ");
        int quantidade;
        try {
            quantidade = Integer.parseInt(sc.nextLine().trim());
            if (quantidade < 0) {
                System.out.println("Quantidade não pode ser negativa.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Quantidade inválida.");
            return;
        }

        service.atualizar(codigo, nome, categoria, preco, quantidade);
    }

    private static void excluirProduto(Scanner sc, ProdutoService service) {
        System.out.print("Digite o código do produto a ser excluído: ");
        String codigo = sc.nextLine().trim();
        if (codigo.isEmpty()) {
            System.out.println("Código não pode ser vazio.");
            return;
        }
        service.excluir(codigo);
    }
}