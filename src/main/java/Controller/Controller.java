package Controller;

import DataMappers.PizzaMapper;
import Model.Bestilling;
import Model.Pizza;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    public Pizza createPizza(List<Object> pizzainfo) {
        String navn = (String) pizzainfo.get(0);
        String ingredienser = (String) pizzainfo.get(1);
        double pris = (double) pizzainfo.get(2);
        Pizza pizza = new Pizza();
        pizza.setNavn(navn);
        pizza.setIngredienser(ingredienser);
        pizza.setPris(pris);
        return pizza;
    }

    public ArrayList<Pizza> sendPizzasFromDB(PizzaMapper pm) {
        return pm.makePizzaObjectsFromDB();
    }

    public Bestilling createBestilling(List<Object> bestillingsinfo) {
        LocalTime afhentning = (LocalTime) bestillingsinfo.get(0);
        ArrayList<Pizza> pizzaArrayList = (ArrayList<Pizza>) bestillingsinfo.get(1);
        Bestilling bestilling = new Bestilling(afhentning, pizzaArrayList);
        return bestilling;
    }

    public static Pizza getPizzaTypeByNavn(String navn, PizzaMapper pm) {
        Pizza retPizza = null;
        ArrayList<Pizza> pizzaliste = pm.makePizzaObjectsFromDB();
        for (Pizza p : pizzaliste) {
            if (p.getNavn().equals(navn)) {
                retPizza = p;
                System.out.println("Pizzaen er tilføjet bestillingen");
            } else {
                System.out.println("Pizzaen findes ikke på menukortet, prøv igen");
            }
        }
        return retPizza;
    }
}
