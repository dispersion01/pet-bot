package com.skypro.petbot.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long age;
    private LocalDateTime dateAdoption;

    @OneToOne
    private Owner owner;

    public Pet(Long id, String name, Long age, LocalDateTime dateAdoption) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dateAdoption = dateAdoption;
    }

    public Pet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public LocalDateTime getDateOdoption() {
        return dateAdoption;
    }

    public void setDateOdoption(LocalDateTime dateOdoption) {
        this.dateAdoption = dateOdoption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id) && Objects.equals(name, pet.name) && Objects.equals(age, pet.age) && Objects.equals(dateAdoption, pet.dateAdoption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, dateAdoption);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dateOdoption=" + dateAdoption +
                '}';
    }
}
