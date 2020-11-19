package bookshopsystemapp.services;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@Service
public interface BookService {
    void seedBooks() throws IOException;

    List<String> getAllBooksTitlesAfter();

    Set<String> getAllAuthorsWithBookBefore();
}
