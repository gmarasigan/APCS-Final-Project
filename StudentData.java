import java.util.*;
import java.io.*;

public class StudentData {
  
  //private ArrayList<String> unformattedData ;
  ArrayList<String> unformattedData = new ArrayList<String>();
  private String[][] formattedData;
  private File fileName;
  
  public StudentData(String file) {
    try {
      fileName = new File(file); //opens the file to read
      Scanner scan = new Scanner(fileName); //instantiates a Scanner object that will read the file
      
      /* Initialize the ArrayList and read through the file, populating the  */
      while(scan.hasNextLine())
      {
        String str = scan.nextLine();
        str = str.replaceAll("\"", "");
        unformattedData.add(str);
      }
      /* populate unformattedData array with data from the table */
      /* use String method replaceAll(String replace, String replacement) to get rid double quotes */
      
      
      /* parse through the first row of unformattedData to determine the number of columns */
      String temp = unformattedData.get(0);
      int comma = 0;
      int col = 1;
      while(comma != -1)
      {
          comma = temp.indexOf(",");
          temp = temp.substring(comma + 1);
          col++;
      }
      
      
      /* initialize the formattedData array using rows and columns */
      formattedData = new String[unformattedData.size()][col];
      
      
      /* populate formattedData array with data from unformattedData */
      for(int r = 0; r < unformattedData.size(); r++)
      {
          String row = unformattedData.get(r);
          int i = temp.indexOf(",");
          for(int c = 0; c < col; c++)
          {
              int com = row.indexOf(",");
              if(com != -1)
              {
                  formattedData[r][c] = row.substring(0, com);
                  // System.out.println(formattedData[r][c]);
                  com++;
                  row = row.substring(com);
              }
          }
      }
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
  
  public String[][] getFormattedData() {
    return formattedData;
  }
  
  
  /* Returns the row containing the country and year. Returns -1 if not found. */
  public int getRow(String countryName, String year) {
     for(int i = 0; i < formattedData.length; i++)
     {
         // System.out.println("[i][0]" + formattedData[i][0]);
         // System.out.println("[i][1]" + formattedData[i][1]);
         if(formattedData[i][0].equals(countryName) && 
         formattedData[i][1].equals(year))
         {
           // System.out.println("vvvv getRow found the row");
            return i;
         }
     }
     //System.out.println("vvvv getRow did not find the row");
     return -1;
  }
} 
  