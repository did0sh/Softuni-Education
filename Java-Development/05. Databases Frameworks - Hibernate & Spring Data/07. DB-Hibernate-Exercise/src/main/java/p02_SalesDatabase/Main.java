package p02_SalesDatabase;

import p02_SalesDatabase.entities.Customer;
import p02_SalesDatabase.entities.Product;
import p02_SalesDatabase.entities.Sale;
import p02_SalesDatabase.entities.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sales");
        EntityManager entityManager = factory.createEntityManager();

        Customer customer = new Customer();
        customer.setEmail("pesho@abv.bg");
        customer.setName("Pesho Peshev");
        customer.setCreditCardNumber("ASDF 9123 SDJD KKKK");

        StoreLocation storeLocation = new StoreLocation();
        storeLocation.setLocationName("The Mall");

        Product product = new Product();
        product.setName("Test Product");
        product.setPrice(BigDecimal.valueOf(9.99));
        product.setQuantity(1d);

        Sale sale = new Sale();
        sale.setCustomer(customer);
        sale.setProduct(product);
        sale.setStoreLocation(storeLocation);
        sale.setDate(new Date());

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(customer);
            entityManager.persist(storeLocation);
            entityManager.persist(product);
            entityManager.persist(sale);

            entityManager.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
