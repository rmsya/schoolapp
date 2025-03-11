package com.academicproject.memberservice.domain.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@MappedSuperclass
public abstract class BaseEntity {

    @Column(nullable = false, updatable = false)
    private Timestamp createdTime;

    @Column(nullable = false)
    private Timestamp updatedTime;

    @PrePersist
    protected void onCreate() {
        createdTime = new Timestamp(System.currentTimeMillis());
        updatedTime = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedTime = new Timestamp(System.currentTimeMillis());
    }
}
