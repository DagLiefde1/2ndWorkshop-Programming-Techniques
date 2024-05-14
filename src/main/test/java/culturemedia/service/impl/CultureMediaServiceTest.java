package culturemedia.service.impl;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;

import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewRepository;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ViewRepositoryImpl;

import culturemedia.service.CultureMediaService;
import culturemedia.service.impl.CultureMediaServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CultureMediaServiceTest {
    private CultureMediaService cultureMediaService;

    @BeforeEach
    void init(){
        VideoRepository videoRepository = new VideoRepositoryImpl();
        ViewRepository viewRepository = new ViewRepositoryImpl();
        cultureMediaService = new CultureMediaServiceImpl(videoRepository, viewRepository);
    }

    private void createVideos(){
    List <Video> videos = List.of(
        new Video("01", "Title 1", "Description 1", 4.5),
        new Video("02", "Titulo 2", "Description 2", 5.5),
        new Video("03", "Title 3", "Description 3", 4.4),
        new Video("04", "Titulo 4", "Description 4", 3.5),
        new Video("05", "Title 5", "Description 5", 5.7),
        new Video("06", "Title 6", "Description 6", 5.1));

        for (Video video : videos) {
            cultureMediaService.save(video);
        }
    }


    @Test
    void when_FindAllVideos_returns_all_videos_successfully() throws VideoNotFoundException {
        createVideos();
        List <Video> videos = cultureMediaService.findAll();
        assertEquals(6, videos.size());
    }


    @Test
    void when_FindAllVideos_throws_the_exception_successfully() {
        VideoNotFoundException thrown = assertThrows(
                VideoNotFoundException.class,
                () -> cultureMediaService.findAll());
    }


    @Test
    void when_FindVideoByTitle_returns_video_successfully() throws VideoNotFoundException {
        createVideos();
        List <Video> videos = cultureMediaService.findByTitle("Title 3");
        assertEquals(1, videos.size());
    }


    @Test
    void when_FindVideoByTitle_throws_the_exception_successfully() {
        assertThrows(VideoNotFoundException.class, () -> cultureMediaService.findByTitle("Title 3"));
    }


    @Test
    void when_FindVideoByDuration_returns_video_successfully() throws VideoNotFoundException {
        createVideos();
        List <Video> videos = cultureMediaService.findByDuration(3.5,4.5);
        assertEquals(3, videos.size());
    }


    @Test
    void when_FindVideoByDuration_throws_the_exception_successfully() {
        assertThrows(VideoNotFoundException.class, () -> cultureMediaService.findByDuration(3.5,4.5));
    }
}
