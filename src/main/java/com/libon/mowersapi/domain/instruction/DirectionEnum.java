package com.libon.mowersapi.domain.instruction;

import com.libon.mowersapi.domain.mower.Mower;

public enum DirectionEnum implements  Instruction{
    G,D;

    @Override
    public void applyToMower(Mower mower) {
        mower.changeDirection(this);
    }
}
