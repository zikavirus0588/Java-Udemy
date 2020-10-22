package com.company;

import com.company.entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args){
//        testaPolimorfismo();
        testaAbstractClass();
    }
    public static void testaPolimorfismo() throws ParseException{
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Enter the number of products: ");
        int numberOfProducts = sc.nextInt();
        List<Product> list = new ArrayList<>();
        for(int i = 1; i<=numberOfProducts; i++){
            System.out.println("Product #" + i + " data:");
            System.out.print("Commom, Used or imported (c/u/i)? ");
            char response = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String productName = sc.nextLine();
            System.out.print("Price: ");
            double productPrice = sc.nextDouble();
            if (response == 'i'){
                System.out.print("Custom fee: ");
                double customFee = sc.nextDouble();
                list.add(new ImportedProduct(productName,productPrice,customFee));
            } else if (response == 'u'){
                System.out.print("Manufacture dade (DD/MM/YYYY): ");
                Date manufactureDate = sdf.parse(sc.next());
                list.add(new UsedProduct(productName,productPrice,manufactureDate));
            } else {
                list.add(new Product(productName,productPrice));
            }
        }
        System.out.println();
        System.out.println("PRICE TAGS: ");
        for (Product p : list){
            System.out.println(p.priceTag());
        }
        sc.close();
    }

    public static void testaAbstractClass(){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Payer> list = new ArrayList<>();
        System.out.print("Enter the number of tax payers: ");
        int numberOfPayers = sc.nextInt();
        for(int i = 1; i <= numberOfPayers; i++){
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char response = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String nameOfPayer = sc.nextLine();
            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();
            if (response == 'i'){
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                list.add(new IndividualPayer(nameOfPayer,anualIncome,healthExpenditures));
            } else {
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                list.add(new CompanyPayer(nameOfPayer,anualIncome,numberOfEmployees));
            }
        }
        System.out.println();
        double sum = 0.0;
        System.out.println("TAXES PAID:");
        for (Payer p : list){
            System.out.println(p.getName() + ": $ " + String.format("%.2f",p.taxPaid()));
            sum += p.taxPaid();
        }
        System.out.println();
        System.out.println("TOTAL TAXES: "+String.format("%.2f",sum));
        sc.close();
    }
}
