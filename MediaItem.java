package src.oop;

public class MediaItem {
    protected int id;
    protected String title;

    public MediaItem(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getInfo() {
        return "ID: " + id + ", Title: " + title;
    }
}
