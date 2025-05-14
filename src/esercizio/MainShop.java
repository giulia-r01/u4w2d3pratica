package esercizio;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainShop {
    public static void main(String[] args) {

        //Prodotti

        Product p1 = new Product(1L, "Il Signore degli Anelli", "Books", 15.50);
        Product p2 = new Product(2L, "Cofanetto della saga Harry Potter", "Books", 102.90);
        Product p3 = new Product(3L, "Ciuccio", "Baby", 3.5);
        Product p4 = new Product(4L, "Pannolini", "Baby", 10.5);
        Product p5 = new Product(5L, "scarpe", "Boys", 45.5);
        Product p6 = new Product(6L, "Giacca", "Boys", 30.0);
        Product p7 = new Product(7L, "Maglietta", "Boys", 15.5);
        Product p8 = new Product(8L, "L'Ombra del vento", "Books", 19.70);


        List<Product> products = List.of(p1,p2,p3,p4,p5,p6,p7,p8);

        // Clienti
        Customer c1 = new Customer(18756L, "Mario", 1);
        Customer c2 = new Customer(35246L, "Mario", 2);
        Customer c3 = new Customer(56438L, "Mario", 2);


        // Ordini

        Order o1 = new Order(1L, "spedito", LocalDate.of(2021, 1, 30),
                LocalDate.of(2021, 2, 1), List.of(p1, p2, p3),  c1);

        Order o2 = new Order(2L, "spedito", LocalDate.of(2021, 2, 10),
                LocalDate.of(2021, 2, 15), List.of(p4, p5, p6),  c2);

        Order o3 = new Order(3L, "spedito", LocalDate.of(2021, 3, 2),
                LocalDate.of(2021, 3, 10), List.of(p7, p8),  c3);

        List<Order> orders = List.of(o1,o2,o3);


        System.out.println("--------Esercizio 1--------");

        List<Product> prodottiBooksMagg100 = products.stream().filter(product -> product.getCategory().
                equals("Books")&& product.getPrice()>100).toList();

        System.out.println("I prodotti contenuti nella categoria Books con prezzo superiore a 100 sono: \n" + prodottiBooksMagg100);

        System.out.println("\n--------Esercizio 2--------");

        List<Order> ordiniCatBaby =  orders.stream().filter(order -> order.getProducts().stream().
                anyMatch(product -> product.getCategory().equals("Baby"))).toList();

        System.out.println("Gli ordini con prodotti di categoria Baby sono: \n" + ordiniCatBaby);

        System.out.println("\n--------Esercizio 3--------");

        List<Product> prodottiBoysScontati = products.stream().filter(product -> product.getCategory().equals("Boys"))
                .map(product -> {product.setPrice(product.getPrice()*0.9);
                    return product;}).toList();

        System.out.println("Gli ordini con prodotti di categoria Boys scontati sono: \n" + prodottiBoysScontati);

        System.out.println("\n--------Esercizio 4--------");

        List<Product> prodottiFebAprTier = orders.stream().filter(order -> order.getCustomer().getTier()==2)
                .filter(order -> order.getOrderDate().isAfter(LocalDate.of(2021,2,1))&&
                        order.getOrderDate().isBefore(LocalDate.of(2021,4,1))).
                        flatMap(order -> order.getProducts().stream()).toList();

        System.out.println("I prodotti ordinati da clienti di livello 2 tra 1/2/21 e 1/4/21 sono: \n" + prodottiFebAprTier);
        

    }
}
