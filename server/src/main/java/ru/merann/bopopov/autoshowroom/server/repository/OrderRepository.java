package ru.merann.bopopov.autoshowroom.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.merann.bopopov.autoshowroom.server.model.Client;
import ru.merann.bopopov.autoshowroom.server.model.Order;
import ru.merann.bopopov.autoshowroom.server.model.Status;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByClientAndStatus(Client client, Status status);

    @Query("from Order o where o.client.id = :client_id and o.status = :status")
    List<Order> findAllByClientIdAndStatus(@Param("client_id") Long clientId, @Param("status") Status status);

    Order findOneById(Long id);

    @Query("from Order o where o.client.id = :id")
    List<Order> findAllByClient(@Param("id") Long userId);
}
