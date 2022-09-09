package de.chloecdn.cdnlib.network.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.List;

public class BotInstance {

    private JDA jda;

    public BotInstance(String appToken, GatewayIntent[] intents, OnlineStatus onlineStatus, Activity activity, boolean blockCurrentThread) {
        //To avoid errors when shutting down the bot manually.
        //------------------------------------------------------
        try {
            Class.forName("net.dv8tion.jda.internal.managers.AudioManagerImpl");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //------------------------------------------------------
        JDABuilder builder = JDABuilder.createDefault(appToken);
        builder.enableIntents(List.of(intents));
        builder.setStatus(onlineStatus);
        builder.setActivity(activity);
        try {
            this.jda = (!blockCurrentThread) ? builder.build() : builder.build().awaitReady();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        this.jda.shutdown();
    }

    public JDA getJDA() {
        return jda;
    }
}
