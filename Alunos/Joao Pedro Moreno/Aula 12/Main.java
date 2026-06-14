import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
    
    //Atv1
    ArrayList<Integer> numeros = new ArrayList<>();

    for (int i = 1; i <= 10; i++) {
        numeros.add(i);
    }

    ArrayList<Integer> numerosPares = numeros.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toCollection(ArrayList::new));
            System.out.println("Atv1: " + numerosPares + "\n");

    
    //Atv2
    ArrayList<String> nomes = new ArrayList<>();

    nomes.add("roberto");
    nomes.add("josé");
    nomes.add("caio");
    nomes.add("vinicius");

    ArrayList<String> nomesMaiusculos = nomes.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toCollection(ArrayList::new));
            System.out.println("Atv2: " + nomesMaiusculos + "\n");

    //Atv3 - Crie um programa que conte quantas vezes cada palavra única aparece em uma lista de strings. Utilize a Stream API para processar os dados. Lista de palavras("se", "talvez", "hoje" "sábado", "se", "quarta", "sábado")
    ArrayList<String> palavras = new ArrayList<>();
    palavras.add("se");
    palavras.add("talvez");
    palavras.add("hoje");
    palavras.add("sábado");
    palavras.add("se");
    palavras.add("quarta");
    palavras.add("sábado");

    System.out.println("Atv3: Contagem de palavras:");
    palavras.stream()
            .collect(Collectors.groupingBy(p -> p, Collectors.counting()))
            .forEach((palavra, contagem) -> System.out.println(palavra + ": " + contagem));

    //Atv4 - Crie uma Classe Produto, ela possui os atributos nome e preço. Crie uma lista com 4 objetos do tipo Produto, pode definir os valores diretamente no código("hard coded"). Escreva um programa que filtre os produtos cujo preço seja maior que R$ 100,00 utilizando a Stream API.
    ArrayList<Produto> produtos = new ArrayList<>();
    produtos.add(new Produto("Produto A", 50.0));
    produtos.add(new Produto("Produto B", 150.0));
    produtos.add(new Produto("Produto C", 200.0));
    produtos.add(new Produto("Produto D", 80.0));

    ArrayList<Produto> produtosFiltrados = produtos.stream()
            .filter(p -> p.getPreco() > 100.0)
            .collect(Collectors.toCollection(ArrayList::new));
            System.out.println("\nAtv4: Produtos com preço maior que R$ 100,00:");
            produtosFiltrados.forEach(p -> System.out.println(p.getNome() + " - R$ " + p.getPreco()));

    //Atv5 - Realize a soma do valor total dos Produtos que estão na lista de produtos criados na atv4, realize essa soma utilizando Stream API.
    double somaTotal = produtos.stream()
            .mapToDouble(Produto::getPreco)
            .sum();
    System.out.println("\nAtv5: Soma total dos produtos: R$ " + somaTotal);

    //Atv6- Dada a lista("Java", "Python", "C", "JavaScript", "Ruby"), ordene a mesma conforme o tamanho da palavra, da menor para a maior, utilizando a Stream API.
    ArrayList<String> linguagens = new ArrayList<>();
    linguagens.add("Java");
    linguagens.add("Python");
    linguagens.add("C");
    linguagens.add("JavaScript");
    linguagens.add("Ruby");

    ArrayList<String> linguagensOrdenadas = linguagens.stream()
            .sorted((l1, l2) -> Integer.compare(l1.length(), l2.length()))
            .collect(Collectors.toCollection(ArrayList::new));
    System.out.println("\nAtv6: Linguagens ordenadas pelo tamanho:");
    linguagensOrdenadas.forEach(System.out::println);

    }
}



