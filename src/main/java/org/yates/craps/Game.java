package org.yates.craps;

import org.yates.io.InputHandler;

public class Game {
    private final Player player = new Player();

    public Game() {
        System.out.printf("Welcome to craps, %s.%n", player.getName());
        run();
        System.out.println("Thanks for playing, " + player.getName());
    }

    public void run() {
        InputHandler ih = InputHandler.builder()
                .prompt("Press 'r' to start a game and 'q' to quit: ")
                .errorMessage("Please enter either 'r' or 'q'")
                .validator(in -> in.equals("r") || in.equals("q"))
                .build();
        while (true) {
            if (ih.query().equals("q"))
                return;

            Roll roll = player.roll();
            Event ev = Event.analyzePoint(roll.getPoint());
            if (ev == Event.Natural) {
                System.out.println("You rolled a natural " + roll.getPoint() + "!!");
                System.out.println("You won!!!");
                continue;
            } else if (ev == Event.Craps) {
                System.out.println("Awh craps! You rolled a " + roll.getPoint() + "...");
                System.out.println("You lose!");
                continue;
            }

            // Rolled a point
            System.out.println("You rolled a point number!");
            System.out.printf("Now roll %d again before you roll a seven!!%n", roll.getPoint());
            while (true) {
                Roll r = player.roll();
                if (r.getPoint() == 7) {
                    System.out.println("Seven-out! You lost!");
                    break;
                } else if (r.getPoint() == roll.getPoint()) {
                    System.out.println("You got a successful pass! You win!");
                    break;
                }
            }
        }
    }
}
