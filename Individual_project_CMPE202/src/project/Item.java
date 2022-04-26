package project;

public class Item {
	private String caterogy="";
    private int Quantity=0;
    private double price=0.00;

    public Item(String category, int availableQuantity, double price){
        this.caterogy = category;
        this.Quantity = availableQuantity;
        this.price = price;
    }

    public String getCategoryname(){
        return this.caterogy;
    }

    public double getPrice(){
        return this.price;
    }

    public Integer getCurrentQuantity() {
    	return this.Quantity;
    }

    public void updateQuantity(Integer orderedQ){
        this.Quantity = this.Quantity - orderedQ;
    }
}
