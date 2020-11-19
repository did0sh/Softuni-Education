package p02_WarningLevels;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Logger {
    private List<Message> messages;

    public Logger() {
        this.messages = new ArrayList<>();
    }

    public void addMessage(String importance, String message){
        Message message1 = new Message(importance, message);
        this.messages.add(message1);
    }

    public void filterMessages(String importance){
        this.messages =  this.messages.stream()
                .filter(message -> message.getImportance()
                        .compareTo(Enum.valueOf(Importance.class, importance)) >= 0)
                .collect(Collectors.toList());
    }

    public Iterable<Message> getMessages(){
        return this.messages;
    }
}
