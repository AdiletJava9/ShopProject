import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        AuctionManager manager = new AuctionManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Создать аукцион");
            System.out.println("2. Посмотреть активные аукционы");
            System.out.println("3. Завершить аукцион");
            System.out.println("4. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите название товара: ");
                    String name = scanner.nextLine();
                    String title = scanner.nextLine();
                    System.out.print("Введите стартовую цену: ");
                    double price = scanner.nextDouble();
                    Product product = new Product(name,title,0,3);
                    manager.createAuction(product, price);
                    break;
                case 2:
                    manager.listActiveAuctions();
                    break;
                case 3:
                    System.out.print("Введите ID аукциона: ");
                    String auctionId = scanner.nextLine();
                    manager.closeAuction(auctionId);
                    break;
                case 4:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }
}