package com.libon.mowersapi.domain.mower;

import com.libon.mowersapi.domain.instruction.DirectionEnum;
import com.libon.mowersapi.domain.instruction.Instruction;
import com.libon.mowersapi.domain.orientation.OrientationEnum;
import com.libon.mowersapi.domain.orientation.OrientationFactory;

import java.util.List;

public class Mower {
    private static final int MIN_X = 0;
    private static final int MIN_Y = 0;


    private final String id;
    private final Integer maxX;
    private final Integer maxY;
    private int x;
    private int y;
    private OrientationEnum orientation;
    private final List<Instruction> instructions;


    public Mower(String id, int maxX, int maxY, int x, int y, OrientationEnum orientation, List<Instruction> instructions) {
        this.id = id;
        this.maxX = maxX;
        this.maxY = maxY;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.instructions = instructions;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public OrientationEnum getOrientation() {
        return orientation;
    }

    public String getId() {
        return id;
    }

    public void changeDirection(DirectionEnum direction) {
        orientation = OrientationFactory.changeOrientation(orientation, direction);
    }

    public void advance() {
        switch (orientation) {
            case N -> goNorth();
            case S -> goSouth();
            case W -> goWest();
            case E -> goEast();
        }
    }

    public Mower applyInstructions() {
        instructions.stream().forEach( instruction -> instruction.applyToMower(this));
        return this;
    }

    private void goEast() {
        if (x + 1 <= maxX) x++;
    }

    private void goWest() {
        if (x - 1 >= MIN_X) x--;
    }

    private void goSouth() {
        if (y - 1 >= MIN_Y) y--;
    }

    private void goNorth() {
        if (y + 1 <= maxY) y++;
    }

}
