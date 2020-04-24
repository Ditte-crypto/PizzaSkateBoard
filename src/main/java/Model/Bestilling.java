package Model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bestilling {
LocalTime afhentning;
ArrayList<Pizza> pizzaerIBestilling;
int id;

    public Bestilling( LocalTime afhentning, ArrayList<Pizza> pizzaerIBestilling) {
        this.afhentning = afhentning;
        this.pizzaerIBestilling = pizzaerIBestilling;
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
}

