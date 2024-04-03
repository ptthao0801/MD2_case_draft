package controller;

import controller.validation.ValidationTool;

public class ProductController implements Action, ValidationTool {

    @Override
    public void display() {
        System.out.println("------DISPLAY------");

    }

    @Override
    public void add() {
        System.out.println("------ADD------");

    }

    @Override
    public void remove() {
        System.out.println("------REMOVE------");

    }

    @Override
    public void search() {
        System.out.println("------SEARCH------");

    }

    @Override
    public void writeToFile() {
        System.out.println("------WRITE TO FILE------");

    }

    @Override
    public void readFromFile() {
        System.out.println("------READ FROM FILE------");

    }
}
