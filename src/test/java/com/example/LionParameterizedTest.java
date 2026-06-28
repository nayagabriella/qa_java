package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private String sex;
    private boolean expectedHasMane;

    public LionParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][] {
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void testLionSexAndMane() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, feline);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}