package ru.merann.bopopov.autoshowroom.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.merann.bopopov.autoshowroom.server.model.Model;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {

    @Query("from Model m where m.make.id=?1 and lower(m.name) like lower(concat(?2,'%'))")
    List<Model> findAllByName(Long makeId, String name);

    Model findOneById(Long id);

}
