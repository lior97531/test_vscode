public class StoreItem {

  final private int catNumber;
   private String name;

   private double price;

  private   double discount = 0;

    public StoreItem(int number, String Name, double p) {
        final int default_price= 10;
        catNumber = number;
        name = Name;
        price = p;
        if (price < 0)
            price = default_price;


    }


    public void setName(String S) {
        name = S;

    }

    public void setPrice(double p) {
        if (p > 0)
            price = p;

    }

    public void setDiscount(double d) {
        if (d > 0 && d < 1)
            discount = d;

    }

    public int getCatNumber() {
        return (catNumber);

    }

    public String getName() {
        return (name);

    }

    public double getPrice() {
        return (price);

    }

    public double getDiscount() {
        return (discount);

    }

    public String toString() {

        double NewPrice = 0;
        NewPrice = price - (price * (discount));
        if(discount>0)
        return (catNumber + ", " + name + ", " + price + " NIS" + ", discount " + discount * 100 + "%" + ", price after discount  " + NewPrice);
        return (catNumber + ", " + name + ", " + price + " NIS");

    }

    public boolean isExpensive() {
        final int expensive =200;
        if (price > expensive)
            return (true);
        return (false);
    }

    public boolean theOwnerHasGoneCrazy(){
       final double highDiscount=0.7;
        if (discount>highDiscount)
            return (true);
        return (false);

    }


}
