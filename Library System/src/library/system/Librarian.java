
package library.system;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Librarian extends Person {
    Scanner input = new Scanner(System.in);
    
    private static int numOfLibrarian = 0;
    List<String> librarianUsername = new ArrayList<>();
    List<String> librarianPassword = new ArrayList<>();
    ArrayList<String> librarianId = new ArrayList<>();
    ArrayList<String> librarianPhoneNum = new ArrayList<>();
    ArrayList<Integer> librarianAge = new ArrayList<>();

    Librarian() {
        //default Librarians
        librarianUsername.add("Hajar Saleh Bawazir");
        librarianPassword.add("Hajar123");
        librarianId.add("HSB123");
        librarianPhoneNum.add("+966575552257");
        librarianAge.add(20);
        numOfLibrarian++;
        
        librarianUsername.add("Sara Khalid Alsaqer");
        librarianPassword.add("Sara123");
        librarianId.add("SKA123");
        librarianPhoneNum.add("+966515551046");
        librarianAge.add(20);
        numOfLibrarian++;
    }

    public boolean isLibrarians(){
        int Continue = 1;
        int islib = 0;
        do{
            System.out.print("Enter your ID: ");
            String userID = input.next();

            System.out.print("Enter your Password: ");
            String passWord = input.next();
            
            this.id = userID;
            this.password = passWord;
            
            do{
                if (isLibrarians(id, password)){
                    System.out.println("\n\t**Welcome To Librarian System**\n");
                    islib = 1;
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
    
        if(islib ==1)
            return true;
        else
            return false;
    }
    
    public boolean isLibrarians(String id,String password){
        if (librarianId.contains(id)){ 
                if(librarianPassword.contains(password)){
                    if (librarianId.indexOf(id)==librarianPassword.indexOf(password)){
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
            System.out.println("There is NO librarian with this ID!");
            return false;
        }    
    }
    
    public void addLibrarian (){
        int genNum = 0;
        int genPassword = 0;
        char firstChar = '\u0000';
        String sFirstChar = null;
        char midChar = '\u0000';
        String sMidChar = null;
        char lastChar = '\u0000';
        String sLastChar = null;
        String firstName;
        String middleName;
        String lastName;
        
        System.out.println();
        
            input.nextLine();
        System.out.print("\tEnter librarian first name: ");
        firstName = input.nextLine();
        firstName.trim().toUpperCase();
        
        System.out.print("\tEnter librarian middle name: ");
        middleName = input.nextLine();
        middleName.trim().toUpperCase();
        
        System.out.print("\tEnter librarian last name: ");
        lastName = input.nextLine().toUpperCase();
        lastName.trim();
        
        String fullname = (firstName + " " + middleName + " " + lastName); //NAME
        this.userName = fullname;
        librarianUsername.add(userName);
        
        System.out.print("\tEnter librarian age: "); //AGE
        int age = input.nextInt(); 
        this.age = age;
        librarianAge.add(age);
        
        /*System.out.print("\tEnter librarian Phone Number: "); //Phone
        String phone = input.next();
        this.phoneNum= phone;
        librarianPhoneNum.add(phoneNum);*/
        
        boolean checkNum = false;
        int check = 0;
        do{
            System.out.print("\tEnter the librarian 8 phone number digit starting from 5 (Ex:5XXXXXXXX):  ");
            String phonenum = input.next();

            for (int i = 0; i < phonenum.length(); i++) {                 
                if (phonenum.charAt(i) >= '0'&& phonenum.charAt(i) <= '9') {
                    checkNum = true;
                }                
            }
        
            if(phonenum.charAt(0)== '0' || phonenum.length()<9 || phonenum.length()>=10 || phonenum.charAt(0)!= '5' || checkNum == false){
                System.out.println("\tThis phone number is invalid!");
            }
            else{
                phonenum = ("+966" + phonenum);
                this.phoneNum = phonenum; 
                librarianPhoneNum.add(phoneNum); 
                check = 1;
            }          
        }while(check!=1);
        
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
        librarianId.add(id); //RANDOM ID
               
        firstChar = userName.charAt(0);
        firstChar = Character.toLowerCase(firstChar);
        sFirstChar = Character.toString(firstChar);
        
        midChar = userName.charAt(userName.length()/2);
        midChar = Character.toUpperCase(midChar);
        sMidChar = Character.toString(midChar);
        
        genPassword = 100 + (int) (Math.random() * ((999 - 100) + 1));
        
        this.password = sFirstChar + sMidChar + genPassword + userName.charAt(userName.length()-1);
        librarianPassword.add(password);
        
        numOfLibrarian++;
        
        System.out.println("\tLibrarian " + numOfLibrarian + " was added Successfully with the ID of: " + id + " and the Password of: " + password+"\n");
    }
    
    public void deleteLibrarian (String libID){
        int librarianNum;   
        int libNum = 0;
        
        this.id = libID;
        librarianNum = librarianId.indexOf(id)+1;
        
        libNum = librarianId.indexOf(id);
        
        librarianId.remove(id);
        librarianPassword.remove(librarianPassword.get(libNum));
        librarianUsername.remove(librarianUsername.get(libNum));
        librarianPhoneNum.remove(librarianPhoneNum.get(libNum));
        librarianAge.remove(librarianAge.get(libNum));
                
        this.numOfLibrarian--;
        
        System.out.println("\tLibrarian " + librarianNum + " was Deleted Successfully\n");  
    }
    
    public void viewLibrarian(){          
        for(int i = 0; i < numOfLibrarian; i++) { 
            System.out.println();
            System.out.println("\tLibrarian " + (i+1) + " :");
            System.out.println("\tLibrarian Name: " +librarianUsername.get(i));
            
            for(int j = 0; j < numOfLibrarian; j++) {
                System.out.println("\tID: " +librarianId.get(i));
                break;
            }
            
            for(int j = 0; j < numOfLibrarian; j++) {
                System.out.println("\tPassword: " +librarianPassword.get(i));
                break;
            }
            
            for(int j = 0; j < numOfLibrarian; j++) {
                System.out.println("\tAge: " +librarianAge.get(i));
                break;
            }
            
            for(int j = 0; j < numOfLibrarian; j++) {
                System.out.println("\tPhone Number: " +librarianPhoneNum.get(i));
                break;
            }
        } 
        System.out.println();
    }  
    
    public void librarinTask(List <Book> Scientificlist , List <Book> Entertainmentlist, List <Book> finalScientificlist , List <Book> finalEntertainmentlist) {
        int choice ;
        
            do{
                
                System.out.println("\n\tEnter \n\t1 for Adding book\n\t2 for Deleting book \n\t3 for Searching for book \n\t4 for Viewing book \n\t0 for Exiting librarian systeam");
                System.out.println("\t-----------------------------");
                System.out.print("\n\tYour Choice is: ");
                
                choice=input.nextInt();
                   
                switch(choice){
                    case 1:
                        addBook(Scientificlist, Entertainmentlist,finalScientificlist,finalEntertainmentlist);
                        break;
                    case 2:
                        deleteBook(Scientificlist, Entertainmentlist,finalScientificlist,finalEntertainmentlist);
                        break;
                    case 3:
                        searchBook(Scientificlist, Entertainmentlist);
                        break; 
                    case 4:
                        viewBook(Scientificlist, Entertainmentlist);
                        break;   
                    case 0:
                        System.out.println("\n\tExited from librarian systeam\n");
                        break;
            }
        }while(choice!=0);          
    }
    
    void addBook(List <Book> Scientificlist , List <Book> Entertainmentlist, List <Book> finalScientificlist , List <Book> finalEntertainmentlist){
        
        String title;
        String language;
        String aurhor;
        int numberOfcopy;
        String bookType;
        double price;
        int allowedAge;
        int bookId;
        int numberOfPages;
        int choice;  
                
           do{
                    input.nextLine();
                System.out.println("\n\tEnter \n\t1-Add Scientific Book.\n\t2-Add Entertainment Book. \n\t0-Exit Add book");
                System.out.println("\t-----------------------------");
                System.out.print("\n\tYour Choice is: ");
                choice=input.nextInt();
           
                switch(choice){
                    case 0:
                        break;
                    case 1:
                    case 2:
                            input.nextLine();
                        System.out.print("\n\tEnter book tiltle: ");
                            title=input.nextLine();

                        System.out.print("\tEnter book language: ");
                            language=input.nextLine();

                        System.out.print("\tEnter book aurhor: ");
                            aurhor=input.nextLine();

                        System.out.print("\tEnter the number of copies: ");
                        numberOfcopy=input.nextInt();

                            input.nextLine(); 

                        System.out.print("\tEnter book Type: ");
                            bookType=input.nextLine();

                        System.out.print("\tEnter book price: ");
                            price=input.nextDouble();

                        System.out.print("\tEnter book allowed Age: ");
                            allowedAge=input.nextInt();

                        System.out.print("\tEnter book Id: ");
                            bookId=input.nextInt();

                        System.out.print("\tEnter number of pages in the book: ");
                            numberOfPages=input.nextInt();


                        if(choice==1){
                            Scientificlist.add(new Scientific(title,language,aurhor,numberOfcopy,bookType,price,allowedAge,bookId,numberOfPages));
                            finalScientificlist.add(new Scientific(title,language,aurhor,numberOfcopy,bookType,price,allowedAge,bookId,numberOfPages));
                            System.out.println("\t***The scientific book "+ Scientificlist.size()+" has been added***");

                        }
                        else if(choice==2) {
                            Entertainmentlist.add(new Entertainment(title,language,aurhor,numberOfcopy,bookType,price,allowedAge,bookId,numberOfPages));
                            finalEntertainmentlist.add(new Entertainment(title,language,aurhor,numberOfcopy,bookType,price,allowedAge,bookId,numberOfPages));
                            System.out.println("\t***The entertainment book "+ Entertainmentlist.size()+" has been added***");
                        }
                        
                        break;
                                
                    default:
                        System.out.println("\tWrong Entery, try again");
                    }     
           }while(choice!=0);
    }

    void deleteBook(List <Book> Scientificlist , List <Book> Entertainmentlist, List <Book> finalScientificlist , List <Book> finalEntertainmentlist){
        int choice;
        String name;
        
           do{
                int index=0;
                boolean value = false;
                input.nextLine();
                System.out.println("\n\tEnter \n\t1-Delete Scientific Book.\n\t2-Delete Entertainment Book. \n\t0-Exit delete book");
                System.out.println("\t-----------------------------");
                System.out.print("\n\tYour Choice is: ");
                choice=input.nextInt();
           
                switch(choice){
                    case 0:
                        break;
                    case 1:
                        input.nextLine();
                        System.out.print("\tEnter book title that you want to delete it :");
                        name=input.nextLine();
           
                        for(int i=0 ;i<Scientificlist.size();i++){
                            if(name.equals(Scientificlist.get(i).title)){
                                index=i;
                                value=true;
                            }
                        }
                        
                        if (value==true){
                            System.out.println("\tThe book \"" + Scientificlist.get(index).title + "\" has been removed");
                            Scientificlist.remove(index);
                            finalScientificlist.remove(index);
                        }
                        else{
                           System.out.println("\tThere is no book with this name !!");  
                        }
                        
                        break;
                   
                    case 2:
                        input.nextLine();
                        System.out.print("\tEnter book title that you want to delete it :");
                        name=input.nextLine();
           
                        for(int i=0 ;i<Entertainmentlist.size();i++){
                            if(name.equals(Entertainmentlist.get(i).title)){
                                index=i;
                                value=true;
                            }
                        }
                        
                        if (value==true){
                            System.out.println("\tThe book \"" + Entertainmentlist.get(index).title+"\" has been removed");
                            Entertainmentlist.remove(index);
                            finalEntertainmentlist.remove(index);
                        }
                        
                        else{
                           System.out.println("\tThere is no book with this name !!");  
                       }
                        
                        break;
                   
                    default:
                        System.out.println("\tWrong Entery, try again");
                    }     
           }while(choice!=0);
    }
}

    
    
