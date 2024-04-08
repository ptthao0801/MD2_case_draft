package controller;

import controller.validation.ValidationTool;
import model.Customer;
import model.Employee;
import model.Order;
import model.Product;

import java.io.*;
import java.util.*;


public class OrderController implements ActionForModel, ValidationTool {
    Scanner scanner = new Scanner(System.in);
    List<Order> orders = new ArrayList<>();
    List<Product> topProducts = new ArrayList<>();
    Set<Integer> idProductSet = new HashSet<>();
    String path = "order.txt";


    public OrderController(){
        orders.add(new Order(1,45,50,34,1));
        orders.add(new Order(1,60,40,34,1));
        orders.add(new Order(1,30,30,34,1));
        orders.add(new Order(1,20,3,34,1));

        orders.add(new Order(1,50,60,34,2));
        orders.add(new Order(1,45,34,34,2));
        orders.add(new Order(1,35,20,34,2));
        orders.add(new Order(1,70,50,34,2));

        orders.add(new Order(1,70,400,34,3));
        orders.add(new Order(1,100,3,34,3));

        orders.add(new Order(1,100,1000,34,4));

        orders.add(new Order(1,10,600,34,5));
    }

    @Override
    public void display() {
        System.out.println("------DISPLAY ORDER------");
        Collections.sort(orders);
        for (Order order:orders){
            System.out.println(order);
        }
    }

    @Override
    public void add() {
        System.out.println("------ADD ORDER------");
        System.out.println("Enter ID: ");
        int id;
        while (true) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (ValidationTool.idValidation(id)) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. ID must be a number. Please re-enter: ");
            }
        }
        System.out.println("Enter price: ");
        double price;
        while (true) {
            price = Double.parseDouble(scanner.nextLine());
            if (ValidationTool.priceValidation(price)){
                break;
            }
        }
        System.out.println("Enter quantity: ");
        int quantity;
        while (true) {
            quantity = Integer.parseInt(scanner.nextLine());
            if (ValidationTool.quantityValidation(quantity)){
                break;
            }
        }
        System.out.println("Enter ID Customer: ");
        int idCustomer;
        while (true) {
            idCustomer = Integer.parseInt(scanner.nextLine());
            if (ValidationTool.quantityValidation(idCustomer)){
                break;
            }
        }
        System.out.println("Enter ID Product: ");
        int idProduct;
        while (true) {
            idProduct = Integer.parseInt(scanner.nextLine());
            if (ValidationTool.quantityValidation(idProduct)){
                break;
            }
        }
        Order newOrder = new Order(id, price, quantity,idCustomer,idProduct);
        orders.add(newOrder);
        System.out.println("ADDED SUCCESSFULLY!");
        System.out.println(newOrder);
    }

    @Override
    public void remove() {
        System.out.println("------REMOVE ORDER------");
        System.out.println("Remove this ID: ");
        while (true){
            boolean isAvailable = false;
            int id = scanner.nextInt();
            for (Order order:orders){
                if (order.getIdOrder()==id){
                    isAvailable = true;
                    orders.remove(order);
                    break;
                }
            }
            if(isAvailable){
                System.out.println("ORDER ID "+id+" HAS BEEN REMOVED SUCCESSFULLY!");
            } else {
                System.out.println("ORDER ID NOT FOUND! Please re-enter: ");
            }
        }
    }

    @Override
    public void search() {
        System.out.println("------SEARCH ORDER------");
        System.out.println("Enter Order ID: ");
        String searchItem = scanner.nextLine();
        boolean found = false;
        for (Order order : orders) {
            if (String.valueOf(order.getIdOrder()).equals(searchItem)) {
                System.out.println("FOUND! " + order);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("ORDER NOT FOUND!");
        }
    }

    @Override
    public void writeToFile() {
        System.out.println("------WRITE TO FILE------");
        ObjectOutputStream oos = null;
        String path = "order.txt";
        try {
            FileOutputStream fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            for (Order order : orders) {
                oos.writeObject(order);
            }
            fos.close();
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("DONE WRITING TO FILE "+ path);
    }

//    @Override
    public void readFromFile() {
        System.out.println("------READ FROM FILE------");
        List<Order> readOrders = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                try {
                    Order order = (Order) ois.readObject();
                    if (order != null) {
                        readOrders.add(order);
                    } else {
                        break;
                    }
                } catch (EOFException e) {
                    // Đọc đến cuối file
                    break;
                }
            }
            System.out.println("DONE READING FROM FILE " + path);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        List<Order> orderDataFromFile = readOrders;
        for (Order order : orderDataFromFile){
            System.out.println(order);
        }
    }
    public List<Product> getOrderValueByIdList() {

        // In ra danh sách ID sản phẩm và thêm chúng vào idProductSet
//        System.out.println("ID List: ");
        for (Order order : orders) {
            int idProduct = order.getIdProduct();
            idProductSet.add(idProduct);
//            System.out.println(idProduct);
        }

// In ra từng phần tử đã được thêm vào idProductSet
//        System.out.println("Elements in idProductSet: ");
//        for (Integer id : idProductSet) {
////            System.out.println(id);
//        }

        // Tính tổng giá trị đơn hàng dựa trên từng ID sản phẩm
        System.out.println("Order value by Product ID:");
        for (Integer id : idProductSet) {
            double value = 0; // Reset giá trị của value cho mỗi ID sản phẩm mới
            String name;
            for (Order order : orders) {
                if (order.getIdProduct() == id) {
                    value += order.getPrice() * order.getQuantity();
//                    name = product.
                }
            }
            topProducts.add(new Product(id, value));
            System.out.println("Product ID: " + id + ", Total Sale: " + value);

            // can sap xep lai topProducts by value
        }
        sortTopOrderValue();
        return topProducts;
    }
    public void sortTopOrderValue() {
        // Sắp xếp topProducts sử dụng Comparator
        Collections.sort(topProducts, new Comparator<Product>(){
            @Override
            public int compare(Product p1, Product p2) {
                // So sánh giá trị value của hai Product
                return Double.compare(p2.getTotalValueByProductId(), p1.getTotalValueByProductId());
                // Để sắp xếp giảm dần, sử dụng p2.getValue() - p1.getValue()
            }
        });

        // In ra danh sách topProducts đã được sắp xếp
//        System.out.println("Sorted topProducts:");
//        for (Product product : topProducts) {
//            System.out.println("Product ID: " + product.getId() + ", Total Sale: " + product.getTotalValueByProductId());
//        }
    }


}
