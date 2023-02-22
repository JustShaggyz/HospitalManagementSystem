## Hospital Management System API

This is a Spring Boot API for managing hospitals, doctors, patients, and patient visits. When the API is started, it automatically creates 3 users with different roles:

- "user" with role ADMIN and password user_123 
- "doctor" with role DOCTOR and password doctor_123 
- "patient" with role PATIENT and password patient_123

The ADMIN has access to everything and can create everything. The DOCTOR can create patients, records, and visits, but cannot create hospitals and other doctors. The PATIENT cannot create anything, only view the data.

## Getting Started
To get started with the Hospital Management System API, follow these steps:
- Clone the repository to your local machine. 
- Open the project in your preferred IDE. 
- Run the application. 
- The API will be available at http://localhost:8080.

## Endpoints
The Hospital Management System API provides the following endpoints:
- GET /hospitals - Returns a list of registered hospitals. 
- GET /hospitals/create-hospital - Returns a page for creating a new hospital. 
- POST /hospitals/create - Creates a new hospital. 
- GET /hospitals/delete/{id} - Deletes the hospital with the specified ID.
- GET /doctors - Returns a list of doctors with the hospital they work at. 
- GET /doctors/create-doctor - Returns a page for creating a new doctor. 
- POST /doctors/create - Creates a new doctor.
- GET /patients - Returns a list of patients with their doctor. 
- GET /patients/create-patient - Returns a page for creating a new patient. 
- POST /patients/create - Creates a new patient.
- GET /records - Returns a list of patient records. 
- GET /records/getrecord - Returns a specific patient record. 
- GET /records/create-record - Returns a page for creating a new patient record. 
- POST /records/create - Creates a new patient record.
- GET /visits - Returns a list of patient visits. 
- GET /visits/create-visit - Returns a page for creating a new patient visit. 
- POST /visits/create - Creates a new patient visit. 
- GET /visits/search-diagnose - Returns a page for searching for patient visits by diagnosis. 
- POST /visits/diagnose - Returns a list of patient visits that match the given diagnosis.

All endpoints except for the login endpoint require authentication. The ADMIN, DOCTOR, and PATIENT users are authorized to access different endpoints as described in the previous section. You can authenticate by logging in with one of the 3 pre-configured users.
