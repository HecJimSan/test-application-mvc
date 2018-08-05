package com.test.testapplication.bdd;


import com.test.testapplication.controller.InfoDetailsDTO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class InformationSteps extends CucumberRoot {


    public static final String CODE_MESSAGE = "code should contains ES for the country selected";
    public static final String DESCRIPTION_MESSAGE = "description should contains Nice place to have visit";
    private  String countrySelection;
    private String descriptionSelection;
    private InfoDetailsDTO infoDetails;
    private String uri;

    @Given("^a client wants to get relevant data about ([^\\\\s]+) and ([^\\\\s]+)")
    public void a_client_wants_to_get_relevant_data_about(String country, String description) throws Throwable {
        countrySelection = country;
        descriptionSelection = description;
        uri = "http://localhost:" + port + "/information";
    }

    @When("^it makes a request to get information")
    public void it_makes_a_request_to_get_information_about_Spain() throws Throwable {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(uri);
        stringBuilder.append("?");
        stringBuilder.append("country=");
        stringBuilder.append(countrySelection);
        stringBuilder.append("&");
        stringBuilder.append("description=");
        stringBuilder.append(descriptionSelection);
        infoDetails = testRestTemplate.getForObject(stringBuilder.toString(), InfoDetailsDTO.class);
    }

    @Then("^the client receives the data$")
    public void the_client_receives_the_data() throws Throwable {
        Assert.assertEquals(CODE_MESSAGE, infoDetails.getCode(), "1235");
        Assert.assertEquals(DESCRIPTION_MESSAGE, infoDetails.getDescription(), "100000 people");
    }



}