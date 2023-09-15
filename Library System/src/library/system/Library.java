
package library.system;
import java.util.ArrayList;
import java.util.Scanner;

public class Library{

    public static void main(String[] args) {
        Librarian librarian = new Librarian();
        
        ArrayList<Book> finalScientificlist = new ArrayList<>();
        ArrayList<Book> finalEntertainmentlist = new ArrayList<>();
        
        finalScientificlist.add(new Scientific("The First Three Minutes","English","Steven Weinberg",5,"Physics book",5,13,1,203));
        finalScientificlist.add(new Scientific("Taking on the Plastics Crisis","English","Hannah Testa",2,"Physics book",5,7,2,64));
        finalScientificlist.add(new Scientific("The Logic of Scientific Discovery","English","Karl Raimund",3,"Logic",5,15,3,500));
              
        finalEntertainmentlist.add(new Entertainment("Thirty one Day Mindfulness Challenge Cards","English","Month of Mindfulness",5,"challenges",3,14,5,100));
        finalEntertainmentlist.add(new Entertainment("In Just Cause Behind the Shadow","English","Noval Socram",3,"novel",3,15,7,35));
        
        ArrayList<Book> Scientificlist = new ArrayList<>();
        ArrayList<Book> Entertainmentlist = new ArrayList<>();
        
        Scientificlist.add(new Scientific("The First Three Minutes","English","Steven Weinberg",5,"Physics book",5,13,1,203));
        Scientificlist.add(new Scientific("Taking on the Plastics Crisis","English","Hannah Testa",2,"Physics book",5,7,2,64));
        Scientificlist.add(new Scientific("The Logic of Scientific Discovery","English","Karl Raimund",3,"Logic",5,15,3,500));
              
        Entertainmentlist.add(new Entertainment("Thirty one Day Mindfulness Challenge Cards","English","Month of Mindfulness",5,"challenges",3,14,5,100));
        Entertainmentlist.add(new Entertainment("In Just Cause Behind the Shadow","English","Noval Socram",3,"novel",3,15,7,35));
        
        Scanner input = new Scanner(System.in);
                
        int choice = 1;
        int numofuser=0;
        
        System.out.println("**************Welcome To library system**************");
        
        do{
            System.out.println("Enter 1 for adminstration system,\nEnter 2 for librarian system,\nEnter 3 for Member system,\nEnter 0 to Exit.");
            System.out.println("================================");
            System.out.print("Your Choice is: ");
            choice = input.nextInt();
            
            System.out.println();
            
            switch(choice){
                
                case 0:
                    System.out.println("The number of user that used the library system is:" + numofuser);
                    System.exit(0);

                case 1:
                    Administration admin = new Administration(); 
                    admin.isAdministrator(librarian);
                    numofuser++;
                    break;
                    
                case 2:
                    boolean islib = librarian.isLibrarians();
                    if (islib==true){
                        librarian.librarinTask(Scientificlist, Entertainmentlist,finalScientificlist,finalEntertainmentlist);
                        numofuser++;
                    }
                    else{
                        System.out.println("You are not a librarian!");
                        System.out.println();
                    }      
                    break;
                    
                    case 3:
                        
                        Member member = new Member();
                        
                        int choice2=0;
                        boolean isMem = false;
                        
                        System.out.println("\nEnter 1 if you are a new member.\nEnter 2 if you are an existing member\nEnter 0 to Exit.");
                        System.out.println("-----------------------------"); 
                        System.out.print("\nyour choice is: "); 
                        choice2 = input.nextInt();
                        
                        switch(choice2){
                            case 0:
                                break;
                            
                            case 1:
                                member.newMember();
                                
                                isMem = member.isMember();
                                
                                if (isMem==true){
                                    member.memberTask(Scientificlist, Entertainmentlist,finalScientificlist,finalEntertainmentlist);
                                }
                                else{
                                    System.out.println("You are not a Member!");
                                    System.out.println();
                                }
                                
                                break;
                                                              
                            case 2:
                                isMem = member.isMember();
                                
                                if (isMem==true){
                                    member.memberTask(Scientificlist, Entertainmentlist,finalScientificlist,finalEntertainmentlist);
                                    numofuser++;
                                }
                                else{
                                    System.out.println("You are not a Member!");
                                    System.out.println();
                                }
                                break;
                                                              
                            default:
                                System.out.println("Your input is invalid!");
                                break;    
                        }
                        
                        break;
                    
                default:
                    break; 
            }
        }while(choice!=4);
    }
}
