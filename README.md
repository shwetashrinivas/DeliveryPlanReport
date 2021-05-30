# Objective

Design/Implement a simple web application to display the Delivery Plan report with main focus on business service APIs to handle various functionalities as described below.

## Background

In Supply Chain Planning world, the Delivery Plan (DP here after) is a report which provides information as to whether demands can be fulfilled in the requested time and quantity. From a technical perspective, DP is simply a **persisted entity** with attributes/columns like: Delivery No, Part, Depot, Customer, Due Date, Delivery Date, Quantity, Delivery Margin etc.

| Delivery No | Part | Depot | Customer | Quantity | Due Date | Delivery Date | Margin |
|--|--|--|--|--|--|--|--|--|--|--|
|100 | Hard Disk | Beijing| CUST-1| 20| 2014-06-30| 2014-06-25| 10000€|
|200| Processor| Beijing| CUST-1| 40| 2014-06-30 |2014-07-25 |40000€|
|300 |Cable |Beijing| CUST-1|20 |2014-06-30 |2014-07-25|1000€|
|400 |Hard Disk| Taiwan |CUST-2|20 |2014-06-25| 2014-06-25 |12000€|
|500| Processor |Taiwan |CUST-2| 20 |2014-06-22 |2014-07-25 |50000€|
|600| Cable |Taiwan |CUST-2| 20| 2014-06-30| 2014-06-22| 2000€|
|700 |Display| Taiwan| CUST-2 |20 |2014-06-23 |2014-06-25 |70000€|

## Tasks
1. **Report** - Design/Implement a Java/JEE application to read the persisted DP and display it as a report (tabular view). The main focus is to design the different layers : database layer, business
services, data transfer objects, presentation layer and UI (see below)
2. **Filters** – The report data can be filtered. This means, the business services should be able to accept some filters (e.g. part, depot, customer, date range) and output only the relevant data.
3. **Sorting** – The business service should be able to accept an attribute to sort the data (e.g. sort by customer).
4. **Offset** – Assume the report to have hundreds/thousands of records. The data traffic between the client and server becomes quiet high. Therefore, the business service can accept a pagination size or data offset (e.g. retrieve the records from 20010 to 20020).
5. **REST layer** – The UI interacts with the REST layer using standard HTTP methods like GET etc and passing parameters. The REST methods may implement the above business functionalities or simply call a business service layer. It is your design decision.
6. **Testing** - Some thoughts about how to perform integration tests on this application. 


## Bonus tasks

1. Display a Pie-Chart/Bar chart (using any JS library) to provide the delivery margin (in €) aggregated by customer i.e. sum the delivery margin for every customer and display the result in either of the charts of your choice.
2. Display a Pie-Chart/Bar chart (using any JS library) to provide the number of late deliveries aggregated by customer. A delivery is late if the delivery date is after the due date. Sum the number of such late deliveries by customer and display it on a chart.