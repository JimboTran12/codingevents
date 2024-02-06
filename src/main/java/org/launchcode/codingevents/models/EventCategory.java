package org.launchcode.codingevents.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
public class EventCategory {
    @Id
    @GeneratedValue
    private int ID;
    @Size(min=3, message = "Name must be longer than 3 letters")
    private String name;

    public EventCategory(String name) {
        this.name = name;
    }
    public EventCategory(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventCategory that = (EventCategory) o;
        return getID() == that.getID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getName());
    }

    @Override
    public String toString() {
        return name;

    }
}
