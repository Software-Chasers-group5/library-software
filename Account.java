import java.util.*;
import java.io.*;
public class Account{
    public void Register(){
        //////////CASE 1
      /**Case 1 is the code for registering to the LMS.
       * Where every member need to enter the username, Roll number,you need to put the password. */			
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter user name");
        String userName=sc.nextLine();
        System.out.println("Enter Rollno");
        String rollno=sc.nextLine();
        System.out.println("Enter password");
        String password=sc.nextLine();
        System.out.println("REMEMBER!!!!!");
        System.out.println("YOUR MEMBERSHIP ID IS LAST 2 DIGITS OF YOUR ROLL NUMBER");
        System.out.println("YOUR MEMBERSHIP ID IS LAST 2 DIGITS OF YOUR ROLL NUMBER");
        System.out.println("Enter your Membership id");
        String memberShipid=sc.nextLine();
        String filepath="ap.csv";
        try{
          /**Here we used some classes of input and output stream.
           * To enter the data to the csv file.
           * We used Classes like FileWriter, BufferedWriter, PrintWriter.
           */
          FileWriter fw = new FileWriter(filepath,true);
          BufferedWriter bw=new BufferedWriter(fw);
          PrintWriter pw=new PrintWriter(bw);
          pw.println(userName+","+rollno+","+memberShipid+","+password+","+"\n");
          pw.flush();
          pw.close();
          System.out.println("Registration successfull");
        }
        catch(Exception E){
          System.out.println(E);
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();			
    }
    public boolean Login(){
        /**Case 2 is for login
         * The registered member can get access to login the software.
         * If registration is successfull then member can issue a book or Return a book that is already issued.
         */
        Scanner j=new Scanner(System.in);
        System.out.println("Enter membership id");
        String memberShipid=j.nextLine();
        System.out.println("Enter password");
        String password=j.nextLine();
        String filepath="ap.csv";
        try{
          /**Here we used x variable for creating object to the Scanner class. */
          Scanner x;
          boolean flag=false;
          x=new Scanner(new File(filepath));
          x.useDelimiter("[,\n]");
          while(x.hasNext()){
            String userName=x.next();
            System.out.println(userName);
            String Rollno=x.next();
            String membership=x.next();
            String password1=x.next(); 
            System.out.println(password1);   
            if(membership.equals(memberShipid)&&password1.equals(password)){
              return true;
            }
            
          }
        }
    
       catch(Exception e){
           System.out.println("Execption caught");
       }
       return false;
}
      public void Feedback(){
        /**code for giving feedback by the member. */
        // we use the Scanner class to take the input i.e name of the book.
        Scanner n=new Scanner(System.in);
        System.out.println("Enter the StudentId:");
        String studentId=n.nextLine();
        //Scanner s=new Scanner(System.in);
        System.out.println("enter your feedback:");
        String feedback=n.nextLine();
        try {
            //creating an object for File class.
          File f1 = new File("FeedBack.txt");
          if(!f1.exists()) {
            f1.createNewFile();
          }
         //we use the file writer class to get the name.
          FileWriter fileWritter = new FileWriter(f1.getName(),true);
          BufferedWriter bw = new BufferedWriter(fileWritter);
          //bw.write("\n");
          bw.write(studentId+" "+":"+" "+feedback+"\n");
          bw.close();
          //System.out.println("Done");
        } 
        catch(IOException e){
           e.printStackTrace();
        } 
       /**   File file = new File("RecommendedBooks.txt");
        Scanner c = new Scanner(file);
 
        // we just need to use \\Z as delimiter
         c.useDelimiter("\\z");
   
         System.out.println(c.next()); **/
      }
}
