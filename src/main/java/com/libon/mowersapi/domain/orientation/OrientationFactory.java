package com.libon.mowersapi.domain.orientation;

import com.libon.mowersapi.domain.instruction.DirectionEnum;

import java.util.Map;

import static com.libon.mowersapi.domain.instruction.DirectionEnum.*;
import static com.libon.mowersapi.domain.orientation.OrientationEnum.*;

public class OrientationFactory {

    private static final Map<DirectionEnum,OrientationEnum> northMap = Map.of(G, W, D, E);
    private static final Map<DirectionEnum,OrientationEnum> southMap = Map.of(G, E, D, W);
    private static final  Map<DirectionEnum,OrientationEnum> westMap = Map.of(G, S, D, N);
    private static final Map<DirectionEnum,OrientationEnum> eastMap = Map.of(G, N, D, S);


    private OrientationFactory() {
    }

    public static OrientationEnum changeOrientation(OrientationEnum orientation, DirectionEnum direction) {
        return switch (orientation) {
            case N -> northMap.getOrDefault(direction, N);
            case S -> southMap.getOrDefault(direction, S);
            case W -> westMap.getOrDefault(direction, W);
            case E -> eastMap.getOrDefault(direction, E);
        };
    }
}
