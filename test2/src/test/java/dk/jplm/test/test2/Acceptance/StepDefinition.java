package dk.jplm.test.test2.Acceptance;


import dk.jplm.test.test2.service.Game;
import dk.jplm.test.test2.service.UtilityService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class StepDefinition {
    private static final String URL = "/utility/reverse";
    // For REST endpoint testing
    @Autowired
    private MockMvc mvc;

    @Autowired
    private UtilityService utilityService;

   /* Not used since i needed a new instance of the object for each loop
   @Autowired
    private Game game;
    */

    private String provided;
    private String expected;
    private String actual;

    @Given("that the user provides a valid String {string}")
    public void that_the_user_provides_a_valid_string(String string) {
        System.out.println("User enters value here");
        provided = string;
    }

    @When("invoking reverse String utility")
    public void invoking_reverse_string_utility() {
       /* Example for testing a REST endpoint
        this.actual = this.mvc.perform(get(URL).queryParam("string", String.valueOf(string)))
                .andReturn()
                .getResponse()
                .getContentAsString();
        */
        this.actual = utilityService.reverseString(this.provided);
    }

    @Then("the user should be shown a reverse String order {string}")
    public void the_user_should_be_shown_a_reverse_string_order(String string) {
        this.expected = string;
        assertEquals(expected, actual);
    }

    private String providedLowercase;
    private String expectedTwo;
    private String actualTwo;

    @Given("a user provides a valid input {string}")
    public void aUserProvidesAValidInputLowercase(String input) {
        this.providedLowercase = input;
    }

    @When("wanting to capitalize a String")
    public void wantingToCapitalizeAString() {
        this.actualTwo = utilityService.capitalizeString(this.providedLowercase);
    }

    @Then("the String will be capitalized {string}")
    public void theStringWillBeCapitalizedUppercase(String output) {
        this.expectedTwo = output;
        assertEquals(expectedTwo, actualTwo);
    }

    private String providedUppercase;
    private String expectedThree;
    private String actualThree;

    @Given("a user provides a valid String input {string}")
    public void aUserProvidesAValidStringInputStringInput(String stringInput) {
        this.providedUppercase = stringInput;
    }

    @When("wanting to lowercase a String")
    public void wantingToLowercaseAString() {
        this.actualThree = utilityService.lowercaseString(providedUppercase);
    }

    @Then("the user input will be lowercased {string}")
    public void theUserInputWillBeLowercasedStringOutput(String stringOutput) {
        this.expectedThree = stringOutput;
        assertEquals(expectedThree, actualThree);
    }

    private Integer frames;
    private Integer pins;
    private Integer score;

    // Little method to be able to hack the bowling solution ¯\_(ツ)_/¯
    public void rollMany(int n, int pins, Game game) {
        for (int i = 0; i < n; i++)
            game.roll(pins);
    }

    @Given("you have bowled {int} times")
    public void youHaveBowledFramesTimes(int frames) {
        this.frames = frames;
    }

    @When("knocking down {int}")
    public void knockingDownPins(int pins) {
        this.pins = pins;
    }

    @Then("your total score should be: {int}")
    public void yourTotalScoreShouldBeScore(int score) {
        Game game = new Game();
        rollMany(frames, pins, game);
        game.roll(this.pins);
        int expectedScore = game.score();
        this.score = score;
        assertEquals(expectedScore, score);
    }

}
