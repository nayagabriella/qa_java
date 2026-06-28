package com.example;

import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Test
    public void testLionMale() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testLionFemale() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testLionInvalidSex() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        new Lion("Неизвестно", feline);
    }

    @Test
    public void testGetKittens() throws Exception {
        // Создаём мок Feline
        Feline feline = Mockito.mock(Feline.class);
        when(feline.getKittens()).thenReturn(5);

        Lion lion = new Lion("Самец", feline);
        assertEquals(5, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", feline);
        assertEquals(expectedFood, lion.getFood());
    }
}