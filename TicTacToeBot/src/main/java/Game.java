import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;
import java.util.*;

public class Game {

    public boolean gameOver = false;

    public boolean running = false;

    public int botMove;

    public int numMoves;

    public String endMessage = "";

    public String[][] board = {{":white_small_square:", ":white_small_square:", ":white_small_square:"},
            {":white_small_square:", ":white_small_square:", ":white_small_square:"},
            {":white_small_square:", ":white_small_square:", ":white_small_square:"}};

    public Color color = new Color(90, 100, 240);

    public EmbedBuilder embed = new EmbedBuilder();

    public Random random;

    public void drawBoard() {
        StringBuilder out = new StringBuilder();
        for (String[] strings : board) {
            for (int j = 0; j < board[0].length; j++) {
                out.append(strings[j]);
            }
            out.append("\n");
        }
        embed.setDescription(out.toString());
    }

    public void updateBotMove() {
        random = new Random();
        botMove = random.nextInt(9) + 1;
    }

    public void movePlayer(int playerMove) {
        switch (playerMove) {
            case 1 -> board[0][0] = ":negative_squared_cross_mark:";
            case 2 -> board[0][1] = ":negative_squared_cross_mark:";
            case 3 -> board[0][2] = ":negative_squared_cross_mark:";
            case 4 -> board[1][0] = ":negative_squared_cross_mark:";
            case 5 -> board[1][1] = ":negative_squared_cross_mark:";
            case 6 -> board[1][2] = ":negative_squared_cross_mark:";
            case 7 -> board[2][0] = ":negative_squared_cross_mark:";
            case 8 -> board[2][1] = ":negative_squared_cross_mark:";
            case 9 -> board[2][2] = ":negative_squared_cross_mark:";
        }
        numMoves++;
        checkBoard();
    }

    public void moveBot() {
        if (!gameOver) {
            updateBotMove();

            switch (botMove) {
                case 1:
                    if (board[0][0].equals(":white_small_square:")) {
                        board[0][0] = ":o2:";
                        numMoves++;
                    }
                    else {
                        moveBot();
                    }
                    break;
                case 2:
                    if (board[0][1].equals(":white_small_square:")) {
                        board[0][1] = ":o2:";
                        numMoves++;
                    }
                    else {
                        moveBot();
                    }
                    break;
                case 3:
                    if (board[0][2].equals(":white_small_square:")) {
                        board[0][2] = ":o2:";
                        numMoves++;
                    }
                    else {
                        moveBot();
                    }
                    break;
                case 4:
                    if (board[1][0].equals(":white_small_square:")) {
                        board[1][0] = ":o2:";
                        numMoves++;
                    }
                    else {
                        moveBot();
                    }
                    break;
                case 5:
                    if (board[1][1].equals(":white_small_square:")) {
                        board[1][1] = ":o2:";
                        numMoves++;
                    }
                    else {
                        moveBot();
                    }
                    break;
                case 6:
                    if (board[1][2].equals(":white_small_square:")) {
                        board[1][2] = ":o2:";
                        numMoves++;
                    }
                    else {
                        moveBot();
                    }
                    break;
                case 7:
                    if (board[2][0].equals(":white_small_square:")) {
                        board[2][0] = ":o2:";
                        numMoves++;
                    }
                    else {
                        moveBot();
                    }
                    break;
                case 8:
                    if (board[2][1].equals(":white_small_square:")) {
                        board[2][1] = ":o2:";
                        numMoves++;
                    }
                    else {
                        moveBot();
                    }
                    break;
                case 9:
                    if (board[2][2].equals(":white_small_square:")) {
                        board[2][2] = ":o2:";
                        numMoves++;
                    }
                    else {
                        moveBot();
                    }
                    break;
            }
            checkBoard();
        }
    }

    public void resetBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ":white_small_square:";
            }
        }
        numMoves = 0;
        gameOver = false;
    }

    public void checkBoard() {
        if ((board[0][0].equals(":negative_squared_cross_mark:") && board[0][1].equals(":negative_squared_cross_mark:") && board[0][2].equals(":negative_squared_cross_mark:"))
                || (board[1][0].equals(":negative_squared_cross_mark:") && board[1][1].equals(":negative_squared_cross_mark:") && board[1][2].equals(":negative_squared_cross_mark:"))
                || (board[2][0].equals(":negative_squared_cross_mark:") && board[2][1].equals(":negative_squared_cross_mark:") && board[2][2].equals(":negative_squared_cross_mark:"))) {
            endMessage = "You win!";
            gameOver = true;
        }
        else if ((board[0][0].equals(":o2:") && board[0][1].equals(":o2:") && board[0][2].equals(":o2:"))
                || (board[1][0].equals(":o2:") && board[1][1].equals(":o2:") && board[1][2].equals(":o2"))
                || (board[2][0].equals(":o2:") && board[2][1].equals(":o2:") && board[2][2].equals(":o2:"))) {
            endMessage = "I win!";
            gameOver = true;
        }
        else if ((board[0][0].equals(":negative_squared_cross_mark:") && board[1][0].equals(":negative_squared_cross_mark:") && board[2][0].equals(":negative_squared_cross_mark:"))
                || (board[0][1].equals(":negative_squared_cross_mark:") && board[1][1].equals(":negative_squared_cross_mark:") && board[2][1].equals(":negative_squared_cross_mark:"))
                || (board[0][2].equals(":negative_squared_cross_mark:") && board[1][2].equals(":negative_squared_cross_mark:") && board[2][2].equals(":negative_squared_cross_mark:"))) {
            endMessage = "You win!";
            gameOver = true;
        }
        else if ((board[0][0].equals(":o2") && board[1][0].equals(":o2:") && board[2][0].equals(":o2:"))
                || (board[0][1].equals(":o2:") && board[1][1].equals(":o2:") && board[2][1].equals(":o2:"))
                || (board[0][2].equals(":o2:") && board[1][2].equals(":o2:") && board[2][2].equals(":o2:"))) {
            endMessage = "I win!";
            gameOver = true;
        }
        else if ((board[0][0].equals(":negative_squared_cross_mark:") && board[1][1].equals(":negative_squared_cross_mark:") && board[2][2].equals(":negative_squared_cross_mark:"))
                || (board[0][2].equals(":negative_squared_cross_mark:") && board[1][1].equals(":negative_squared_cross_mark:") && board[2][0].equals(":negative_squared_cross_mark:"))) {
            endMessage = "You win!";
            gameOver = true;
        }
        else if ((board[0][0].equals(":o2:") && board[1][1].equals(":o2:") && board[2][2].equals(":o2:"))
                || (board[0][2].equals(":o2:") && board[1][1].equals(":o2:") && board[2][0].equals(":o2:"))) {
            endMessage = "I win!";
            gameOver = true;
        }
        else if (numMoves >= 9) {
            endMessage = "Cat-scratch!";
            gameOver = true;
        }
    }

    public void drawGameEmbed(GuildMessageReceivedEvent event) {
        embed.setTitle("Tic-Tac-Toe", "");
        drawBoard();
        if (gameOver) {
            embed.addField(endMessage, "Type '!start' to play again!", false);
            numMoves = 0;
            running = false;
        }
        embed.setColor(color);
        embed.setFooter("Bot created by ff4lse #8864");
        event.getMessage().reply(embed.build()).queue();
        embed.clear();
    }

    public void drawGameHelpEmbed(GuildMessageReceivedEvent event) {
        embed.setTitle("Tic-Tac-Toe Helper", "");
        embed.setDescription("Answers to frequently asked questions below.");
        embed.addField("How do I start the game?", "Type '!start'.", false);
        embed.addField("How do I end the game?", "Type '!end'.", false);
        embed.addField("How do I reset the game?", "Type '!reset'.", false);
        embed.addField("How do I select where I move?", "Type the prefix '!' followed by a number (1-9).", false);
        embed.setColor(color);
        embed.setFooter("Bot created by ff4lse #8864");
        event.getMessage().reply(embed.build()).queue();
        embed.clear();
    }
}