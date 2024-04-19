package culturemedia.service.impl;

import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;

import java.util.List;

public class CultureMediaServiceImpl {

    private VideoRepository videoRepository;

    private ViewsRepository viewsRepository;

    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    public Video save(Video video)  {
        return videoRepository.save(video);
    }

    public View save(View view)  {
        return viewsRepository.save(view);
    }


}
