package esercizio;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class MainShop {
    public static void main(String[] args) {

        // CLIENTI
        Customer c1 = new Customer(18756L, "Mario", 1);
        Customer c2 = new Customer(35246L, "Mario", 2);
        Customer c3 = new Customer(56438L, "Mario", 1);

        // PRODOTTI

        Product p1 = new Product(1L, "Romanzo", "Books", 120.0);
        Product p2 = new Product(2L, "Ciuccio", "Baby", 20.0);
        Product p3 = new Product(3L, "Gioco", "Toys", 45.0);
        Product p4 = new Product(4L, "Libro scolastico", "Books", 80.0);
        Product p5 = new Product(5L, "Peluche", "Baby", 35.0);
        Product p6 = new Product(6L, "Maglietta", "Boys", 25.0);

        //ORDINI

        Order o1 = new Order(875463L, "shipped", LocalDate.of(2021, 2, 15), LocalDate.of(2021, 2, 20), Arrays.asList(p1,p2), c1);
        Order o2 = new Order(
                2L, "pending",
                LocalDate.of(2021, 3, 10),
                LocalDate.of(2021, 3, 15),
                Arrays.asList(p3, p5),
                c2
        );

        Order o3 = new Order(
                3L, "delivered",
                LocalDate.of(2021, 5, 5),
                LocalDate.of(2021, 5, 10),
                Arrays.asList(p4, p6),
                c2
        );

        List<Order> orders = Arrays.asList(o1,o2,o3);
        List<Product> products = Arrays.asList(p1,p2,p3,p4,p5,p6);


        //Esercizio #1
        products.stream().filter(product -> product.getCategory().contains("Books")).forEach(System.out::println);

        System.out.println("-----------------------");

        products.stream().filter(product -> product.getPrice()>100).forEach(System.out::println);


        System.out.println("--------Esercizio #2--------");
        orders.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> product.getCategory().equals("Baby")))
                .forEach(System.out::println);


        System.out.println("--------Esercizio #3--------");
        products.stream().filter(product -> product.getCategory().equals("Boys"))
                .forEach(product -> {double originalPrice = product.getPrice(); product.setPrice(originalPrice*0.9);});
        System.out.println("\nProdotti 'Boys' dopo sconto:");
        products.stream()
                .filter(product -> "Boys".equals(product.getCategory()))
                .forEach(System.out::println);

        System.out.println("--------Esercizio #4--------");
        
    }
}
