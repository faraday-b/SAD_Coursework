# Business Concept Model

## Overview

The following diagram represents the **Business Concept Model** derived from the project requirements. It illustrates the relationships between the core entities involved in the stock comparison system.

![Improved_Business_Concept_Model](https://github.com/user-attachments/assets/a5fb3819-515a-439d-823c-9561d46ce690)

## Key Model Logic

- **Comparison to Company:** Supports comparing 1 to 2 companies as per the specification.
- **Data Constraints:** Each comparison is bound by a specific **Data Range** (maximum 2 years).
- **Persistence:** All **Daily Price** records are stored in a **Local Database** to ensure offline functionality.
- **Data Sourcing:** Price data is retrieved from an **External Data Source** (e.g., Yahoo Finance).
- **Output:** The system generates a **Performance Graph** to visualize the comparison results.
