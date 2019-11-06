package cuban.engineer.fizzbuzz.domain;

/**
 * Class FizzBuzz for checking if number is: Fizz or Buzz
 */
public class FizzBuzz {


    /**
     * Check if number given is divisible by 3.
     *
     * @param number
     * @return boolean
     */
    public boolean isFizz(Integer number) {
        return (number % 3 == 0);
    }

    /**
     * Check if number given is divisible by 5.
     *
     * @param number
     * @return boolean
     */
    public boolean isBuzz(int number) {
        return (number % 5 == 0);
    }
}
