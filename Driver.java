public class Driver
{
    public static void main(String[] args)
    {
        StudentData file = new StudentData("RawIncomeData.csv");

        CountryData jp = new CountryData(file, "Japan", "2014");
        CountryData us = new CountryData(file, "United States", "2000");
        CountryData no = new CountryData(file, "Norway", "2010");
        
        System.out.println("Japan’s Gini index in 2014 was " + jp.giniIndex());
        System.out.println("United States’ Gini Index in 2000 was " + us.giniIndex());
        System.out.println("Norway’s Gini Index in 2010 was " + no.giniIndex());

        // debug
        // System.out.println(file.getFormattedData()[2280][1]);
    }
}
