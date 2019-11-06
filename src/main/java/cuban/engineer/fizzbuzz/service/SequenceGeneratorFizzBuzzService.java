package cuban.engineer.fizzbuzz.service;

import cuban.engineer.fizzbuzz.domain.FizzBuzz;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

/**
 * Class SequenceGeneratorFizzBuzzService is a Service for generating a FizzBuzz sequence.
 */
@Service
public class SequenceGeneratorFizzBuzzService {

    private final FizzBuzz fizzBuzzClass = new FizzBuzz();

    /**
     * FizzBuzz Sequence generator
     *
     * @param start start boundary of the range.
     * @param end end boundary of the range.
     * @return the {@link String} sequence FizzBuzz.
     */
    public String sequenceGenerator(int start, int end) {
        StringBuilder chain = new StringBuilder();
        IntStream.rangeClosed(start, end).forEach(number -> {
            String result = "";
            if (fizzBuzzClass.isFizz(number))
                result = "Fizz";
            if (fizzBuzzClass.isBuzz(number))
                result += "Buzz";
            if (result.equals(""))
                result = Integer.toString(number);
            chain.append(number < end ? String.format("%s,", result): result);
        });
        return chain.toString();
    }
}
