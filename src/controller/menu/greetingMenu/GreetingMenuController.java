package controller.menu.greetingMenu;

import controller.menu.ActionForMenu;
import model.StoreHCM;
import model.StoreHN;

import java.util.Scanner;

public class GreetingMenuController implements ActionForMenu {
    StoreHCM storeHCM = new StoreHCM();
    StoreHN storeHN = new StoreHN();
    Scanner scanner = new Scanner(System.in);
    public void display(){
        System.out.println("------SELECT STORE------");
        System.out.println("0. Exit");
        System.out.println("1. HÀ NỘI");
        System.out.println("2. HỒ CHÍ MINH");
        System.out.println("-------------> Enter your selection: ");
    }

    @Override
    public void runBySelecTion() {
        int selection = scanner.nextInt();
        switch (selection){
            case 0:
                System.exit(0);
                break;
            case 1:
                storeHN.greeting();
                break;
            case 2:
                storeHCM.greeting();
                break;
            default:
                System.out.println("WARNING: INVALID OPTION. Please re-enter: ");
                break;
        }
    }

}
