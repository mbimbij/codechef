Feature: welcomeOfferAbTesting

  Scenario Outline: Send Harvestor events or welcome offers, with experimentation infos
    Given user <userId> with <confirmedTripCount> confirmed trip
    And feature flag returns <featureFlag>
    When we call the checkout endpoint on monetize-servix
    Then <thereIsOrNot> a welcome-offer in the reponse
    Then an harvestor event is <sentOrNot> on topic "active_flags"
    And if a harvestor event was sent, it had the following values:
      | type                               | ActiveFlags               |
      | from                               | monetize-servix           |
      | payload.flag-group                 | user-segmentation         |
      | payload.flag-name                  | welcome-offer-abc-testing |
      | payload.value                      | <expectedGroup>           |
      | payload.context.user_id            | <userId>                  |
      | payload.context.external_reference | $external_reference       |
    Examples:
      | userId                               | confirmedTripCount | featureFlag | expectedGroup |
      | cc01f857-d7d4-4c55-8e6e-1192ebf60000 | 0                  | none        | control       |
      | cc01f857-d7d4-4c55-8e6e-1192ebf60020 | 0                  | ROOKIE_2    | treatment     |
      | cc01f857-d7d4-4c55-8e6e-1192ebf60001 | 1                  | none        |               |
      | cc01f857-d7d4-4c55-8e6e-1192ebf60021 | 1                  | ROOKIE_2    | treatment     |
      | cc01f857-d7d4-4c55-8e6e-1192ebf60002 | 2                  | none        |               |
      | cc01f857-d7d4-4c55-8e6e-1192ebf60022 | 2                  | ROOKIE_2    |               |
