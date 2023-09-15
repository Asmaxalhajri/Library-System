
package library.system;

public class Scientific extends Book {
    
    Scientific (String title ,String language, String aurhor,  int numberOfcopy, String bookType, double price, int allowedAge,int bookId,int numberOfPages){
        this.title = title;
        this.aurhor = aurhor;
        this.numberOfcopy = numberOfcopy;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.language = language;
        this.bookType = bookType;
        this.bookId = bookId;
        this.allowedAge = allowedAge;
        numberOfBooks++;
    }   
}
