# individual-project-Shreyansh

The program starts excecution from the Billing class which is inside src -> project.

Upon running the user will have to enter the absolute path of the input file in the console.

The output files that might be an error message or a success message will be written in the same path as the input and will be of the following format.

For Success :- output_{random_number}.csv
For Error :- error_{random_number}.txt

# Design Patterns Used

1) Singleton Pattern:-

Singleton Pattern comes under creational pattern as this pattern provides one of the best ways to create an object. This pattern involves a single class which is responsible to create an object while making sure that only single object gets created. This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class. In this project I have used Singleton for the Database class. I made the instance and the Constructor for Database class private and created getInstace which will return the Database object.

2) Chain of Responsibility:- 

The chain of responsibility pattern creates a chain of receiver objects for a request. This pattern decouples sender and receiver of a request based on type of request. This pattern comes under behavioral patterns. Here in my implementation I have implemented the Chain of Responsibility pattern for the Validation of Quantity and Cap amount.

    a) I have created an interface Validator which will be implmented by ValidateQuantity and then ValidatedCap.

    b) If the processing of ValidateQuantity is successful then we move to ValidatedCap. If any error in ValidateQuantity it will return the error for that item and ask the user to reduce the quantity.

3) Factory Pattern:-

In Factory pattern, we create object without exposing the creation logic to the client and refer to newly created object using a common interface. For this program I have used Factory Pattern for the output to the User that is to create the error or the Success file.

Both the SuccessMessage class and the ErrorMessage class implement the Output Interface. Based on the goodtoclear variable in writeFinal function in IObasic class we decide if we are going to write a success file or error message.

# Class Diagram:-


![image1](https://github.com/gopinathsjsu/individual-project-Sheryansh96/blob/main/Screenshots/ClassDiagram.png)




# Output Screenshot

## Success Message:-


Inventory :-


![image1](https://github.com/gopinathsjsu/individual-project-Sheryansh96/blob/main/Screenshots/Inv1.png)



Console log:-


![image1](https://github.com/gopinathsjsu/individual-project-Sheryansh96/blob/main/Screenshots/Console1.png)



Output:-


![image1](https://github.com/gopinathsjsu/individual-project-Sheryansh96/blob/main/Screenshots/Output1.png)



# Error Message when item is more that the stock quantity:-

Inventory :-


![image1](https://github.com/gopinathsjsu/individual-project-Sheryansh96/blob/main/Screenshots/Inv2.png)



Console log:-


![image1](https://github.com/gopinathsjsu/individual-project-Sheryansh96/blob/main/Screenshots/Console2.png)



Output:-


![image1](https://github.com/gopinathsjsu/individual-project-Sheryansh96/blob/main/Screenshots/Output2.png)


# Error Message when Cap amount is exceeded:-

Inventory :-


![image1](https://github.com/gopinathsjsu/individual-project-Sheryansh96/blob/main/Screenshots/Inv3.png)



Console log:-


![image1](https://github.com/gopinathsjsu/individual-project-Sheryansh96/blob/main/Screenshots/Console2.png)



Output:-


![image1](https://github.com/gopinathsjsu/individual-project-Sheryansh96/blob/main/Screenshots/Console3.png)

