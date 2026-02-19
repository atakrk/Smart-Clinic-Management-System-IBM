# Database Schema Design

This project uses a hybrid database architecture:

- **MySQL** → Structured relational data (patients, doctors, appointments)
- **MongoDB** → Flexible document-based data (prescriptions)

---

# MySQL Database Design

Relational data ensures strong consistency and proper relationships between core entities.

## Table: patients

| Column Name   | Data Type     | Constraints |
|--------------|--------------|------------|
| id           | INT          | PK, AUTO_INCREMENT |
| name         | VARCHAR(100) | NOT NULL |
| email        | VARCHAR(100) | NOT NULL, UNIQUE |
| phone_number | VARCHAR(15)  | NOT NULL |
| date_of_birth| DATE         |  |
| gender       | VARCHAR(10)  |  |
| registered_at| TIMESTAMP    | DEFAULT CURRENT_TIMESTAMP |

---

## Table: doctors

| Column Name   | Data Type     | Constraints |
|--------------|--------------|------------|
| id           | INT          | PK, AUTO_INCREMENT |
| name         | VARCHAR(100) | NOT NULL |
| specialization | VARCHAR(100) | NOT NULL |
| email        | VARCHAR(100) | NOT NULL, UNIQUE |
| phone_number | VARCHAR(15)  |  |
| is_active    | BOOLEAN      | DEFAULT TRUE |

---

## Table: appointments

| Column Name     | Data Type | Constraints |
|----------------|----------|------------|
| id             | INT      | PK, AUTO_INCREMENT |
| patient_id     | INT      | FK → patients(id), NOT NULL |
| doctor_id      | INT      | FK → doctors(id), NOT NULL |
| appointment_time | DATETIME | NOT NULL |
| status         | INT      | DEFAULT 0 (0=Scheduled, 1=Completed, 2=Cancelled) |
| created_at     | TIMESTAMP| DEFAULT CURRENT_TIMESTAMP |

---

## Table: admin

| Column Name   | Data Type     | Constraints |
|--------------|--------------|------------|
| id           | INT          | PK, AUTO_INCREMENT |
| username     | VARCHAR(50)  | NOT NULL, UNIQUE |
| password_hash| VARCHAR(255) | NOT NULL |
| email        | VARCHAR(100) | NOT NULL, UNIQUE |
| role         | VARCHAR(50)  | DEFAULT 'superadmin' |

---

# MongoDB Collection Design

MongoDB is used for flexible prescription records.

## Collection: prescriptions

```json
{
  "appointmentId": 103,
  "patientId": 23,
  "doctorId": 7,
  "patientName": "Elena Ruiz",
  "medications": [
    { "name": "Amoxicillin", "dosage": "500mg", "frequency": "3x/day", "duration": "7 days" },
    { "name": "Ibuprofen", "dosage": "200mg", "frequency": "as needed" }
  ],
  "doctorNotes": "Follow up in 1 week.",
  "issuedAt": "2025-07-03T10:15:00Z"
}