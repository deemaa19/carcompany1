Feature: Product Installation Details for Car Company
  Description: Users should be able to view installation details for a specific product on the car company's website.

  Scenario Outline: User views installation details for a product
    Given the user is on the product details page
    When the user selects a specific product
    Then the user should see detailed information about the installation process for that product

    Examples:
      | product_name     | expected_installation_details                                  |
      | Steering Wheel   | - Ensure the vehicle is parked on a flat surface.              |
      |                  | - Disconnect the battery to ensure safety during installation. |
      |                  | - Remove the old steering wheel carefully.                     |
      |                  | - Install the new steering wheel, securing it properly.        |
      | Brake System     | - Lift the vehicle using a suitable jack.                      |
      |                  | - Remove the old brake components.                             |
      |                  | - Install the new brake components, ensuring proper alignment. |
      | Tire Replacement | - Loosen the lug nuts before lifting the vehicle.              |
      |                  | - Remove the old tires and replace them with new ones.         |
      |                  | - Tighten the lug nuts securely.                               |

  Scenario Outline: User views installation details for a different product
    Given the user is on the product details page
    When the user selects a different product
    Then the user should see detailed information about the installation process for that product

    Examples:
      | product_name    | expected_installation_details                                       |
      | Exhaust System  | - Ensure the vehicle is on a stable surface.                        |
      |                 | - Locate and remove the old exhaust system components.              |
      |                 | - Install the new exhaust system, securing it properly.             |
      | Lighting System | - Turn off the vehicle and disconnect the battery.                  |
      |                 | - Remove the old lighting components carefully.                     |
      |                 | - Install the new lighting components, ensuring proper connections. |

  Scenario Outline: User views installation details for a product with no details
    Given the user is on the product details page
    When the user selects a product with no installation details available
    Then the user should see a message indicating that no installation details are available for that product

    Examples:
      | product_name_with_no_details | expected_message                                           |
      | Air Freshener                | "Installation details are not available for this product." |
      | Decorative Car Stickers      | "Installation details are not available for this product." |
      | Car Keychain                 | "Installation details are not available for this product." |
