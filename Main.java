package pkg12f4567_client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) 
    {
        mainClient p=new mainClient();
        p.start();
    }
}
class mainClient extends Thread
{
    @Override
    public void run()
    {
        Scanner sc=new Scanner(System.in);
        try
        {
            Socket st=new Socket("localhost",4579);
            
            System.out.println("Enter ID");
            int id=sc.nextInt();
           
            //send
            DataOutputStream ds=new DataOutputStream(st.getOutputStream());
            ds.writeInt(id);
            System.out.println("The ID sent to the client="+id);
            ds.flush();
                        
            //receive
            DataInputStream dis=new DataInputStream(st.getInputStream());
            double mValues=dis.readDouble();
            
            //dispaly
            System.out.println("The Monetroy Values is ="+mValues);
           
         
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}


