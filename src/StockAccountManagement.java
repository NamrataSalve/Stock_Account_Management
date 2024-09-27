/*
Create a program to manage and report on stock portfolios.
27-sep-2024
 */
import java.util.ArrayList;
import java.util.Scanner;
// Class to represent a Stock
class Stock {
    // Attributes of a Stock
    private String name;
    private int numberOfShares;
    private double sharePrice;
    // Constructor to initialize a Stock object
    public Stock(String name, int numberOfShares, double sharePrice) {
        this.name = name;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }
    // Method to calculate the total value of the stock
    public double getValue() {
        return numberOfShares * sharePrice;
    }
    // Getters for the Stock attributes
    public String getName() {
        return name;
    }
    public int getNumberOfShares() {
        return numberOfShares;
    }
    public double getSharePrice() {
        return sharePrice;
    }
}
// Class to represent a Stock Portfolio
class StockPortfolio {
    // List to hold multiple Stock objects
    private ArrayList<Stock> stocks;
    // Constructor to initialize the StockPortfolio
    public StockPortfolio() {
        stocks = new ArrayList<>();
    }
    // Method to add a Stock to the portfolio
    public void addStock(Stock stock) {
        stocks.add(stock);
    }
    // Method to print the report of the portfolio
    public void printReport() {
        double totalValue = 0;
        System.out.println("Stock Report:");
        // Loop through each stock in the portfolio
        for (Stock stock : stocks) {
            double stockValue = stock.getValue();
            totalValue += stockValue;
            // Print details of each stock
            System.out.println("Stock: " + stock.getName() + ", Number of Shares: " + stock.getNumberOfShares() + ", Share Price: " + stock.getSharePrice() + ", Total Value: " + stockValue);
        }
        // Print the total value of the portfolio
        System.out.println("Total Value of Portfolio: " + totalValue);
    }
}
// Main class to manage the stock account
public class StockAccountManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockPortfolio portfolio = new StockPortfolio();
        // Get the number of stocks from the user
        System.out.print("Enter the number of stocks: ");
        int numberOfStocks = scanner.nextInt();
        scanner.nextLine(); // consume newline
        // Loop to get details of each stock from the user
        for (int i = 0; i < numberOfStocks; i++) {
            System.out.print("Enter stock name: ");
            String name = scanner.nextLine();
            System.out.print("Enter number of shares: ");
            int numberOfShares = scanner.nextInt();
            System.out.print("Enter share price: ");
            double sharePrice = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            // Create a new Stock object and add it to the portfolio
            Stock stock = new Stock(name, numberOfShares, sharePrice);
            portfolio.addStock(stock);
        }
        // Print the stock portfolio report
        portfolio.printReport();
        scanner.close();
    }
}
