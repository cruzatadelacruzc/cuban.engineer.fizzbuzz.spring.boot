package cuban.engineer.fizzbuzz;

import cuban.engineer.fizzbuzz.service.SequenceGeneratorFizzBuzzService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration tests for the {@link SequenceGeneratorFizzBuzzService } service.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SequenceGeneratorFizzBuzzServiceIT {

    private static final String SEQUENCE_RIGHT = "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz,16,17,Fizz,19,Buzz";
    private static final String SEQUENCE_WRONG = "1,2,Buzz,4,Fizz,Buzz,7,8,Buzz,Fizz,11,Buzz,13,14,Fizz,16,17,Buzz,19,Fizz";

    private final Integer startBoundary = 1;
    private final Integer endBoundary = 20;


    @Autowired
    private SequenceGeneratorFizzBuzzService fizzBuzzService;

    @Test
    public void assertThatServiceGeneratesSequence() {
        assertThat(fizzBuzzService.sequenceGenerator(startBoundary,endBoundary)).isEqualTo(SEQUENCE_RIGHT);
    }

    @Test
    public void assertThatServiceGeneratesSequenceRight() {
        assertThat(fizzBuzzService.sequenceGenerator(startBoundary,endBoundary)).isNotEqualTo(SEQUENCE_WRONG);
    }



}
