import java.util.Scanner;

public class Day13 {

    public static abstract class Book{
        String title;
        String author;
        Book(String t,String a){
            title=t;
            author=a;
        }
        abstract void display();

    }

    public static class MyBook extends Book{

        int price;

        MyBook(String title, String author, int price){
            super(title, author);
            this.price = price;

        }

        @Override
        void display() {
            System.out.println("Title: "+ this.title);
            System.out.println("Author: "+ this.author);
            System.out.println("Price: "+ this.price);

        }
    }


    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        String title=sc.nextLine();
        String author=sc.nextLine();
        int price=sc.nextInt();
        Book new_novel=new MyBook(title,author,price);
        new_novel.display();

    }
}
