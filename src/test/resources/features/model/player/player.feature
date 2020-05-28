Feature: Player expected strategy

  Scenario: First player should return random moves
    Given First player is of RandomPlayer type
    When Player makes a new move
    Then It invokes randomizer

  Scenario: RockPlayer should return rock moves
    Given Second player is of RockPlayer type
    #When
    Then It returns a ROCK move