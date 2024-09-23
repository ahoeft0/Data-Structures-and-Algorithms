//Import classes
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;  
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Ashton Hoeft
 * @version 3/1/2023
 * 
 * This class declares the method to convert the information from a csv file into an html file
 */
public class CSVConversion {
    /**
     * 
     * @param csv .csv file to convert
     * @param html .html file to inset information from csv into
     * @throws FileNotFoundException
     * @throws IOException 
     * 
     * This program stores the information from csv and inserts it into html
     */
    public static void infoInserter(File csv, File html) throws FileNotFoundException, IOException {
        //Check how many lines of information are in csv
        Scanner countScan = new Scanner(csv);
        int i = 0;
        while (countScan.hasNextLine()) {
            countScan.nextLine();
            i++;
        }
        
        //Declare Scanner and two-dimensional array to store information
        Scanner infoScan = new Scanner(csv);
        String[][] allInfo = new String[i][4];
        
        //Store all information from csv
        for (int j = 0; j < allInfo.length; j++) {
            //Declare variables to use to find information
            String info = infoScan.nextLine();
            String[] infoArray = info.split(",");
            String[] dateArray = infoArray[0].split("/");

            //Declare variables for information
            int issueDateList = Integer.parseInt(dateArray[0]) + (Integer.parseInt(dateArray[2]) * 12) - 23296;
            int denominationList = Integer.parseInt(infoArray[1]);
            String seriesList = "";
            
            //Create a DecimalFormat variable
            DecimalFormat df = new DecimalFormat();
            df.setMinimumFractionDigits(2);

            //Check what type of bond it is and store information as defined by bond type
            if (infoArray[2].contains("I")) {
                seriesList = "I";
            } else if (infoArray[2].contains("EE")) {
                seriesList = "EE";
            } else if (infoArray[2].contains("E")) {
                seriesList = "E";
            }
            
            //Store information in the two-dimesnional array
            allInfo[j][0] = "Bond" + (j + 1);
            allInfo[j][1] = "" + issueDateList;
            allInfo[j][2] = "" + denominationList;
            allInfo[j][3] = seriesList;

        }
        //Create the updated website and make it able to be appended
        File newFile = new File("updatedSite.html");
        newFile.createNewFile();
        FileOutputStream stream = new FileOutputStream(newFile, true);
        PrintWriter writer = new PrintWriter(stream);

        //Declare variables to make updated website
        Scanner scan = new Scanner(html);
        String line;
        String temp;
        String[] tempArray;
          
        //Create updated website
        while (scan.hasNextLine()) {
            //Add the parts of the website that don't include the new information
            line = scan.nextLine();
            if (!line.contains("<input type=\"hidden\" name=\"SerialNumList\"")) {
                writer.write(line + "\n");
            }
            //Add the parts of the website with updated information
            else {
                //Add the SerialNum of new bonds
                tempArray = line.split("value=\"");
                temp = tempArray[0] + "value=\"";
                for (int j = 0; j < allInfo.length; j++) {
                    temp += allInfo[j][0] + ";";
                }
                temp += tempArray[1] + "\n";
                writer.write(temp);

                //Add the IssueDate of new bonds
                line = scan.nextLine();
                tempArray = line.split("value=\"");
                temp = tempArray[0] + "value=\"";
                for (int j = 0; j < allInfo.length; j++) {
                    temp += allInfo[j][1] + ";";
                }
                temp += tempArray[1] + "\n";
                writer.write(temp);

                //Add the Series of new bonds
                line = scan.nextLine();
                tempArray = line.split("value=\"");
                temp = tempArray[0] + "value=\"";
                for (int j = 0; j < allInfo.length; j++) {
                    temp += allInfo[j][3] + ";";
                }
                temp += tempArray[1] + "\n";
                writer.write(temp);

                //Add the Denomination of new bonds 
                line = scan.nextLine();
                tempArray = line.split("value=\"");
                temp = tempArray[0] + "value=\"";
                for (int j = 0; j < allInfo.length; j++) {
                    temp += allInfo[j][2] + ";";
                }
                temp += tempArray[1] + "\n";
                writer.write(temp);

                //Add the IssuePrice of new bonds
                line = scan.nextLine();
                tempArray = line.split("value=\"");
                temp = tempArray[0] + "value=\"";
                for (int j = 0; j < allInfo.length; j++) {
                    temp += "0;";
                }
                temp += tempArray[1] + "\n";
                writer.write(temp);

                //Add the Interest of new bonds
                line = scan.nextLine();
                tempArray = line.split("value=\"");
                temp = tempArray[0] + "value=\"";
                for (int j = 0; j < allInfo.length; j++) {
                    temp += "0.00;";
                }
                temp += tempArray[1] + "\n";
                writer.write(temp);

                //Add the YTDInterest of new bonds
                line = scan.nextLine();
                tempArray = line.split("value=\"");
                temp = tempArray[0] + "value=\"";
                for (int j = 0; j < allInfo.length; j++) {
                    temp += "0.00;";
                }
                temp += tempArray[1] + "\n";
                writer.write(temp);

                //Add the Value of new bonds
                line = scan.nextLine();
                tempArray = line.split("value=\"");
                temp = tempArray[0] + "value=\"";
                for (int j = 0; j < allInfo.length; j++) {
                    temp +=  "0.00;";
                }
                temp += tempArray[1] + "\n";
                writer.write(temp);

                //Add the InterestRate of new bonds
                line = scan.nextLine();
                tempArray = line.split("value=\"");
                temp = tempArray[0] + "value=\"";
                for (int j = 0; j < allInfo.length; j++) {
                    temp += "0.00;";
                }
                temp += tempArray[1] + "\n";
                writer.write(temp);

                //Add the NextAccrualDate of new bonds
                line = scan.nextLine();
                tempArray = line.split("value=\"");
                temp = tempArray[0] + "value=\"";
                for (int j = 0; j < allInfo.length; j++) {
                    temp += "0;";
                }
                temp += tempArray[1] + "\n";
                writer.write(temp);

                //Add the MaturityDate of new bonds
                line = scan.nextLine();
                tempArray = line.split("value=\"");
                temp = tempArray[0] + "value=\"";
                for (int j = 0; j < allInfo.length; j++) {
                    temp += "0;";
                }
                temp += tempArray[1] + "\n";
                writer.write(temp);

                //Add the Note of new bonds
                line = scan.nextLine();
                tempArray = line.split("value=\"");
                temp = tempArray[0] + "value=\"";
                for (int j = 0; j < allInfo.length; j++) {
                    temp += "0;";
                }
                temp += tempArray[1] + "\n";
                writer.write(temp);
            }
        }

        //Close writer and stream
        writer.close();
        stream.close();
    }
}