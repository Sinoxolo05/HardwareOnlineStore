
package za.ac.cput.domain;
/*
 * Category.java
 * Category Domain Entity using Builder Pattern
 * Author: Sinoxolo Kobeni 230801846
 * Date: 21 June 2026
 */

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private String parentId;

    // Required by JPA
    protected Category() {
    }

    // Builder constructor
    private Category(Builder builder) {
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
                "categoryId='" + categoryId + '\'' +
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
            return new Category(this);
        }
    }
}