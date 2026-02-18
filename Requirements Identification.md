# Requirements Identification #

**Project:** Share Price Comparison Web Application 

This section identifies and defines the requirements and scope for the Share Price Comparison Web Application. The purpose of this system is to allow users to retrieve, store, and compare historical share price data over time using a robust and scalable Java-based architecture. 

# 1.	Functional Requirements

**Share symbol:** This part of the system is about letting users type in the stock symbols they want to look up


•	Allow the user to enter one or more stock symbols.

•	Make sure the symbols are real and supported (so the system doesn’t waste time looking up something that doesn’t exist).

**Why these matters**

•	The whole application depends on these symbols. If the user enters something invalid, nothing else will work properly.

•	Checking the symbols early prevents errors and avoids unnecessary calls to external services.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**Date Range Selection:** This requirement is about letting users choose the time for the stock price data they want to see.


•	Allow users to pick a start date and an end date.

•	Only let them choose a range of up to two years.

**Why these matters**

•	Many free financial data services only allow requests for a limited time range. Keeping it under two years avoids errors or blocked requests.

•	 Smaller date ranges help the system run faster and more reliably.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**Retrieval of Historical Share Price Data:** This requirement is about how the system gets past stock prices for the symbols the user enters.


•	Fetch daily historical stock prices from an external service (for example, Yahoo Finance).

•	Use a separate “data provider interface” so the system isn’t tied to just one source.

**Why these matters**

•	External data services can change, break, or become unavailable at any time.

•	This makes the system more flexible, easier to maintain, and more reliable.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**Graphical Data Visualisation:** This requirement is about showing the stock price data in a way that’s easy for users to understand immediately.


•	Display the historical stock prices on a line chart.

•	Show how the price changes over time so users can easily spot trends and patterns.

**Why these matters**
•	Graphs make the information much easier to understand than raw numbers.

•	Users can quickly see whether a stock is rising, falling, or staying steady.



--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------




**Share Price Comparison:** This requirement is about letting users compare several stocks on one chart so they can easily see how each one performs over the same period.

•	Allow multiple shares to be displayed together on a single chart.

•	Align all share price data to the same date range so the comparison is accurate.

•	Process and synchronise data in the service layer to ensure each stock lines up correctly.

**Why these matters**

•	Users can quickly understand differences in performance when shares are shown side by side. by side.

•	Aligning data avoids misleading comparisons and ensures the chart reflects real trends.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**Persistent Data Storage:** This requirement is about keeping all retrieved share price data saved on the local system so the application can run efficiently and reliably, even without an internet connection.

•	Store all fetched share price data in a persistent format, such as a relational database or structured files like JSON.

•	Makes sure the stored data can be reused without repeatedly calling external APIs.

•	Organise the data layer so it can efficiently read, write, and update stored records.

**Why these matters**

•	Reduces dependency on external data sources, improving performance and reliability.

•	Enables offline access, allowing users to view previously retrieved data at any time.

•	Influences how the data layer is designed, since it must support long term storage and efficient retrieval. term storage and efficient retrieval.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**Offline Functionality:** This requirement is about ensuring the system can still operate in a limited but useful way when there is no internet connection, by relying on data that has already been stored locally.

•	Load previously saved share price data when the system cannot reach external APIs.

•	Provide essential features—such as viewing past stock information—even without network access.

•	Integrate closely with the persistence mechanism so offline mode works smoothly.

**Why these matters**

•	Improves reliability for users in areas with unstable or intermittent connectivity.

•	Ensures the application remains usable even when online services are unavailable.

•	Reinforces the need for persistent storage early in the system’s architecture.







--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------







# 2.	Non-Functional Requirements

**Maintainability:** This requirement is about ensuring the system can be easily updated, fixed, and expanded as the project grows over multiple sprints.

•	Use a clear layered architecture with well-defined responsibilities. defined responsibilities.

•	Separate concerns so each component handles a specific part of the system.

•	Provide clean, stable interfaces that make future changes easier to implement.

**Why these matters**

•	Reduces the effort needed to add new features or modify existing ones.

•	Helps the team maintain code quality as the system evolves.

•	Supports long term development across multiple sprints. term development across multiple sprints.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Scalability:** This requirement ensures the system can grow without major redesigns, supporting new features, data sources, or storage options.

•	Allow new components to be added with minimal impact on existing ones.

•	Support flexible integration of additional data sources or storage mechanisms.

•	Use an architecture that can expand as the system’s scope increases.

**Why these matters**

•	Makes the system future proof and adaptable to new requirements.

•	Encourages reuse of existing components instead of rebuilding functionality.

•	Reduces technical debt as the project grows.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**Reliability:** This requirement focuses on keeping the system usable even when external services fail or behave unpredictably.

•	Handle API failures gracefully without crashing or blocking the user.

•	Use cached or stored data when live data cannot be retrieved.

•	Provide fallback behaviour that maintains core functionality.

**Why these matters**

•	Prevents complete service failure when external APIs are unavailable.

•	Ensures users can still access essential information.

•	Improves overall system stability and trustworthiness.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**Performance:** This requirement ensures the system responds quickly and avoids unnecessary delays, especially when processing historical data.

•	Minimise repeated or unnecessary API calls.

•	Process and load historical data efficiently.

•	Use local caching and persistent storage to reduce latency.

**Why these matters**

•	Improves responsiveness and overall user experience.

•	Reduces load on external services.

•	Ensures the system performs well even with large datasets.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


**Usability:** This requirement ensures the system is simple and intuitive for users, even those with limited technical experience.

•	Provide clear and straightforward input controls.

•	Display readable, easy to interpret charts and comparisons. to interpret charts and comparisons.

•	Offer an interface that guides users naturally through key tasks.

**Why these matters**

•	Makes the system accessible to a wider range of users.

•	Helps users retrieve and compare share prices without confusion.

•	Enhances overall satisfaction and ease of use.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

# Constraints, Risks, and Mitigation

The project is limited by academic deadlines, a short development timeframe, and dependence on third party financial data providers. There is a risk that external APIs may become unavailable or impose rate limits. This is mitigated through data abstraction and the use of local persistent storage. All requirements have been shaped with these constraints in mind. party financial data providers. There is a risk that external APIs may become unavailable or impose rate limits. This is mitigated through data abstraction and the use of local persistent storage. All requirements have been shaped with these constraints in mind.

# Alignment with Project Goals

All requirements directly support the aim of building a robust, scalable, and user-friendly share price comparison application using Java and solid architectural practices. The investigation ensures that each requirement is realistic, achievable, and well supported by the proposed system design friendly share price comparison application using Java and solid architectural practices. The investigation ensures that each requirement is realistic, achievable, and well supported by the proposed system design. friendly share price comparison application using Java and solid architectural practices. The investigation ensures that each requirement is realistic, achievable, and well supported by the proposed system design.




















