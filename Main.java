import java.util.*;  //importing java.util package
import java.io.*; //importing java.
import java.text.*;  //import the java.util package

/////////Main class starting
public class Main {
   ////////Main method starting
  public static void main(String args[])throws Exception {
   ////////Switch case starting
    //menu for library management system.
    System.out.println("***MENU***");
    System.out.println("1.REGISTER");
    System.out.println("2.LOGIN");
    System.out.println("3.SEARCH");
    System.out.println("4.RECOMMEND");
    System.out.println("5.FEEDBACK");
    System.out.println("6.HELP");
    System.out.println("7.EXIT");	
    Account1 obj= new Account1();	
    Book bookObj=new Book();
    /**Select the choice that you needed. */
    System.out.println("enter your choice");
    System.out.println("enter your choice in integers only");
    Scanner scan = new Scanner(System.in);
    int choice = scan.nextInt();//accept user input
    switch(choice)
    {
      //////////CASE 1
      /**Case 1 is the code for registering to the LMS.
       * Where every member need to enter the username, Roll number,you need to put the password. */			
      case 1:
        
        obj.Register();
        break;			
      case 2:
          boolean flag=obj.Login();
          if(flag){
            /**if the login is successful then member can access the submenu. */
            System.out.println("***SUBMENU***");
            System.out.println("1.ISSUE");
            System.out.println("2.RETURN");
            //int choice2 = scan.nextInt();
            //scan.close();
            switch(1){
              case 1:
              /***code for issue a book. */
                /**It stores the data in (Key, Value) pairs, and you can access them by an index of another type  */
                /**hm hashmap stores the student id and no.of book already issued */
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
                  if(a<2){
                    System.out.println("you are eligible to issue");
                    int p=d.get(bookName);
                    if(p>0){
                     
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
                else{
                  System.out.println("Invalid StudentId");
                }
                //System.out.println(hm);
                // System.out.println(m);
               // return new issue();
                break;
              case 2:
                      System.out.println("code in progress");
            }
          }
          else
              System.out.println("Login unsuccessful");
        
        
        break;			
      case 3: 
        
        bookObj.Search();
        break;
      case 4:
        bookObj.Recommend();
        break;
      case 5:
        obj.Feedback();
        break;
      case 6:
        /**code for help requirement in LMs */
        System.out.println("you can know each and every feature of the software using this feature");
        System.out.println("code still in development");
        try {
          File myObj1 = new File("help.txt");//path of file
          Scanner myReader = new Scanner(myObj1);
          while (myReader.hasNextLine()) {
          String data = myReader.nextLine();
          System.out.println(data);
        }
        myReader.close();
        }
        catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        break;		    
      case 7: 
        /**Code for exiting the application. */
        System.out.println("exiting the application");
        System.exit(0);
        break;
      default: System.out.println("Incorrect input!!! Please re-enter choice from our menu");
    }
  }
}