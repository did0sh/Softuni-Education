package bookshopsystemapp.repository;

import bookshopsystemapp.domain.entities.AgeRestriction;
import bookshopsystemapp.domain.entities.Book;
import bookshopsystemapp.domain.entities.EditionType;
import bookshopsystemapp.newBook.ReducedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    // 01. Books Titles by Age Restriction
    //List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    // 02. Golden Books
    //List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    // 03. Books by Price
    //List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal low, BigDecimal high);

    // 04. Not Released Books
    //@Query("SELECT b FROM bookshopsystemapp.domain.entities.Book AS b WHERE FUNCTION('YEAR', b.releaseDate) <> :year")
    //List<Book> getBooksByReleaseDateNot_Year(@Param("year") final int year);

    // 05. Books Released Before Date
    //List<Book> findAllByReleaseDateBefore(LocalDate date);

    // 07. Books Search
    //List<Book> findAllByTitleContaining(String text);

    // 08. Book Titles Search
    //@Query("SELECT b FROM bookshopsystemapp.domain.entities.Book AS b WHERE b.author.lastName LIKE :starting%")
    //List<Book> getBooksByAuthorLastNameStartsWith(@Param("starting") String starting);

    // 09. Count Books
    //@Query("SELECT COUNT(b) FROM bookshopsystemapp.domain.entities.Book AS b WHERE LENGTH(b.title) > :titleLength")
    //Long getCountOfBooks(@Param("titleLength") int titleLength);

    // 11. Reduced Book
    //ReducedBook getBookByTitle(final String title);

    // 12. Increase Book Copies
    //@Modifying
    //@Query("UPDATE bookshopsystemapp.domain.entities.Book AS b SET b.copies = b.copies + :cnt WHERE b.releaseDate > :date")
    //Integer increaseCopiesForBooksReleasedAfterDate(@Param("date") LocalDate startDate, @Param("cnt") int copiesToAdd);

    // 13. Remove Books
    @Modifying
    @Query("DELETE FROM bookshopsystemapp.domain.entities.Book AS b WHERE b.copies < :num")
    Integer deleteBookByCopiesLessThan(@Param("num") Integer num);
}
