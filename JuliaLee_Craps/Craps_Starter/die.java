package Craps_Starter;

/**
 * RandomGenerator is replacement for Random class.
 * It is blazing fast and has more variety of methods than Random.
 * It is not cryptographically secure. If needed for more security, use SecureRandom.
 */

import java.util.random.RandomGenerator;


public class die {
    int sides;

    // Get the default RandomGenerator for use in method rollDice
    private final RandomGenerator randomNumbers = RandomGenerator.getDefault();

    public die(int sides) {
        this.sides = sides;
    }

    public int roll() {
        return randomNumbers.nextInt(1, sides + 1);
    }
}