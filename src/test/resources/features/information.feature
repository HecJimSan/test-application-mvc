Feature: Provide different scenarios

  Background: Stub services
    Given Stub service for 1234 code
  Scenario: Get information based in one identifier
    Given a client wants to get relevant data about Spain and population
    When it makes a request to get information
    Then the client receives the data