package culturemedia.controllers;

import culturemedia.exception.CultureMediaException;
import culturemedia.exception.VideoNotFoundException;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ViewRepositoryImpl;
import culturemedia.service.CultureMediaService;
import culturemedia.service.impl.CultureMediaServiceImpl;
import culturemedia.model.Video;
import culturemedia.service.impl.CultureMediaServiceImpl;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.List;

@RestController
public class CultureMediaController {

	private final CultureMediaService cultureMediaService;


	public CultureMediaController() {
		this.cultureMediaService = new CultureMediaServiceImpl(new VideoRepositoryImpl(), new ViewRepositoryImpl());
	}

    public CultureMediaController(CultureMediaService cultureMediaService){
        this.cultureMediaService = cultureMediaService;
    }

    @GetMapping
    public List <Video> find_allVideos(){
        try {
            return cultureMediaService.findAll();
        }
        catch (VideoNotFoundException e) { return Collections.emptyList();}
    }

    @PostMapping
    public Video add_video(@RequestBody Video video){return cultureMediaService.save(video);}
}