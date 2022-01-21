package com.example.notepadapp;

public class NotesDetails {
    int id;
    String topic,note;

    public NotesDetails(int id, String topic, String note) {
        this.id = id;
        this.topic = topic;
        this.note = note;
    }
    public NotesDetails()
    {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
