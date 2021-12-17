package co.zorrillo.zorrillo.repository.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.zorrillo.zorrillo.model.Order;

public interface OrderCrudRepository extends MongoRepository<Order, Integer > {
    @Query ("{'salesMan.zone': ?0}")
    List <Order>findByZone(final String zone0);

    @Query ("{status: ?0}")
    List <Order> findByStatus (final String Status);

    Optional <Order> findTopByOrderByIdDesc();
    
}
