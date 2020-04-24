package Model;

import Controller.Controller;
import DataMappers.BestillingsMapper;
import DataMappers.PizzaMapper;
import View.View;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Controller c = new Controller();
        PizzaMapper pm = new PizzaMapper();

        startMenuFunk(view, c, pm);
    }
    public static void lavNyPizza(View view, Controller c, PizzaMapper pm){
        List<Object> pizzainfo = view.createPizza();
        Pizza pizza = c.createPizza(pizzainfo);
        pm.createPizzaInDB(pizza);
        view.success();
    }
    public static void lavNyBestilling(View view, Controller c, BestillingsMapper bm, PizzaMapper pm){
        List<Object> bestillingsinfo = view.createBestilling(pm, c);
        Bestilling bestilling = c.createBestilling(bestillingsinfo);
        bm.createBestillingInDB(bestilling);

    }

    public static void visPizzaerIDBTilBruger(View view, Controller c, PizzaMapper pm){
        ArrayList<Pizza> pizzaer = c.sendPizzasFromDB(pm);
        view.showMenu(pizzaer);
    }

    public static void startMenuFunk(View view, Controller c, PizzaMapper pm){
        Scanner in = new Scanner(System.in);
        view.startMenu();
        String input = in.nextLine().toLowerCase();
        if(!input.equals("q")){
            switch(input){
                case "1":lavNyPizza(view, c, pm);
                    startMenuFunk(view, c, pm);
                break;
                case "2":visPizzaerIDBTilBruger(view, c, pm);
                startMenuFunk(view, c, pm);
                break;
                case "3":view.lavBestilling(pm);
                startMenuFunk(view, c, pm);
                break;
                default:
                    System.out.println("Ugyldigt input");
                    startMenuFunk(view, c, pm);
            }
        }else{startMenuFunk(view, c, pm);}
    }
}
