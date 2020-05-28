Feature: Tournament functionalities

  Scenario: Check tournament number of games
    Given Tournament has been played
    #When
    Then There has to be exactly 100 played games


  Scenario: Check stats report quantities for all possible game results
    Given Tournament has been played
    #When
    Then Stats should contain DRAW results
    And  Stats should contain FIRST_PLAYER results
    And  Stats should contain SECOND_PLAYER results
    And  Result summation should be 100
