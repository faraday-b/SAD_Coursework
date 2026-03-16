## Business Type Model Documentation

### Overview

The Business Type Model defines the core logic and data structures of the Stock Comparison System. It is organized into two Spheres of Responsibility to separate analytical logic from raw data management.

### Spheres of Responsibility

#### Sphere A: Comparison Logic

- **Comparison (`<<core>>`)**: Coordinates the analysis between one or two companies.
- **Performance Graph (`<<type>>`)**: Data structure used to render the visual output.
- **Data Range (`<<type>>`)**: Defines the temporal scope of the comparison.
- **IComparisonMgt (`<<interface>>`)**: Entry point for initiating comparisons.

#### Sphere B: Stock Data Management

- **Company (`<<core>>`)**: Represents the entity being tracked.
- **Daily Price (`<<type>>`)**: Historical data points including date, closing price, and volume.
- **Share Symbol (`<<category>>`)**: Identification used to find companies via market tickers.
- **IStockDataMgt (`<<interface>>`)**: Manages the local database of company information.

### External Data Interfaces

- **IPriceProvider**: Connects to the external API to fetch missing historical data.
- **IPersistence**: Manages local storage to ensure data is persistently stored.

### Structural Constraints

- **Multiplicity**: A `Comparison` instance is associated with **1..2** `Company` instances.
- **Composition**: The `IComparisonMgt` and `IStockDataMgt` interfaces act as roots for their respective spheres.
- **Ownership**: `Comparison` owns its specific `Performance Graph` and `Data Range` instances.
