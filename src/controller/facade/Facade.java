package controller.facade;

import controller.*;
import model.Product;

import java.util.List;

public class Facade {
    CategoryController category = new CategoryController();
    ProductController product = new ProductController();
    public void displayProductAndCategory(){
        product.display();
        category.display();
    }
    public void getTop10Products() {
        System.out.println("--------TOP 10 PRODUCTS BY SALES VALUE--------");
        OrderController orderController = new OrderController();
        ProductController productController = new ProductController();

        // Get Order Value List by ID
        List<Product> orderValueByIdList = orderController.getOrderValueByIdList();

        // Get Product List
        List<Product> productList = productController.getProductList();
        for (Product o: orderValueByIdList){
            for (Product p: productList){
                if (o.getId() == p.getId()){
                    System.out.println("Total Sales Value = " + o.getTotalValueByProductId() + ", ID = " + o.getId() + ", Product: " + p.getCategory() + " " + p.getName());
                }
            }

        }
    }

//    public static void main(String[] args) {
//        getTop10Products();
//    }
}
