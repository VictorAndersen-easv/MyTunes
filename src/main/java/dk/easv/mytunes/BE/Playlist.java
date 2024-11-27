package dk.easv.mytunes.BE;

public class Playlist {
    private int id;
    private String title;
    private float duration;

    public Playlist(int id, String title, float duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }
}
