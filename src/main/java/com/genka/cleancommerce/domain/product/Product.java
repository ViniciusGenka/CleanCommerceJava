package com.genka.cleancommerce.domain.product;

import com.genka.cleancommerce.domain.address.Address;
import com.genka.cleancommerce.domain.category.Category;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Product {
    private UUID id;
    private List<Category> categories;
    private String description;
    private Double price;
    private Address stockAddress;
    private Integer stockQuantity;
    private String title;

    public Product() {
    }

    public Product(UUID id, List<Category> categories, String description, Double price, Address stockAddress, Integer stockQuantity, String title) {
        this.id = id;
        this.categories = categories;
        this.description = description;
        this.price = price;
        this.stockAddress = stockAddress;
        this.stockQuantity = stockQuantity;
        this.title = title;
    }

    public Product(List<Category> categories, String description, Double price, Address stockAddress, Integer stockQuantity, String title) {
        this.categories = categories;
        this.description = description;
        this.price = price;
        this.stockAddress = stockAddress;
        this.stockQuantity = stockQuantity;
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Address getStockAddress() {
        return stockAddress;
    }

    public void setStockAddress(Address stockAddress) {
        this.stockAddress = stockAddress;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && Objects.equals(stockAddress, product.stockAddress) && Objects.equals(stockQuantity, product.stockQuantity) && Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, price, stockAddress, stockQuantity, title);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stockAddress=" + stockAddress +
                ", stockQuantity=" + stockQuantity +
                ", title='" + title + '\'' +
                '}';
    }
}
