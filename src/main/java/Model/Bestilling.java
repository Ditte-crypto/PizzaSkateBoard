package Model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;

public class Bestilling {
    LocalTime afhentning;
    ArrayList<Pizza> pizzaerIBestilling;
    int id;

    public Bestilling(LocalTime afhentning, ArrayList<Pizza> pizzaerIBestilling) {
        this.afhentning = afhentning;
        this.pizzaerIBestilling = pizzaerIBestilling;
    }

    public Bestilling(CharSequence afhentning, ArrayList<Pizza> pizzaerIBestilling) {
        this.pizzaerIBestilling = pizzaerIBestilling;
        this.afhentning = afhentningstidspunkt(afhentning);
    }

    public int getId() {
        return id;
    }

    public void setAfhentning(LocalTime afhentning) {
        this.afhentning = afhentning;
    }

    public void setPizzaerIBestilling(ArrayList<Pizza> pizzaerIBestilling) {
        this.pizzaerIBestilling = pizzaerIBestilling;
    }

    public LocalTime getAfhentning() {
        return afhentning;
    }

    public ArrayList<Pizza> getPizzaerIBestilling() {
        return pizzaerIBestilling;
    }


public LocalTime afhentningstidspunkt(CharSequence input){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hhmm");
    TemporalAccessor temporalAccessor = formatter.parse(input);
    LocalTime afhentningstidspunkt = LocalTime.from(temporalAccessor);
    return afhentningstidspunkt;
}
}