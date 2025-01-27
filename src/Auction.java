import java.time.LocalDateTime;

public class Auction {
    private String auctionID;
    private String titleAuction;
    private double startingPrice;
    private double currentRate;
    private User currentLeader;
    private LocalDateTime endTime;
    private boolean status;
    private Product product;

    public Auction(String auctionID, String titleAuction, double startingPrice, double currentRate, User currentLeader, LocalDateTime endTime, boolean status, Product product) {
        this.auctionID = auctionID;
        this.titleAuction = titleAuction;
        this.startingPrice = startingPrice;
        this.currentRate = currentRate;
        this.currentLeader = currentLeader;
        this.endTime = endTime;
        this.status = status;
        this.product = product;
    }


    public Auction(String auctionID, Product product, double startingPrice) {
    }

    public String getAuctionID() {
        return auctionID;
    }

    public void setAuctionID(String auctionID) {
        this.auctionID = auctionID;
    }

    public String getTitleAuction() {
        return titleAuction;
    }

    public void setTitleAuction(String titleAuction) {
        this.titleAuction = titleAuction;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public double getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(double currentRate) {
        this.currentRate = currentRate;
    }

    public User getCurrentLeader() {
        return currentLeader;
    }

    public void setCurrentLeader(User currentLeader) {
        this.currentLeader = currentLeader;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public boolean placeBid(User user, double bidAmount) {
        if (!status) {
            System.out.println("Аукцион завершен!");
            return false;
        }
        if (bidAmount <= currentRate) {
            System.out.println("Ставка должна быть выше текущей!");
            return false;
        }
        if (user.getBalance() < bidAmount) {
            System.out.println("Недостаточно средств для ставки!");
            return false;
        }
        currentRate = bidAmount;
        currentLeader = user;
        System.out.println("Ставка принята: " + bidAmount);
        return true;
    }

    @Override
    public String toString() {
        if (product != null) {
            return "Auction{id='" + product.getProductID() + "', product=" + product.getProductName() + ", currentBid=" + currentLeader + ", isActive=" + status + "}";
        } else {
            return "Auction{id='" + product.getProductID() + "', product=No product, currentBid=" + currentLeader + ", isActive=" + status + "}";
        }
    }


    public void closeAuction() {
        status = false;
        System.out.println("Аукцион завершен. Победитель: " + (currentLeader != null ? currentLeader.getUserName() : "никто"));
    }
}
