package orsi.elso.cucumber;


import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import orsi.elso.Szamologep;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Created by msimon on 16.1.2018.
 */
public class StepDefinitions {

    /**
     * Kis regexp help Orsinak:
     * (-?\\d+) szam, akar minusz elojellel is
     * (\\d+) szam, nem lehet minusz
     * (.*) akarhany akarmi, azaz valamilyen szoveg
     * (true|false) boolean igaz/hamis ertekek
     */

    /**
     * Ezt a map-et hasznaljuk arra, hogy a valtozokat elmemntsuk (adott szamokat)
     * es a kesobbi teszt lepesekben hozza tudjunk ferni.
     */
    private Map<String, Integer> valtozok;

    public StepDefinitions() {
        valtozok = new HashMap<>();
    }

    /**
     * This will run before each scenario and clears the valtozok object.
     */
    @Before
    public void beforeScenarioClearWorld() {
        valtozok.clear();
    }

    @Given("^Ket szam, '(-?\\d+)' es '(-?\\d+)'$")
    public void adottKetSzam(int a, int b) throws Throwable {
        // elmentjuk a valtozok erteket, hogy  akesobbi lepesekben tudjuk hasznalni oket
        valtozok.put("A", a);
        valtozok.put("B", b);
    }

    @Then("^Az osszeguk '(-?\\d+)' lesz$")
    public void elvartOsszeg(int elvartOsszeg) throws Throwable {
        // Itt ellenorizzuk, hogy a korabban megadott ket szam osszege megegyezik-e az eklvart eredmennyel.
        assertTrue(Szamologep.osszeadas(valtozok.get("A"), valtozok.get("B")) == elvartOsszeg);
    }
}
