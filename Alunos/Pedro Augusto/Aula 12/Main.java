import java.util.*;
import java.util.stream.*;

public class Main {

    // ATV4 - Classe Produto
    static class Produto {
        private String nome;
        private double preco;

        public Produto(String nome, double preco) {
            this.nome = nome;
            this.preco = preco;
        }

        public String getNome() { return nome; }
        public double getPreco() { return preco; }

        @Override
        public String toString() {
            return nome + " - R$ " + String.format("%.2f", preco);
        }
    }

    // ATV1
    static void atividadeUm(Scanner sc) {
        System.out.println("\n=== ATV1: Filtrar números pares ===");
        System.out.print("Digite ao menos 8 números inteiros separados por espaço: ");
        String linha = sc.nextLine();

        List<Integer> numeros = Arrays.stream(linha.trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (numeros.size() < 8) {
            System.out.println("Atenção: você digitou menos de 8 números.");
        }

        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Números pares: " + pares);
    }

    // ATV2
    static void atividadeDois() {
        System.out.println("\n=== ATV2: Converter nomes para maiúsculas ===");
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");

        List<String> maiusculos = nomes.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Nomes originais: " + nomes);
        System.out.println("Nomes em maiúsculas: " + maiusculos);
    }

    // ATV3
    static void atividadeTres() {
        System.out.println("\n=== ATV3: Contar ocorrências de palavras ===");
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");

        Map<String, Long> contagem = palavras.stream()
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()));

        System.out.println("Lista: " + palavras);
        System.out.println("Contagem por palavra:");
        contagem.forEach((palavra, qtd) -> System.out.println("  \"" + palavra + "\": " + qtd + " vez(es)"));
    }

    // ATV4
    static List<Produto> criarListaProdutos() {
        return Arrays.asList(
                new Produto("Notebook", 3500.00),
                new Produto("Mouse", 79.90),
                new Produto("Teclado", 149.90),
                new Produto("Headset", 49.90)
        );
    }

    static void atividadeQuatro() {
        System.out.println("\n=== ATV4: Filtrar produtos com preço > R$ 100,00 ===");
        List<Produto> produtos = criarListaProdutos();

        List<Produto> filtrados = produtos.stream()
                .filter(p -> p.getPreco() > 100.00)
                .collect(Collectors.toList());

        System.out.println("Todos os produtos:");
        produtos.forEach(p -> System.out.println("  " + p));
        System.out.println("Produtos acima de R$ 100,00:");
        filtrados.forEach(p -> System.out.println("  " + p));
    }

    // ATV5
    static void atividadeCinco() {
        System.out.println("\n=== ATV5: Soma total dos produtos ===");
        List<Produto> produtos = criarListaProdutos();

        double total = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();

        System.out.println("Produtos:");
        produtos.forEach(p -> System.out.println("  " + p));
        System.out.printf("Valor total: R$ %.2f%n", total);
    }

    // ATV6
    static void atividadeSeis() {
        System.out.println("\n=== ATV6: Ordenar linguagens por tamanho do nome ===");
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");

        List<String> ordenadas = linguagens.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        System.out.println("Lista original: " + linguagens);
        System.out.println("Ordenada por tamanho (menor → maior): " + ordenadas);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("============================================");
        System.out.println("  Sistema de Atividades - Stream API Java   ");
        System.out.println("============================================");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha a atividade que deseja executar:");
            System.out.println("  1 - Filtrar números pares de uma lista");
            System.out.println("  2 - Converter nomes para maiúsculas");
            System.out.println("  3 - Contar ocorrências de palavras");
            System.out.println("  4 - Filtrar produtos com preço > R$ 100,00");
            System.out.println("  5 - Somar valor total dos produtos");
            System.out.println("  6 - Ordenar linguagens por tamanho do nome");
            System.out.println("  0 - Sair");
            System.out.print("Opção: ");

            String opcao = sc.nextLine().trim();

            switch (opcao) {
                case "1": atividadeUm(sc); break;
                case "2": atividadeDois(); break;
                case "3": atividadeTres(); break;
                case "4": atividadeQuatro(); break;
                case "5": atividadeCinco(); break;
                case "6": atividadeSeis(); break;
                case "0":
                    System.out.println("Encerrando...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        sc.close();
    }
}
