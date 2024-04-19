package culturemedia.model;

public record Video(String code, String title, String description, Double duration){
    @Override
    public String code() {
        return code;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public Double duration() {
        return duration;
    }
}

