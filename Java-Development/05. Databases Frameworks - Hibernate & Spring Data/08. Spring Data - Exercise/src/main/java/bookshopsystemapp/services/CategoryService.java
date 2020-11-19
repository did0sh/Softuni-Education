package bookshopsystemapp.services;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface CategoryService {

    void seedCategories() throws IOException;
}
