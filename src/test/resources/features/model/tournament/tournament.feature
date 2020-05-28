Feature: Tournament functionalities

  Scenario: Check tournament number of games
    Given Tournament has been played
    #When
    Then There has to be exactly 100 played games
