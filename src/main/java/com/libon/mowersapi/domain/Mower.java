package com.libon.mowersapi.domain;

import java.util.List;

public class Mower {
    private static final Integer MIN_X = 0;
    private static final Integer MIN_Y = 0;


    private final String id;
    private final Integer maxX;
    private final Integer maxY;
    private Integer x;
    private Integer y;
    private OrientationEnum orientation;
    private final List<InstructionEnum> instructions;


    public Mower(String id, Integer maxX, Integer maxY, Integer x, Integer y, OrientationEnum orientation, List<InstructionEnum> instructions) {
        this.id = id;
        this.maxX = maxX;
        this.maxY = maxY;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.instructions = instructions;
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

    private void changeDirection(InstructionEnum instruction) {
        orientation = OrientationFactory.changeOrientation(orientation, instruction);
    }

    private void advance() {
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


    public Mower applyInstructions() {
        for (InstructionEnum instruction : instructions) {
            switch (instruction) {
                case G, D -> this.changeDirection(instruction);
                case A -> this.advance();
            }
        }

        return this;
    }
}
