package bookshopsystemapp.controller;

import bookshopsystemapp.services.AuthorService;
import bookshopsystemapp.services.BookService;
import bookshopsystemapp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookShopController implements CommandLineRunner {
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public BookShopController(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.authorService.seedAuthors();
        this.categoryService.seedCategories();
        this.bookService.seedBooks();

        //print book titles 'after 2000-12-31'
         this.bookTitles();

        //print authors with book before '1990-01-01'
        // this.authorNames();
    }

    private void bookTitles() {
        List<String> bookTitles = this.bookService.getAllBooksTitlesAfter();

        System.out.println(String.join("\r\n", bookTitles));
    }

    private void authorNames() {
        this.bookService.getAllAuthorsWithBookBefore().forEach(System.out::println);
    }
}
