package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.ProductSalesReportItem;

public class ProductServiceImpl implements ProductService {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private static final String DB_URL = "jdbc:mysql://localhost:3306/classicmodels";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "aptx4869";

    private static final String SQL_GET_SALES_REPORT = "SELECT\n"
            + "  pl.productLine,\n"
            + "  p.productVendor,\n"
            + "  p.productCode,\n"
            + "  p.productName,\n"
            + "  od.quantityOrdered,\n"
            + "  od.priceEach,\n"
            + "  o.status,\n"
            + "  c.city\n"
            + "FROM products p\n"
            + "  INNER JOIN productlines pl ON p.productLine = pl.productLine\n"
            + "  INNER JOIN orderdetails od ON p.productCode = od.productCode\n"
            + "  INNER JOIN orders o ON od.orderNumber = o.orderNumber\n"
            + "  INNER JOIN customers c ON o.customerNumber = c.customerNumber\n"
            + "ORDER BY p.productLine, p.productVendor, p.productCode, od.quantityOrdered DESC, o.status, c.city;";

    @Override
    public List<ProductSalesReportItem> getSalesReport() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);

        log("Dang ket noi toi co so du lieu ...");
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        Statement stmt = conn.createStatement();

        log("Dang thuc hien truy van...");
        ResultSet rs = stmt.executeQuery(SQL_GET_SALES_REPORT);

        log("Dang thu thap ket qua...");
        List<ProductSalesReportItem> products = new ArrayList<>();
        while (rs.next()) {
            ProductSalesReportItem report = new ProductSalesReportItem();
            report.setGetProductLine(rs.getString("productLine"));
            report.setProductVendor(rs.getString("productVendor"));
            report.setProductCode(rs.getString("productCode"));
            report.setProductName(rs.getString("productName"));
            report.setQuantityOrdered(rs.getInt("quantityOrdered"));
            report.setPriceEach(rs.getDouble("priceEach"));
            report.setOrderStatus(rs.getString("status"));
            report.setOrderFromCity(rs.getString("city"));


            products.add(report);
        }

        log("Hoan thanh thu thap ket qua. Dang dong cac ket noi...");
        rs.close();
        stmt.close();
        conn.close();

        log("Thanh cong!");
        return products;
    }

    private void log(String message) {
        System.out.println("ProductServiceImpl: " + message);
    }
}