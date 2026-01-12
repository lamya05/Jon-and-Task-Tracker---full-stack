# 📊 Job Tracker - Fullstack Application

This is a professional **Job Application and Habit Tracker** built using a modern fullstack architecture. It allows users to track their career progress and daily habits in one place.

## 🚀 Key Features
* **Authentication:** Secure user login and registration system.
* **Job Tracking:** Add, delete, and monitor job applications (Company, Role, Status).
* **Habit Management:** Weekly habit tracker to maintain consistency.
* **REST API:** Robust backend with 3 specialized controllers (User, Job, Habit).
* **Persistence:** All data is stored securely in a MySQL database.

## 🛠️ Technology Stack
Backend: Java 21, Spring Boot 3.5.x, Hibernate (JPA).
Frontend: HTML5, CSS3 (Modern UI), JavaScript (Fetch API).
Database:MySQL 8.0.
Server: Tomcat (Running on Port **8081**).

## ⚙️ How to Run

### 1. Backend (Spring Boot)
1. Navigate to the `Backemd` folder.
2. Configure your MySQL credentials in `src/main/resources/application.properties`.
3. Run the application via your IDE or terminal: `./mvnw spring-boot:run`.
4. The API will be live at `http://localhost:8081`.

### 2. Frontend
1. Navigate to the `Frontend` folder.
2. Open `login.html` using a browser or Live Server.
3. Ensure the JavaScript fetch calls are pointing to `http://localhost:8081`.

## 📂 Project Structure
```text
Job Tracker- fullstack/
├── Backemd/          # Spring Boot Java Source Code
├── Frontend/         # HTML, CSS, and JS Files
└── README.md         # Documentation
