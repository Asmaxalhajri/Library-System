
package library.system;
import java.util.List;
import java.util.Scanner;

public class Person {  
    Scanner input=new Scanner(System.in);
    
    String userName;
    String password;
    String phoneNum;
    String id;
    int age;
    
    Person(){}
    
    Person(String username , String password, String phonenum, String id, int age){
       this.userName = username;
       this.password = password;
       this.phoneNum = phonenum;
       this.id = id;
       this.age = age;
    }
    
    public void searchBook(List <Book> Scientificlist , List <Book> Entertainmentlist){
        int choice;
        String name;
        
        do{
            input.nextLine();
            System.out.println("\n\tEnter \n\t1-Search Scientific Book.\n\t2-Search Entertainment Book.\n\t0-Exit from search book");
            System.out.println("\t-----------------------------");
            System.out.print("\tYour Choice is: ");
            choice=input.nextInt();
          
            int index=0;
            boolean value=false;
            switch(choice){
               
               case 0:
                   break;
                   
               case 1:
                    input.nextLine();
                    System.out.print("\tEnter book title that you are looking for :");
                    name=input.nextLine();
                    for(int i=0 ;i<Scientificlist.size();i++){
                        if(name.equals(Scientificlist.get(i).title)){
                            index=i;
                            value=true;
                           }
                    }
                    
                    if (value==true){
                        System.out.println("\n\t------------"+"Scientific Book Number "+(index+1)+"------------");
                        System.out.println("\tBook tiltle :"+Scientificlist.get(index).title+"\n\tBook language: "+Scientificlist.get(index).language+"\n\tBook aurhor :"+Scientificlist.get(index).aurhor+"\n\tnumber of copy for the book:"+Scientificlist.get(index).numberOfcopy+"\n\tBook Type:"+Scientificlist.get(index).bookType+"\n\tBook price:"+Scientificlist.get(index).price +"\n\tBook allowed Age:"+Scientificlist.get(index).allowedAge+"\n\tBook Id:"+Scientificlist.get(index).bookId+"\n\tNumber of pages in the book :"+Scientificlist.get(index).numberOfPages);
                    }
                    
                    else{
                        System.out.println("\tThere is no book with this name !!");  
                    }
                   break;
                   
                case 2:
                    input.nextLine();
                    System.out.print("\tEnter book title that you are looking for :");
                    name=input.nextLine();
                    for(int i=0 ;i<Entertainmentlist.size();i++){
                        if(name.equals(Entertainmentlist.get(i).title)){
                            index=i;
                            value=true;
                        }
                    }
                    
                    if (value==true){
                        System.out.println("\n\t------------"+"Entertainment Book Number "+(index+1)+"------------");
                        System.out.println("\tBook tiltle :"+Entertainmentlist.get(index).title+"\n\tBook language: "+Entertainmentlist.get(index).language+"\n\tBook aurhor :"+Entertainmentlist.get(index).aurhor+"\n\tnumber of copy for the book:"+Entertainmentlist.get(index).numberOfcopy+"\n\tBook Type:"+Entertainmentlist.get(index).bookType+"\n\tBook price:"+Entertainmentlist.get(index).price +"\n\tBook allowed Age:"+Entertainmentlist.get(index).allowedAge+"\n\tBook Id:"+Entertainmentlist.get(index).bookId+"\n\tNumber of pages in the book :"+Entertainmentlist.get(index).numberOfPages);
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
   
    public void viewBook(List <Book> Scientificlist , List <Book> Entertainmentlist){

        int check = 0;
        
        do{
            System.out.println("\n\tEnter\n\t1-view Scientific Books.\n\t2-view Entertainment Books.\n\t3-view All Books.\n\t0-To Exit from veiw book.");
            System.out.println("\t-----------------------------");
            System.out.print("\tYour Choice is: ");
            int num = input.nextInt();

            switch(num){
                
                case 0:
                    System.out.println("\tYou have exited the view");
                    check=1;
                    break;
                
                case 1: 
                    System.out.println("\t________________Scientific Book List_______________");
                    System.out.println("\n\t   ***The number of Scientific Books is: " + Scientificlist.size());
                    
                    System.out.println();
                    
                    for(int i=0; i<Scientificlist.size();i++){
                        System.out.println("\t------------"+"Scientific Book Number "+(i+1)+"------------");
                        System.out.println("\tBook tiltle: "+Scientificlist.get(i).title+"\n\tBook language: "+Scientificlist.get(i).language+"\n\tBook aurhor: " +Scientificlist.get(i).aurhor+"\n\tnumber of copy for the book: "+Scientificlist.get(i).numberOfcopy+"\n\tBook Type: "+Scientificlist.get(i).bookType+"\n\tBook price: "+Scientificlist.get(i).price +"\n\tBook allowed Age: "+Scientificlist.get(i).allowedAge+"\n\tBook Id: "+Scientificlist.get(i).bookId+"\n\tNumber of pages in the book: "+Scientificlist.get(i).numberOfPages);
                    }
                    break;

                case 2:
                    System.out.println("\t_______________Entertainment Book List_______________");
                    System.out.println("\n\t   ***The number of Entertainment Books is: " + Entertainmentlist.size());
                    
                    System.out.println();
                    
                    for(int i=0; i<Entertainmentlist.size();i++){
                        System.out.println("\t------------"+"Entertainment Book Number "+(i+1)+"------------");
                        System.out.println("\tBook tiltle: "+Entertainmentlist.get(i).title+"\n\tBook language: "+Entertainmentlist.get(i).language+"\n\tBook aurhor: "+Entertainmentlist.get(i).aurhor+"\n\tnumber of copy for the book: "+Entertainmentlist.get(i).numberOfcopy+"\n\tBook Type: "+Entertainmentlist.get(i).bookType+"\n\tBook price: "+Entertainmentlist.get(i).price +"\n\tBook allowed Age: "+Entertainmentlist.get(i).allowedAge+"\n\tBook Id: "+Entertainmentlist.get(i).bookId+"\n\tNumber of pages in the book: "+Entertainmentlist.get(i).numberOfPages);
                    }
                    break;
                                   
                case 3:
                    System.out.println("\t________________Scientific Book List_______________");
                    System.out.println("\n\t   ***The number of Scientific Books is: " + Scientificlist.size());
                    
                    System.out.println();
                    
                    for(int i=0; i<Scientificlist.size();i++){
                        System.out.println("\t------------"+"Scientific Book Number "+(i+1)+"------------");
                        System.out.println("\tBook tiltle: "+Scientificlist.get(i).title+"\n\tBook language: "+Scientificlist.get(i).language+"\n\tBook aurhor: " +Scientificlist.get(i).aurhor+"\n\tnumber of copy for the book: "+Scientificlist.get(i).numberOfcopy+"\n\tBook Type: "+Scientificlist.get(i).bookType+"\n\tBook price: "+Scientificlist.get(i).price +"\n\tBook allowed Age: "+Scientificlist.get(i).allowedAge+"\n\tBook Id: "+Scientificlist.get(i).bookId+"\n\tNumber of pages in the book: "+Scientificlist.get(i).numberOfPages);
                    }
                    
                    System.out.println();
                    
                    System.out.println("\t_______________Entertainment Book List_______________");
                    System.out.println("\n\t   ***The number of Entertainment Books is: " + Entertainmentlist.size());
                    
                    System.out.println();
                    
                    for(int i=0; i<Entertainmentlist.size();i++){
                        System.out.println("\t------------"+"Entertainment Book Number "+(i+1)+"------------");
                        System.out.println("\tBook tiltle: "+Entertainmentlist.get(i).title+"\n\tBook language: "+Entertainmentlist.get(i).language+"\n\tBook aurhor: "+Entertainmentlist.get(i).aurhor+"\n\tnumber of copy for the book: "+Entertainmentlist.get(i).numberOfcopy+"\n\tBook Type: "+Entertainmentlist.get(i).bookType+"\n\tBook price: "+Entertainmentlist.get(i).price +"\n\tBook allowed Age: "+Entertainmentlist.get(i).allowedAge+"\n\tBook Id: "+Entertainmentlist.get(i).bookId+"\n\tNumber of pages in the book: "+Entertainmentlist.get(i).numberOfPages);
                    }
                    break;

                default: System.out.println("\tWrong value!");
            }
            
        }while(check==0);
    }
    
}

