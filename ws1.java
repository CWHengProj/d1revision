//workshop 1 revision

import java.io.Console;
import java.util.LinkedList;
import java.util.Scanner;

public class ws1{
    public static void main(String[] args){
        System.out.println("Welcome to your shopping cart");
        LinkedList <String> cart = new LinkedList<>();
        boolean loop = true;
            while (loop){
                System.out.printf(">");
                Console cons = System.console(); //initializes console, prompts user to type
                String userInput = cons.readLine().toLowerCase();//saves user input as a string value
                Scanner word = new Scanner(userInput);//remove first word to determine what function user intends to use
                String firstWord = word.next();
                //switch case to determine next course of action
                switch (firstWord) {
                    case "list":
                        int i =1;
                        if (cart.size()!=0){
                            for (String item: cart){
                                System.out.printf("%d. ",i);
                                System.out.println(item);
                                i++;
                            }
                        }
                        else
                            System.out.println("Your cart is empty");
                        break;
                
                    case "add":
                        //clean data, create a list of items to loop through and add onto set
                        String temp = "";
                        while (word.hasNext()){
                            temp = word.next().trim().replace(","," ");
                            if (cart.contains(temp)){
                                System.out.printf("You have %s in your cart\n", temp);
                            }
                            else {
                                cart.add(temp);
                                System.out.printf("%s added to cart\n",temp);
                            }   
                        }
                        break;
                    case "delete":
                        int num = Integer.parseInt(word.next().trim());
                        if (num>(cart.size())){
                            System.out.println("Incorrect item index");
                        }
                        else{
                            System.out.printf("%s removed from your list\n", cart.get(num-1));
                            cart.remove(num-1);
                        }
                        
                        break;
                    default:
                        System.out.println("Please enter List, Add, or Delete to start the program.");
                        loop = false;
                        break;
                }
                word.close();
        }
    }
}