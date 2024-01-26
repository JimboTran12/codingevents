package org.launchcode.codingevents.models;

import jakarta.validation.constraints.*;

import java.util.Objects;

public class Event {
    @NotBlank
    @Size(min = 3, max = 50, message = "Name has to be 3 - 50 characters")
    private String name;
    @Size(max = 500, message = "Description too long")
    private String description;
    @NotBlank
    @Email(message = "Invalid email. Try again")
    private String contactEmail;

    @NotBlank(message = "Location can't be blank")
    private String location;

    @AssertTrue(message = "attendee must register for the event ")
    boolean registered;
    @Positive(message="Number of attendees must be one or more.")
    private int numberOfAttendees;


    private int id;
    private static int nextID = 1;

    public Event(String name, String description, String contactEmail, String location, boolean isRegistered, int numberOfAttendees) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.registered = isRegistered;
        this.numberOfAttendees = numberOfAttendees;
    }

    public Event(){
        this.id = nextID / 2;
        nextID++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isRegistered() {
        return registered;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return getId() == event.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
