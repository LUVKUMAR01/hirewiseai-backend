🚀 HireWise AI - Resume ATS & Mock Interview System
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)
![Spring Security](https://img.shields.io/badge/Spring_Security-JWT-blue)
![Database](https://img.shields.io/badge/Database-MySQL-blue)
![AI](https://img.shields.io/badge/AI-Gemini-purple)
![License](https://img.shields.io/badge/License-MIT-green)

AI-powered Resume ATS + Mock Interview System using Spring Boot and Gemini AI with JWT authentication, Swagger API documentation, and RESTful backend architecture.

An **AI-powered Resume ATS & Mock Interview System** built using **Spring Boot**, **Spring Security**, **JWT Authentication**, **Spring Data JPA**, **MySQL**, and **Google Gemini AI**.

The application automates resume evaluation, compares resumes against job descriptions, identifies missing skills, generates ATS scores, creates AI-powered interview questions, and provides personalized improvement suggestions.


he application automates resume evaluation, compares resumes against job descriptions, identifies missing skills, generates ATS scores, creates AI-powered interview questions, and provides personalized improvement suggestions.

---

# 📑 Table of Contents

- Overview
- Features
- Tech Stack
- System Architecture
- Project Flow
- Folder Structure
- REST APIs
- Installation
- Running the Project
- Sample Request & Response
- Key Learnings
- Future Enhancements
- Author

---

# 📌 Overview

The system can:

- Analyze resumes
- Compare resumes with Job Descriptions
- Generate ATS Scores
- Identify missing keywords
- Recommend improvements
- Generate AI-powered interview questions
- Evaluate interview answers

---

# ✨ Features

## Authentication

- User Registration
- User Login
- JWT Authentication
- Protected REST APIs

---

## Resume ATS

- Resume Analysis
- Resume vs Job Description Matching
- ATS Score Generation
- Missing Keyword Detection
- AI Skill Extraction
- Resume Improvement Suggestions

---

## Mock Interview

- AI Question Generation
- Answer Evaluation
- Score Generation
- Feedback Generation

- # 🛠 Tech Stack

| Category | Technologies |
|-----------|--------------|
| Language | Java 17 |
| Framework | Spring Boot |
| Security | Spring Security, JWT |
| Database | MySQL |
| ORM | Spring Data JPA |
| AI | Google Gemini API |
| Documentation | Swagger/OpenAPI |
| Build Tool | Maven |

---

# 🏗 System Architecture

```text
                    User
           (Swagger / Postman)

                    │

                    ▼

          Spring Boot REST APIs

                    │

      ┌─────────────┼─────────────┐

      ▼             ▼             ▼

Authentication   Resume ATS   Mock Interview

      │             │             │

      └─────────────┼─────────────┘

                    ▼

          Google Gemini AI

                    ▼

          Spring Data JPA

                    ▼

                 MySQL
```

---

# 🔄 Project Flow

```text
User Login

     │

     ▼

JWT Authentication

     │

     ▼

Upload Resume

     │

     ▼

Resume Parsing

     │

     ▼

Gemini AI

     │

     ├── ATS Score

     ├── Skill Extraction

     ├── Missing Keywords

     ├── Resume Suggestions

     └── Interview Questions

     │

     ▼

Store Results

     │

     ▼

Return JSON Response
```

---

# 📂 Folder Structure

```text
src
├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── config
├── exception
└── util

# 🔗 REST APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /auth/register | Register User |
| POST | /auth/login | Login User |
| POST | /resume/match | Resume Analysis |
| POST | /mock-interview/evaluate | Interview Evaluation |

# ⚙ Installation

bash
git clone https://github.com/LUVKUMAR01/hirewiseai-backend.git

cd hirewiseai-backend

🚀 How to Run Locally

Clone repo git clone https://github.com/your-username/your-repo.git
Configure DB spring.datasource.url=jdbc:mysql://localhost:3306/your_db spring.datasource.username=root spring.datasource.password=your_password
Run project mvn spring-boot:run


Configure

```properties
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=

GEMINI_API_KEY=
JWT_SECRET=
```

Run

```bash
mvn spring-boot:run
```

---

# 📤 Sample Request

```json
{
  "resume": "...",
  "jobDescription": "..."
}
# 📥 Sample Response

```json
{
  "matchPercentage":85,
  "missingSkills":["Docker","AWS"],
  "atsScore":82,
  "suggestions":"Improve cloud skills"
}
```

---

# 🔐 Security

- Spring Security
- JWT Authentication
- Protected REST APIs
- Stateless Authentication
- Role-based Authorization

---

# 📖 Key Learnings

- Spring Boot REST API Design
- Spring Security + JWT
- Google Gemini AI Integration
- Prompt Engineering
- Database Design using JPA
- AI-powered Resume Evaluation
- Production-ready Backend Architecture

---

# 🚀 Future Enhancements

- React Frontend
- Docker Deployment
- AWS Deployment
- CI/CD using GitHub Actions
- Email Notification
- Redis Caching
- Kafka Event Processing

---

# 👨‍💻 Author

**Luv Kumar**

Java Backend Developer

GitHub: https://github.com/LUVKUMAR01

LinkedIn: *(Add your profile link)*

---

# ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub.
