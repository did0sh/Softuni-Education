package p02_BookShop;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String author, String title, double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    private void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    private void setAuthor(String author) {
        String[] names = author.split("\\s+");
        if (names.length > 1) {
            String secondName = names[1];
            if (Character.isDigit(secondName.charAt(0))) {
                throw new IllegalArgumentException("Author not valid!");
            }
        }
        this.author = author;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    private String getTitle() {
        return this.title;
    }

    private String getAuthor() {
        return this.author;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("Type: %s%n", this.getClass().getSimpleName()))
                .append(String.format("Title: %s%n", this.getTitle()))
                .append(String.format("Author: %s%n", this.getAuthor()))
                .append(String.format("Price: %.1f%n", this.getPrice()));
        return sb.toString();

    }
}
