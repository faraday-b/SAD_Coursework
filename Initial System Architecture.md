# Initial System Architecture

The Share Price Comparison Web Application is designed using a clear, layered structure that keeps the system organised and easy to work with. Each layer has its own role, which helps the application stay flexible, easier to maintain, and ready to grow in the future. The presentation layer focuses on what the user sees, the business logic layer handles the main processing and rules, the data access layer manages how information is stored and retrieved, and the external services layer connects the app to outside data sources. By separating these responsibilities, the system becomes more reliable and simpler to update. With this architecture, the application is able to: 

- Retrieve share price data from an external provider such as Yahoo Finance
- Store share price data locally using a database such as SQLite
- Provide chart visualisation through a client-side charting library such as Chart.js

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

# System Architecture Diagram




<img width="747" height="597" alt="image" src="https://github.com/user-attachments/assets/64ee4a5b-ed46-4489-a9e2-ba28eee639a4" />





The diagram is to provide a high-level overview of the system structure, identifying the main components, their interfaces, and how they interact. The architecture focuses on clarity, avoiding low-level implementation details.




**Overview of the System:**

The Share Price Analysis System allows users to:

-Enter a stock symbol

-Select a date range

-View stock performance

-Compare multiple stocks



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

------------------------------------------------------------------------------------------------------------------

<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/e772164a-069a-4f2c-a967-373ea70af999" />


# What Are Interfaces?
Interfaces is a agreements or contracts between parts of the system.

**They say**:

“If you want to use me, here’s exactly what I can do.”

This makes the system flexible, organised, and easy to change later.

**Examples of interfaces**:

IStockService

IComparisonService

IStockRepository

IExternalStockAPI

------------------------------------------------------------------------------------------------------------------

# Components That Implement One Interface

These components have one clear job, so they only need to follow one contract.

<img width="622" height="160" alt="image" src="https://github.com/user-attachments/assets/6e9582ad-0d1f-4505-a629-7be67e129bc8" />

They follow the Single Responsibility Principle, each one does one thing well.

**This makes them**:

- easier to understand

- easier to test

- easier to update

------------------------------------------------------------------------------------------------------------------

# Components That Implement Multiple Interfaces
Some components need to coordinate several tasks, so they implement more than one interface.

**Example**:
StockService

**Implements**:

- IStockService

- IStockDataProvider

**Why?**

Because StockService must:

- get stock data

- check local storage

- call the external API if needed

So it needs to talk to both the repository and the external API.

------------------------------------------------------------------------------------------------------------------

**Components That Use Interfaces** 

Some components don’t provide the functionality — they just use it.

**Example**:

StockController

**Uses**:

- IStockService

- IComparisonService

But it does not implement them.

**Why?**

**This keeps the controller loosely coupled, meaning**:

- it doesn’t depend on specific implementations

- you can swap out services without changing the controller

------------------------------------------------------------------------------------------------------------------

# Advantages

**Modularity**

Each part of the system has a clear job.
If something breaks, you know exactly where to look.

**Maintainability**

You can update or replace one component without affecting the whole system.

**Example**:

Switching from Yahoo Finance to another API requires changing only one component.

**Scalability**

The system can grow easily.
You can add new features or swap technologies without redesigning everything.

**Testability**

Because everything uses interfaces, you can create “fake” versions of components for testing.

This makes unit testing easier, faster and more reliable
