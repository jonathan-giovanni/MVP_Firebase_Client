package hv.dev4u.org.mvp_firebase_client.model;

public class Product extends Item{
    String description;
    String price;


    public Product() {
    }

    public Product(String id_product, String title_product, String description, String price) {
        id      = id_product;
        title   = title_product;
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
