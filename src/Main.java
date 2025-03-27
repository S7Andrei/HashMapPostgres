import java.util.Scanner;
import java.util.UUID;
import java.util.Optional;

import entities.Product;
import repository.HashMapRepository;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMapRepository<Product> productRepository = new HashMapRepository<>();

        int option;

        do {
            System.out.println("\033[H\033[2J");
            System.out.flush();

            System.out.println("\n---MENU---");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Buscar Produto");
            System.out.println("3 - Sair");
            System.out.println("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Cadastrar Produto");
                    System.out.print("Nome do Produto: ");
                    String name = scanner.nextLine();
                    System.out.print("Preço do Produto: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    Product product = new Product(name, price);
                    productRepository.save(product);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("Buscar Produto");
                    System.out.print("ID do Produto: ");
                    String id = scanner.nextLine();
                    Optional<Product> foundProduct = productRepository.findById(UUID.fromString(id));
                    if (foundProduct.isPresent()) {
                        System.out.println("Produto encontrado: " + foundProduct.get().getName() + " - " + foundProduct.get().getPrice());
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente");
            }

        } while (option != 3);

        scanner.close();
    }
}