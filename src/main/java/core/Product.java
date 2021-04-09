package core;

public class Product {
    private final String id;
    private final String title;
    private final String cost;

    public Product(String id, String title, String cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return  "id: " + id + "\n" +
                "title: " + title + "\n" +
                "cost: " + cost + "\n\n";
    }
}
