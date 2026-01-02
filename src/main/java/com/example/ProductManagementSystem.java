package com.example;

public class ProductManagementSystem {
    private Product products[];
    private int count;
     public ProductManagementSystem(int size) {
         products = new Product[size];
         count = 0;
     }
     public void addProduct(Product product) {
        if(count<products.length) {
          products[count++] = product;
         System.out.println("Product added successfully");
        }
        else {
         System.out.println("Product not added successfully");
        }
     }
     public void displayAll()
     {
      if(count==0)
      {
       System.out.println("There are no products available in the system");
       return ;
      }

       for(int i=0;i<count;i++)
       {
        products[i].displayInfo();
       }


     }
     public void searchProduct(int id)
     {
      if(count==0)
         {
           System.out.println("Product not found");
           return;
         }
      for(int i=0;i<count;i++)
      {
       if(products[i].getId()==id)
        {
          System.out.println("Product found");
        }
      }


     }

     public void updateProduct(int id,String name,double price)
     {
      for(int i=0;i<count;i++)
      {
       if(products[i].getId()==id)
        {
          products[i].setName(name);
          products[i].setPrice(price);
          System.out.println("Product updated successfully");
          return;
        }
      }
      System.out.println("Product not found");

     }
     public void deleteProduct(int id)
     {
      for(int i=0;i<count;i++) {
       if (products[i].getId() == id) {
        for (int j = i; j < count - 1; j++) {
         products[j] = products[j + 1];
        }
        products[--count] = null;
        System.out.println("Product deleted successfully");
        return;

       }
      }
       System.out.println("Product not found");
     }
     public void findMostExpensive()
     {
      if(count==0)
      {
       System.out.println("There are no products available in the system");
       return;
      }
      Product max=products[0];
      for(int i=1;i<count;i++)
      {
       if(products[i].getPrice()>max.getPrice())
        {
          max=products[i];
        }
      }
      System.out.println("Most Expensive Product found");
      max.displayInfo();

     }

     public void sortByPrice()
     {
      for(int i=0;i<count-1;i++)
      {
       for(int j=0;j<count-i-1;j++)
       {
        if(products[j].getPrice()>products[j+1].getPrice())
        {
         Product temp=products[j];
         products[j]=products[j+1];
         products[j+1]=temp;
        }
       }
      }
      System.out.println("Product sorted successfully");

     }

}
