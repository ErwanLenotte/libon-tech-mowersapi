package com.libon.mowersapi.domain;

import java.util.Map;

import static com.libon.mowersapi.domain.InstructionEnum.*;
import static com.libon.mowersapi.domain.OrientationEnum.*;

public class OrientationFactory {

    private static Map<InstructionEnum,OrientationEnum> northMap = Map.of(G, W, D, E);
    private static Map<InstructionEnum,OrientationEnum> southMap = Map.of(G, E, D, W);
    private static Map<InstructionEnum,OrientationEnum> westMap = Map.of(G, S, D, N);
    private static Map<InstructionEnum,OrientationEnum> eastMap = Map.of(G, N, D, S);


    private OrientationFactory() {
    }

    public static OrientationEnum changeOrientation(OrientationEnum orientation, InstructionEnum instruction) {
        return switch (orientation) {
            case N -> northMap.getOrDefault(instruction, N);
            case S -> southMap.getOrDefault(instruction, S);
            case W -> westMap.getOrDefault(instruction, W);
            case E -> eastMap.getOrDefault(instruction, E);
        };
    }
}
