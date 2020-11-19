package bookshopsystemapp.service;

import java.io.IOException;
import java.util.List;

public interface AuthorService {

    void seedAuthors() throws IOException;

    //p06
    //List<String> getAuthorsNamesWhereFirstNameEndsWithGivenString();

    //p10
    //List<String> getAuthorsAndBookCopies();
}
