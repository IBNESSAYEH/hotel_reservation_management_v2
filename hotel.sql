CREATE TABLE room (
                      roomID SERIAL PRIMARY KEY,
                      category VARCHAR(50) NOT NULL,
                      price DECIMAL(10, 2) NOT NULL,
                      roomNumbers INT NOT NULL,
                      Tarif DECIMAL(10, 2),
                      roomSize INT,
                      hotelId INT NOT NULL,
                      FOREIGN KEY (hotelId) REFERENCES hotel(hotelId) ON DELETE CASCADE
);

-- Création de la table hotel
CREATE TABLE hotel (
                       hotelId SERIAL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       balance DECIMAL(10, 2) DEFAULT 0
);

-- Création de la table guest
CREATE TABLE guest (
                       guestId SERIAL PRIMARY KEY,
                       fullName VARCHAR(100) NOT NULL,
                       cin VARCHAR(50) NOT NULL UNIQUE,
                       email VARCHAR(100) NOT NULL,
                       phone VARCHAR(20),
                       balance DECIMAL(10, 2) DEFAULT 0
);

-- Création de la table reservation
CREATE TABLE reservation (
                             reservationID SERIAL PRIMARY KEY,
                             startDate DATE NOT NULL,
                             endDate DATE NOT NULL,
                             roomTypeId INT NOT NULL,
                             refundAmount DECIMAL(10, 2),
                             isCanceled BOOLEAN DEFAULT FALSE,
                             guestId INT NOT NULL,
                             hotelId INT NOT NULL,
                             FOREIGN KEY (roomTypeId) REFERENCES roomType(roomTypeId) ON DELETE CASCADE,
                             FOREIGN KEY (guestId) REFERENCES guest(guestId) ON DELETE CASCADE,
                             FOREIGN KEY (hotelId) REFERENCES hotel(hotelId) ON DELETE CASCADE
);
