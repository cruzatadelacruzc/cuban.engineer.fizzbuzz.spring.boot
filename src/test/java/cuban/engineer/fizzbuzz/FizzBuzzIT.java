package cuban.engineer.fizzbuzz;

import cuban.engineer.fizzbuzz.domain.FizzBuzz;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration tests for the {@link FizzBuzz} domain.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FizzBuzzIT {

    private FizzBuzz fizzBuzz;
    private final Integer fizzNumber = 3;
    private final Integer notFizzNumber = 31;

    private final Integer buzzNumber = 55;
    private final Integer notBuzzNumber = 56;

    @Before
    public void setUp() {
        this.fizzBuzz = new FizzBuzz();
    }

    @Test
    public void testNumberIsFizz() {
        assertThat(this.fizzBuzz.isFizz(fizzNumber)).isTrue();
    }

    @Test
    public void testNumberIsNotFizz() {
        assertThat(this.fizzBuzz.isFizz(notFizzNumber)).isFalse();
    }

    @Test
    public void testNumberIsBuzz() {
        assertThat(this.fizzBuzz.isBuzz(buzzNumber)).isTrue();
    }

    @Test
    public void testNumberIsNotBuzz() {
        assertThat(this.fizzBuzz.isBuzz(notBuzzNumber)).isFalse();
    }
}
