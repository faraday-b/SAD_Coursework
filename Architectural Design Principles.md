# Architectural Design Principles

Our system is built upon **Simple Architecture principles** to ensure the application is **robust**, **maintainable**, and **scalable**.

## Layered Architecture

The system is organized into a **strict top-down hierarchy** where each layer has a specific level of abstraction and only interacts with the layer directly beneath it.

### Application Flow

The control flow moves from the entry point to the data source: **Main** → **ShareController** → **ShareService** → **PriceRepository** → **PriceDataSource**.

### Implementation

For instance, **Main.java** is only responsible for starting the app and creating the **ShareController**, while the **ShareController** acts strictly as an intermediary between the user and the service layer. This prevents **"spaghetti code"** by ensuring dependencies are predictable and organized.

## Separation of Concern (SOC)

Each section of the application addresses a **distinct concern**, ensuring that **business logic** is never mixed with **data storage** or **user interface code**.

- **ShareServiceImpl.java**: This class is dedicated solely to **business logic** and coordinating operations, such as retrieving share prices. It does not concern itself with how data is stored or where it comes from.

- **InMemoryPriceRepository.java**: This class is exclusively responsible for **persistence logic**. By keeping storage logic here, we ensure that changes to how data is saved (e.g., moving from memory to a database) do not require changes to the business logic in the service layer.

## Abstraction

We use **interfaces** to define **"contracts"** for our components, hiding the complex implementation details from the rest of the system.

**ShareService.java** and **PriceRepository.java**: These interfaces define what the system can do without specifying how it does it.

### Implementation

By having the **ShareServiceImpl** interact with the **PriceRepository interface** rather than a concrete class, we achieve **"low coupling"**. This allows us to use an **InMemoryPriceRepository** for **Sprint 1** while maintaining the flexibility to swap it for a **SQLite repository** in future sprints without changing a single line of code in the service layer.

## Encapsulation and Information Hiding

Internal workings of a component are hidden, exposing only what is necessary through **stable interfaces**.

- **YahooFinanceDataSource.java**: This component encapsulates all interactions with **external systems**. Because it is isolated behind the **PriceDataSource interface**, any future changes to the Yahoo Finance API will be contained within this single file and will not affect the core application.

- **SharePrice.java**: This **domain model** encapsulates daily share price records (symbol, date, closing price), remaining entirely independent of the infrastructure layers that move or store it.
