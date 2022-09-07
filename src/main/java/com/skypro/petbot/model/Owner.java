package com.skypro.petbot.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;

    private String name;

    @OneToMany(mappedBy = "ownerId")
    private Set<Report> report;

    public Owner(Long chatId, String name, Report report) {
        this.chatId = chatId;
        this.name = name;
    }

    public Owner() {
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(chatId, owner.chatId) && Objects.equals(name, owner.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId, name);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "chatId=" + chatId +
                ", name='" + name + '\'' +
                ", report=" + report +
                '}';
    }
}
