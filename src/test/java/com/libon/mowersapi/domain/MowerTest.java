package com.libon.mowersapi.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.libon.mowersapi.domain.InstructionEnum.*;
import static com.libon.mowersapi.domain.OrientationEnum.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

 class MowerTest {
    @Test
    void mower_from_north_should_go_west_when_direction_is_left(){
        Mower mower = new Mower("id",0,0,0,0,N, List.of(G));
        mower.applyInstructions();
        OrientationEnum actual = mower.getOrientation();
        assertThat(actual).isEqualTo(W);
    }

    @Test
    void mower_from_north_should_go_east_when_direction_is_right(){
        Mower mower = new Mower("id",0,0,0,0,N, List.of(D));
        mower.applyInstructions();
        OrientationEnum actual = mower.getOrientation();
        assertThat(actual).isEqualTo(E);
    }

    @Test
    void mower_from_south_should_go_east_when_direction_is_left(){
        Mower mower = new Mower("id",0,0,0,0,S,List.of(G));
        mower.applyInstructions();
        OrientationEnum actual = mower.getOrientation();
        assertThat(actual).isEqualTo(E);
    }

    @Test
    void mower_from_south_should_go_west_when_direction_is_right(){

        Mower mower = new Mower("id",0,0,0,0,S,List.of(D));
        mower.applyInstructions();
        OrientationEnum actual = mower.getOrientation();
        assertThat(actual).isEqualTo(W);
    }


    @Test
    void mower_from_west_should_go_south_when_direction_is_left(){
        Mower mower = new Mower("id",0,0,0,0,W,List.of(G));
        mower.applyInstructions();
        OrientationEnum actual = mower.getOrientation();
        assertThat(actual).isEqualTo(S);
    }

    @Test
    void mower_from_west_should_go_north_when_direction_is_right(){
        Mower mower = new Mower("id",0,0,0,0,W,List.of(D));
        mower.applyInstructions();
        OrientationEnum actual = mower.getOrientation();
        assertThat(actual).isEqualTo(N);
    }

    @Test
    void mower_from_east_should_go_north_when_direction_is_left(){
        Mower mower = new Mower("id",0,0,0,0,E,List.of(G));
        mower.applyInstructions();
        OrientationEnum actual = mower.getOrientation();
        assertThat(actual).isEqualTo(N);
    }

    @Test
    void mower_from_east_should_go_south_when_direction_is_right(){
        Mower mower = new Mower("id",0,0,0,0,E,List.of(D));
        mower.applyInstructions();
        OrientationEnum actual = mower.getOrientation();
        assertThat(actual).isEqualTo(S);

    }

    @Test
    void mower_should_advance_south(){
        Mower mower = new Mower("id",1,1,1,1,S,List.of(A));
        mower.applyInstructions();

        assertThat(mower.getY()).isZero();
        assertThat(mower.getX()).isEqualTo(1);
    }
    @Test
    void mower_should_advance_north(){
        Mower mower = new Mower("id",1,1,0,0,N,List.of(A));
        mower.applyInstructions();

        assertThat(mower.getY()).isEqualTo(1);
        assertThat(mower.getX()).isZero();
    }
    @Test
    void mower_should_advance_east(){
        Mower mower = new Mower("id",1,1,0,0,E,List.of(A));
        mower.applyInstructions();

        assertThat(mower.getX()).isEqualTo(1);
        assertThat(mower.getY()).isZero();
    }
    @Test
    void mower_should_advance_west(){
        Mower mower = new Mower("id",1,1,1,1,W,List.of(A));
        mower.applyInstructions();

        assertThat(mower.getX()).isZero();
        assertThat(mower.getY()).isEqualTo(1);
    }


    @Test
    void mower_should_not_advance_south(){
        Mower mower = new Mower("id",1,1,0,0,S,List.of(A));
        mower.applyInstructions();

        assertThat(mower.getY()).isZero();
        assertThat(mower.getX()).isZero();
    }
    @Test
    void mower_should_not_advance_north(){
        Mower mower = new Mower("id",1,1,1,1,N,List.of(A));
        mower.applyInstructions();

        assertThat(mower.getY()).isEqualTo(1);
        assertThat(mower.getX()).isEqualTo(1);
    }
    @Test
    void mower_should_not_advance_east(){
        Mower mower = new Mower("id",1,1,1,1,E,List.of(A));
        mower.applyInstructions();

        assertThat(mower.getX()).isEqualTo(1);
        assertThat(mower.getY()).isEqualTo(1);
    }
    @Test
    void mower_should_not_advance_west(){
        Mower mower = new Mower("id",1,1,0,0,W,List.of(A));
        mower.applyInstructions();

        assertThat(mower.getX()).isZero();
        assertThat(mower.getY()).isZero();
    }

}
