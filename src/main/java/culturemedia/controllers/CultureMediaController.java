package culturemedia.controllers;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ViewRepositoryImpl;
import culturemedia.service.CultureMediaService;
import culturemedia.service.impl.CultureMediaServiceImpl;
import culturemedia.model.Video;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController

@RequestMapping("videos")

@CrossOrigin(origins = "*")
public class CultureMediaController {

	private final CultureMediaService cultureMediaService;


	public CultureMediaController() {
		this.cultureMediaService = new CultureMediaServiceImpl(new VideoRepositoryImpl(), new ViewRepositoryImpl());
	}

    public CultureMediaController(CultureMediaService cultureMediaService){
        this.cultureMediaService = cultureMediaService;
    }

    @GetMapping
    public List <Video> findAllVideos(){
        try {
            return cultureMediaService.findAll();
        }
        catch (VideoNotFoundException e) { return Collections.emptyList();}
    }

    @PostMapping
    public Video addVideo(@RequestBody Video video){return cultureMediaService.save(video);}

}