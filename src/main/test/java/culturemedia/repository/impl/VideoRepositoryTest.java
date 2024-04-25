package culturemedia.repository.impl;

import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class VideoRepositoryTest {

    private VideoRepository videoRepository;

    @BeforeEach
    void init(){

        videoRepository = new VideoRepositoryImpl();

        List<Video> videos = List.of(new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Title 2", "----", 5.5),
                new Video("03", "Title 3", "----", 4.4),
                new Video("04", "Title 4", "----", 3.5),
                new Video("05", "Clip 5", "----", 5.7),
                new Video("06", "Clip 6", "----", 5.1));


        for ( Video video : videos ) {
            videoRepository.save( video );
        }

    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() {
        List<Video> videos = videoRepository.findAll( );
        assertEquals(6, videos.size());
    }

    @Test
    void when_FindByTitle_only_videos_which_contains_the_word_in_the_title_should_be_returned_successfully() {
        List<Video> videos = videoRepository.find( "TITLE " );
        assertEquals(3, videos.size());
    }

    @Test
    void when_FindByDuration_only_videos_between_the_range_should_be_returned_successfully() {
        List<Video> videos = videoRepository.find( 4.5, 5.5 );
        assertEquals(3, videos.size());
    }

    @Test
    void when_FindByTitle_does_not_match_any_video_an_empty_list_should_be_returned_successfully() {
        List<Video> videos = videoRepository.find( "notValidTitle" );
        assertNull(videos);
    }

    @Test
    void when_FindByDuration_does_not_match_any_video_an_empty_list_should_be_returned_successfully() {
        List<Video> videos = videoRepository.find( 8.0,19.0 );
        assertEquals(0, videos.size());
    }

}