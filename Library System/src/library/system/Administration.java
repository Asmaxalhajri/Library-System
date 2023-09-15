
package library.system;
import java.util.Scanner;

public class Administration{
    Scanner input = new Scanner(System.in);
    
    String adminLibID;
    Administrators [] administrator = new Administrators[2];
    
    final String adminUsername [] = {"Lama", "Asma"};
    final String adminPassword [] = {"Lama123", "Asma123"};
    
    Administration(){
        administrator[0] = new Administrators ("Lama ", 20, "+966535557677", "Lama");
        administrator[1] = new Administrators ("Asma ", 20, "+966515559422", "Asma");
    }
    
    void isAdministrator(Librarian librarian){

        int Continue = 1;
        
        do{
            Scanner input = new Scanner(System.in);

            System.out.print("Enter your Username: ");
            String username = input.next();

            System.out.print("Enter your Password: ");
            String password = input.next();

            do{
                if (isAdministrator(username, password)){
                    System.out.println("\n\t**Welcome To Administrator System**\n");
                    
                    int AdminContinue = 1;
                    
                    do{
                        System.out.println("\tEnter 1 to View Administrators,\n\tEnter 2 to Hire a Librarian,\n\tEnter 3 to Fire a Librarian,\n\tEnter 4 to View All Librarians,\n\tEnter 0 to Exit Administration System.\n");
                        System.out.print("\tYour Choice is: ");
                        int AdminChoice = input.nextInt();
                        System.out.println();
                        
                        switch(AdminChoice){
                            case 0:
                                AdminContinue = 0;
                                Continue = 0;
                                break;
                            case 1:
                                viewAdministrator();
                                break; 
                            case 2:
                                hiring(librarian);
                                break;   
                            case 3:
                                firing(librarian);
                                break;
                            case 4:
                                viewLibrarian(librarian);
                                break; 
                            
                        }
                    }while(AdminContinue!=0);
                }
                else{
                    System.out.print("\nEnter 1 to re-enter your informaion or 0 to Exit: ");
                    Continue = input.nextInt();
                    System.out.println("");
                    break;
                }

            }while(Continue!=0);
        }while(Continue!=0);
    }
 
    
    boolean isAdministrator(String username , String password ){
        
        for(int i=0;i<adminUsername.length;i++){    
            if(adminUsername[i].equals(username)){
                if(adminPassword[i].equals(password)){
                    return true;
                }
                else{
                    System.out.println("The password of the username is wrong!");
                    return false;
                }
            }
            else{
                System.out.println("There is no administrator with this username!");
                return false;
            }
        }
        return false;
    }   
    
    void viewAdministrator(){
        for(int i=0; i< administrator.length; i++){
            System.out.println("\tAdministrator " + (i+1) + ": ");
            System.out.println("\tAdministrator Name: " + administrator[i].getName());
            System.out.println("\tAdministrator Age: " + administrator[i].getAge());
            System.out.println("\tAdministrator Phone Number: " + administrator[i].getphoneNumber());
            System.out.println("\tAdministrator Username: " + administrator[i].getUsername());
            System.out.println();
        }
    }
    
    void hiring(Librarian librarian){
        librarian.addLibrarian();
    }
    
    void firing(Librarian librarian){

        System.out.print("\tEnter The Librarian ID: ");
        String libID = input.next();
        
        this.adminLibID = libID;
        
        librarian.deleteLibrarian(adminLibID);
    }
    
    void viewLibrarian(Librarian librarian){
        librarian.viewLibrarian(); 
    }
}