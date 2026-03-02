package com.hw_w2.homework.w2.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "professor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Subject> subjects = new ArrayList<>();

    @ManyToMany()
    @JoinTable(
            name = "professor_student",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        this.students.add(student);
        student.getProfessors().add(this);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
        student.getProfessors().remove(this);
    }
}
