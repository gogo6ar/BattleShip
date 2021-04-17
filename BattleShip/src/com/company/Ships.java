package com.company;

public enum Ships {
    SHIP1PX("\uD83D\uDEE5"), SHIP2PX("\uD83D\uDEE5"),
    SHIP3PX("\uD83D\uDEE5"), SHIP4PX("\uD83D\uDEE5"),
    EMPTY("\u2B1C"), ARIA("\uD83D\uDFE6"), FIRE("\u25CF"),
    SHIP_SHOT("\u2716");

    public String getDescription() {
        return description;
    }

    private String description;

    Ships(String description) {
        this.description = description;
    }

    Ships() {

    }
}
