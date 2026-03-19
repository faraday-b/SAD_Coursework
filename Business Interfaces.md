# Sprint 2: Business Interface Specification

## 1. Introduction

This section defines the business interfaces for the Share Price Comparison application. These interfaces represent the core "regions of responsibility" within the business layer, acting as a stable contract between the user-facing system interfaces and the underlying data.

## 2. Business Interface Discovery

The operations for these interfaces were discovered by analyzing the **Use Case Model**, the **System Interfaces**, and the **Initial System Architecture**. By mapping user goals (Use Cases) to the data required (Business Type Model), we identified the necessary functional services.

### 2.1 Discovery Mapping Table

The following table demonstrates how high-level use cases and system triggers were used to define specific business operations.

| **Use Case**                    | **System Interface (Trigger)** | **Discovered Business Operation**                  |
| ------------------------------- | ------------------------------ | -------------------------------------------------- |
| **Search Share Price History**  | `ISearchShare`                 | `IStockDataMgt::findCompany(query)`                |
| **Compare Company Performance** | `IComparePerformance`          | `IComparisonMgt::createComparison(tickers)`        |
| **Filter by Date Range**        | `IDateRangeSelector`           | `IComparisonMgt::setAnalysisRange(range)`          |
| **View Advanced Analytics**     | `IAnalyticsUI`                 | `IComparisonMgt::calculateAdvancedAnalytics(type)` |
| **Manage Offline Data**         | `IDataManager`                 | `IStockDataMgt::manageOfflineData(data)`           |

---

## 3. Business Interface Definitions

Based on the discovery process, two primary business interfaces have been defined. These interfaces manage the core types identified in the Business Type Model.

### 3.1 `IStockDataMgt` (Stock Data Management)

This interface manages the **Company** core region, including daily pricing and ticker symbols.

- **`searchShare(query: String): List<Company>`**: Returns a list of companies matching the search criteria.
- **`getCompanyDetails(symbol: ShareSymbol): Company`**: Retrieves metadata for a specific company.
- **`getPriceHistory(symbol: ShareSymbol, range: DataRange): List<DailyPrice>`**: Provides the raw time-series data required for charting.
- **`manageOfflineData(data: List<DailyPrice>)`**: Handles the persistence of local data for offline use.

### 3.2 `IComparisonMgt` (Comparison Management)

This interface manages the **Comparison** core region, adding value by processing raw stock data into comparative analysis.

- **`createComparison(companies: List<Company>): Comparison`**: Initializes a new comparison set for the user.
- **`setAnalysisRange(range: DataRange)`**: Updates the time bounds for the current comparison.
- **`calculateAdvancedAnalytics(type: String): List<Double>`**: Calculates Moving Averages or Volatility metrics.
- **`generateGraphData(comparisonId: String): PerformanceGraph`**: Transforms comparison data into coordinates for visual rendering.

---

## 4. Operational Usage (Collaboration Diagram)

To describe how these operations are used in practice, the following communication flow outlines the **"Compare Company Performance"** use case.

### 4.1 Use Case: Compare Company Performance

This diagram illustrates the interaction between the two business components to generate a comparative analysis.

![compare performance](https://github.com/user-attachments/assets/9a873da9-483f-4975-9d57-1ad7f6b3e720)

**Communication Flow:**

1. The **User** selects stocks via the system interface.

2. **Message 1:** The System Interface (`:CompareUI`) calls `createComparison(tickers)` on the **`ComparisonManager`**.

3. **Message 2:** The `ComparisonManager` requests data by calling `getPriceHistory(symbol)` on the **`StockDataManager`**.

4. **Message 3:** The `ComparisonManager` executes its internal business logic via `calculatePerformance()`.

---

### 4.2 Use Case: Search Share Price History

This diagram illustrates the data acquisition process from external sources.

![search share](https://github.com/user-attachments/assets/8ec07a0d-d7cd-4e5e-8587-baf3f8ad5155)

**Communication Flow:**

1. The **User** enters a ticker symbol.

2. **Message 1:** The **`:SearchUI`** captures the input and triggers the business logic.

3. **Message 2:** The **`StockDataManager`** receives the `searchShare(symbol)` request.

4. **Message 3:** The manager invokes **`requestMarketData(symbol)`** on the external **`IPriceProvider`** (API).

5. **Message 4:** The manager performs a self-call to **`validateResults()`** before the data is persisted or displayed.

## 5. Summary of Architecture

By keeping the **Business Interfaces** (`IStockDataMgt` and `IComparisonMgt`) separate from the **System Interfaces**, the system maintains a clean three-tier architecture. This ensures that the core business logic remains stable even if the user interface or external data providers change in future sprints.
