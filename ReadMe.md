# Exercise

      

## Note
1. Multi module structure is preferred choice

## Requirement
    + JDK 11.

## Project structure
This project contains two sub projects
    ### GoldCoins
        To calculate the payment from the king to his knights 
        The input are read from the CSV file
        
        Start the InterviewApplication either from your preferred IDE
        Or from command line make sure you have compiled the project with the right JDK version
        goto web-app/ target folder and run java -jar web-app-1.0-SNAPSHOT-spring-boot.jar
        =============
        Results are generated via GoldenRunner automatically as soon as the boot app is started
        alternatively results can be viwed via the test GoldPaymentTest
        --------------
    
    ### NextNumber
        ### Assumption
            + Probability size always equals 1.
            + randomNums size is not fixed

        To produce random number calculator

        Start the InterviewApplication either from your preferred IDE
        Or from command line make sure you have compiled the project with the right JDK version
        goto web-app/ target folder and run java -jar web-app-1.0-SNAPSHOT-spring-boot.jar
        Set of tests were added specifically to validate the random call
        =============

    ### Swagger Web 

     I have added a web layers, just to visualise the results

    For Payments
       Open http://localhost:8081/swagger-ui.html and navigate to [findAllCoinsPayment]
       Select the [try out] option
       Similar data to the below is received
           [
           {
           "noOfDays": 16,
           "noOfCoins": 61
           },
           {
           "noOfDays": 10000,
           "noOfCoins": 942820
           },
           {
           "noOfDays": 100,
           "noOfCoins": 945
           },
           {
           "noOfDays": 21,
           "noOfCoins": 91
           },
           {
           "noOfDays": 6,
           "noOfCoins": 14
           }
           ]
    
    ### Random Number
       Open http://localhost:8081/swagger-ui.html and navigate to [findRandomNumber]
       Select the [try out] option
       Similar data to the below is received
       Responsebody 0
       For different results you have to try few times to generate a different number 
