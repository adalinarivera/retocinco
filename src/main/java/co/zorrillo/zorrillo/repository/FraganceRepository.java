package co.zorrillo.zorrillo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.zorrillo.zorrillo.model.Fragance;
import co.zorrillo.zorrillo.repository.crud.FraganceCrudRepository;

@Repository
public class FraganceRepository {
    @Autowired
    private FraganceCrudRepository fraganceCrudRepository;

    public List<Fragance> getAll() {
        return fraganceCrudRepository.findAll();
    }

    public Optional<Fragance> getFragance(String reference) {
        return fraganceCrudRepository.findById(reference);
    }
    public Fragance create(Fragance fragance) {
        return fraganceCrudRepository.save(fragance);
    }

    public void update(Fragance fragance) {
        fraganceCrudRepository.save(fragance);
    }
    
    public void delete(Fragance fragance) {
        fraganceCrudRepository.delete(fragance);
    }
    public List<Fragance> gadgetsByPrice(double precio) {
        return fraganceCrudRepository.findByPriceLessThanEqual(precio);
    }

    public List<Fragance> findByDescriptionLike(String description) {
        return fraganceCrudRepository.findByDescriptionLike(description);
    }
}
