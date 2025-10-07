package com.libon.mowersapi.domain.instruction;

import com.libon.mowersapi.domain.mower.Mower;

public enum MouvementEnum implements Instruction{
    A;

    @Override
    public void applyToMower(Mower mower) {
        mower.advance();
    }
}
