
package library.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Member extends Person {
    Scanner input=new Scanner(System.in);
    
    private int numOfMember = 0;
    ArrayList<String> memberUsername = new ArrayList<> ();
    ArrayList<String> memberPassword = new ArrayList<> (); 
    ArrayList<String> memberId = new ArrayList<> ();
    ArrayList<String> memberPhoneNum = new ArrayList<> ();
    ArrayList<Integer> memberage = new ArrayList<> ();
                     
    public Member(){
        //default Librarians
        memberUsername.add("Wadha Mohammed Al-Hajri");
        memberPassword.add("Wadha123");
        memberId.add("WMH123");
        memberPhoneNum.add("+966545897321");
        memberage.add(20);
        numOfMember++;
        
        memberUsername.add("Jenan Shaheed Al-Habbas");
        memberPassword.add("Jenan123");
        memberId.add("JHH123");
        memberPhoneNum.add("+966544896321");
        memberage.add(20);
        numOfMember++;
    }
    
    public boolean isMember(){
        int Continue = 1;
        int isMem = 0;
        do{
            System.out.print("\nEnter your ID: ");
            String idin = input.next();

            System.out.print("Enter your Password: ");
            String passWord = input.next();
            
            this.id = idin;
            this.password = passWord;
            
            do{
                if (isMember(id, password)){
                    System.out.println("\n\t**Welcome To Membeer System**");
                    isMem = 1;
                    Continue = 0;
                }
                else{
                    System.out.print("\nEnter 1 to re-enter your informaion or 0 to Exit: ");
                    Continue = input.nextInt();
                    System.out.println("");
                    break;
                }

            }while(Continue!=0);
        }while(Continue!=0);
    
        if(isMem ==1)
            return true;
        else
            return false;
    }
    
    public boolean isMember(String id, String password){
        if (memberId.contains(id)){ 
                if(memberPassword.contains(password)){
                    if (memberId.indexOf(id) == memberPassword.indexOf(password)){
                        return true;
                    }

                    else{
                        System.out.println("The ID Doesn't match password!");
                        return false;
                    }
                }                    

                else{
                    System.out.println("The ID password is wrong!");
                    return false;
                }
        }                 

        else{ 
            System.out.println("There is NO Membeer with this username!");
            return false;
        }    
    }
    
    public void newMember(){
        
        int genNum = 0;
        char firstChar = '\u0000';
        String sFirstChar = null;
        char midChar = '\u0000';
        String sMidChar = null;
        char lastChar = '\u0000';
        String sLastChar = null;
        String firstName;
        String middleName;
        String lastName;
        
        System.out.println("");
        
        System.out.print("Enter your first name: ");
        firstName = input.nextLine();
        firstName.trim();
        
        System.out.print("Enter your middle name: ");
        middleName = input.nextLine();
        middleName.trim();
        
        System.out.print("Enter your last name: ");
        lastName = input.nextLine();
        lastName.trim();
        
        System.out.print("Enter your age: "); //AGE
        int age = input.nextInt(); 
        this.age = age;
        memberage.add(age); 
        
        String username = (firstName + " " + middleName + " " + lastName); //NAME
        this.userName = username;
        memberUsername.add(userName);
        
        firstChar = firstName.charAt(0);
        firstChar = Character.toUpperCase(firstChar);
        sFirstChar = Character.toString(firstChar);
        
        midChar = middleName.charAt(middleName.length()/2);
        midChar = Character.toUpperCase(midChar);
        sMidChar = Character.toString(midChar);
        
        lastChar = lastName.charAt(lastName.length()-1);
        lastChar = Character.toUpperCase(lastChar);
        sLastChar = Character.toString(lastChar);

        genNum = 100 + (int) (Math.random() * ((999 - 100) + 1));
        
        this.id = sFirstChar + sMidChar + sLastChar + genNum ;
        System.out.println("");
        System.out.println("Your Id is: " + id + " Don't forget it your entery as a member depends on it");
        System.out.println("");
        memberId.add(id); //RANDOM ID
        
        input.nextLine();
        
        System.out.print("Enter your Password: "); //PASSWORD
        String passWord = input.nextLine();
        this.password = passWord;
        memberPassword.add(password);
 
        boolean checkNum = false;
        int check = 0;
        do{
            System.out.print("Enter the librarian 8 phone number digit starting from 5 (Ex:5XXXXXXXX):  ");
            String phonenum = input.next();

            for (int i = 0; i < phonenum.length(); i++) {                 
                if (phonenum.charAt(i) >= '0'&& phonenum.charAt(i) <= '9') { 
                    checkNum = true;
                }                
            }
        
            if(phonenum.charAt(0)== '0' || phonenum.length()<9 || phonenum.length()>=10 || phonenum.charAt(0)!= '5' || checkNum == false){
                System.out.println("This phone number is invalid!");
            }
            else{
                phonenum = ("+966" + phonenum);
                this.phoneNum = phonenum; 
                memberPhoneNum.add(phoneNum); 
                check = 1;
            }         
        }while(check!=1);
            
        this.numOfMember++;
        
        System.out.println("\nMember " + numOfMember + " was added Successfully\n");
    }
    
    public void memberTask(List <Book> Scientificlist , List <Book> Entertainmentlist, List <Book> finalScientificlist , List <Book> finalEntertainmentlist) {
        int choice ;
        
            do{   
                System.out.println("\n\tEnter \n\t1 for Borrow book,\n\t2 for Retern book,\n\t3 for Search for a book,\n\t4 for View books, \n\t0 for Exit Member System ");
                System.out.println("\t-----------------------------");
                System.out.print("\tYour Choice is: ");
                
                choice=input.nextInt();
                   
                switch(choice){
                    case 1:
                        if(docounterB == 0 && docounterR == 3){
                            System.out.println("\tYou can't borrow any more books because \n\t\tyou have exited the borrowing book limit! \n\t\tOR \n\t\tyou didn't return the books you already borrowed");
                            continue;
                        }
                        borrowBook(Scientificlist, Entertainmentlist);
                        
                        break;
                    case 2:
                        if(docounterR == 0){
                            System.out.println("\n\tYou can't return any more books");                           
                            continue;
                        }
                        returnBook(Scientificlist, Entertainmentlist,finalScientificlist,finalEntertainmentlist);
                        break;
                    case 3:
                        searchBook(Scientificlist, Entertainmentlist);
                        break; 
                    case 4:
                        viewBook(Scientificlist, Entertainmentlist);
                        break;   
                    case 0:
                        System.out.println("\nExit from Membeer systeam");
                        break;
            }
        }while(choice!=0);          
    }
   
    private int docounterR;    
    private int docounterB = 3;
    private int checkerB = 1;   
    public void borrowBook(List <Book> Scientificlist , List <Book> Entertainmentlist){
               
        System.out.println("\n\t-----------------------------------------------------------------------------------------------------------------");
        System.out.println("\tThe maximum number of books you can borrow is 3 books! If you exceed this number the bill will print automaticly");
        System.out.println("\t-----------------------------------------------------------------------------------------------------------------");
        
        int choose;
        String bookName;
               
        List<String> booktitle = new ArrayList<String>();
        List<String> booktype = new ArrayList<String>();
        List<Double> bookPrice = new ArrayList<Double>();
        
        do{
            bookName = null;
                       
            System.out.println("\n\tEnter 1 to borrow scientific book, \n\tEnter 2 to borrow Entertainment Book,\n\tEnter 3 to Print your bill,\n\tEnter 0 to Exit from borrow.");
            System.out.println("\t----------------------------------------");
            System.out.print("\tYour choice is: ");
            choose = input.nextInt();
            
            if(docounterB == 0 && (choose == 1 || choose == 2 || choose == 3) && docounterR == 3){
                System.out.println("\tYou can't borrow any more books because \n\tyou have exited the borrowing book limit! \n\tOR \n\tyou didn't return the books you already borrowed");
                checkerB=2;
                choose=4;
                break;
            }
            
            switch(choose){

                case 0:
                    System.out.println("\tyou have exited the borrowing book limit!");
                    choose=4;
                    break;

                case 1:
                    
                    input.nextLine();
                    
                    int j = Scientificlist.size();
                    
                    if(j!=-1 && docounterB !=0){  
                    System.out.print("\tEnter the name of the book you want to borrow: ");                   
                    bookName = input.nextLine().trim();      
                    
                        for(int i=0 ; i<(Scientificlist.size()) ; i++){ 
                            if(bookName.equals(Scientificlist.get(i).title)){ 
                                if(Scientificlist.get(i).numberOfcopy>0){
                                    int copy = Scientificlist.get(i).numberOfcopy;
                                    Scientificlist.get(i).setNumberOfcopy(copy-1);
                                    booktitle.add(bookName);
                                    booktype.add("Scientific");
                                    bookPrice.add(Scientificlist.get(i).price);
                                    docounterB = docounterB-1;
                                    break;                                
                                }                                
                                else{
                                    System.out.println("\tAll the copies from this book are not available!");
                                    break;
                                }    
                            }                           
                            else if (j!=0){
                                j--;

                                if(j==0 && (bookName.equals(Scientificlist.get(i).title)==false)){
                                    System.out.println("\tThere is no book with this title!");
                                    break;
                                }                               
                                continue;
                            }                           
                        }      
                    }                                      
                    break;

                case 2:
                    
                    input.nextLine();
                    
                    int s = Entertainmentlist.size();
                    
                    if(s!=-1 && docounterB !=0){  
                    System.out.print("\tEnter the name of the book you want to borrow: ");                   
                    bookName = input.nextLine().trim();      
                    
                        for(int i=0 ; i<(Entertainmentlist.size()) ; i++){ 
                            if(bookName.equals(Entertainmentlist.get(i).title)){ 
                                if(Entertainmentlist.get(i).numberOfcopy>0){
                                    int copy = Entertainmentlist.get(i).numberOfcopy;
                                    Entertainmentlist.get(i).setNumberOfcopy(copy-1);
                                    booktitle.add(bookName);
                                    booktype.add("Entertainment");
                                    bookPrice.add(Entertainmentlist.get(i).price);
                                    docounterB = docounterB-1;
                                    break;                                
                                }                                
                                else{
                                    System.out.println("\tAll the copies from this book are not available!");
                                    break;
                                }    
                            }                           
                            else if (s!=0){
                                s--;

                                if(s==0 && (bookName.equals(Entertainmentlist.get(i).title)==false)){
                                    System.out.println("\tThere is no book with this title!");
                                    break;
                                }                               
                                continue;
                            }                           
                        }      
                    }
                    break;
                    
                case 3:
                    System.out.println();
                    Bill newBill = new Bill();
                    newBill.createBill(booktitle,booktype ,bookPrice);
                    choose=4;
                    break;

            }     
        }while(docounterB!=0 && choose!=4 );  
        
        if(docounterB == 0 && checkerB == 1){ 
            System.out.println();
            Bill newBill = new Bill();
            newBill.createBill(booktitle,booktype ,bookPrice);
        }

        if(docounterB == 0){
            docounterR = 3;
        }
        else if(docounterB == 1){
            docounterR = 2;
        }
        else if(docounterB == 2){
            docounterR = 1;
        }
        else if(docounterB == 3){
            docounterR = 0;
        }
    } 
     
    private int checkerR = 1; 
    public void returnBook(List <Book> Scientificlist , List <Book> Entertainmentlist, List <Book> finalScientificlist , List <Book> finalEntertainmentlist){
        System.out.println("\n\t------------------------------------------------------");
        System.out.println("\tThe maximum number of books you can return is 3 books!");
        System.out.println("\t-------------------------------------------------------");
        int choose;
        String bookName;
               
        List<String> booktitle = new ArrayList<String>();
        List<Double> bookPrice = new ArrayList<Double>();
        
        do{
            bookName = null;
                       
            System.out.println("\n\tEnter 1 to return scientific book, \n\tEnter 2 to return Entertainment Book,\n\tEnter 3 to see how many books are left for you to return,\n\tEnter 0 to Exit from return book.");
            System.out.println("\t----------------------------------------");
            System.out.print("\tYour choice is: ");
            choose = input.nextInt();
            
            if(docounterR == 0 && (choose == 1 || choose == 2 || choose == 3)){
                System.out.println("\tYou can't return any more books");
                checkerR=2;
                choose=4;
                break;
            }
            
            switch(choose){

                case 0:
                    System.out.println("\tyou have exited the returning number of book!");
                    choose=4;
                    break;

                case 1:
                    
                    input.nextLine();
                    
                    int j = Scientificlist.size();
                    
                    if(j!=-1 && docounterR !=0){  
                    System.out.print("\tEnter the name of the book you want to return: ");                   
                    bookName = input.nextLine().trim();      
                    
                        for(int i=0 ; i<(Scientificlist.size()) ; i++){ 
                            if(bookName.equals(Scientificlist.get(i).title)){     
                                if(Scientificlist.get(i).numberOfcopy==0 || Scientificlist.get(i).numberOfcopy<finalScientificlist.get(i).numberOfcopy){ 
                                    int copy = Scientificlist.get(i).numberOfcopy;
                                    Scientificlist.get(i).setNumberOfcopy(copy+1);
                                    booktitle.add(bookName);
                                    bookPrice.add(Scientificlist.get(i).price);
                                    docounterR = docounterR-1;
                                    docounterB = docounterB+1;
                                    break;                                
                                }                                
                                else{
                                    System.out.println("\tAll the copies from this book are available!");
                                    break;
                                }    
                            }                           
                            else if (j!=0){
                                j--;

                                if(j==0 && (bookName.equals(Scientificlist.get(i).title)==false)){
                                    System.out.println("\tThere is no book with this title!");
                                    break;
                                }                               
                                continue;
                            }                           
                        }      
                    }                                      
                    break;

                case 2:
                    
                    input.nextLine();
                    
                    int s = Entertainmentlist.size();
                    
                    if(s!=-1 && docounterR !=0){  
                    System.out.print("\tEnter the name of the book you want to return: ");                   
                    bookName = input.nextLine().trim();      
                    
                        for(int i=0 ; i<(Entertainmentlist.size()) ; i++){ 
                            if(bookName.equals(Entertainmentlist.get(i).title)){
                                if(Entertainmentlist.get(i).numberOfcopy==0 || Entertainmentlist.get(i).numberOfcopy<finalEntertainmentlist.get(i).numberOfcopy){
                                    int copy = Entertainmentlist.get(i).numberOfcopy;
                                    Entertainmentlist.get(i).setNumberOfcopy(copy+1);
                                    booktitle.add(bookName);
                                    bookPrice.add(Entertainmentlist.get(i).price);
                                    docounterR = docounterR-1;
                                    docounterB = docounterB+1;

                                    break;                                
                                }                                
                                else{
                                    System.out.println("\tAll the copies from this book are available!");
                                    break;
                                }    
                            }                           
                            else if (s!=0){
                                s--;

                                if(s==0 && (bookName.equals(Entertainmentlist.get(i).title)==false)){
                                    System.out.println("\tThere is no book with this title!");
                                    break;
                                }                               
                                continue;
                            }                           
                        }      
                    }
                    break;
                    
                case 3:
                    System.out.println();
                    System.out.println("\tYou have to retern " + docounterR + " Books");
                    break;

            }     
        }while(docounterR!=0 && choose!=4 );  
        
        if(docounterR == 0 && checkerR == 1){ 
            System.out.println();
            System.out.println("\tYou have reterned all books");
        }       
    }
   
}
