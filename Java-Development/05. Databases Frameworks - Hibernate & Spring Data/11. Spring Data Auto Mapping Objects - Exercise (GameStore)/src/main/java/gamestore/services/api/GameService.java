package gamestore.services.api;

import gamestore.dto.GameDetailsView;
import gamestore.dto.GameTitlePriceView;
import gamestore.entities.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameService {
    Game findById(Long id);

    Game findByTitle(String title);

    List<GameTitlePriceView> findAll();

    GameDetailsView findGameDetails(String title);

    void add(Game game);

    void update(Game game);

    void remove(Game game);
}
