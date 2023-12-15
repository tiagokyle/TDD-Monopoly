import com.example.tddmonopoly.Dice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiceTest {

    @Test
    void diceShouldBeTwelveWithTwoSixes(){
        Random random = mock(Random.class);
        when(random.nextInt(6)).thenReturn(5);

        Dice dice = new Dice(random);
        int[] expected = new int[] {6,6};

        assertArrayEquals(expected,dice.roll());

    }

    @Test
    void diceShouldReturnTrueWhenDouble(){
        Random random = mock(Random.class);
        when(random.nextInt(6)).thenReturn(5);

        Dice dice = new Dice(random);
        dice.roll();

        Assertions.assertTrue(dice.isDouble(), "Not a valid double!");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void validDoubleWhenDiceAreTheSame(int number){
        Random random = mock(Random.class);
        when(random.nextInt(6)).thenReturn(number);

        Dice dice = new Dice(random);
        dice.roll();

        Assertions.assertTrue(dice.isDouble(), "Not a valid double!");
    }

}