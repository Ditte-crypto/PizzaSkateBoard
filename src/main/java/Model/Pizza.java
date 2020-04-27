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

    public Pizza(int id, String navn, String ingredienser, double pris){
        this.id = id;
        this.navn = navn;
        this.ingredienser = ingredienser;
        this.pris = pris;
    }

    @Override
    public String toString() {
        return  "\nPizza Nummer: " + id +
                "\nNavn: " + navn  +
                "\ningredienser: " + ingredienser +
                "\npris: " + pris;
    }

    public void setId(int id) {
        this.id = id;
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


    }

