package com.ucb.sakila.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String name;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    private Boolean isDeleted = false;

    public Long getCategoryId() {
		return categoryId;
	}
    
    public Boolean getIsDeleted() {
		return isDeleted;
	}
    
    public LocalDateTime getLastUpdate() {
		return LocalDateTime.now();
	}
    
    public String getName() {
		return name;
	}
    
    public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
    
    public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
    
    public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
    
    public void setName(String name) {
		this.name = name;
	}
    
}