package hr.ferit.osnove_rwma_dz4;

public class Makeup {
    private String name;
    private String price;
    private String rating;
    private String description;
    private String image_link;

    public Makeup(String name, String price, String rating, String description, String imageLink) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.description = description;
        this.image_link =imageLink;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public String getImage_link() {
        return image_link;
    }

}
