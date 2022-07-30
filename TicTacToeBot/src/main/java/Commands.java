import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;

public class Commands extends ListenerAdapter {
    public Game game;

    public HashMap<User, Game> games = new HashMap<>();

    public String prefix = "!";

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split(" ");

        if (!games.containsKey(event.getAuthor())) {
            games.put(event.getAuthor(), new Game());
        }

        game = games.get(event.getAuthor());

        if (args[0].equalsIgnoreCase(prefix + "start") && !game.running) {
            game.running = true;
            game.resetBoard();
            game.drawGameEmbed(event);
        }

        if (game.running) {
            if (args[0].equalsIgnoreCase(prefix + "1") && (game.board[0][0].equals(":white_small_square:"))) {
                game.movePlayer(1);
                game.moveBot();
                game.drawGameEmbed(event);
            }
            else if (args[0].equalsIgnoreCase(prefix + "2") && (game.board[0][1].equals(":white_small_square:"))) {
                game.movePlayer(2);
                game.moveBot();
                game.drawGameEmbed(event);
            }
            else if (args[0].equalsIgnoreCase(prefix + "3") && (game.board[0][2].equals(":white_small_square:"))) {
                game.movePlayer(3);
                game.moveBot();
                game.drawGameEmbed(event);
            }
            else if (args[0].equalsIgnoreCase(prefix + "4") && (game.board[1][0].equals(":white_small_square:"))) {
                game.movePlayer(4);
                game.moveBot();
                game.drawGameEmbed(event);
            }
            else if (args[0].equalsIgnoreCase(prefix + "5") && (game.board[1][1].equals(":white_small_square:"))) {
                game.movePlayer(5);
                game.moveBot();
                game.drawGameEmbed(event);
            }
            else if (args[0].equalsIgnoreCase(prefix + "6") && (game.board[1][2].equals(":white_small_square:"))) {
                game.movePlayer(6);
                game.moveBot();
                game.drawGameEmbed(event);
            }
            else if (args[0].equalsIgnoreCase(prefix + "7") && (game.board[2][0].equals(":white_small_square:"))) {
                game.movePlayer(7);
                game.moveBot();
                game.drawGameEmbed(event);
            }
            else if (args[0].equalsIgnoreCase(prefix + "8") && (game.board[2][1].equals(":white_small_square:"))) {
                game.movePlayer(8);
                game.moveBot();
                game.drawGameEmbed(event);
            }
            else if (args[0].equalsIgnoreCase(prefix + "9") && (game.board[2][2].equals(":white_small_square:"))) {
                game.movePlayer(9);
                game.moveBot();
                game.drawGameEmbed(event);
            }
            else if (args[0].equalsIgnoreCase(prefix + "reset")) {
                game.resetBoard();
                game.drawGameEmbed(event);
            }
            else if (args[0].equalsIgnoreCase(prefix + "end")) {
                game.resetBoard();
                game.running = false;
            }
        }

        if (args[0].equalsIgnoreCase(prefix + "help")) {
            game.drawGameHelpEmbed(event);
        }
    }
}
