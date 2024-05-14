package culturemedia.service.impl;

import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewRepository;
import culturemedia.service.CultureMediaService;
import culturemedia.exception.VideoNotFoundException;

import java.util.List;

public class CultureMediaServiceImpl implements CultureMediaService {

    private VideoRepository videoRepository;

    private ViewRepository viewsRepository;

    public CultureMediaServiceImpl(VideoRepository videoRepository, ViewRepository viewsRepository) {
        this.videoRepository = videoRepository;
        this.viewsRepository = viewsRepository;
    }

    @Override
    public List<Video> findAll() throws VideoNotFoundException {
        List <Video> videos = this.videoRepository.findAll();
        if (videos.isEmpty()) {
            throw new VideoNotFoundException();
        }
        return videos;
    }

    @Override
    public Video save(Video video)  {
        this.videoRepository.save(video);
        return video;
    }

    @Override
    public List<Video> findByTitle(String title) throws VideoNotFoundException {
        List<Video> videos = this.videoRepository.find(title);
        if (videos == null || videos.isEmpty()) {
            throw new VideoNotFoundException();
        }
        return videos;
    }

    @Override
    public List<Video> findByDuration(Double fromDuration, Double toDuration) throws VideoNotFoundException {
        List<Video> videos = this.videoRepository.find(fromDuration, toDuration);
        if (videos.isEmpty()) {
            throw new VideoNotFoundException();
        }
        return videos;
    }

    @Override
    public View save(View view)  {
        this.viewsRepository.save(view);
        return view;
    }
}
