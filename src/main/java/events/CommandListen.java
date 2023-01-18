package events;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;
import eventVitals.CommandVitals;

public class CommandListen extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent command) {
        super.onSlashCommandInteraction(command);
        switch (command.getName()) {
            case "ping": /* if the command sent was ping */
                /* get the quantity */
                OptionMapping scope = command.getOption("quantity");
                assert scope != null;
                int done = 0;
                int todo = CommandVitals.slashPing.getintfromstring(scope.getAsString());
                command.reply("Okay!")
                        .queue();
                if (todo != 0) {
                    do {
                        command.getChannel().sendMessage("Pong")
                                .queue();
                        done++;
                    } while (done != todo);
                    break;
                }

                /* note that this is only a switch case because it is set to have more commands */
            /* if I were to permanently only have 1 command I would use an if statement */

        }
    }
}
