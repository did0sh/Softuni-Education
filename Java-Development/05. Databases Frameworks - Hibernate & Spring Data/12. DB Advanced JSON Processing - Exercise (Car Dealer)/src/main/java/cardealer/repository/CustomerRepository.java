package cardealer.repository;

import cardealer.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "SELECT * FROM customers AS c ORDER BY c.birth_date, c.is_young_driver", nativeQuery = true)
    List<Customer> getAllByBirthDate();
}
