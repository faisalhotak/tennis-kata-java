package org.kata.tennis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class PlayerTest {

//    @ParameterizedTest
//    @ValueSource(strings = {"love", "fifteen", "thirty", "forty"})
//    @DisplayName("When a String point is given, then the evaluatePoint method should return the integer value of the point")
//    void evaluatePoint_shouldReturnTheIntegerValueOfThePoint(String point) {
//        // Given
//        Player player = new Player("Player Test");
//
//        // When
//        int result = player.evaluatePoint(point);
//
//        // Then
//        switch (point) {
//            case "love":
//                assertEquals(0, result);
//                break;
//            case "fifteen":
//                assertEquals(15, result);
//                break;
//            case "thirty":
//                assertEquals(30, result);
//                break;
//            case "forty":
//                assertEquals(40, result);
//                break;
//
//            default:
//                fail("Unexpected point value");
//        }
//
//        assertEquals(0, result);
//    }
}