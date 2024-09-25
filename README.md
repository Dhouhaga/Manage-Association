# Association Management System

This is a Java-based project designed to manage associations (organizations), donors, and donations. The system provides functionalities for creating donations, displaying donors and donation lists, and deleting donations.

## Features
The project includes the following features:
1. **Create a new donation instance**
2. **Display the list of donors for a given association (organization)**
3. **Display the list of donations for a given association (organization)**
4. **Display the list of donations for a given donor**
5. **Delete a donation**

Each operation updates the relevant lists for donations, donors, and associations.

## Classes
The repository includes the following classes:

- **`Association.java`**: Manages associations and their related operations.
- **`Don.java`**: Represents a donation entity.
- **`Donneur.java`**: Represents a donor entity.
- **`LenException.java`**: Custom exception handling for invalid lengths.
- **`Organisation.java`**: Represents an organization (association) and manages its data and operations.
- **`ValueException.java`**: Custom exception handling for invalid values.
- **`test.java`**: Contains test cases to validate the functionality of the system.
- **`tempCodeRunnerFile.java`**: Temporary code runner file.

## Data Structures
- The project uses `ArrayList<>` to manage and update the lists of donations (`Liste_Dons`) and other related entities.

## How to Run
1. Clone the repository.
2. Compile the Java classes.
3. Run the `test.java` to execute test cases and interact with the association management system.

## Requirements
- Java Development Kit (JDK) 8 or higher.
