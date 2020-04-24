package DataMappers;

import Model.Bestilling;
import Model.Pizza;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
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

    /*
            CharSequence tidspunkt = in.nextLine();
        //tidspunkt til DateTime type
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hhmm");
        TemporalAccessor temporalAccessor = formatter.parse(tidspunkt);
        LocalTime afhentningstidspunkt = LocalTime.from(temporalAccessor);
     */

    BestillingsMapper bestillingsMapper;
    Bestilling bestilling;
    DateTimeFormatter formatter;
    TemporalAccessor temporalAccessor;
    LocalTime localTime;
    ArrayList<Pizza> pizzas;
    CharSequence tidspunkt;

    Pizza pizza1;
    Pizza pizza2;

    @Before
    public void setUp() throws Exception {
        tidspunkt = "0104";
        bestillingsMapper = new BestillingsMapper();
        formatter = DateTimeFormatter.ofPattern("hhmm");
        temporalAccessor = formatter.parse(tidspunkt);
        localTime = LocalTime.from(temporalAccessor);
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