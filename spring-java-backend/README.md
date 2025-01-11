
    Concepts to include

		Api for ticket booking
		Decide all the apis
		Entity or Model
		For all use hibernate validation eg - @Entity or @Table or @Column or field validation
		Controller
		Write business logic in service
		Apply few design pattern - creational or behavior or structural
		Filtering or Criteria for getting result
		Sql top 5 interview question
		Use java 8
		Use oops concepts
		Transaction management and its isolation levels
		Spring security and JWT token validation
		Junit 5 test cases - with interview question
		Db locking mechanism - pessimist locking, Optimistic locking
		Multithreading concept while booking
		Log configure normal logs info or error level
		Check for logs in AWS make it searchable like splunk or kibana

		Micro service component and architecture



    Requirement 
    API Req
    

    Model 
    Ent Show ticket booking - 
        Venue - id, Address, name, capacity, admin
        User ---- Admin - name, address, id, age, gender
      isAdmin ---- Customer - name ,  

    Business logic
    Customer or admin can update their personal details
    Admin can add or cancel shows free shows assumption
    Customer should be able to login and view shows
    One customer can book max of 5 tickets per show
    Customer cannot add or cancel - security
    Customer can cancel booking before 2hrs
    View show list date and time passed wise
    View booking history for user

    Login 
    UserId 
    Password 
    Integrate with JWT token


////////////////////////////////////////////////////////

    Model
    ---> Venue - Single venue 
    ---> User - for both admin and customer
    ---> EventDetails 
    ---> Booking details

		Api for ticket booking
		Decide all the apis

    ----> Contoller 
          Show controller
            -> Add show - admin access only 
            -> Cancel show - admin access only
            -> Add cron job api to expire show when time has passed
            -> Get list of upcoming show for the selected date with seat count available - both customer and admin
            -> 
          Booking contoller
            -> Book show api - customer only 
            -> Cancel booking api - before 2 hrs for customer only
            -> Booking history api by user - customer only
          User Constoller 
            -> Register user - both should have access
            -> Login api - both 
            -> Update details api - both 

/////////
  Apply spotless formatter
  Apply archunit 
  Timed and trace for methods
  Emit metrics
  Check for vulnerablities
  Foreign key @one-many, @one one
  Try orphanremoval and cascadetype
  Unit test 

Integration test at the end if possible spin containers
Logstash

CHECK FOR ACCESS MODIFIERS 
    
    
            
          
    
    
    
    
    
    
    
    
    

