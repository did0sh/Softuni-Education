package bookshopsystemapp.service;

import bookshopsystemapp.domain.entities.Book;
import bookshopsystemapp.newBook.ReducedBook;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface BookService {

    void seedBooks() throws IOException;

    //p01
    //List<String> getAllTitlesWithGivenAgeRestriction();

    //p02
    //List<String> getAllTitlesFromGoldBooks();

    //p03
    //List<String> getTitlesPricesFromBooksWithPriceLowerThan5HigherThan40();

    //p04
    //List<String> getTitlesWhereReleaseDateIsNot();

    //p05
    //List<String> getTitlesFromGivenReleaseDate();

    //p07
    //List<String> getTitlesContainingGivenString();

    //p08
    //List<String> getTitlesAuthorsWhereAuthorLastNameLikePattern();

    //p09
    //Long getBooksCountWhereTitleLengthLongerThan();

    //p11
    //String getReducedBookInformationByGivenTitle();

    //p12
    //String addBookCopies();

    //p13
    String deleteBooks();
}
