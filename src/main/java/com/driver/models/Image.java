package com.driver.models;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String description;
    private String dimensions;

    @ManyToOne
    @JoinColumn
    Blog blog;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
    public Image() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}