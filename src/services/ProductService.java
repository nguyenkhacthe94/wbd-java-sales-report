package services;

import models.ProductSalesReportItem;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    public List<ProductSalesReportItem> getSalesReport() throws ClassNotFoundException, SQLException;
}
