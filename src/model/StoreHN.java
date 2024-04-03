package model;

public class StoreHN extends Store{
    public StoreHN() {
        super();
    }

    public StoreHN(int id) {
        super(id);
    }
    @Override
    public void greeting() {
        System.out.println("--------WELCOME TO "+ getName() + " HÀ NỘI --------");
    }
}
