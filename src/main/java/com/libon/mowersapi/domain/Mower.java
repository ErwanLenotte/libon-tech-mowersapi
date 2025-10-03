package com.libon.mowersapi.domain;

public class Mower {
    private static final Integer MIN_X = 0;
    private static final Integer MIN_Y = 0;

    private String id;
    private Integer maxX;
    private Integer maxY;
    private Integer x;
    private Integer y;
    private OrientationEnum orientation;

    public Mower(String id, Integer maxX, Integer maxY, Integer x, Integer y, OrientationEnum orientation) {
        this.id = id;
        this.maxX = maxX;
        this.maxY = maxY;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public OrientationEnum getOrientation() {
        return orientation;
    }

    public String getId() {
        return id;
    }

    public void changeDirection(InstructionEnum instruction) {
        orientation = OrientationFactory.changeOrientation(orientation,instruction);
    }

    public void advance() {
        switch (orientation) {
            case N -> {
                if (y + 1 <= maxY) y++;
            }
            case S -> {
                if (y - 1 >= MIN_Y) y--;
            }
            case W -> {
                if (x - 1 >= MIN_X) x--;
            }
            case E -> {
                if (x + 1 <= maxX) x++;
            }
        }
    }


}
