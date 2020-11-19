package p05_BillsPaymentSystem;

import p05_BillsPaymentSystem.entities.BankAccount;
import p05_BillsPaymentSystem.entities.BillingDetail;
import p05_BillsPaymentSystem.entities.CreditCard;
import p05_BillsPaymentSystem.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;

public class Demo {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("bills_payment");
        EntityManager entityManager = factory.createEntityManager();

        try {
            CreditCard creditCard = new CreditCard();
            creditCard.setCardType("VISA");
            creditCard.setExpirationMonth(8);
            creditCard.setExpirationYear(2020);
            creditCard.setNumber("1234 4444 4444 0123");

            CreditCard creditCard2 = new CreditCard();
            creditCard2.setCardType("MasterCard");
            creditCard2.setExpirationMonth(1);
            creditCard2.setExpirationYear(2026);
            creditCard2.setNumber("1327 9812 9203 DF12");

            BankAccount account = new BankAccount();
            account.setBankName("ReifesenBank");
            account.setSwiftCode("1278239&&!@#");
            account.setNumber("00293");

            BankAccount account2 = new BankAccount();
            account2.setBankName("CustomBank");
            account2.setSwiftCode("123asdfDD&&!@#");
            account2.setNumber("155234");

            User user = new User();
            user.setFirstName("Peter");
            user.setLastName("Petrov");
            user.setEmail("pesho123@gmail.com");
            user.setPassword("1234");

            account.setOwner(user);
            account2.setOwner(user);
            creditCard.setOwner(user);
            creditCard2.setOwner(user);

            user.setBillingDetails(new HashSet<BillingDetail>(){{
                add(creditCard);
                add(creditCard2);
                add(account);
                add(account2);
            }});

            entityManager.getTransaction().begin();

            entityManager.persist(user);

            entityManager.getTransaction().commit();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            entityManager.getTransaction().rollback();
        }

    }
}
