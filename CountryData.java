import java.util.*;
public class CountryData
{
    private String name;
    private int year;
    private int population;
    private int[] incomeDeciles;

    public CountryData(StudentData incomeData, String country, String year)
    {
        incomeDeciles = new int[12];
        int r = incomeData.getRow(country, year);
        // System.out.println("[DEBUG PRINT] r is " + r);
        String data[][] = incomeData.getFormattedData();
        // DEBUG CODE TO PRINT OUT 
        // for(String[] vars : data)
        // {
            // for(String a : vars)
            // {
                // System.out.print(a + " ");
            // }
            // System.out.println();
        // }
        
        // String name = data[r][0];
        
        for(int c = 2; c < 12; c++)
        {
            
            incomeDeciles[c] = Integer.parseInt(data[r][c]);
        }
        // for(int var : incomeDeciles)
            // System.out.print(var + " ");
        
    }
    
    public int totalIncome()
    {
        int total = 0;
        for(int c = 2; c < 12; c++)
        {
            total += incomeDeciles[c];
        }
         //System.out.println("[DEBUG] income is " + total + " vvvvv");
        return total;
    }
    public double giniIndex()
    {
        //System.out.println("vvvvv income decile printtage");
        //for(int var : incomeDeciles)
            //System.out.print(+ var + " ");
        
        double decSum = 0;
        double jibby = 0;
        for(int i = 2; i < incomeDeciles.length; i++)
        {
            int s = 0;
            for(int j = 2; j <= i; j++)
            {
                s += incomeDeciles[j];
                
                //DEBUG
                //System.out.println();
                //System.out.print(incomeDeciles[j] + " adaswa icnoedecile j is: " + j);
            }
            if(i != 2 && i != incomeDeciles.length - 1)
                decSum += s * 2;
            else
                decSum += s;
            
        }
        jibby = 1 - ((0.1/totalIncome()) * decSum);
        return jibby;
    }
}
