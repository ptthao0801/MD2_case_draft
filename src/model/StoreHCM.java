package model;

public class StoreHCM extends Store{
    public StoreHCM() {
        super();
    }
    public StoreHCM(int id) {
        super(id);
    }

    @Override
    public void greeting() {
        System.out.println("--------WELCOME TO "+ getName() + " HỒ CHÍ MINH --------");
    }
}
