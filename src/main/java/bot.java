import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.GatewayIntent;
import events.*;
import javax.security.auth.login.LoginException;

public class bot {
    public static void main (String[] args) throws LoginException {

        /* Log in to the bot with the bot token */
        final String token = "token";
        JDABuilder jdabuilder = JDABuilder.createDefault(token);

        /* Define jda as the built bot */
        JDA jda = jdabuilder
                /* add event listeners*/
                .addEventListeners(new ReadyListen())
                .addEventListeners(new MessageListen())
                .addEventListeners(new CommandListen())
                /* add intents*/
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                /* build*/
                .build();


        /* set the rich presence state */
        jda.getPresence().setActivity(Activity.listening("commands"));


        /* making the options */
        OptionData Quantity = new OptionData(
                OptionType.STRING,
                "quantity",
                "Amount of times you want to see pong",
                false);


        /* creating commands */
        jda.upsertCommand("ping","says ping the amount of times you")
                .setGuildOnly(true)
                .addOptions(Quantity)
                .queue();

    }
}
