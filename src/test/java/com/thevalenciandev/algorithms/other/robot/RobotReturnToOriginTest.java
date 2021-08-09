package com.thevalenciandev.algorithms.other.robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RobotReturnToOriginTest {

    @Test
    void test() {
        assertFalse(RobotReturnToOrigin.judgeCircle("L"));
        assertFalse(RobotReturnToOrigin.judgeCircle("LL"));
        assertTrue(RobotReturnToOrigin.judgeCircle("UD"));
        assertFalse(RobotReturnToOrigin.judgeCircle("RRDD"));
        assertFalse(RobotReturnToOrigin.judgeCircle("LDRRLRUULR"));
        assertTrue(RobotReturnToOrigin.judgeCircle("LLDDRRUU"));
    }

}