import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Main
{

    public static void main(String[] args)
    {
        createNewDir(".\\2UPresults");
        createNewFile(".\\2UPresults\\results.txt");
        welcomeWindow myFrame = new welcomeWindow();
    }

    // The method for my coinflip which generates a 1 or 2 randomly and assigns Heads to a 1
    // and a Tails to 2...
    public static String numberGen()
    {
        Random rdmNum1 = new Random();
        int number1 = rdmNum1.nextInt(1, 3);

        if(number1 == 1){
            System.out.println("Heads");
            return "Heads";
        }
        else {
            System.out.println("Tails");
            return "Tails";
        }
    }
    public static void createNewDir(String dirName)
    {
        try
        {
            File dir = new File(dirName);
            dir.mkdirs();
        }
        catch (Exception e)
        {
            System.out.println("Directory creation error.");
        }

    }

    //
    public static void createNewFile(String name)
    {
        try
        {
            File myFile = new File(name);
            //Check if file exists
            if(!myFile.exists()) {
                if (myFile.createNewFile()) {
                    System.out.println("File created: " + myFile.getName());
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("Ooooohhh... a bad error has occurred! Nasty!");
            e.printStackTrace();
        }
    }
}
