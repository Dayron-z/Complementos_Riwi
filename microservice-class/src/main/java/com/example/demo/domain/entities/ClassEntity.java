package com.example.demo.domain.entities;


import com.example.demo.utils.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity(name = "class")
@NoArgsConstructor
@AllArgsConstructor
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String text;
    @Column(nullable = false)
    LocalDateTime created_at;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    State state = State.ACTIVE;
}
