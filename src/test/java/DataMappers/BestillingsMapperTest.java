package DataMappers;

import Model.Bestilling;
import Model.Pizza;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BestillingsMapperTest {

    /*
    LocalTime afhentning;
ArrayList<Pizza> pizzaerIBestilling;
int id;

    public Bestilling( LocalTime afhentning, ArrayList<Pizza> pizzaerIBestilling) {
        this.afhentning = afhentning;
        this.pizzaerIBestilling = pizzaerIBestilling;
    }
     */

    /*
        int id;
    String navn;
    String ingredienser;
    double pris;
     */

    BestillingsMapper bestillingsMapper;
    Bestilling bestilling;
    LocalTime localTime;
    ArrayList<Pizza> pizzas;

    Pizza pizza1;
    Pizza pizza2;

    @Before
    public void setUp() throws Exception {
        bestillingsMapper = new BestillingsMapper();
        localTime = LocalTime.now();
        pizzas = new ArrayList<>();
        pizza1 = new Pizza(1,"Margarita", "bacon, skinke", 100);
        pizza2 = new Pizza(2,"Hawaii", "Ananas", 2);
        pizzas.add(pizza1);
        pizzas.add(pizza2);
        bestilling = new Bestilling(localTime,pizzas);

    }

    @Test
    public void createBestillingInDB() {
        bestillingsMapper.createBestillingInDB(bestilling);
    }
}