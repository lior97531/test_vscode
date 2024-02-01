public class StoreMain {
    public static void main(String[] args) {
        StoreItem item1 = new StoreItem(111, "Milk", 5.3);
        System.out.println(item1);
        item1.setDiscount(0.1);
        System.out.println(item1);
        System.out.println(item1.getName()+" is expensive? "+ item1.isExpensive());
        System.out.println(item1.getName() + " crazy discount? " + item1.theOwnerHasGoneCrazy ()
        );




    }
}
