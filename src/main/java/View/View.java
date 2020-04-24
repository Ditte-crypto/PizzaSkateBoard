package View;

import DataMappers.PizzaMapper;
import Model.Pizza;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
   public List<Object> createPizza(){
       List<Object> retList = new ArrayList <Object>();
       Scanner in = new Scanner(System.in);

           System.out.println("Pizza navn: ");
           String navn = in.nextLine();
           retList.add(navn);
           System.out.println("Pizza ingredienser: ");
           String ingredienser = in.nextLine();
           retList.add(ingredienser);
           System.out.println("Pizza pris: ");
           double pris = in.nextDouble();
           retList.add(pris);
           return retList;

   }
   public void showMenu(ArrayList<Pizza> pizzaer){
       System.out.println(pizzaer);
   }
   public void startMenu(){
       System.out.println("[1]: lav ny pizza til menukortet\n"
       +"[2] : se menukortet\n"+"[3] : lav bestilling\n"
       +"[q] : for at vende tilbage til hovedmenuen\n");
   }
    public List<Object> lavBestilling(PizzaMapper pm){
        List<Object> retList = new ArrayList <Object>();
        Scanner in = new Scanner(System.in);

        System.out.println("[1] : tilføj pizza til bestilling\n" +
                "[2] : sæt afhentningstidspunkt\n"+
                "[3] : forlad vindue\n");
        String input = in.nextLine();
        while(!input.equals("3")) {
            switch (input) {
                case "q":
                    System.out.println("Du vil ikke tilføje flere pizzaer");
                    break;
                case "2": System.out.println("Afhentningstidspunkt? hh:mm, skriv 1 istedet for 13");
                String afhentning = in.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");
                TemporalAccessor temporalAccessor = formatter.parse(afhentning);
                LocalTime afhentningstidspunkt = LocalTime.from(temporalAccessor);
                retList.add(afhentningstidspunkt);
                break;
                case "1":
                        System.out.println("Pizza? tryk q når du ikke vil tilføje flere pizzaer");
                        String pizzanavn = in.nextLine();
                        Pizza pizza = new Pizza();
                        pizza.getPizzaTypeByNavn(pizzanavn, pm);
                        retList.add(pizza);
                    break;
                default:
                    System.out.println("Ugyldigt input");
                    lavBestilling(pm);
            }
        }

        return retList;

    }

}






