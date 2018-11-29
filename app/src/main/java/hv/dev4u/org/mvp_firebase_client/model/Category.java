package hv.dev4u.org.mvp_firebase_client.model;

public class Category extends Item{
    String description;


    public Category() {
    }

    public Category(String id_category, String title_category, String description) {
        id      = id_category;
        title   = title_category;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
