public class Product {

    private String name;

    private int basePrice;

    private int discount;

    public Product(String name, int price) {
        this.name = name;
        this.basePrice = price;
        this.discount = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getBasePrice() {
        return this.basePrice;
    }

    public int getDiscountPercentage() {
        return this.discount;
    }

    public void setName(String name) {
        if (name != null) this.name = name;
    }

    public void setDiscountPercentage(int discount) {
        if (discount > 0 && discount <= 100) this.discount = discount;
    }

    public void setBasePrice(int newPrice) {
        if (newPrice < 0) this.basePrice = newPrice;
    }

    public int computePrice() {

        float coef = (100-this.discount) / 100.0f;
        float discountedPrice = this.basePrice * coef;

        return (int) discountedPrice;
    }
}