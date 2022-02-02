# J2E_final_project

-------------------------------

**0- Description**

This application was coded as part of the final project for the JEE course of the TSI program at ENSG. It makes use of Java
technologies such as **Spring**, **Hibernate**, **SpringMVC** and **SpringBoot**.

This application is an event manager which allows an administrator to create, edit or delete evenements. It also allows the admin to add, edit or remove participants linked to the events.



---------


Please follow the following steps in order to install and launch our application on your computer.

*********
1 - **Import the file and install the necessary dependencies**

First, you will have to clone the project from the github page associated with it.

In a Linux terminal, please get the directions to the folder you want the application to be saved on and then run the following command line:

```bash
  git clone https://github.com/Charles0009/J2E_final_project.git
  ```
The project runs on maven, so be sure to have maven installed on your computer, if not, here is a tutorial : https://maven.apache.org/users/index.html

The project uses a database as well. The setup of the database is described below. Here, we recommend you to install PotgreSQL by following this tutorial :  https://www.postgresql.org/download/

We advise you to use PgAdmin to visualize the database. To install it, follow this link : https://www.pgadmin.org/download/. On this project, we used version 4.5.

Finally, we advise you to install the IDE IntelliJ as this program was developed under it and the tutorial will follow the functionalities offered by this IDE. Here is a link to install it : https://www.jetbrains.com/idea/download/. Choose the Community edition.

Note : if you are more experienced with another IDE, our program is also compatible but the ways to run it on other IDEs than IntelliJ will not be showed in this tutorial.

----------------------
**2 - Get your database ready**

At this point, you should have PostgreSQL installed and an app (PgAdmin) to visualize the database.

To setup your database, follow these steps :

1) create a user with the name you want, for simplicity in this tutorial, we create the user 'test'
2) create a database with the name you want, for simplicity in this tutorial, we create the database 'test'
3) create a password you want for accessing your database, for simplicity in this tutorial, we create the password 'test'

When the database is created you can open an IDE (for this tutorial, we use IntelliJ) and check the file hibernate.cfg.xml in the directory src/main/java/resources.
You will have to check the lines 7 to 9 to make sure that the parameters match the one you parametrized your database with.

----------
**3 - Launch the application**
In your IntelliJ IDE, on the top right, a web configuration should be displyed, if so, just hit the run button after building the project.

If the configuration is not present, add a new one by following those steps :

1) Click "Edit configurations...", a new window should pop up.
2) On the top left, click the + button.
3) Choose the "Application" configuration.
4) Then choose the name of your configuration.
5) Choose the Java v11 or 13 JDK.
6) Put the path to the file ServingWebContentApplication.java as the main.
7) Hit apply and then ok.

Once you've hit the run button, go to your usual web explorer and enter the url "localhost:8080" in the research bar.
The app should launch normally, if not don't hesitate to contact us on Github!

**Enjoy**
