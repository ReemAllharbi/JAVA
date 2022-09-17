package show.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import show.models.Tvshow;
import show.repositories.TVshowRepository;

@Service

public class TVshowService {
	
	private TVshowRepository tvshowRepository;
	public TVshowService (TVshowRepository tvshowRepository) {

		this.tvshowRepository = tvshowRepository;
	}
	
	
	public List<Tvshow> allTvshow() {
    	return  tvshowRepository.findAll();
	}
	
	
	public Tvshow createTvshow(Tvshow b) {
		return  tvshowRepository.save(b);
	    }

	public Tvshow findTvshow(Long id) {
	    Optional<Tvshow> optionalTvshow =  tvshowRepository.findById(id);
	    return optionalTvshow.isPresent()?  optionalTvshow.get() : null;
	}
	
	

	public Tvshow updateTvshow(Long id,Tvshow tvshow) {
		Tvshow current_tvshow = findTvshow(id);
		
		current_tvshow.setName(tvshow.getName());
		current_tvshow.setNetwork(tvshow.getNetwork());
		current_tvshow.setDesctiption(tvshow.getDesctiption());
		return  tvshowRepository.save(current_tvshow);
	    }
	
	
	
	
	public void deleteTvshow(Long id) {

		tvshowRepository.deleteById(id);
	}
	
	
	
}
