package events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MessageListen extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        super.onMessageReceived(event);
        String message = event.getMessage().getContentRaw();
        System.out.println("Usr sent: " + message);
        /* we are going to get all the words from the message and use it for happy little memes */
        String[] words = message.split(" ");
        for (String word : words) {
            /* making it non-case sensitive */
            word = word.toLowerCase();
            switch (word){
                case "thinking":
                    event.getChannel()
                            .sendMessage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXnniZfdE1B2O2mWw1pcNaEql2HPfFsQE0ag&usqp=CAU")
                            .queue();
                    break;


            }
        }
    }
}
