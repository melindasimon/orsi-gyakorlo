Feature: szamologep mukodes teszt

  Scenario: osszeadunk ket szamot, akkor az elvart eredmenyt kapjuk
    Given Ket szam, '12' es '7'
    Then Az osszeguk '19' lesz

  Scenario Outline: osszeadunk ket szamot, akkor az elvart eredmenyt kapjuk, sok szamparra tesztelve
    Given Ket szam, '<A>' es '<B>'
    Then Az osszeguk '<ELVART_OSSZEG>' lesz
    Examples:
      | A | B | ELVART_OSSZEG |
      | 0 | 0 | 0             |
      | 1 | 4 | 5             |
      | 4 | -1 | 3             |
      | 8 | 9 | 17            |
      | 2 | 9 | 11            |

