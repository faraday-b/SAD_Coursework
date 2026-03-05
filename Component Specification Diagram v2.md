![Component diagram](<Component diagram.png>)

## Component description

The **Component Specification diagram** consists of seven primary components that define the system's modular structure:

| **Component**             | **Description**                                                                                                           |
| ------------------------- | ------------------------------------------------------------------------------------------------------------------------- |
| **Data Provider**         | Responsible for obtaining **daily price information** from up-to-date stock market rates, such as **Yahoo Finance**.      |
| **Persistence Manager**   | Manages **local storage and retrieval** to ensure **offline functionality** without a network connection.                 |
| **Comparison Engine**     | Contains the logic required to process share prices for one or more companies and **synchronize datasets** for graphing.  |
| **UI Component**          | Manages the interface that displays **historical share performance graphs** to the end user.                              |
| **Configuration Manager** | Manages **system-wide settings**, including external **API keys** and the specific file paths for **local JSON storage**. |
| **Validation Service**    | Enforces specific system constraints, such as the **maximum range of two years** for historical data retrieval.           |
| **Analytics Service**     | Dedicated to **mathematical calculations**, effectively separating complex data analysis from the primary graphing logic. |

## Interfaces description

The components interact through a series of defined **interfaces** that serve as system contracts:

| **Interface**          | **Description**                                                                                                                   |
| ---------------------- | --------------------------------------------------------------------------------------------------------------------------------- |
| **IPriceData**         | Facilitates the transfer of **fetched share data** to the persistence layer for storage.                                          |
| **IStockRepository**   | Enables the **Comparison Engine** to load necessary data even when the system is in **offline mode**.                             |
| **IComparisonService** | Supplies the **final processed graph data** to the **UI Component** for visual display.                                           |
| **IConfig**            | Supplies essential settings to the **Data Provider** for API connectivity and the **Persistence Manager** for local file mapping. |
| **IValidator**         | Used to **verify user-entered dates and symbols** before the system attempts a data fetch.                                        |
| **IStatistics**        | Provides methods for calculating **percentage changes**, **volatility** (price movement magnitude), and **moving averages**.      |

## External dependency description

The ‘External API’ provides the data for the ‘Data Provider’ component to access.
