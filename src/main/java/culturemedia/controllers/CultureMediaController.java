package culturoteca.controllers;

import culturoteca.exception.VideoNotFoundException;
import culturoteca.service.impl.CultureMediaServiceImpl;
import culturoteca.model.Video;
import culturoteca.service.impl.CultureMediaServiceImpl;

import java.util.List;

public class CultureMediaController {

	private final CultureMediaServiceImpl cultureMediaService;


	public CultureMediaController(CultureMediaServiceImpl cultureMediaService) {
		this.cultureMediaService = cultureMediaService;
	}

    public List <Video> find_allVideos() throws VideoNotFoundException {
        List <Video> videos = null;
        videos = cultureMediaService.findAll();
        return videos;
    }

}