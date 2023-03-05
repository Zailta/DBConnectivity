## DBConnectivity using JPA and JDBC 


Welcome to the README file 

This project is a mockup for using JDBC and JPA Hibernate
JDBC is depected through CRUD operations performed over SQL DB

JPA is depected throgh a ticket persistence and retrieval process using:
**1. Java
2. Jakarta Servlet
3. JPA
4. AJAX
5. GSON and 
6. JSON Object.**

This project aims to provide a simple and efficient way of managing tickets using these technologies. Here are the key features of our project:

**1.Persistence: We use JPA to persist ticket information to a database. This allows us to store and retrieve tickets as needed, ensuring that they are available even after the application is restarted.
2.Retrieval: We use AJAX to fetch tickets from the database without having to reload the entire page. This provides a seamless user experience and helps improve the overall performance of the application.
3.Serialization: We use GSON to serialize ticket objects into JSON format, which can be easily transmitted over the network. This allows us to exchange ticket information with other applications, making it easier to integrate our application into a larger ecosystem.
4.JSON Object: We use JSON Object to represent ticket data in a structured format, making it easy to parse and manipulate ticket information within our application.**
In addition to the technologies mentioned above, we also utilize the Embeddable and Inheritance annotations from Hibernate. Here's how we use them in our project:

**1.Embeddable Annotation: We use the Embeddable annotation to define a composite primary key for our Ticket entity. This allows us to combine multiple columns into a single primary key, which can be useful when dealing with complex relationships between entities.
2.Inheritance Annotation: We use the Inheritance annotation to implement inheritance in our Ticket entity hierarchy. Specifically, we use the Single Table strategy to store all the entities in a single table, with a discriminator column indicating the type of each entity. This allows us to model relationships between different types of tickets (e.g. bug reports, feature requests) in a flexible and extensible way.
To use our Embeddable and Inheritance annotations in your own project, simply import the relevant Hibernate packages and add the appropriate annotations to your entity classes.**

To get started with our application, follow these steps:
Clone the repository to your local machine.
Import the project into your IDE of choice (e.g. Eclipse, IntelliJ).
Build and run the project using a server of your choice (e.g. Apache Tomcat).
Navigate to the application's homepage and start managing your tickets!
We hope you find our project helpful and easy to use. If you have any questions or feedback, please feel free to reach out to us.
