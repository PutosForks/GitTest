
package classdesign.gupta.protectedexample.building;

import classdesign.gupta.protectedexample.library.Book;


public class StoryBook extends Book{
    
    StoryBook () {
        Book b = new Book();
        // b.author = "Steven";  -- won't work
        
        
        author = "Steven";     
    }
    
    
    
}
