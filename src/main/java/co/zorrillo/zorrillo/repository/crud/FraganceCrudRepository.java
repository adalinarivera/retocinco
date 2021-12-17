package co.zorrillo.zorrillo.repository.crud;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.zorrillo.zorrillo.model.Fragance;

public interface FraganceCrudRepository extends MongoRepository<Fragance, String>{
    public List<Fragance> findByPriceLessThanEqual(double precio);

    @Query ("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Fragance> findByDescriptionLike(String description);
}
