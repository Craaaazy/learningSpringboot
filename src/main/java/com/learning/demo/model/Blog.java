package com.learning.demo.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Blog {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy="org.hibernate.id.UUIDGenerator")
    private String id;

    @NotNull
    @Column(unique=true)
    private String btitle;      //变量名不能有_
    private String bcontent;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private User user;


    public Blog(@NotNull String btitle, String bcontent, User user) {
        this.btitle = btitle;
        this.bcontent = bcontent;
        this.user = user;
    }

    public Blog() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
