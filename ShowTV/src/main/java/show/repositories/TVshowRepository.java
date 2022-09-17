package show.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import show.models.Tvshow;



public interface TVshowRepository extends CrudRepository<Tvshow, Long>{
	List<Tvshow> findAll();
	List<Tvshow> findById(int id); 

	
}
