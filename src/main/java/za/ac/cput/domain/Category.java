
package za.ac.cput.domain;
import jakarta.persistence.*;

import java.util.Objects;
/*
 * Category.java
 * Category Domain Entity using Builder Pattern
 * Author: Sinoxolo Kobeni 230801846
 * Date: 21 June 2026
 */



@Entity
@Table(name = "category")
public class Category {

    @Id
    private String categoryId;

    private String name;
    private String parentId;

    public Category() {

    }

    public Category(Builder builder) {
        this.categoryId = builder.categoryId;
        this.name = builder.name;
        this.parentId = builder.parentId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public String getParentId() {
        return parentId;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + categoryId + '\'' +
                ", name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }

    public static class Builder {

        private String categoryId;
        private String name;
        private String parentId;

        public Builder setCategoryId(String categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setParentId(String parentId) {
            this.parentId = parentId;
            return this;
        }

        public Builder copy(Category category) {
            this.categoryId = category.categoryId;
            this.name = category.name;
            this.parentId = category.parentId;
            return this;
        }

        public Category build() {
            Objects.requireNonNull(
                    categoryId,
                    "Category identity required"
            );
            return new Category(this);
        }
    }
}