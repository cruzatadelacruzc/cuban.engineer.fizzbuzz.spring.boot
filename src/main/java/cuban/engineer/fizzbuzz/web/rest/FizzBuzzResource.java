package cuban.engineer.fizzbuzz.web.rest;

import cuban.engineer.fizzbuzz.service.SequenceGeneratorFizzBuzzService;
import cuban.engineer.fizzbuzz.web.rest.error.WrongBoundaryException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FizzBuzzResource {

    private final SequenceGeneratorFizzBuzzService fizzBuzzService;

    public FizzBuzzResource(SequenceGeneratorFizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    /**
     * Generate a FizzBuzz sequence.
     * @param start start boundary of the range.
     * @param end end boundary of the range.
     * @return the {@link ResponseEntity} with status {@code 200 (Ok)} and the sequence FizzBuzz.
     * @throws WrongBoundaryException {@code 400 (Bad Request)} if {@param start} is greater than {@param end}.
     */
    @RequestMapping("/fizzbuzz")
    public String generateSequenceFizzBuzz( @RequestParam("start") int start, @RequestParam("end") int end) throws WrongBoundaryException {
        if (start >= end )
            throw new WrongBoundaryException(String.format("Wrong boundaries range. start boundary (%d) must be greater than end boundary (%d).", start, end));
        return fizzBuzzService.sequenceGenerator(start, end);
    }
}
