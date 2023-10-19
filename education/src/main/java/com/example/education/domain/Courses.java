/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.education.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




@Entity
public class Courses {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;  
    
    private String title;
    private String description;
    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView(Views.FullMessage.class)
    private LocalDateTime creationDate;
    
    private LocalDateTime updateDate;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User createdBy;
    
    

    public Courses() {
    }

    public Courses(String title, String description,User user) {
        this.createdBy = user;
        this.title = title;
        this.description = description;
    }
    public String getAuthorName() {
        return createdBy != null ? createdBy.getUsername() : "<none>";
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the creationDate
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the updateDate
     */
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate the updateDate to set
     */
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return the createdBy
     */
    public User getAuthor() {
        return createdBy;
    }

    /**
     * @param author the createdBy to set
     */
    public void setAuthor(User author) {
        this.createdBy = author;
    }
    
}
