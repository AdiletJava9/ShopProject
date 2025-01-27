import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AuctionManager {
    private List<Auction> activeAuctions;      //  Текущие активные аукционы
    private List<Auction> completedAuctions;   // Завершенные аукционы (история)
    private Map<String, Auction> auctionMap;   // Карта аукционов по ID
    private int nextAuctionId;                 // Генератор ID для аукционов
    private List<User> registeredUsers;        // Зарегистрированные пользователи
    private List<Product> availableItems;

    public AuctionManager(List<Auction> activeAuctions, List<Auction> completedAuctions, Map<String, Auction> auctionMap, int nextAuctionId, List<User> registeredUsers, List<Product> availableItems) {
        this.activeAuctions = activeAuctions;
        this.completedAuctions = completedAuctions;
        this.auctionMap = auctionMap;
        this.nextAuctionId = nextAuctionId;
        this.registeredUsers = registeredUsers;
        this.availableItems = availableItems;
    }

    public AuctionManager() {
        activeAuctions = new ArrayList<>();
        completedAuctions = new ArrayList<>();
        nextAuctionId = 1;
    }

    public List<Auction> getActiveAuctions() {
        return activeAuctions;
    }

    public void setActiveAuctions(List<Auction> activeAuctions) {
        this.activeAuctions = activeAuctions;
    }

    public List<Auction> getCompletedAuctions() {
        return completedAuctions;
    }

    public void setCompletedAuctions(List<Auction> completedAuctions) {
        this.completedAuctions = completedAuctions;
    }

    public Map<String, Auction> getAuctionMap() {
        return auctionMap;
    }

    public void setAuctionMap(Map<String, Auction> auctionMap) {
        this.auctionMap = auctionMap;
    }

    public int getNextAuctionId() {
        return nextAuctionId;
    }

    public void setNextAuctionId(int nextAuctionId) {
        this.nextAuctionId = nextAuctionId;
    }

    public List<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(List<User> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    public List<Product> getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(List<Product> availableItems) {
        this.availableItems = availableItems;
    }

    public void createAuction(Product product, double startingPrice) {
        String auctionID = "AUC-" + nextAuctionId++;
        Auction auction = new Auction(auctionID, product, startingPrice);
        activeAuctions.add(auction);
        System.out.println("Создан аукцион: " + auctionID);
    }

    public void closeAuction(String auctionId) {
        for (Auction auction : activeAuctions) {
            if (auction.getAuctionID().equals(auctionId)) {
                auction.closeAuction();
                activeAuctions.remove(auction);
                completedAuctions.add(auction);
                return;
            }
        }
        System.out.println("Аукцион с ID " + auctionId + " не найден!");
    }

    public void listActiveAuctions() {
        System.out.println("Активные аукционы:");
        for (Auction auction : activeAuctions) {
            System.out.println(auction);
        }
    }

}
