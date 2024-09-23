//Import classes
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Ashton Hoeft
 * @version 3/1/2023
 * 
 * This Client converts the information about bonds in a csv file and inserts the information
 * into an html website that tracks bonds.
 */
public class Client {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Declare csv file to get information on bonds from and html file to use as a default template for the conversion
        final File html = new File("SavingsBonds-0-Bonds-Entered.html");
        final File csv = new File("SavingsBonds.csv");
        
        //Delete any current file that has the same name as the updated website will have
        File updated = new File("updatedSite.html");
        updated.delete();
       
        //Convert the information by calling infoInserter
        CSVConversion.infoInserter(csv, html);
    }
}