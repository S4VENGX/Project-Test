# MySQL Database Schema Design

## Database: hospital_management

### Tables and Relationships

#### 1. doctors
| Column Name | Data Type | Constraints |
|--------------|------------|--------------|
| doctor_id | INT | PRIMARY KEY, AUTO_INCREMENT |
| name | VARCHAR(100) | NOT NULL |
| specialization | VARCHAR(100) | NOT NULL |
| email | VARCHAR(100) | UNIQUE, NOT NULL |
| phone | VARCHAR(15) | NOT NULL |

#### 2. patients
| Column Name | Data Type | Constraints |
|--------------|------------|--------------|
| patient_id | INT | PRIMARY KEY, AUTO_INCREMENT |
| name | VARCHAR(100) | NOT NULL |
| dob | DATE | NOT NULL |
| gender | VARCHAR(10) | NOT NULL |
| address | VARCHAR(255) | NULL |
| phone | VARCHAR(15) | UNIQUE |

#### 3. appointments
| Column Name | Data Type | Constraints |
|--------------|------------|--------------|
| appointment_id | INT | PRIMARY KEY, AUTO_INCREMENT |
| patient_id | INT | FOREIGN KEY REFERENCES patients(patient_id) |
| doctor_id | INT | FOREIGN KEY REFERENCES doctors(doctor_id) |
| appointment_date | DATETIME | NOT NULL |
| status | VARCHAR(50) | DEFAULT 'Scheduled' |

#### 4. admin
| Column Name | Data Type | Constraints |
|--------------|------------|--------------|
| admin_id | INT | PRIMARY KEY, AUTO_INCREMENT |
| username | VARCHAR(50) | UNIQUE, NOT NULL |
| password | VARCHAR(255) | NOT NULL |

---

### ERD (Entity Relationship Diagram)
- One doctor can have many appointments.
- One patient can have many appointments.
- Admin manages both doctors and patients.
