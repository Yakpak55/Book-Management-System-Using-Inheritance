# Book-Management-System-Using-Inheritance
 Developed a Java program to manage bookstore and library books, demonstrating the use of inheritance and abstract classes.
 
The project involved:

● Abstract Class Book: Created an abstract class Book with common fields for author, title, and isbn. Included methods shared by both subclasses, such as getters, setters, and an abstract toString method.

● BookstoreBook Class: Implemented the BookstoreBook class extending Book, adding fields for price, onSale status, and discount percentage. Overrode the toString method to display book details, including sale price.

● LibraryBook Class: Implemented the LibraryBook class extending Book, adding a field for callNumber. The callNumber was generated based on a random floor number, author's name, and isbn. Overrode the toString method to display the library book details.

● BookList Management: Created a BookList class to manage an array of up to 100 Book objects, storing both bookstore and library books in a single collection.

● User Interaction: Designed a command-line interface for user interaction, allowing the addition of books, displaying all books, and differentiating between bookstore and library books.

Skills: Java · Object Oriented Design · Object-Oriented Programming (OOP) · Inheritance and Polymorphism · Command-Line Interface (CLI) · Software Development Lifecycle
