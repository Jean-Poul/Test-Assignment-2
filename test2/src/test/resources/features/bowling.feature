Feature: Bowling game

  Scenario Outline: Bowling game
    Given you have bowled <frames> times
    When knocking down <pins>
    Then your total score should be: <score>
    Examples:
      | frames | pins | score |
      | 20     | 0    | 0     |
      | 20     | 1    | 20    |
      | 12     | 10   | 300   |