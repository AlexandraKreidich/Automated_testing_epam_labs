package services;

public class Runner {
    public static void main(String[] args) {
        CreatorService creator = new CreatorService();
        MenuService menu = new MenuService(creator.CreateUniversity());
    }
}
