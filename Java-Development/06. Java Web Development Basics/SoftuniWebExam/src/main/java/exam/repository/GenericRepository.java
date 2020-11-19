package exam.repository;

import java.util.List;

public interface GenericRepository<Entity, ID> {

    Entity save(Entity entity);

    List<Entity> findAll();

    Entity findById(ID id);
}