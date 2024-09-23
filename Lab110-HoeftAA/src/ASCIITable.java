/**
 *
 * @author Ashton Hoeft
 * @version 4/25/2023
 * 
 * This class allows for the creation of a table using data inputted by the user
 */
public class ASCIITable {
     /**
     * Make an ASCII Table using data from the tests
     *
     * @param array the data to put into the ASCII Table
     * @param titleName the title to put at the top of the table (Value is not used if title = false)
     * @param title boolean value, if to insert a title or not
     * @param centerAlignedColumnLabels boolean value, if to center align column labels or not
     * @param leftAlignedRowLabels boolean value, if to left align row labels or not
     */
    public static void printTableDynamic_v3(String [][] array, String titleName, boolean title, boolean centerAlignedColumnLabels, boolean leftAlignedRowLabels) {
        //Determine column widths
        int maxLength[] = new int[array[0].length];
        for(int i = 0; i < maxLength.length; i++) {
            for(int j = 0; j < array.length; j++) {
                if(array[j][i].length() > maxLength[i])
                    maxLength[i] = array[j][i].length();
            }
        }
        
        //Create divider line
        String divider = "+";
        for(int i = 0; i < maxLength.length; i++) {
            for(int j = 0; j < maxLength[i] + 4; j++) {
                divider += "-";
            }
            divider += "+";
        }
        divider += "\n";
        
        //Check if the client wants a title or not
        if(title) {
            //Create title divider line
            String titleDivider = "+";
            for(int i = 0; i < maxLength.length; i++) {
                for(int j = 0; j < maxLength[i] + 4; j++) {
                    titleDivider += "-";
                }
            }
            for(int i = 0; i < maxLength.length - 1; i++) {
                    titleDivider += "-";
                }
            titleDivider += "+\n";
        
            //Print out title divider at the top of table
            System.out.print(titleDivider);
            
            //Calculate number of spaces to print in title line
            int max = 0;
            for(int i = 0; i < maxLength.length; i++) {
                max += maxLength[i] + 4;
            }
            max += maxLength.length - 1;
            max = max - titleName.length();
            
            //Create and print center aligned title
            String titleLine = "|";
            //Check if max is odd and create title line with an extra space
            if(max % 2 != 0) {
                titleLine += " ";
                for(int i = 0; i < max / 2; i++) {
                    titleLine += " ";
                }
                titleLine += title;
                for(int i = 0; i < max / 2; i++) {
                    titleLine += " ";
                }
                titleLine += "|";
            }
            //Otherwise it is odd and create title line with no extra space
            else {
                for(int i = 0; i < max / 2; i++) {
                    titleLine += " ";
                }
                titleLine += titleName;
                for(int i = 0; i < max / 2; i++) {
                    titleLine += " ";
                }
                titleLine += "|";
            }
            //Print out title line
            System.out.println(titleLine);
        }
        
        
        //Print out table
        System.out.print(divider);
        String columnLabel = "";
        for (String[] subArray : array) {
            for(int j = 0; j < maxLength.length; j++ ) {
                //If user wants center aligned column labels, concatenate the line for it
                if(centerAlignedColumnLabels) {
                    //Calculate number of spaces to print
                    int max = 0;
                    max = maxLength[j] + 4 - subArray[j].length();
                    
                    //Check if max is odd and create column label with an extra space
                    if(max % 2 != 0) {
                        columnLabel += "| ";
                        for(int i = 0; i < max / 2; i++) {
                            columnLabel += " ";
                        }
                        columnLabel += subArray[j];
                        for(int i = 0; i < max / 2; i++) {
                            columnLabel += " ";
                        }
                    }
                    //Otherwise it is odd and create column label with no extra space
                    else {
                        columnLabel += "|";
                        for(int i = 0; i < max / 2; i++) {
                            columnLabel += " ";
                        }
                        columnLabel += subArray[j];
                        for(int i = 0; i < max / 2; i++) {
                            columnLabel += " ";
                        }
                    }
                }
                //Print not centered column values
                else {
                    //If user wants left aligned row labels, print them
                    if(leftAlignedRowLabels && j == 0) {
                        //Print part of row that is left aligned
                        String format = "|  %-" + maxLength[j] + "s  ";
                        System.out.printf(format, subArray[j]);
                    }
                    //Print the right aligned values of each row
                    else {
                        //Print part(s) of row that is right aligned
                        String format = "|  %" + maxLength[j] + "s  ";
                        System.out.printf(format, subArray[j]);
                    }
                }
            }
            
            //If the user wants center aligned column labels, print them
            if(centerAlignedColumnLabels) {
                System.out.print(columnLabel);
            }
            //Ensure the other rows are not center aligned
            centerAlignedColumnLabels = false;
            
            //Print new line
            System.out.printf("|\n");
            
            //Print divider line
            System.out.printf(divider);
        }
    }
}
