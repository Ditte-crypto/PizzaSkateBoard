package View;

import Controller.Controller;
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
    public List<Object> createBestilling(PizzaMapper pm, Controller c){
        List<Object> retList = new ArrayList <Object>();
        Scanner in = new Scanner(System.in);
        System.out.println("Afhentningstidspunkt? hh:mm");
        CharSequence tidspunkt = in.nextLine();
        //tidspunkt til DateTime type
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");
        TemporalAccessor temporalAccessor = formatter.parse(tidspunkt);
        LocalTime afhentningstidspunkt = LocalTime.from(temporalAccessor);
        retList.add(afhentningstidspunkt);
        return retList;
        /*metode der tilføjer pizzaobjekter i et loop
        Pizza retPizza = addPizzaTilBestilling(pm, c);
        return retList;*/
    }
    public void success(){
        System.out.println("Handling gennemført.");
    }
    public Pizza addPizzaTilBestilling(PizzaMapper pm, Controller c){
       Scanner in = new Scanner(System.in);
       System.out.println("Tilføj ny pizza til bestillingen vha. navn. Tryk q for quit");
       Pizza retPizza = null;
       String input = in.nextLine();
       while(!input.equals("q")){
           String navn = in.nextLine();
           retPizza = c.getPizzaTypeByNavn(navn, pm);
       }
       return retPizza;
    }

}






