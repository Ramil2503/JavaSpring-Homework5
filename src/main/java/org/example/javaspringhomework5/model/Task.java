package org.example.javaspringhomework5.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private TaskStatus status;

    @Column(name = "creation_date",nullable = false)
    private LocalDate creationDate;
    @PrePersist
    public void setCreationDate() {
        this.creationDate = LocalDate.now();
    }

}
