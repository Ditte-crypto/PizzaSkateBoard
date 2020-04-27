package DataMappers;

import Model.Pizza;
import Util.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/*
insert into pizzaer(Pizzanavn,Ingredienser,Pris)
values ('Vesuvio','tomatsauce,ost,skinke og oregano',57);

public Pizza(int id, String navn, String ingredienser, double pris) {
        this.id = id;
        this.navn = navn;
        this.ingredienser = ingredienser;
        this.pris = pris;
    }
 */

public class PizzaMapper {
    //Pizzaobjekt --> pizzatabel-række
    public void createPizzaInDB(Pizza pizza) {
        String sqlQuery = "";
        Connection connection = DBConnector.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            sqlQuery = "insert into pizzaer(Pizzanavn,Ingredienser,Pris) values ('"
                    + pizza.getNavn() + "','"
                    + pizza.getIngredienser() + "',"
                    + pizza.getPris() + ");";
            statement.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            System.out.println("Fejl: " + e.getMessage());
        }
    }
    public ArrayList<Pizza> makePizzaObjectsFromDB(){
        ArrayList<Pizza> pizzaer = new ArrayList<>();
        Pizza retPizza = null;
        String sqlQuery = "";
        Connection connection = DBConnector.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            sqlQuery ="select * from pizzaer";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            //bearbejdning af resultset:
            while(resultSet.next()){
                int pizzaID = resultSet.getInt("PizzaID");
                String navn = resultSet.getString("Pizzanavn");
                String ingredienser = resultSet.getString("Ingredienser");
                double pris = resultSet.getDouble("Pris");
                retPizza = new Pizza();
                retPizza.setId(pizzaID);
                retPizza.setNavn(navn);
                retPizza.setIngredienser(ingredienser);
                retPizza.setPris(pris);
                pizzaer.add(retPizza);
            }
        } catch (SQLException e) {
            System.out.println("Fejl: " + e.getMessage());
        }

        return pizzaer;
    }
    }

