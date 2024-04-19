package culturemedia.model;
import java.time.LocalDateTime;
public record View(String userFullName, LocalDateTime startPlayingTime, Integer age, Video video) {
        @Override
        public String userFullName() {
            return userFullName;
        }

        @Override
        public LocalDateTime startPlayingTime() {
            return startPlayingTime;
        }

        @Override
        public Integer age() {
            return age;
        }

        @Override
        public Video video() {
            return video;
        }
}

