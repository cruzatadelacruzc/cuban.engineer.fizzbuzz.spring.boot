package cuban.engineer.fizzbuzz;

import cuban.engineer.fizzbuzz.service.SequenceGeneratorFizzBuzzService;
import cuban.engineer.fizzbuzz.web.rest.FizzBuzzResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration tests for the {@link FizzBuzzResource} REST controller.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FizzBuzzResourceIT {

    private static final String SEQUENCE = "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz,16,17,Fizz,19,Buzz";

    private final Integer startBoundary = 1;
    private final Integer endBoundary = 20;

    private MockMvc mockMvc;

    @MockBean
    private SequenceGeneratorFizzBuzzService fizzBuzzService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(fizzBuzzService.sequenceGenerator(startBoundary, endBoundary)).thenReturn(SEQUENCE);
        FizzBuzzResource resource = new FizzBuzzResource(fizzBuzzService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(resource).build();
    }

    @Test
    public void testSequenceFizzBuzzRight() throws Exception {

        mockMvc.perform(get("/fizzbuzz")
                .param("start", String.valueOf(startBoundary))
                .param("end", String.valueOf(endBoundary)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(SEQUENCE)));
    }

    @Test
    public void testInputParametersWrong() throws Exception {
        mockMvc.perform(get("/fizzbuzz")
                .param("start", "30")
                .param("end", "20"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
