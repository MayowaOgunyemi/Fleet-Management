DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Customers;
DROP TABLE IF EXISTS Roles;
DROP TABLE IF EXISTS UserRoles;
DROP TABLE IF EXISTS Permissions;
DROP TABLE IF EXISTS RolePermissions;
DROP TABLE IF EXISTS Vehicles;
DROP TABLE IF EXISTS ReservationStatus;
DROP TABLE IF EXISTS RentalRequests;
DROP TABLE IF EXISTS VehicleReservation;


-- User Authentication and Authorization

-- Users Table
CREATE TABLE Users (
   UserID INT AUTO_INCREMENT PRIMARY KEY,
   email VARCHAR(255) NOT NULL,
   PasswordHash VARCHAR(255) NOT NULL,
   SessionToken VARCHAR(255) NOT NULL
);

-- Customers Table
CREATE TABLE Customers (
   CustomerID INT AUTO_INCREMENT PRIMARY KEY,
   email VARCHAR(255) NOT NULL,
   PasswordHash VARCHAR(255) NOT NULL,
   SessionToken VARCHAR(255) NOT NULL
);

-- Configure User Roles and Permissions

-- Roles Table
CREATE TABLE Roles (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Role VARCHAR(255) NOT NULL,
    PermissionID INT REFERENCES Permissions(Id)
);

-- UserRoles Table
CREATE TABLE UserRoles (
   UserRolesID INT AUTO_INCREMENT PRIMARY KEY,
   UserID INT REFERENCES Users(UserID),
   RoleID INT REFERENCES Roles(Id)
);

-- Permissions Table
CREATE TABLE Permissions (
     Id INT AUTO_INCREMENT PRIMARY KEY,
     Name VARCHAR(255) NOT NULL
);

-- Manage Fleet
-- ReservationStatus Table
CREATE TABLE ReservationStatus (
                                   StatusID INT AUTO_INCREMENT PRIMARY KEY,
                                   Status VARCHAR(255) NOT NULL
);
-- Vehicles Table
CREATE TABLE Vehicles (
                          VehicleID INT AUTO_INCREMENT PRIMARY KEY,
                          Make VARCHAR(255) NOT NULL,
                          StatusID INT REFERENCES ReservationStatus(StatusID)
);

-- RentalRequests Table
CREATE TABLE RentalRequests (
                                RequestID INT AUTO_INCREMENT PRIMARY KEY,
                                CustomerID INT REFERENCES Customers(CustomerID),
                                VehicleID INT REFERENCES Vehicles(VehicleID),
                                RentalDate DATETIME NOT NULL,
                                ReturnDate DATETIME NOT NULL
);

-- Vehicles Reservations

-- VehicleReservation Table
CREATE TABLE VehicleReservation (
                                    ReservationID INT AUTO_INCREMENT PRIMARY KEY,
                                    RequestID INT REFERENCES RentalRequests(RequestID),
                                    ApprovedBy INT REFERENCES Users(UserID),
                                    ApprovalDateTime DATETIME NOT NULL
);
