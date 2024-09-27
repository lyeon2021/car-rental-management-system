# car-rental-management-system

Car Rental Management System Documentation
INTRODUCTION
The Car Rental Management System is a Java application designed to manage car rentals across different agencies. It provides functionality for adding customers, renting and returning cars, and ensuring data integrity through input validation.
Features
A.	Multiple Rental Agencies: Users can manage several rental agencies.
B.	Customer Management: Add new customers or select existing ones.
C.	Car Management: View and rent available cars, with options to return them.
D.	Input Validation: Ensures valid user inputs to maintain the application's integrity.
Technologies Used
Programming Language: Java
Installation Instructions
a)	Ensure you have the Java Development Kit (JDK) installed.
b)	Clone the repository
c)	Open the project in your Java IDE.
d)	Compile and run the Main class to start the application.
Usage Guide
A.	Start the Application.
B.	Select a Rental Agency or exit.
C.	Add or Select a Customer:
D.	Enter the customer’s name.
E.	Rent a Car: Choose from available cars.
F.	Return a Car: Decide whether to return the rented car.
G.	Exit the application.
Code Structure
Key Classes
a)	Car: Handles car details and availability.
b)	Customer: Manages customer information.
c)	RentalAgency: Coordinates car rentals and customer management.
d)	Main: Contains the application's main logic.
 
Encapsulation
A.	Car Class:
Attributes like make, model, and isAvailable are private to protect data.
Public methods are provided to access and modify these attributes.
B.	Customer Class:
The name attribute is private, accessed through a public method.
C.	RentalAgency Class:
Manages lists of Car and Customer objects, keeping them private to ensure encapsulation.
Input Validation
User input for selecting agencies, customers, and cars is validated to ensure that selections are within valid ranges.
Input for customer names is checked to ensure it is not empty.
Conclusion
The Car Rental Management System showcases effective object-oriented programming principles, emphasizing encapsulation and input validation. This ensures a robust and reliable application for managing car rentals efficiently. The modular design allows for easy maintenance and potential enhancements in the future.
Future Enhancements
a)	Database Integration: Implement database support for persistent storage of customers and cars.
b)	Graphical User Interface (GUI): Develop a GUI for improved user experience.
c)	Advanced Search Functionality: Allow users to search for cars based on various criteria (e.g., price, type).


