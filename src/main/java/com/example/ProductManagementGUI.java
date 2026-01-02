package com.example;

import javax.swing.*;
import java.awt.*;

public class ProductManagementGUI {
    private JFrame frame;
    private JTextField idField, nameField, priceField;
    private JTextArea displayArea;
    private ProductManagementSystem productManagementSystem=new ProductManagementSystem(50);
    public ProductManagementGUI() {
        frame = new JFrame("Product Management System");
        frame.setPreferredSize(new Dimension(400,300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        JPanel inputPanel = new JPanel(new GridLayout(10, 1));
        //inputPanel.setPreferredSize(new Dimension(400,300));
        idField = new JTextField();
        nameField = new JTextField();
        priceField = new JTextField();

        inputPanel.add(new  JLabel("Product ID"));
        inputPanel.add(idField);
        inputPanel.add(new  JLabel("Product name"));
        inputPanel.add(nameField);
        inputPanel.add(new  JLabel("Product price"));
        inputPanel.add(priceField);

        JButton shortButton = new JButton("short");
        shortButton.setPreferredSize(new Dimension(80, 30));

        //JPanel buttonPanel = new JPanel(new  GridLayout(20, 5));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,15,10));
        //buttonPanel.setPreferredSize(new Dimension(400, 60));
        JButton addButton = new JButton("Add Product");
        addButton.setPreferredSize(new Dimension(120, 40));
        JButton searchButton = new JButton("Search Product By ID");
         searchButton.setPreferredSize(new Dimension(120, 40));
        JButton updateButton = new JButton("Update Product");
        updateButton.setPreferredSize(new Dimension(120, 40));
        JButton removeButton = new JButton("Remove Product");
        removeButton.setPreferredSize(new Dimension(120, 40));
        JButton viewButton = new JButton("View Product");
        viewButton.setPreferredSize(new Dimension(120, 40));
        JButton sortByPriceButton = new JButton("Sort All Products");
        sortByPriceButton.setPreferredSize(new Dimension(120, 40));
        JButton expensiveProductButton = new JButton("expensive product");
        expensiveProductButton.setPreferredSize(new Dimension(120, 40));
        JButton exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(120, 40));


        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(sortByPriceButton);
        buttonPanel.add(expensiveProductButton);
        buttonPanel.add(exitButton);

        displayArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(displayArea);
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addProduct());
        searchButton.addActionListener(e -> searchProduct());
        updateButton.addActionListener(e->updateProduct());
        removeButton.addActionListener(e-> deleteProduct());
        viewButton.addActionListener(e->viewProducts());
        sortByPriceButton.addActionListener(e->sortByPrice());
        expensiveProductButton.addActionListener(e->expensiveProduct());


        frame.setVisible(true);}

    private void addProduct() {
        int id=Integer.parseInt(idField.getText());
        String name=nameField.getText();
        double price=Double.parseDouble(priceField.getText());
        productManagementSystem.addProduct(new  Product(id,name,price));
        clearFields();

    }
    private void searchProduct() {
        int id=Integer.parseInt(idField.getText());
        productManagementSystem.searchProduct(id);
    }

    private void updateProduct() {
        int newId=Integer.parseInt(idField.getText());
        String newName=nameField.getText();
        double newPrice=Double.parseDouble(priceField.getText());
        productManagementSystem.updateProduct(newId,newName,newPrice);
        clearFields();

    }
    private void deleteProduct() {
        int id=Integer.parseInt(idField.getText());
        productManagementSystem.deleteProduct(id);
        clearFields();
    }
    private void viewProducts() {
        displayArea.setText("");
        productManagementSystem.displayAll();
    }
    private void sortByPrice() {
        productManagementSystem.sortByPrice();
    }
    private void expensiveProduct()
    {
        productManagementSystem.findMostExpensive();
    }


    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        priceField.setText("");
    }
    public static void main(String[] args) {
        new ProductManagementGUI();
    }
}
