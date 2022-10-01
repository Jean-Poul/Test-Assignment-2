Feature: String utility
  We want to be able to test several string utilities

  Scenario Outline: Reverse String order in a given String
    Given that the user provides a valid String <Normal>
    When invoking reverse String utility
    Then the user should be shown a reverse String order <Reverse>
    Examples:
      | Normal | Reverse |
      | "aBc"  | "cBa"   |
      | "Kiss" | "ssiK"  |
      | "teSt" | "tSet"  |

  Scenario Outline: Capitalize String
    Given a user provides a valid input <lowercase>
    When wanting to capitalize a String
    Then the String will be capitalized <uppercase>
    Examples:
      | lowercase | uppercase |
      | "abc"     | "ABC"     |
      | "kiss"    | "KISS"    |
      | "test"    | "TEST"    |

  Scenario Outline: Lowercase String
    Given a user provides a valid String input <StringInput>
    When wanting to lowercase a String
    Then the user input will be lowercased <StringOutput>
    Examples:
      | StringInput | StringOutput |
      | "ABC"       | "abc"        |
      | "KISS"      | "kiss"       |
      | "TEST"      | "test"       |

  Scenario Outline: Bowling game
    Given you have bowled <frames> times
    When knocking down <pins>
    Then your total score should be: <score>
    Examples:
      | frames | pins | score |
      | 20     | 0    | 0     |
      | 20     | 1    | 20    |
      | 12     | 10   | 300   |