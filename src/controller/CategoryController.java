package controller;

import controller.validation.ValidationTool;
import model.Action;
import model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryController implements Action, ValidationTool {
    List<Category> categories = new ArrayList<>();
    @Override
    public void display() {
        System.out.println("------DISPLAY------");
        for (Category category:categories){
            System.out.println(category);
        }
    }

    @Override
    public void add() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void search() {

    }

    @Override
    public void writeToFile() {

    }

    @Override
    public void readFromFile() {

    }
}
