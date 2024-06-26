package culturemedia.service;

import culturemedia.exception.CultureMediaException;
import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.exception.VideoNotFoundException;

import java.util.List;

public interface CultureMediaService {
    List<Video> findAll() throws VideoNotFoundException;
    View save(View view);
    Video save(Video video);
    List<Video> findByTitle(String title) throws VideoNotFoundException;
    List<Video> findByDuration(Double fromDuration, Double toDuration) throws VideoNotFoundException;
}