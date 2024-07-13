package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "profile_pictures")
public class ProfilePicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "picture_url")
    private String pictureUrl;

    // we are skipping CascadeType.REMOVE, because we don't want to delete the user, if we delete its profile picture
    @OneToOne(mappedBy = "profilePicture", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private User user;

    public ProfilePicture() {}

    public ProfilePicture(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ProfilePicture{" +
                "id=" + id +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}
