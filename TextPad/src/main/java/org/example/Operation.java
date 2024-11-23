package org.example;

public class Operation {
    String task;
    int position;
    int length;
    String content;

    public String getContent() {
        return content;
    }

    public String getTask() {
        return task;
    }

    public int getPosition() {
        return position;
    }

    public int getLength() {
        return length;
    }

    public Operation(String task, int position, int length, String content) {
        this.task = task;
        this.position = position;
        this.length = length;
        this.content = content;
    }
}
