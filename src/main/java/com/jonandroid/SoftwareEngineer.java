package com.jonandroid;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class SoftwareEngineer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
    public String techStack;
    @Column(columnDefinition = "TEXT")
    public String learningPath;

    public SoftwareEngineer() {
    }

    public SoftwareEngineer(int id, String name, String techStack, String learningPath) {
        this.id = id;
        this.name = name;
        this.techStack = techStack;
        this.learningPath = learningPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public String getLearningPath() {
        return learningPath;
    }
    public void setLearningPath(String learningPath) {
        this.learningPath = learningPath;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SoftwareEngineer that = (SoftwareEngineer) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(techStack, that.techStack) && Objects.equals(learningPath, that.learningPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, techStack, learningPath);
    }
}
