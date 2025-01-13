# Library Management System

## Overview
This Library Management System is designed to manage library items (e.g., books, magazines), patrons, and their interactions. It uses various design patterns to ensure modularity, extensibility, scalability, and reusability.

## Features
- **LibraryItem (Abstract Class)**: Represents an item in the library with attributes like title, author, ISBN, and publicationYear. Contains an abstract method `displayInfo()` implemented by subclasses.
- **Book and Magazine (Concrete Classes)**: Extend LibraryItem and implement IBorrowable and IReservable interfaces. Provide specific implementations for borrowing, returning, reserving, and canceling reservations.
- **Interfaces**:
  - `IBorrowable`: Defines behaviors for borrowing and returning items.
  - `IReservable`: Defines behaviors for reserving and canceling reservations.
  - `IPatronManagement`: Manages patrons, providing methods to add, retrieve, update, and list all patrons.
  - `ILibraryInventory`: Manages library items and operations like adding, removing, and transferring books.
  - `MyObserver`: Defines the `update()` method for the observer pattern.
- **Patron**: Represents a library member with attributes like name, patronId, and borrowingHistory. Implements the Observer interface to receive notifications.
- **Reservation**: Links a patron with a reserved library item through patronId and ISBN.
- **LibraryInventory**: Manages library items, allowing adding, removing, transferring items, and searching the inventory.
- **PatronManagement**: A singleton class responsible for managing patrons, maintaining a Map of patrons keyed by patronId.
- **NotificationSystem**: Implements the observer pattern for sending notifications to registered observers.
- **RecommendationSystem**: Provides book recommendations for patrons based on predefined logic or borrowing history.
- **LendingSystem**: Coordinates borrowing and returning items, interacting with LibraryInventory and PatronManagement.
- **LibraryItemFactory**: Implements the factory pattern to create instances of LibraryItem subclasses based on a type.

## Design Patterns Used
- **Observer Pattern**: NotificationSystem notifies registered MyObserver instances of events. Patron acts as an observer.
- **Factory Pattern**: LibraryItemFactory creates instances of LibraryItem subclasses.
- **Singleton Pattern**: PatronManagement ensures a single instance manages all patrons.
- **Interface Segregation**: Small, specific interfaces (IBorrowable, IReservable, etc.) promote modularity.

## Workflows
- **Borrowing a Book**: The patron requests a book. LendingSystem verifies the book's availability in LibraryInventory. The book is removed from inventory and added to the patron's borrowing history in PatronManagement.
- **Returning a Book**: The patron returns a book. LendingSystem verifies the book's borrowing record in PatronManagement. The book is added back to LibraryInventory.
- **Reserving an Item**: A patron reserves an item using `reserveItem()` in the item class. A Reservation object is created to link the patron and the item.
- **Notifications**: When an event occurs (e.g., an item becomes available), NotificationSystem notifies registered observers.
- **Recommendations**: The system analyzes a patron's borrowing history or predefined rules. RecommendationSystem generates a list of recommended books.

## Advantages of the Design
- **Modularity**: Separation of concerns into distinct components (e.g., inventory, patrons, notifications).
- **Extensibility**: New features can be added (e.g., additional item types) without modifying existing code.
- **Scalability**: Singleton pattern ensures efficient use of resources (e.g., PatronManagement).
- **Reusability**: Interfaces promote code reuse across multiple item types.

## Getting Started
To get started with the Library Management System, clone the repository and follow the instructions in the `setup` section.

## License
This project is licensed under the MIT License.

SOurce code is availabe in this below link  https://github.com/KIRANME78/LibraryManagement/tree/master/src/main/java/org/example

