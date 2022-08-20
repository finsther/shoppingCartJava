package io.finsther.shoppingCart.model;

public class Brick {

    private Integer id;
    private String name;
    private String description;
    private String imgURL;
    private Integer quantity;
    private Double price;

    public Brick() {
    }

    public Brick(Integer id, String name, String description, String imgURL, Integer quantity, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgURL = imgURL;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Brick{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imgURL='" + imgURL + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
