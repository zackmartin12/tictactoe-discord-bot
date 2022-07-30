import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) throws LoginException {
        JDABuilder jda = JDABuilder.createDefault("OTg2ODA3MjUyNTQ1NTkzMzg0.GzF2IN.4ZddkrHBs-2uZFdqpJo5aOWP7YcrssRXbik6Fo");
        jda.setActivity(Activity.playing("Tic-Tac-Toe"));
        jda.addEventListeners(new Commands());
        jda.build();
    }
}