# Tasks Status:

### Report -
1. Created a sample db and table for delivery plan report using mySQL
2. Implemented a Springboot application to read the persisted DP.
3. Created DTO Layer using @Entity annotation, DAO layer using @Repository annotation, Service Layer using @Service and finally Presentation layer using @Controller.
4. Implemented different GET endpoints for sorting and filtering results.

### Filters – 
Implemented methods to filter using input criteria. (@PathVariables)

### Sorting – 
Implemented methods to sort using given criteria.

### Offset – 
Implemented **pagination** in business service layer that accepts a pagination size.

### REST layer –
* The UI can interact with BE. Added @CrossOrigin()
* Implemented GETMapping as the usecase was to only read from persisted dp.  

### Testing - 
* Unit test can be performed using JUNIT and using mocks.

* Integration testing can be done using ```@DataJpaTest, @SpringBootTest(SpringBootTest.WebEnvironment.MOCK,classes = Application.class) ,
@AutoConfigureMockMvc```


## Pending tasks / Enhancements 

1. Create a UI using Angular that has services @Injectable()) that performs GET requests to the http://localhost:8080/deliveryPlan endpoint.

2. Implement the different methods that performs a GET HTTP request to the http://localhost:8080/deliveryPlan endpoint via Angular's HttpClient. The method returns an Observable instance that holds an array of deliveryPlan objects.

3. Implement bonus tasks