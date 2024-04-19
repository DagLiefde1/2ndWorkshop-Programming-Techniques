package culturemedia.service;

import culturemedia.exception.CultureMediaException;
import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

public interface CultureMediaService {
    List<Video> findAll();
    View save(View view);
    Video save(Video video);
}