package culturemedia.service.impl;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;

import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewRepository;
import culturemedia.repository.impl.ViewRepositoryImpl;

import culturemedia.service.CultureMediaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;


public class CultureMediaServiceTest {
    private CultureMediaService cultureMediaService;
    private final VideoRepository videoRepository = Mockito.mock();
    private final ViewRepository viewRepository = new ViewRepositoryImpl();

    @BeforeEach
    void init(){
        cultureMediaService = new CultureMediaServiceImpl(videoRepository, viewRepository);
    }

    @Test
    void when_FindAllVideos_returns_all_the_videos_successfully() throws VideoNotFoundException {
    doReturn(List.of(
            new Video("01", "Title 1", "Description 1", 4.5),
            new Video("02", "Titulo 2", "Description 2", 5.5),
            new Video("03", "Title 3", "Description 3", 4.4),
            new Video("04", "Titulo 4", "Description 4", 3.5),
            new Video("05", "Title 5", "Description 5", 5.7),
            new Video("07", "Title 6", "Description 6", 5.1)))
            .when(videoRepository).findAll();
    List<Video> videos = cultureMediaService.findAll();
    assertEquals(6, videos.size());
    assertEquals(videos.stream().map(Video::code).toList(), List.of("01", "02", "03", "04", "05", "07"));
    }


    @Test
    void when_FindAllVideos_throws_the_exception_successfully() {
        assertThrows(
                VideoNotFoundException.class,
                () -> cultureMediaService.findAll());
    }


    @Test
    void when_FindVideoByTitle_returns_video_successfully() throws VideoNotFoundException {
        doReturn(List.of(
                new Video("03", "Title 3", "Description 3", 4.4)))
                .when(videoRepository).find("title 3");

        List<Video> videos = cultureMediaService.findByTitle("title 3");
        assertEquals(1, videos.size());
        assertEquals(videos.stream().map(Video::code).toList(), List.of("03"));
    }


    @Test
    void when_FindVideoByTitle_throws_the_exception_successfully() {
        assertThrows(VideoNotFoundException.class, () -> cultureMediaService.findByTitle("Title 3"));
    }


    @Test
    void when_FindVideoByDuration_returns_video_successfully() throws VideoNotFoundException {
        doReturn(List.of(
                new Video("03", "Title 3", "----", 4.4),
                new Video("04", "Title 4", "----", 3.5),
                new Video("05", "Title 5", "----", 5.7)
        ))
        .when(videoRepository).find(3.5,4.5);
        List <Video> videos = cultureMediaService.findByDuration(3.5,4.5);
        assertEquals(3, videos.size());
        assertEquals(videos.stream().map(Video::code).toList(), List.of("03", "04", "05"));
    }


    @Test
    void when_FindVideoByDuration_throws_the_exception_successfully() {
        assertThrows(VideoNotFoundException.class, () -> cultureMediaService.findByDuration(3.5,4.5));
    }
}
