package org.yates.craps;

import org.yates.io.InputHandler;

public class Player {
    private final String name;

    public Player() {
        InputHandler ih = InputHandler.builder()
                .prompt("Please enter a name: ")
                .build();
        name = ih.query();
    }

    public Roll roll() {
        return new Roll();
    }

    public String getName() {
        return this.name;
    }
}
