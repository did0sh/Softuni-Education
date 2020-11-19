package bookshopsystemapp.repository;

import bookshopsystemapp.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    //p06
    //List<Author> findAllByFirstNameEndsWith(String letters);

    //p10
//    @Query("SELECT CONCAT(a.firstName, ' ', a.lastName, ' - ', SUM(b.copies)) " +
//            "FROM bookshopsystemapp.domain.entities.Author AS a " +
//            "JOIN bookshopsystemapp.domain.entities.Book AS b " +
//            "ON a.id = b.author.id " +
//            "GROUP BY a.id " +
//            "ORDER BY SUM(b.copies) DESC ")
//    List<Object> getAuthorsByCountCopies();
}
