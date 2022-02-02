import java.util.*;  //importing java.util package
import java.io.*; //importing java.
import java.text.*;  //import the java.util package
public class Main1
{
   ////////Main method starting
   public static void register()
   {
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
        try
        {
            FileWriter fw = new FileWriter(filepath,true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            pw.println(userName+","+rollno+","+memberShipid+","+password+","+"\n");
            pw.flush();
            pw.close();
            System.out.println("Registration successfull");
        }
        catch(Exception E)
        {
            System.out.println(E);
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void login()
    {
        String filepath="ap.csv";
        Scanner j=new Scanner(System.in);
        System.out.println("Enter membership id");
        String memberShipid=j.nextLine();
        System.out.println("Enter password");
        String password=j.nextLine();
        filepath="ap.csv";
        try
        {
            Scanner x;
            boolean flag=false;
            x=new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");
            while(x.hasNext())
            {
                String userName=x.nextLine();
                //System.out.println(userName);
                String Rollno=x.nextLine();
                //System.out.println(Rollno);
                String membership=x.nextLine();
                String password1=x.nextLine();    
                if(membership.equals(memberShipid))
                {
                  flag=true;
                  break;
                }
            }
            if(flag)
            {
                System.out.println("***SUBMENU***");
                System.out.println("1.ISSUE");
                System.out.println("2.RETURN");
                Scanner scan=new Scanner(System.in);
                int choice = Integer.parseInt(scan.nextLine());
                //ex.printStackTrace();
                switch(choice)
                {
                    case 1:
                    HashMap<String, Integer> hm=new HashMap<String, Integer>();
                    /**m hashmap stores the student id with date of issue */
                    HashMap<String, String> m=new HashMap<String, String>();
                    /** d hasmap stores the bookname and no.of book present */
                    HashMap<String, Integer> d=new HashMap<String, Integer>();
                    hm.put("O7",1);
                    hm.put("O6",1);
                    hm.put("M8",2);
                    hm.put("N1",2);
                    d.put("c",6);
                    d.put("python",5);
                    d.put("Java",6);
                    d.put("SE",10);
                    System.out.println("Enter Student Id,bookName");
                    Scanner c = new Scanner(System.in);
                    String studentId = c.nextLine();
                    Scanner c1 = new Scanner(System.in);
                    String bookName = c1.nextLine();
                    /** it gives the date */
                    String pattern = "MM-dd-yyyy";
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                    String date = simpleDateFormat.format(new Date());
                    //System.out.println(date);
                    //it checks whether thestudent id is present in hashmap hm.
                    if(hm.containsKey(studentId))
                    {
                        int a=hm.get(studentId);
                        if(a<2)
                        {
                            System.out.println("you are eligible to issue");
                            int p=d.get(bookName);
                            if(p>0)
                            {
                                m.put(studentId,date);
                                d.put(bookName,++p);
                                hm.put(studentId,++a);
                                System.out.println("Issue Successful");
                            }
                            else
                                System.out.println("not possible");
                        }
                        else
                            System.out.println("you are not eligible since no.of book issued are already 2");
                    }
                    else
                    {
                      System.out.println("Invalid StudentId");
                    }
                    break;
                    case 2:
                        System.out.println("code in progress");
                }
            }
            else
                System.out.println("Login unsuccessful");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void search()
    {
        System.out.println("1 Search by Booktitle\n");
        System.out.println("2 Search by Author\n");
        System.out.println("3 Search by publisher\n");
        System.out.println("Press any key to EXIT\n");
        System.out.println("Enter your choice: ");
        Scanner b=new Scanner(System.in);
        int choice=b.nextInt();
        switch(choice)
        {
            case 1:
                boolean f1=false;
                System.out.println("Enter Book name:");
                Scanner o=new Scanner(System.in);
                String bookName=o.nextLine();
                String bt1[]={"S","java","python","c"};
                for(int i=0;i<bt1.length;i++)
                {
                  //String f=bt1[i];
                    if(bookName.equals(bt1[i]))
                    {
                        f1=true;
                    }                  
                }
                if(f1)
                {
                    System.out.println("Found");
                }
                else
                    System.out.println("not found");
                break;
            case 2:
             /** case2 is searching a book by author.*/
                System.out.println("Enter the name of the author");
                Scanner s=new Scanner(System.in);
                Scanner u=new Scanner(System.in);
                String bookAuthor=u.nextLine();
                String auth[]={"James Gosling","Roger s Pressmen","Dennis Ritche","Guido Van Rossum","stephen Wolfram","Brendan Eich"};
                for(int k=0;k<auth.length;k++)
                {
                    if(bookAuthor.equals(auth[k]))
                        System.out.println("Found ");
                }
                break;
            case 3:
            /**Case3 is searching a book by publisher. */
                System.out.println("Enter the name of the publisher:");
                Scanner v=new Scanner(System.in);
                String bookPublisher=v.nextLine();
                String pubr[]={"The Pragmatic Bookshelf","CENGAGE","Manning publications","Peachpit","No Starch Press","Que","LeanPub"};
                for(int m=0;m<pubr.length;m++)
                {
                    if(bookPublisher.equals(pubr[m]))
                        System.out.println("Found");
                }
                break;
        }
    }
    public static void recommend()
    {
        Scanner z=new Scanner(System.in);
        System.out.println("Enter the name of the book that you recommended:\n");
        String s=z.nextLine();
        try 
        {
          //creating an object for File class.
            File f1 = new File("RecommendedBooks.txt");
            if(!f1.exists()) 
            {
                f1.createNewFile();
            }
            //we use the file writer class to get the name.
            FileWriter fileWritter = new FileWriter(f1.getName(),true);
            BufferedWriter bw = new BufferedWriter(fileWritter);
            //bw.write("\n");
            bw.write(s+"\n");
            bw.close();
            //System.out.println("Done");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        } 
    }
    public static void feedback()
    {
        /**code for giving feedback by the member. */
        // we use the Scanner class to take the input i.e name of the book.
        Scanner n=new Scanner(System.in);
        System.out.println("Enter the StudentId:");
        String studentId=n.nextLine();
        //Scanner s=new Scanner(System.in);
        System.out.println("enter your feedback:");
        String feedback=n.nextLine();
        try
        {
            //creating an object for File class.
            File f1 = new File("FeedBack.txt");
            if(!f1.exists())
            {
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
        catch(IOException e)
        {
           e.printStackTrace();
        } 
    }
    public static void help()
    {
        System.out.println("you can know each and every feature of the software using this feature");
        System.out.println("code still in development");
        try 
        {
             File myObj1 = new File("help.txt");//path of file
            Scanner myReader = new Scanner(myObj1);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void exit()
    {
        System.out.println("exiting the application");
        System.exit(0);
    }
    public static void main(String args[]) 
    {
        System.out.println("***MENU***");
        System.out.println("1.REGISTER");
        System.out.println("2.LOGIN");
        System.out.println("3.SEARCH");
        System.out.println("4.RECOMMEND");
        System.out.println("5.FEEDBACK");
        System.out.println("6.HELP");
        System.out.println("7.EXIT");		
        /**Select the choice that you needed. */
        System.out.println("enter your choice");
        System.out.println("enter your choice in integers only");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();//accept user input
        switch(choice)
        {
            case 1:register();break;
            case 2:login();break;
            case 3:search();break;
            case 4:recommend();break;
            case 5:feedback();break;
            case 6:help();break;
            case 7:exit();break;
            default: System.out.println("Incorrect input!!! Please re-enter choice from our menu");
        }
    }
}