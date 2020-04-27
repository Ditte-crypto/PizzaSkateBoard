package DataMappers;

import Model.Bestilling;
import Model.Pizza;
import Util.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;

public class BestillingsMapper {
    public void createBestillingInDB(Bestilling bestilling) {
        /*
        getConnection
        Opret bestilling i databasen
        Hent bestillingsID fra databasen.
        Loop igennem pizza {
        For værd pizza:
        Hent pizzaID fra pizza
        Indsæt bestillingsID,pizzaID
        }

         */

        /*
        INSERT INTO pizzabestillinger (BestillingsID, PizzaID)
        VALUES
        (1,3),
        (1,2),
        (2,1);
         */
        String sqlQuerybestillinger = "";
        String sqlQuerybestillinger2 = "";
        String sqlQuerybestillinger3 = "";
        Pizza pizza = new Pizza();

        Connection connection = DBConnector.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            Statement statement2 = connection.createStatement();
            sqlQuerybestillinger = "insert into bestillinger(afhentning) values ('"
                    + bestilling.getAfhentning() + "');";
            statement.executeUpdate(sqlQuerybestillinger, Statement.RETURN_GENERATED_KEYS);

            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            int bestillingsID = resultSet.getInt(1);
            ArrayList<Pizza> pizzaerIBestilling = bestilling.getPizzaerIBestilling();
            for(Pizza p : pizzaerIBestilling){
                int pizzaId = p.getId();
                sqlQuerybestillinger2 = sqlQuerybestillinger2 + "insert into pizzabestillinger(BestillingsID, PizzaID) values " +
                        "("+bestillingsID+","+ pizzaId+");";
            }
            statement2.addBatch(sqlQuerybestillinger2);
            statement2.executeBatch();


        } catch (SQLException e) {
            System.out.println("Fejl: " + e.getMessage());
        }
    }
}

