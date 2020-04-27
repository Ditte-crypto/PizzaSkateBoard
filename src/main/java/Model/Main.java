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
        BestillingsMapper bm = new BestillingsMapper();

        c.startMenuFunk(view, c, pm, bm);
    }

}
