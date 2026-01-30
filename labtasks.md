Part 2 – Transport Component Analysis
Now refer to the Transport example from the lecture slides. You are given:
Task 3:

1. Identify the software component in the Transport example.Transport
2. Identify its provided interface.Transportable
3. Describe its responsibilities.Transport is used to transport email messages via SMTP
4. Explain how encapsulation is achieved.Transport encapsulates emailing
  functionality
  – A client can use the class by
  • Importing it via import email.Transport;
  • Instantiating it via
  Transportable tr = new Transport();
  – Client programmer does not need (and cannot
  see) method code of Transport
  – Uses class with no problems via its interface

Task 4:
1- Explain the purpose of each method in the Transportable interface.

methods:

public String getSmtpHost(); -

public int getSmtpPort();

2- How does the send() method handle potential errors during email transmission?

3. What external services does the send() method rely on?
