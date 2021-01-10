# AirportManagementSystem

I.	Description: 

A system that consists of multiple subsystems that handles different parts of the airport each subsystem should manage and keep track a vital part of the airport’s everyday process. 

The first sub-system is a Booking sub-system and the main actor for this system is the passenger, gives the customer the ability to search, book and cancel flights. The customer is able to edit his booking details. For example: upgrade his booking from commercial class to first class. The bookings are handled by management employees for booking confirmation, update passengers with flight information for example weather changes or flight delays. The system will also handle payment for bookings and refunds to the billing account.

The second sub-system is a Flight management sub-system managed by management employee, it allows him/her to add flights, edit flight information, cancel flights, revoke bookings, reassign pilots, view flight bookings.

The third sub-system is a Plane sub-system keeps track of pilots assigned to each flight. It also determines each flight’s gate by which passengers enter or leave the airport. It should also manage the slots which planes departure from or land in.  

II.	System Architecture (MVC)

A.	MVC
Separated into three levels; model, view and Controller. The model represents the data to the user and define the application objects, the view is the visual representation and show actual output, the controller is the brain behind the system which links the database and models and GUI together.
B.	Why MVC?
•	Faster deployment and distribution of work meaning each level can be done separately.
•	Changing the model level does not affect the whole architecture. Which works well with our system considering the continuous changes in data models. For example, required booking data model.
•	Previous experience in development using this architecture which makes error handling easier and working more efficient. 

C.	MVC in Airport Management system
IN our system the model is represented in the classes: Flight, booking, pilot, plane, plane slot, passenger, management employee, admin, user, feedback, billing account, gate. The views are represented in Login GUI, Passenger GUIs, Management Employee GUIs. The controllers are represented in system Manager and for each view there would be a controller.


IV.	Use case Diagram (Updated):
 

Link to Image: 
https://www.mediafire.com/file/xeuy9d5pgyeezdn/AirportMSUseCaseUpdated.png/file
V.	Class Diagram
 
Link: https://www.mediafire.com/file/h0ggn74yruptkmv/AirportMSClassDiagramFinal.png/file

VI.	Deployment Diagram
 
Link: https://lucid.app/lucidchart/invitations/accept/88e631ce-706c-4540-a539-a2181ae9ec44


VII.	Package Diagram 
 
Link: https://lucid.app/lucidchart/invitations/accept/77508984-18fd-4919-8099-8ba2ffa53f8f

VIII.	Design Patterns Used:
Note: coloured classes are classes contributing in design patterns
A.	Singleton pattern: used to prevent the creation of more than one admin for the system.
 
B.	Read-only Interface pattern
used to prevent the Management Employee from accessing the Feedback class constructor and thus, prevents the Management Employee from creating a feedback object as a feedback object should only be created by a passenger and a Management Employee is only allowed to read the feedback information.
 

C.	Observer pattern 
used for sending notifications to the passengers who have made a booking on a certain flight in case any change occurs to the flight (like an update to the flight, cancelling of the flight).
 
D.	Abstraction occurrence pattern
used to separate the unique booking details from a certain flight as creating a flight object for each booking and including the booking details within the flight object will result in the duplication of the same flight object through having many flight objects with the same flightID, plane, airline, destination, etc. so isolating the distinct booking details will lead to having only one object of each distinct flight.
 
E.	Strategy pattern
 used to allow the passenger to have various interchangeable search methods to choose from, they can set the search method to either searching flights by destination country or by airline company.

 
