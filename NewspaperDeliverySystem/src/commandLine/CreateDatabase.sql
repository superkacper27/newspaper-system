CREATE DATABASE newspaperSystem;

CREATE TABLE Customers(
    FirstName varchar(255),
    LastName varchar(255),
    Address varchar(255),
    PhoneNumber varchar(255),
    Eircode varchar(255),
    DeliveryDays varchar(255),
    Email varchar(255),
    id int
);

Describe Customer;

CREATE TABLE Orders(
    ID int,
    DaysOfDelivery varchar(255),
    Publications varchar(255)
);

Describe Orders;