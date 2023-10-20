package org.yates.craps;

public enum Event {
    Craps, Natural, Point;

    public static Event analyzePoint(int point) {
        return switch (point) {
            case 2, 3, 12 -> Craps;
            case 7, 11 -> Natural;
            default -> Point;
        };
    }
}
