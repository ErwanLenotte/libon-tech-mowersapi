package com.libon.mowersapi.domain.orientation;

import org.junit.jupiter.api.Test;

import static com.libon.mowersapi.domain.instruction.DirectionEnum.*;
import static com.libon.mowersapi.domain.orientation.OrientationEnum.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OrientationFactoryTest {
    @Test
    void from_north_should_go_west_when_direction_is_left() {
        OrientationEnum actual = OrientationFactory.changeOrientation(N, G);
        assertThat(actual).isEqualTo(W);
    }

    @Test
    void from_north_should_go_east_when_direction_is_right() {
        OrientationEnum actual = OrientationFactory.changeOrientation(N, D);
        assertThat(actual).isEqualTo(OrientationEnum.E);
    }

    @Test
    void from_south_should_go_east_when_direction_is_left() {
        OrientationEnum actual = OrientationFactory.changeOrientation(S, G);
        assertThat(actual).isEqualTo(OrientationEnum.E);
    }

    @Test
    void from_south_should_go_west_when_direction_is_right() {
        OrientationEnum actual = OrientationFactory.changeOrientation(S, D);
        assertThat(actual).isEqualTo(W);
    }


    @Test
    void from_west_should_go_south_when_direction_is_left() {
        OrientationEnum actual = OrientationFactory.changeOrientation(W, G);
        assertThat(actual).isEqualTo(OrientationEnum.S);
    }

    @Test
    void from_west_should_go_north_when_direction_is_right() {
        OrientationEnum actual = OrientationFactory.changeOrientation(W, D);
        assertThat(actual).isEqualTo(N);
    }

    @Test
    void from_east_should_go_north_when_direction_is_left() {
        OrientationEnum actual = OrientationFactory.changeOrientation(E, G);
        assertThat(actual).isEqualTo(N);
    }

    @Test
    void from_east_should_go_south_when_direction_is_right() {
        OrientationEnum actual = OrientationFactory.changeOrientation(E, D);
        assertThat(actual).isEqualTo(S);
    }


}
