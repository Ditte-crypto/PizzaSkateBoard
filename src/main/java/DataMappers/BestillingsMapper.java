package DataMappers;

import Model.Bestilling;
import Model.Pizza;
import Util.DBConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BestillingsMapper {
    public void createBestillingInDB(Bestilling bestilling) {
        String sqlQuery = "";
        Connection connection = DBConnector.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            sqlQuery = "insert into bestillinger(afhentning) values ("
                    + bestilling.getAfhentning() + "00);";
            statement.executeUpdate(sqlQuery);
            ArrayList<Pizza> pizzaerIBestilling = bestilling.getPizzaerIBestilling();
            for (Pizza p : pizzaerIBestilling) {
                int pizzaId = p.getId();
                int bestillingsId = bestilling.getId();
                sqlQuery = "insert into pizzabestillinger(bestilling, pizza) values(" +
                        pizzaId + ", " + bestillingsId + ");";
                statement.executeUpdate(sqlQuery);
            }

        } catch (SQLException e) {
            System.out.println("Fejl: " + e.getMessage());
        }
    }
}

