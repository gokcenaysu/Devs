package kodlama.io.devs.repositories;

import kodlama.io.devs.models.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

    Technology findByName(String name);
}
