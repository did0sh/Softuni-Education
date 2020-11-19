package bookshopsystemapp.service;

import bookshopsystemapp.domain.entities.*;
import bookshopsystemapp.newBook.ReducedBook;
import bookshopsystemapp.repository.AuthorRepository;
import bookshopsystemapp.repository.BookRepository;
import bookshopsystemapp.repository.CategoryRepository;
import bookshopsystemapp.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final static String BOOKS_FILE_PATH = "D:\\Repositories\\GitHub\\SpringDataAdvanced\\src\\main\\resources\\files\\books.txt";

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedBooks() throws IOException {
        if (this.bookRepository.count() != 0) {
            return;
        }

        String[] booksFileContent = this.fileUtil.getFileContent(BOOKS_FILE_PATH);
        for (String line : booksFileContent) {
            String[] lineParams = line.split("\\s+");

            Book book = new Book();
            book.setAuthor(this.getRandomAuthor());

            EditionType editionType = EditionType.values()[Integer.parseInt(lineParams[0])];
            book.setEditionType(editionType);

            LocalDate releaseDate = LocalDate.parse(lineParams[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
            book.setReleaseDate(releaseDate);

            int copies = Integer.parseInt(lineParams[2]);
            book.setCopies(copies);

            BigDecimal price = new BigDecimal(lineParams[3]);
            book.setPrice(price);

            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(lineParams[4])];
            book.setAgeRestriction(ageRestriction);

            StringBuilder title = new StringBuilder();
            for (int i = 5; i < lineParams.length; i++) {
                title.append(lineParams[i]).append(" ");
            }

            book.setTitle(title.toString().trim());

            Set<Category> categories = this.getRandomCategories();
            book.setCategories(categories);

            this.bookRepository.saveAndFlush(book);
        }
    }


    private Author getRandomAuthor() {
        Random random = new Random();

        int randomId = random.nextInt((int) (this.authorRepository.count() - 1)) + 1;

        return this.authorRepository.findById(randomId).orElse(null);
    }

    private Set<Category> getRandomCategories() {
        Set<Category> categories = new LinkedHashSet<>();

        Random random = new Random();
        int length = random.nextInt(5);

        for (int i = 0; i < length; i++) {
            Category category = this.getRandomCategory();

            categories.add(category);
        }

        return categories;
    }

    private Category getRandomCategory() {
        Random random = new Random();

        int randomId = random.nextInt((int) (this.categoryRepository.count() - 1)) + 1;

        return this.categoryRepository.findById(randomId).orElse(null);
    }

    //p01
//    @Override
//    public List<String> getAllTitlesWithGivenAgeRestriction() {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        AgeRestriction ageRestriction = AgeRestriction.valueOf(input.toUpperCase());
//
//        List<Book> books = this.bookRepository.findAllByAgeRestriction(ageRestriction);
//        return books.stream()
//                .map(book -> String.format("%s", book.getTitle()))
//                .collect(Collectors.toList());
//    }

    //p02
//    @Override
//    public List<String> getAllTitlesFromGoldBooks() {
//        EditionType editionType = EditionType.GOLD;
//        int copies = 5000;
//
//        List<Book> books = this.bookRepository.findAllByEditionTypeAndCopiesLessThan(editionType, copies);
//        return books.stream()
//                .map(Book::getTitle)
//                .collect(Collectors.toList());
//    }

    //p03
//    @Override
//    public List<String> getTitlesPricesFromBooksWithPriceLowerThan5HigherThan40() {
//        BigDecimal low = new BigDecimal("5");
//        BigDecimal high = new BigDecimal("40");
//
//        List<Book> books = this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(low, high);
//        return books.stream()
//                .map(book -> String.format("%s - $%.2f", book.getTitle(), book.getPrice()))
//                .collect(Collectors.toList());
//    }

    //p04
//    @Override
//    public List<String> getTitlesWhereReleaseDateIsNot() {
//        Scanner scanner = new Scanner(System.in);
//
//        int date = Integer.parseInt(scanner.nextLine());
//
//        List<Book> books = this.bookRepository.getBooksByReleaseDateNot_Year(date);
//        return books.stream()
//                .map(Book::getTitle)
//                .collect(Collectors.toList());
//    }

    //p05
//    @Override
//    public List<String> getTitlesFromGivenReleaseDate() {
//        Scanner scanner = new Scanner(System.in);
//
//        LocalDate date = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//
//        List<Book> books = this.bookRepository.findAllByReleaseDateBefore(date);
//        return books.stream()
//                .map(Book::getTitle)
//                .collect(Collectors.toList());
//    }

    //p07
//    @Override
//    public List<String> getTitlesContainingGivenString() {
//        Scanner scanner = new Scanner(System.in);
//
//        String input = scanner.nextLine();
//
//        List<Book> books = this.bookRepository.findAllByTitleContaining(input);
//        return books.stream()
//                .map(Book::getTitle)
//                .collect(Collectors.toList());
//    }

    //p08
//    @Override
//    public List<String> getTitlesAuthorsWhereAuthorLastNameLikePattern() {
//        Scanner scanner = new Scanner(System.in);
//
//        String input = scanner.nextLine();
//
//        List<Book> books = this.bookRepository.getBooksByAuthorLastNameStartsWith(input);
//        return books.stream()
//                .map(book -> String.format("%s (%s %s)",
//                        book.getTitle(),
//                        book.getAuthor().getFirstName(),
//                        book.getAuthor().getLastName()))
//                .collect(Collectors.toList());
//    }

    //p09
//    @Override
//    public Long getBooksCountWhereTitleLengthLongerThan() {
//        Scanner scanner = new Scanner(System.in);
//
//        int titleLength = Integer.parseInt(scanner.nextLine());
//
//       return this.bookRepository.getCountOfBooks(titleLength);
//    }

//    //p11
//    @Override
//    public String getReducedBookInformationByGivenTitle() {
//        Scanner scanner = new Scanner(System.in);
//
//        String title = scanner.nextLine();
//
//       return (null == this.bookRepository.getBookByTitle(title))
//               ? "Not Found" :
//               this.bookRepository.getBookByTitle(title).toString();
//    }

    //p12
//    @Override
//    public String addBookCopies() {
//        Scanner scanner = new Scanner(System.in);
//
//        LocalDate date = LocalDate.parse(scanner.nextLine(),
//                DateTimeFormatter.ofPattern("dd MMM yyyy"));
//
//        int amountOfCopies = Integer.parseInt(scanner.nextLine());
//        Integer modifiedBooks = this.bookRepository.increaseCopiesForBooksReleasedAfterDate(date, amountOfCopies);
//       return String.format("%d book copies were added.", modifiedBooks * amountOfCopies);
//    }

    //p13
    @Override
    public String deleteBooks() {
        Scanner scanner = new Scanner(System.in);
        int amountOfCopies = Integer.parseInt(scanner.nextLine());

        Integer booksDeleted = this.bookRepository.deleteBookByCopiesLessThan(amountOfCopies);
       return String.format("%d books were deleted", booksDeleted);
    }
}
