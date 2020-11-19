package bookshopsystemapp.controller;

import bookshopsystemapp.service.AuthorService;
import bookshopsystemapp.service.BookService;
import bookshopsystemapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;

@Controller
public class BookshopController implements CommandLineRunner {

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public BookshopController(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.authorService.seedAuthors();
        this.categoryService.seedCategories();
        this.bookService.seedBooks();

        // 01. Books Titles by Age Restriction
//        this.bookService.getAllTitlesWithGivenAgeRestriction()
//                .forEach(System.out::println);


        // 02. Golden Books
//        this.bookService.getAllTitlesFromGoldBooks()
//                .forEach(System.out::println);

        // 03. Books by Price
//        this.bookService.getTitlesPricesFromBooksWithPriceLowerThan5HigherThan40()
//                .forEach(System.out::println);

        // 04. Not Released Books
//        this.bookService.getTitlesWhereReleaseDateIsNot()
//                .forEach(System.out::println);

        // 05. Books Released Before Date
//        this.bookService.getTitlesFromGivenReleaseDate()
//                .forEach(System.out::println);

        // 06. Authors Search
//        this.authorService.getAuthorsNamesWhereFirstNameEndsWithGivenString()
//                .forEach(System.out::println);

        // 07. Books Search
//        this.bookService.getTitlesContainingGivenString()
//                .forEach(System.out::println);

        // 08. Book Titles Search
//        this.bookService.getTitlesAuthorsWhereAuthorLastNameLikePattern()
//                .forEach(System.out::println);

        // 09. Count Books
//        System.out.println(String.format("There are %d books with title length longer than the given.",
//                this.bookService.getBooksCountWhereTitleLengthLongerThan()));

        // 10. Total Book Copies
//        this.authorService.getAuthorsAndBookCopies()
//                .forEach(System.out::println);

        // 11. Reduced Book
//        System.out.println(this.bookService.getReducedBookInformationByGivenTitle());

        // 12. Increase Book Copies
        //System.out.println(this.bookService.addBookCopies());

        // 13. Delete Books
        System.out.println(this.bookService.deleteBooks());
    }
}
