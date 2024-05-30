CREATE TABLE IF NOT EXISTS PATIENT_ENTITY
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(255),
    medical_index INT
);

CREATE TABLE IF NOT EXISTS MEDICAL_UNIT_ENTITY
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(255),
    medical_index INT
);