
package library.system;

public class Administrators{
    
    private String name;
    private int age;
    private String phoneNum;
    private String userName;
    
    public Administrators(String name, int age, String phoneNumber, String username){
        this.name = name;
        this.age = age;
        this.phoneNum = phoneNumber;
        this.userName = username;
    }
    
    public String getName(){
        return name;
    }
    
    public String getphoneNumber(){
        return phoneNum;
    }
    
    public String getUsername(){
        return userName;
    }
    
    public int getAge(){
        return age;
    }
}
