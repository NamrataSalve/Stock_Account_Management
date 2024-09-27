import java.util.ArrayList;
import java.util.Date;
// Class representing shares of a company
class CompanyShares {
    // Private attributes of CompanyShares
    private String stockSymbol;
    private int numberOfShares;
    private Date dateTime;
    // Constructor to initialize the CompanyShares object
    public CompanyShares(String stockSymbol, int numberOfShares) {
        this.stockSymbol = stockSymbol;
        this.numberOfShares = numberOfShares;
        this.dateTime = new Date(); // Set the current date and time
    }
    // Getter for stock symbol
    public String getStockSymbol() {
        return stockSymbol;
    }
    // Getter for number of shares
    public int getNumberOfShares() {
        return numberOfShares;
    }
    // Setter for number of shares
    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }
    // Getter for date and time of the transaction
    public Date getDateTime() {
        return dateTime;
    }
}
// Class representing a stock account
class StockAccount {
    // List to hold multiple CompanyShares objects
    private ArrayList<CompanyShares> sharesList;
    // Constructor to initialize the StockAccount object
    public StockAccount() {
        sharesList = new ArrayList<>();
    }
    // Method to buy shares of a company
    public void buy(String stockSymbol, int numberOfShares) {
        // Loop through the list to find the company shares
        for (CompanyShares shares : sharesList) {
            if (shares.getStockSymbol().equals(stockSymbol)) {
                shares.setNumberOfShares(shares.getNumberOfShares() + numberOfShares); // Update number of shares
                return;
            }
        }
        // If company shares not found, add new CompanyShares object
        sharesList.add(new CompanyShares(stockSymbol, numberOfShares));
    }
    // Method to sell shares of a company
    public void sell(String stockSymbol, int numberOfShares) {
        // Loop through the list to find the company shares
        for (CompanyShares shares : sharesList) {
            if (shares.getStockSymbol().equals(stockSymbol)) {
                // Check if there are enough shares to sell
                if (shares.getNumberOfShares() >= numberOfShares) {
                    shares.setNumberOfShares(shares.getNumberOfShares() - numberOfShares); // Update number of shares
                } else {
                    System.out.println("Not enough shares to sell."); // Print error message
                }
                return;
            }
        }
        System.out.println("Stock symbol not found."); // Print error message if stock symbol not found
    }
    // Method to print the list of company shares
    public void printShares() {
        System.out.println("Shares List:");
        for (CompanyShares shares : sharesList) {
            System.out.println("Stock Symbol: " + shares.getStockSymbol() + ", Number of Shares: " + shares.getNumberOfShares() + ", DateTime: " + shares.getDateTime());
        }
    }
}
// Class to test the functionality of the StockAccount class
public class StockAccountTest {
    public static void main(String[] args) {
        // Create a StockAccount object
        StockAccount account = new StockAccount();
        // Buy shares of AAPL and GOOGL
        account.buy("AAPL", 10);
        account.buy("GOOGL", 15);
        // Sell shares of AAPL
        account.sell("AAPL", 5);
        // Attempt to sell shares of MSFT, which is not in the list
        account.sell("MSFT", 10);
        // Print the list of company shares
        account.printShares();
    }
}
