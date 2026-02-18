# Requirements Identification

**Project:** Share Price Comparison Web Application

This section defines and scopes the functional and non-functional requirements for the Share Price Comparison Web Application. The purpose of the system is to allow users to retrieve, persist, visualise, and compare historical share price data over a selected time period. The application will be implemented using a scalable, layered Java-based architecture to support maintainability, reliability, and future extension.

________________________________________
# 1. Functional Requirements

**Share Symbol Input and Validation**

**Description**

The system shall allow users to enter one or more stock symbols representing publicly traded companies.

**Requirements:**

•	Allow users to input one or more stock symbols.

•	Validate entered symbols against supported markets or data provider listings.

•	Reject invalid or unsupported symbols with appropriate user feedback.

**Rationale:**

Share symbols are the foundation of all data retrieval operations. Early validation prevents unnecessary external API calls, reduces error propagation through the system, and improves user experience by providing immediate feedback.

**Scope Considerations:**

Validation is limited to checking symbol existence and format; the system does not manage company metadata beyond symbol identification.
________________________________________
**Date Range Selection**

**Description:**

The system shall allow users to define the time period for which historical share price data is retrieved.

**Requirements:**

•	Allow users to select a start date and end date.

•	Enforce a maximum date range of two years.

**Rationale:**
Many free financial data providers restrict historical data access to limited time windows. Enforcing a two-year maximum avoids request failures and ensures consistent system behaviour while improving performance by limiting dataset size.

**Scope Considerations:**

The system supports daily historical data only; Throughout the day or real-time data is outside the scope of this project.

________________________________________
**Retrieval of Historical Share Price Data:**

**Description:**

The system shall retrieve historical share price data from external financial data providers.

**Requirements:**

•	Fetch daily historical share price data for validated symbols.

•	Use a data provider abstraction layer to decouple the system from specific external APIs.

•	Support replacement or extension of data sources without impacting core logic.

**Rationale:**

External APIs may change, impose rate limits, or become unavailable. Abstracting data retrieval improves maintainability, supports scalability, and reduces long-term technical risk.

**Scope Considerations:**

Only read-only access to external data is required; the system does not publish or modify financial data.

________________________________________

**Graphical Data Visualisation**

**Description:**

The system shall present historical share price data in a visual format to aid interpretation.

**Requirements:**

•	Display share prices using line charts.

•	Plot price values against time to clearly show trends and fluctuations.

**Rationale:**

Visualisation enables users to quickly understand price behaviour over time. Graphs are significantly more intuitive than raw numerical tables when identifying trends and patterns.

**Scope Considerations:**

Advanced analytics (e.g. indicators, forecasting) are not included.

________________________________________

**Share Price Comparison**

**Description:**
The system shall allow users to compare multiple shares over the same time period.

**Requirements:**

•	Display multiple shares on a single chart.

•	Align all datasets to a common date range.

•	Synchronise missing or non-trading days at the service layer.

**Rationale:**

Side-by-side comparison allows users to easily assess relative performance. Proper alignment ensures comparisons are accurate and not misleading due to mismatched data points.

**Scope Considerations:**

Comparison focuses on price trends only; volume or market capitalisation comparisons are excluded.

________________________________________
**Persistent Data Storage**

**Description:**

The system shall persist retrieved share price data locally.

**Requirements:**

•	Store historical data using a persistent mechanism such as a relational database or structured files (e.g. JSON).

•	Reuse stored data to minimise repeated API calls.

•	Support efficient read, write, and update operations.

**Rationale:**
Persistent storage improves performance, reduces dependency on external services, and enables offline access. This requirement directly influences the design of the data access layer.

**Scope Considerations:**

The system stores historical price data only; user account management is out of scope.
________________________________________
**Offline Functionality**

**Description:**
The system shall provide limited functionality when no internet connection is available.

**Requirements:**

•	Load previously stored share price data when external APIs are unreachable.

•	Allow users to view historical charts and comparisons using cached data.

**Rationale:**

Offline functionality increases system reliability and usability in environments with unstable connectivity. It reinforces the importance of persistent storage in the overall architecture.

**Scope Considerations:**

Offline mode does not support retrieval of new data.

________________________________________
# 2. Non-Functional Requirements

**Maintainability**

**Requirements:**

•	Use a layered architecture with clear separation of concerns.

•	Define stable interfaces between components.

•	Ensure components can be modified independently.

**Justification**

Maintainability supports long-term development across multiple sprints and reduces the cost of future changes.
________________________________________

**Scalability**

**Requirements:**

•	Allow integration of additional data providers.

•	Support alternative storage mechanisms without redesign.

•	Enable system growth with minimal architectural changes.

**Justification**

Scalability ensures the system remains adaptable and future-proof.

________________________________________

**Reliability**

**Requirements:**

•	Handle external API failures gracefully.

•	Use cached or stored data as fallback.

•	Maintain core functionality during partial system failures.

**Justification**

Reliability increases user trust and prevents complete service disruption.

________________________________________

**Performance**

**Requirements:**

•	Minimise unnecessary API calls.

•	Efficiently process and load historical datasets.

•	Leverage local caching to reduce latency.

**Justification**

Good performance improves user experience and reduces external service load.

________________________________________

**Usability**

**Requirements:**

•	Provide intuitive input controls.

•	Display clear, readable charts.

•	Guide users through key tasks naturally.

**Justification**

High usability ensures accessibility for users with varying technical skills.

________________________________________


# Constraints, Risks, and Mitigation

The project is limited by academic deadlines, a short development timeframe, and dependence on third party financial data providers. There is a risk that external APIs may become unavailable or impose rate limits. This is mitigated through data abstraction and the use of local persistent storage. All requirements have been shaped with these constraints in mind. party financial data providers. There is a risk that external APIs may become unavailable or impose rate limits. This is mitigated through data abstraction and the use of local persistent storage. All requirements have been shaped with these constraints in mind.

________________________________________

# Alignment with Project Goals

All requirements directly support the aim of building a robust, scalable, and user-friendly share price comparison application using Java and solid architectural practices. The investigation ensures that each requirement is realistic, achievable, and well supported by the proposed system design friendly share price comparison application using Java and solid architectural practices. The investigation ensures that each requirement is realistic, achievable, and well supported by the proposed system design. friendly share price comparison application using Java and solid architectural practices. The investigation ensures that each requirement is realistic, achievable, and well supported by the proposed system design.












