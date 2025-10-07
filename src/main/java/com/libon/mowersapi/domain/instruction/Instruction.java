package com.libon.mowersapi.domain.instruction;

import com.libon.mowersapi.domain.mower.Mower;

public interface Instruction {
     void applyToMower(Mower mower);
}
