import java.util.Scanner;
import java.util.ArrayList;

class LibraryManagement
{
	private String bookName;
	private String bookNo;
	private String bookCopyNo;
	private String author;
	static int count=0;
	
	LibraryManagement()
	{
	}
	
	LibraryManagement(String bookName,String bookNo,String author,String bookCopyNo)
	{
		this.bookName=bookName;
		this.bookNo=bookNo;
		this.author=author;
		this.bookCopyNo=bookCopyNo;
	}
	
	public void setBook(String bookName)
	{
		this.bookName=bookName;
	}
	
	public void setBookNo(String bookNo)
	{
		this.bookNo=bookNo;
	}
	
	public void setAuthor(String author)
	{
		this.author=author;
	}
	
	public String getBook()
	{
		return bookName;
	}
	
		public String getBookNo()
	{
		return bookNo;
	}
	
		public String getAuthor()
	{
		return author;
	}
	
	public String getBookCopyNo()
	{
		return bookCopyNo;
	}
	
	public String toString() 
	 {
        return String.format("\tBook Name :"+bookName + " " +"\n\tBook Id :"+bookNo+" "+"\n\tAuthor Name :"+author+" "+"\n\tAvailable Copy :"+bookCopyNo);
     }
	
}

class Utility
{
	Scanner sc=new Scanner(System.in);
	ArrayList<LibraryManagement> list=new ArrayList<LibraryManagement>();
	LibraryManagement obj=new LibraryManagement();
	
	 String bookName;
	 String bookNo;
	 String author;
	 String bookCopyNo;
	 
	
	public void addBookDetails()
	{
		System.out.println("Enter Book Name");
		bookName=sc.next();
		
		System.out.println("Enter Book Id");
		bookNo=sc.next();
		
		System.out.println("Enter Author Name");
		author=sc.next();
		
		System.out.println("Enter No Of Available Copy");
		bookCopyNo=sc.next();
		
		LibraryManagement lb=new LibraryManagement(bookName,bookNo,author,bookCopyNo);
		list.add(lb);
		obj.count=list.size();
		
	}
	
	public void showBookDetails()
	{
						if(list.isEmpty())
						{
							System.out.println("List is Empty");
						}
						else
						{
						for(LibraryManagement E : list)
								{
									System.out.println("===========================================");
									System.out.println("\tBook List");
									System.out.println("===========================================");
									System.out.println(E.toString());
								}
						}
	}
	
	public void removeBook()
	{
		if(list.isEmpty())
			{
				System.out.println("List is Empty");
			}
		else
			{
				int index;
				System.out.println("Enter Index No From which you want to delete");
				System.out.println("Index No in between "+0+" to"+(list.size()-1));
				index=sc.nextInt();
				list.remove(index);
				System.out.println("Book removed");
				obj.count=(list.size()-1);
			}
	}
	
	public void searchBookById(String Id)
	{
		int val=0;
		boolean flag=false;
		if(list.isEmpty())
		{
			System.out.println("List is empty");
		}
		else
			{
				for(int i=0;i<list.size();i++)
				{
					if (Id.equals(list.get(i).getBookNo())) 
					{
					  flag=true;
					  val = i;
						break;
					}
					
				}
				if(flag==true)
					{
						System.out.println(list.get(val).toString());
					}
				else
				{
					System.out.println("Enter correct Id");
				}
			}

     	
	}
	

}

class Test
{
	String bookName;
	String bookNo;
	String author;
	static int count=0;
	static String user="admin";
	static String  pass="admin";
	
	public static void main(String args[])
	{
		Utility ut=new Utility();
		Scanner sc=new Scanner(System.in);
		LibraryManagement lm=new LibraryManagement();
		ArrayList<LibraryManagement> list=new ArrayList<LibraryManagement>();

			int choice;
			for(int i=0;;)
			{
				choice :
					System.out.println("************************Library Management*****************************");
					System.out.println("[1] Add Book");
					System.out.println("[2] Show All Book List");
					System.out.println("[3] Show Book List by Id");
					System.out.println("[4] Remove Book");
					System.out.println("[5] Exit");
					System.out.println("choice------>");
					choice=sc.nextInt();
					
					switch(choice)
						{
							case 1:
							ut.addBookDetails();
							break;
							
							case 2:
							ut.showBookDetails();
							
							break;
							
							case 3:
							String Id;
							System.out.println("Enter Book Id");
							Id=sc.next();
							ut.searchBookById(Id);
							break;
							
							case 4:
							ut.removeBook();
							break;
							
							case 5:
							System.out.println("***********EXIT*************");
							System.exit(0);
							break;
							
							default:System.out.println("worng entry");
						}
			}
			

		
		
	}

}