package Model;

import DataMappers.PizzaMapper;

import java.util.ArrayList;

public class Pizza {
    int id;
    String navn;
    String ingredienser;
    double pris;

    public Pizza() {
    }

    public int getId() {
        return id;
    }

    public String getNavn() {
        return navn;
    }

    public String getIngredienser() {
        return ingredienser;
    }

    public double getPris() {
        return pris;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setIngredienser(String ingredienser) {
        this.ingredienser = ingredienser;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public static Pizza getPizzaTypeByNavn(String navn, PizzaMapper pm){
        Pizza retPizza = null;
        ArrayList<Pizza> pizzaliste = pm.makePizzaObjectsFromDB();
        for(Pizza p:pizzaliste){
            if(p.getNavn()==navn){
                retPizza = p;
                System.out.println("Pizzaen er tilføjet bestillingen");
            }
            else {
                System.out.println("Pizzaen findes ikke på menukortet, prøv igen");
            }
        }
        return retPizza;
    }
}
