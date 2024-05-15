package culturemedia.controllers;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.service.impl.CultureMediaServiceImpl;
import culturemedia.model.Video;
import culturemedia.service.impl.CultureMediaServiceImpl;

import java.util.List;

public class CultureMediaController {

	private final CultureMediaServiceImpl cultureMediaService;


	public CultureMediaController(CultureMediaServiceImpl cultureMediaService) {
		this.cultureMediaService = cultureMediaService;
	}

    public List <Video> find_allVideos() throws VideoNotFoundException {
        List <Video> videos = cultureMediaService.findAll();
        return videos;
    }

}