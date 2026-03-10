# Initial System Architecture

The Share Price Comparison Web Application is designed using a clear, layered structure that keeps the system organised and easy to work with. Each layer has its own role, which helps the application stay flexible, easier to maintain, and ready to grow in the future. The presentation layer focuses on what the user sees, the business logic layer handles the main processing and rules, the data access layer manages how information is stored and retrieved, and the external services layer connects the app to outside data sources. By separating these responsibilities, the system becomes more reliable and simpler to update. With this architecture, the application is able to: 

- Retrieve share price data from an external provider such as Yahoo Finance
- Store share price data locally using a database such as SQLite
- Provide chart visualisation through a client-side charting library such as Chart.js

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

# System Architecture Diagram



<img width="707" height="713" alt="image" src="https://github.com/user-attachments/assets/17c35618-4e2a-4f47-b01c-1ec2fe6b0431" />


The system is built in layers so each part has a clear job and is easier to manage. The user interacts with the app through a web browser, which sends requests to the StockController. The controller acts like a coordinator: it decides what needs to happen and passes tasks to different services, such as getting stock data, comparing prices, or preparing charts. The StockRepository is responsible for saving and loading stock prices from a local SQLite database. If the information isn’t already stored, the system uses the YahooFinanceService to fetch the latest share prices from the Yahoo Finance API.


---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

# Presentation Layer (The “Front End”)
**What it does**:  
This is the part of the system the user actually sees and interacts with.

**Main jobs**:

Let the user type in things like a stock symbol and date range

Show graphs and results

Send the user’s request to the backend (the “behind‑the‑scenes” part)

**Examples of tools used**:  
HTML, JavaScript, Chart.js

# Controller Layer (The “Traffic Manager”)
**What it does**:  
This part receives requests from the user interface and decides what needs to happen next.

**Main jobs**:

Listen for requests from the front end

Call the correct service to handle the request

Send the final results back to the front end

**Examples of actions**:

Get stock prices for a chosen date range

Compare two different stocks

# Service Layer (The “Brain” of the App)
**What it does**:  
This is where the main logic and calculations happen.

**Main components and their jobs**:

StockService
Gets stock data

Checks if the data is already saved locally

If not, fetches it from an external API

ComparisonService
Compares two stocks

Works out how each one performed

ChartService
Prepares the data so it can be shown nicely on a graph

# Data Access Layer (The “Storage Manager”)
**What it does**:  
Handles saving and retrieving stock data from local storage.

**Main jobs**:

Save stock prices

Retrieve previously saved data

Manage the local database

**Storage used**:  
SQLite (a lightweight local database)

# External API Client (The “Data Fetcher”)
**What it does**:  
Connects to outside services to get real stock information.

**Main jobs**:

Fetch stock prices from an external source (like Yahoo Finance)

Convert the raw data into a format the app can use

**Example external source**:  
Yahoo Finance
