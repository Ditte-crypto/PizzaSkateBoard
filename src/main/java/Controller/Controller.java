package Controller;

import DataMappers.BestillingsMapper;
import DataMappers.PizzaMapper;
import Model.Bestilling;
import Model.Pizza;
import View.View;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        CharSequence afhentning = (CharSequence) bestillingsinfo.get(0);
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
    public static void lavNyPizza(View view, Controller c, PizzaMapper pm){
        List<Object> pizzainfo = view.createPizza();
        Pizza pizza = c.createPizza(pizzainfo);
        pm.createPizzaInDB(pizza);
        view.success();
    }
    public static void lavNyBestilling(View view, Controller c, BestillingsMapper bm, PizzaMapper pm){
        List<Object> bestillingsinfo = view.createBestilling();
        Bestilling bestilling = c.createBestilling(bestillingsinfo);
        bm.createBestillingInDB(bestilling);
        view.success();

    }

    public static void visPizzaerIDBTilBruger(View view, Controller c, PizzaMapper pm){
        ArrayList<Pizza> pizzaer = c.sendPizzasFromDB(pm);
        view.showMenu(pizzaer);
    }

    public static void startMenuFunk(View view, Controller c, PizzaMapper pm, BestillingsMapper bm){
        Scanner in = new Scanner(System.in);
        view.startMenu();
        String input = in.nextLine().toLowerCase();
        if(!input.equals("q")){
            switch(input){
                case "1":lavNyPizza(view, c, pm);
                    startMenuFunk(view, c, pm, bm);
                    break;
                case "2":visPizzaerIDBTilBruger(view, c, pm);
                    startMenuFunk(view, c, pm, bm);
                    break;
                case "3":lavNyBestilling(view, c, bm, pm);
                    startMenuFunk(view, c, pm, bm);
                    break;
                default:
                    System.out.println("Ugyldigt input");
                    startMenuFunk(view, c, pm, bm);
            }
        }else{startMenuFunk(view, c, pm, bm);}
    }
}