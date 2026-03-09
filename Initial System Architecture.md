# Initial System Architecture

The Share Price Comparison Web Application is designed using a clear, layered structure that keeps the system organised and easy to work with. Each layer has its own role, which helps the application stay flexible, easier to maintain, and ready to grow in the future. The presentation layer focuses on what the user sees, the business logic layer handles the main processing and rules, the data access layer manages how information is stored and retrieved, and the external services layer connects the app to outside data sources. By separating these responsibilities, the system becomes more reliable and simpler to update. With this architecture, the application is able to: 

- Retrieve share price data from an external provider such as Yahoo Finance
- Store share price data locally using a database such as SQLite
- Provide chart visualisation through a client-side charting library such as Chart.js

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

# System Architecture Diagram



<img width="707" height="713" alt="image" src="https://github.com/user-attachments/assets/17c35618-4e2a-4f47-b01c-1ec2fe6b0431" />
