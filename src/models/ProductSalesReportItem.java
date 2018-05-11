package models;

public class ProductSalesReportItem {
    private String getProductLine;
    private String productVendor;
    private String productCode;
    private String productName;
    private int quantityOrdered;
    private double priceEach;
    private String orderStatus;
    private String orderFromCity;

    public ProductSalesReportItem () {}

    public String getGetProductLine() {
        return getProductLine;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public double getPriceEach() {
        return priceEach;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getOrderFromCity() {
        return orderFromCity;
    }

    public void setGetProductLine(String getProductLine) {
        this.getProductLine = getProductLine;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderFromCity(String orderFromCity) {
        this.orderFromCity = orderFromCity;
    }
}
