package org.bravo;

import org.bravo.domain.CoffeeShop;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CoffeeShopTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private CoffeeShop myCoffeeShop;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    public void test(){

        myCoffeeShop.printMenu();

        String expected = """
                Best coffee in the world. Single origin Colombia : 3.0€
                Best coffee in the world. Single origin Colombia, Milk : 3.5€
                Green thea from India : 1.5€
                Green thea from India, Milk : 2.0€
                """.trim().replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));

        Assertions.assertEquals(expected, outputStreamCaptor.toString()
                .trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }


}
