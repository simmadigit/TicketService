This Ticket Service project can be set-up / run using the following methods and in Java 8 Environment.

I. Please follow the instructions to set-up the project in IDE like Eclipse.

	1. Check-out the Project TicketService
	    Project Root Folder : TicketService

	2. Go to File->Import the existing check-out project 

	3. Run TSMainMenuScreen as java application after a successful build using Maven  ( clean Package)

II. Please follow the instructions to run the TicketSystemRunnable.jar
	1. Check-out the Project TicketService
	    Project Root Folder : TicketService

	2. Copy the runnable jar file form this following location 

		TicketService\RUNNABLE\TicketSystemRunnable.jar

	3. Copy the Log4j.xml from this following location 
		TicketService\src\main\resources\Log4j.xml

	4. After copying to your local disk, your folder should have both TicketSystemRunnable.jar , and Log4j.xml

	5. Open the Command Prompt and run the following command to execute the jar file.

		java -jar TicketSystemRunnable.jar

Example:

	C:\Users\simmadi\workspace\RapidCreditLatest\TicketService\RUNNABLE>java -jar TicketSystemRunnable.jar

Output:
-----------------

	Ticketservice.log will be created and the following out put you can see on console to go over the Application.

	C:\Users\simmadi\workspace\RapidCreditLatest\TicketService\RUNNABLE>java -jar TicketSystemRunnable.jar
	log4j: reset attribute= "false".
	log4j: Threshold ="null".
	log4j: Level value for root is  [ALL].
	log4j: root level set to ALL
	log4j: Class name: [org.apache.log4j.RollingFileAppender]
	log4j: Setting property [append] to [false].
	log4j: Setting property [file] to [Ticketservice.log].
	log4j: Setting property [threshold] to [ALL].
	log4j: Parsing layout of class: "org.apache.log4j.PatternLayout"
	log4j: Setting property [conversionPattern] to [%d{ABSOLUTE} %-5p [%c{1}] %m%n].
	log4j: setFile called: Ticketservice.log, false
	log4j: setFile ended
	log4j: Adding appender named [fileAppender] to category [root].
	==========================================
	|   Welcome to the Ticket Service System |
	==========================================
	==========================================
	|       MENU SELECTION                   |
	==========================================
	|    1. Check Seats Availability         |
	|    2. Hold and Reservation of          |
	|       available Seats                  |
	|    3. Close                            |
	==========================================
	Select Option[1 / 2 / 3] :1

	Do you want the Seats Availability by Stage Level [YES/NO]yes
	=========================================
	|       STAGE SELECTION                 |
	=========================================
	|1. Orchestra   Price($100)             |
	|2. Main        Price($75)              |
	|3. Balcony1    Price($50)              |
	|4. Balcony2    Price($40)              |
	=========================================
	Select Option[1 / 2 / 3 / 4] :1
	Available Seats: 1250

	Do you want to continue [YES/NO]yes
	=========================================
	|       Hold Available Seats            |
	=========================================
	Enter Your E-mail ID : siva@gmail.com

	Enter Minimum Venue Level:
	=========================================
	|       STAGE SELECTION                 |
	=========================================
	|1. Orchestra   Price($100)             |
	|2. Main        Price($75)              |
	|3. Balcony1    Price($50)              |
	|4. Balcony2    Price($40)              |
	=========================================
	Select Option[1 / 2 / 3 / 4] :1

	Enter Maximum Venue Level:
	=========================================
	|       STAGE SELECTION                 |
	=========================================
	|1. Orchestra   Price($100)             |
	|2. Main        Price($75)              |
	|3. Balcony1    Price($50)              |
	|4. Balcony2    Price($40)              |
	=========================================
	Select Option[1 / 2 / 3 / 4] :1

	Enter Number Of Seats to Hold:12
	Number of Seats Requested to Hold :12
	Number of Seats Holded :12
	Seats Holded venue Level :1
	Seats Holded across requested levels
	Seats Holded ID :29724
	Your Seats Holded ID is valid for 60 Seconds
	Do you want to continue [YES/NO]yes
	=========================================
	|         Make Reservation of Seats      |
	=========================================
	Enter your Seat Hold ID to make Reservation:29724

	Enter Your E-mail ID : siva@gmail.com
	Reserved Seats:12
	Reserved at stage Level:1
	Price:$1200.0
	Status: Reservation is Success

	Do you want to continue [YES/NO]no
	Thank you , Bye!!!

	C:\Users\simmadi\workspace\RapidCreditLatest\TicketService\RUNNABLE>

