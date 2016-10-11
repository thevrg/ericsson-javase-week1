package hu.dpc.edu;

import java.sql.*;
import java.util.ServiceLoader;

/**
 * Created by vrg on 10/10/16.
 */
public class JdbcTest {
    public static void main(String[] args) throws SQLException {

        final ServiceLoader<Driver> drivers = ServiceLoader.load(Driver.class);
        for(Driver driver:drivers) {
            System.out.println(driver.getClass());
        }

        final Connection connection = DriverManager.getConnection("jdbc:mydriver:valami");
        final DatabaseMetaData metaData = connection.getMetaData();
        System.out.println("version: " + metaData.getDriverMajorVersion());
        System.out.println(connection.getClass());
        System.out.println(metaData.getClass());

    }
}
