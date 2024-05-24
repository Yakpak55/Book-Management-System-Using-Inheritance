// Joshua Sanchez, Christopher Deluigi
// Hw3
// 10/6/2023





import java.util.Scanner;
import java.text.DecimalFormat;
import java. util. Random;


public class hw3 {
	

	public static void main(String[] args) {
		
		
		BookList booklist = new BookList();
		
		
		
		
		int count = 0;
		

		/*   // for testing 
		booklist.newbook(new BookstoreBook("James lee","How to Fly","4874824",20.30,0) );
		booklist.newbook(new BookstoreBook("San fish","Brainrot","4874824",15.30,10) );
		*/
		
		
		
		Scanner myScan = new Scanner(System.in);
		
		
		System.out.println("Welcome to the book program!");
		
		while (count!= 1) {
			
			//these are variables that will be used to store user input and then put into their respected classes.(will reset for each loop)
			String choice;
			String holder[];
			String name;
			String Title;
			String ISBN;
			double price;
			String  percent;
			double deduction;
			String number;
			
			System.out.println("Would you like to create a book object?(yes/no)");
			choice = myScan.nextLine();
			
			//First opition is to make the book 
			if(choice.compareToIgnoreCase("yes") == 0) {
			
				System.out.println("Please enter the author, title, and the isbn of the book separated by /");
				choice = myScan.nextLine();
				System.out.println("\nGot it!\n");
				
				choice = choice.toUpperCase();
				holder = choice.split("/");
				name = holder[0];
				Title = holder[1];
				ISBN = holder[2];
				String choice2;
				
				System.out.println("Now, tell me if it is a bookstore book or a library book (enter BB for bookstore book or LB for library book):");
				choice2 =   myScan.nextLine();		
				boolean retry = true;
				
				//Another while loop in case the user try's to enter the wrong choice 
				while(retry == true ) {
					
					//First choice will bring them to making a new object that is a class of BookstoreBook
					if(choice2.compareToIgnoreCase("BB") == 0) {
						System.out.println("\nGot it!\n");
						retry = false;
						String choice3;
						
						System.out.println("Please enter the list price of "+ Title + " by " + name +":" );
						price = myScan.nextDouble();
						
						System.out.println("Is it on sale?(y/n)");
						myScan.nextLine();
						choice3 = myScan.nextLine();
						
						System.out.println("\nGot it!\n");
						
						
						//If they say yes to the sale then some math will be down to get the reduced price and be stored into the object.
						if(choice3.compareToIgnoreCase("y")== 0) {
							
							System.out.println("Deduction percentage:");
							percent = myScan.nextLine();
							
							//Will only take in the numbers and then convert it back to a double for the calculations.
							percent = percent.replaceAll("[^0-9.]", "");
							deduction = Double.parseDouble(percent);
				
							
							deduction = price - ((deduction/100.00)* price);
							booklist.newbook(new BookstoreBook(name,Title,ISBN,price,deduction) );
							
							System.out.println("Here is your Bookstore  Book information\n");
							booklist.printOneBook(ISBN);
							
						}
						else if(choice3.compareToIgnoreCase("n")== 0) {
							
							
							//If no sale then it will list the same price for what the book was listed for.
							booklist.newbook(new BookstoreBook(name,Title,ISBN,price) );
							System.out.println("Here is your bookstore Book information\n");
							booklist.printOneBook(ISBN);
							
						}
					}
					else if(choice2.compareToIgnoreCase("LB") == 0) {
						//LB stands for making a LibraryBook object.
						System.out.println("\nGot it!\n");
						retry = false;
						
						//This will call a method to make the callnumber string that will be stored into the LibraryBook object.
						number = booklist.combine(name,ISBN);
						
						booklist.newbook(new LibraryBook(name,Title,ISBN,number) );
						System.out.println("Here is your Library Book information\n");
						booklist.printOneBook(ISBN);
						
					}
					else {
						//Will make the user retry if they keep giving the wrong input.
						System.out.println("Oops! That’s not a valid entry. Please try again: ");
						choice2 =  myScan.nextLine();
					}
				}
							
			}
			else if(choice.compareToIgnoreCase("no") == 0) {
				//will exit out the loop to end the code.
				count = 1;
			}
			else {
				//will make the user retry their input 
				System.out.println("Oops! That's not a valid entry. Please try again:");
				continue;
			}

			//booklist.printall(); // for testing purposes to see all objects in the array at once.
			
			
			
		}
		
		//code ends and calls the final print statement.
		booklist.finalprint();
		System.out.println("Take care now!!");
	}
	
	
}





abstract class Book{
	
	private String author;
	private String title;
	private String isbn;
	
	public Book(String author,String title, String isbn) {
		
		this.author = author;
		this.title = title;
		this.isbn = isbn;
	}
	
	
	public Book() {
		
		author = "No author";
		title = "No title";
		isbn = "No isbn";
		
	}
	
	public Book(String author) {
		
		this.author = author;
		title = "No title";
		isbn = "No isbn";
		
		
	}

	// Setters and getters 
	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
	
	public String tostring() {
		return "[" + isbn + "-" + title +" by " + author + ",";
	}
	
}
	
class BookstoreBook extends Book{
	
	double price;
	double reduction;
	
	public BookstoreBook(String author,String title, String isbn,double price, double reduction) {
		super(author,title,isbn);
		this.price = price;
		this.reduction = reduction;
	}
	
	public BookstoreBook(String author,String title, String isbn,double price) {
		super(author,title,isbn);
		this.price = price;
		reduction  = price;
	}
	
	public BookstoreBook() {
		price = 0;
		reduction = 0;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getReduction() {
		return reduction;
	}

	public void setReduction(int reduction) {
		this.reduction = reduction;
	}
	
	DecimalFormat decimal = new DecimalFormat(".00");
	
	@Override
	public String toString() {
		return "[" + getIsbn() + "-" + getTitle() +" by " + getAuthor() + ",$" + decimal.format(price) + " Listed for $" + decimal.format(reduction) +"]" ;
	}
	
}


class LibraryBook extends Book{
	
	String callNumber;
	
	
	
	public LibraryBook(String author,String title, String isbn,String callNumber) {
		super(author,title,isbn);
		this.callNumber = callNumber;
	}
	
	public LibraryBook(String author,String title, String isbn) {
		super(author,title,isbn);
		callNumber = "No callNumber";
		
	}
	
	public LibraryBook() {
		callNumber = "No callNumber";
	}

	
	
	
	//Setters and getters
	public String getCallNumber() {
		return callNumber;
	}

	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}
	
	@Override
	public String toString() {
		return "[" + getIsbn() + "-" + getTitle() +" by " + getAuthor() +"-"+ callNumber +"]" ;
	}
	
	
	
}


class BookList{
	private Book[] list;
	
	public BookList() {
		list = new Book[100];
		
		for(int index = 0; index < 100 ; index++) {
			list[index] = null;
			
		}
		
		
	}
	
	
	public void newbook(Book  book) {
		boolean full = true;
		for(int index = 0; index <100 ;index++) {
			if(list[index] == null) {
				list[index] = book;
				full = false;
				break;
			}
			
		}
		if(full == true)System.out.println("Sorry but you reach the max book limit");
	}
	
	
	
	/*       //For testing only, will print out all the objects 
	public void printall() {
		
		for(Book book: list) {
			if(book != null)
				System.out.println(book);
		}		
	}
	*/
	
	//Will print the single book from either class when adding a new book.
	public void printOneBook(String isbn) {
		for(Book book:list) {
			if (book != null && book.getIsbn().compareTo(isbn) == 0) {
				System.out.println(book);
				break;
			}
			
		}
		
	}
	
	// this method is used to make the call number string, that is used just for the LibraryBook object.
	public String combine(String author,String isbn) {
		
		Random rand = new Random();
		String Final;
		
		//Will generate a number from 0-99
		int randomNumber = rand.nextInt(100);
		String randomString = String.format("%02d", randomNumber);
		
		//Will grab the first 3 letters of author.
		String threeletters = author.substring(0,3);
		
		//Will grab the last number in ISBN
		char lastnumber = isbn.charAt(isbn.length()-1);
		
		//Will combined all the strings into one final string and will return that string back which will be for the callnumber string.
		Final = randomString+ "." + threeletters +"." + lastnumber;
		
		
		return Final;
	}
	
	//This method will print out each BookstoreBook book along with the amount, as well printing out each LibraryBook and it's amount.
	public void finalprint() {
		
		int type = 0;
		int number = count(type);
		
		System.out.println("Here are all your books...\n");
		System.out.println("Bookstore books ("+ number +")");
		
		for(Book book: list) {
			 if(book instanceof BookstoreBook) {
				 System.out.println(book);
			 }
		 }
		System.out.println("\n-------------------------------------------------\n");
		
		type = 1;
		number = count(type);
		System.out.println("Library books (" + number +")");   
		
		for(Book book: list) {
			 if(book instanceof LibraryBook) {
				 System.out.println(book);
			 }
		 }
		System.out.println("\n-------------------------------------------------\n");
	}
	
	// This private method is used only in final print method to get the count for both classes.
	private int count(int type) {
		
		 int count = 0;
		
		 if(type == 0) {
			 for(Book book: list) {
				 if(book instanceof BookstoreBook) {
					 count++;
				 }
			 }
		 }
		 else if(type == 1) {
			 for(Book book: list) {
				 if(book instanceof LibraryBook) {
					 count++;
				 }
			 }
			 
		 }
		return count;
	}
	
	
}

	
	
	