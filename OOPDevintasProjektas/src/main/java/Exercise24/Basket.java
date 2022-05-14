package Exercise24;

public class Basket {

    private int numberOfItems;

    public Basket() {
       numberOfItems = 0;
    }
    public void addToBasket(){
        if(numberOfItems ==10){
            throw new BasketFullException("per pilnas krepsys!");
        }else {
            numberOfItems++;
        }
    }
    public void removeFromBasket(){
        if(numberOfItems == 0){
            throw new BasketEmptyException("krepsys jau yra tuscias!");
        } else {
            numberOfItems--;
        }
    }

    public int getNumberOfItems(){
        return numberOfItems;
    }
}
