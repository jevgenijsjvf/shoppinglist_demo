package com.javaguru.shoppinglist.dto;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Objects;
import org.hibernate.sql.Update;

import java.math.BigDecimal;

public class ProductDTO {

    @NotNull(groups = {Update.class})
    @Null (groups = {Create.class})
    private Long id;
    @NotEmpty (groups = {Update.class, Create.class}, message = "Name must be not blank.")
    private String name;
    private BigDecimal price;
    private String categoty;
    private BigDecimal discount;
    private String description;

    public ProductDTO() {
    }

    public ProductDTO(Long ID, String name, BigDecimal price, String categoty, BigDecimal discount, String description) {
        this.id = ID;
        this.name = name;
        this.price = price;
        this.categoty = categoty;
        this.discount = discount;
        this.description = description;
    }

    public Long getID() {
        return id;
    }

    public void setID(Long ID) {
        this.id = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategoty() {
        return categoty;
    }

    public void setCategoty(String categoty) {
        this.categoty = categoty;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(price, that.price) &&
                Objects.equals(categoty, that.categoty) &&
                Objects.equals(discount, that.discount) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, categoty, discount, description);
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categoty='" + categoty + '\'' +
                ", discount=" + discount +
                ", description='" + description + '\'' +
                '}';
    }

    public interface Update {
        // empty interface
    }

    public interface Create {
        // empty interface
    }
}
