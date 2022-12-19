package com.skypro.petbot.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private byte[] photo;

    private String message;

    @ManyToOne
    @JoinColumn(name = "report")
    private Owner ownerId;

    public Report(Long id, byte[] photo, String message, String ownerId) {
        this.id = id;
        this.photo = photo;
        this.message = message;
    }

    public Report() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return Objects.equals(id, report.id) && Arrays.equals(photo, report.photo) && Objects.equals(message, report.message);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, message);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", photo=" + Arrays.toString(photo) +
                ", message='" + message + '\'' +
                ", ownerId=" + ownerId +
                '}';
    }
}
