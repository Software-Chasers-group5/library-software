import java.util.*;
import java.text.*;
class IssueBook extends BookIssueDetails{
    public static void main(String args[]){
         HashMap<String, Integer> hm=new HashMap<String, Integer>();
         hm.put("J4",1);
         hm.put("J2",1);
         hm.put("D5",2);
         hm.put("B1",0);
		System.out.println("Enter Student Id,Booknumber, name and price");
		Scanner c = new Scanner(System.in);
		String studentId = c.nextLine();
		Scanner c1 = new Scanner(System.in);
		int bookNumber = c1.nextInt();
		Scanner c2 = new Scanner(System.in);
		String name = c2.nextLine();
		Scanner c3 = new Scanner(System.in);
		String issueDate = c3.nextLine();
		BookIssueDetails newIssuedBook = new BookIssueDetails();
		newIssuedBook.setName(name);
		newIssuedBook.setBookNumer(bookNumber);
		
		ArrayList<BookIssueDetails> l=new ArrayList<BookIssueDetails>();
        String pattern = "MM-dd-yyyy";
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
       String date = simpleDateFormat.format(new Date());
       System.out.println(date);
		
		if(hm.containsKey(studentId))
        {
            int a=hm.get(studentId);
            if(a<=2){
                System.out.println("you are eligible to issue");
                a=a+1;
            }
            else
              System.out.println("you are not eligible");
        }
	}

    
}

