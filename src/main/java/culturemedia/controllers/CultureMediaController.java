package culturemedia.controllers;

import culturemedia.exception.CultureMediaException;
import culturemedia.service.CultureMediaService;
import culturemedia.model.Video;

import java.util.List;

public class CultureMediaController {

	private final CultureMediaService cultureMediaService;


	public CultureMediaController(CultureMediaService cultureMediaService) {
		this.cultureMediaService = cultureMediaService;
	}

    public List <Video> find_allVideos() throws CultureMediaException {
        List <Video> videos = cultureMediaService.findAll();
        return videos;
    }

}