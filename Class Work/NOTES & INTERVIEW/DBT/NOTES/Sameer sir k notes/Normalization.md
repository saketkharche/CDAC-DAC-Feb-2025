# NORMALIZATION


- applicable for RDBMS ( eg. MySQL ) and ORDBMS ( eg. ORACLE ).
- Concept of table design
- RDBMS -> 1st to 4th Normal form
- ORDBMS -> 1st to 9th Normal Form
- what tables to create, structures, column, datatype, widths, constraints
- based on user requirnments 
- it's part of a design phase (min 1/6 time should be spend on designing AND  25% - 33% on coding as per sameer sir )

- Aim of Normalization :-
    a. to have an "efficient" table structure
    b. avoid the data redundancy ( avoid the unnecessory duplication of data )
    c. to reduce the problems of insert, update, and delete

- Normalization is done from an input prespective.
-  Normalization is done from a Forms prespective (front end).

* IMP

- VIEW THE ENTIRE APPLICATION ON A PER-TRANSACTION BASIS, AND YOU NORMALISE EACH TRANSACTION SEPARATELY.
- e.g. CUSTOMER_PLACES_AN_ORDER, CUSTOMER_CANCELS_THE_ORDER, GOODS_ARE_DELIVERS, CUSTOMER_MAKES_PAYMENT, CUSTOMER_TERETURNS_THE_GOODS etc.


### lets take an real life example
#### CUSTOMER_PLACES_AN_ORDER

## Getting ready for Normalization:-
- data which flipkart stores

![alt text](image-26.png)



    1. For a given transaction , make a list of fields

    2. Ask client for some sample data
![alt text](image-30.png)



    3. With the permission and involvement of client, strive for atomicity ( column is divided into sub-columns, and sub-columns are divided into sub-sub_columns )
        e.g.
 ![alt text](image-27.png)

    4. For every column, make a list of column properties;
    e.g.
![alt text](image-28.png)

    5. GET CLIENT SIGN-OFF.
    6. END OF CLIENT INVOLVEMENT/ INTERACTION
    7. Assign the datatypr for each column
    8. Assign the width for each column
    9. Assign the not null, unique and check constraints
![alt text](image-29.png)

    10. For all practical purposes, u can have a single table with all these columns

    11. Remove the computed column ( e,g, itemtotal, ototal )
    12. Key element will be Primary key of thei table
----------------------------------------------------------------------



* At this point, the data is Un-Normalised form (UNF)
* Un-Normalised form -> Starting point of NORMALISATION


# NORMALISATION

1. Remove the repeating group into a new table
![alt text](image-31.png)
.
.
2. Key element will be the primary key of new table
![alt text](image-32.png)
.
.
3. (This step may or may not be required) Add the primary key of orignal table to the new table to give u a Composit Primary Key.
![alt text](image-33.png)


    ###     The above three steps are to be repeated gain and again infinitey till u canot normalize it any further

    ###     At this point
        FIRST NORMAL FORM ( FNF ) ( SINGLE NORMAL FORM ) ( 1NF ) :-
        - Repeating groups are removed from the table design.
        QUE   - 1 isto many relationship is always encountered here
 `      DEPT and EMP tables are in First Normal Form 

4. Only the tables with composit primary key emelents are examined
 ![alt text](image-34.png)


5. Those non-key elements that r not dependent on the entire composit primary key, they are to be removed into a new table.
![alt text](image-35.png)

6. Key element on which originally dependent, it is to be added to the new table and it will be the primary key of that new table.

* The above three steps are to be repeated gain and again infinitey till u canot normalize it any further


## SECOND NORMAL FORM (2NF)



    - Every column is functionally dependent on Primary key
    - FUNCTIONAL DEPENDENCY -> Without Primary key, that column cannot function
    - 

7. only the non-key elements are examined for inter-dependencies
8. Inter-dependent columns are to be removed into a new table
![alt text](image-36.png)

9. Key-element will be the primary key of the new table ,  and the primary key of the new table,that column,  it is the be retained in the orignal table for relationship purposes.
![alt text](image-37.png)
![alt text](image-38.png)

## THIRD NORMAL FORM (3NF)

![alt text](image-40.png)
![alt text](image-41.png)

![alt text](image-42.png)
