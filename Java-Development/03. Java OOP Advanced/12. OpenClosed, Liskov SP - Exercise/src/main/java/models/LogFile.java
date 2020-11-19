package models;

import interfaces.File;

public class LogFile implements File {
    private StringBuilder messages;

    public LogFile() {
        this.messages = new StringBuilder();
    }

    @Override
    public void write(String message) {
        this.messages.append(message);
    }

    @Override
    public int getSize() {
        int size = 0;
        for (char letter : this.messages.toString().toCharArray()) {
            if (letter >= 65 && letter <= 122){
                size += letter;
            }
        }
        return size;
    }
}
