# OptimisticLocking
Using ETAg and JPA @Version

ETAG are used in HTTP Header  to identify if there was a change in the Resource.

Conditional Requests
Using an If-* header turns a standard GET request into a conditional GET.  If no change in resource a status 304 - Not modified is sent with Empty response body.
The two If-* headers that are using with ETags are:

If-None-Match and -- Conditional GET
If-Match (Optimistic locking)


This is using a Oracle DB - 12c
DDl to create Portfolio table: 
CREATE TABLE PORTFOLIO
(
PORTFOLIO_KEY INTEGER NOT NULL,
RAR_ID INTEGER,
PORTFOLIO_NAME VARCHAR2(255),
PORTFOLIO_CODE VARCHAR2(255),
CURRENCY VARCHAR2(4),
VALID_FROM DATE,
VALID_TO  DATE,
ACTIVE CHAR(1),
DESCRIPTION VARCHAR2(2000)
);