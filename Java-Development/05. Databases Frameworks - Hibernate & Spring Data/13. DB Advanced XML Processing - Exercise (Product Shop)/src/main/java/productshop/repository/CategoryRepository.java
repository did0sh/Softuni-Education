package productshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import productshop.domain.entities.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    //Query 3
    @Query("SELECT c FROM Category c")
    List<Category> getAll();
}
