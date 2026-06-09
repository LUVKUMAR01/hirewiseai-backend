# hirewise-ai-backend
AI-powered Resume ATS + Mock Interview System using Spring Boot and Gemini AI with JWT authentication, Swagger API documentation, and RESTful backend architecture.

🚀 AI Resume ATS & Mock Interview System

An AI-powered backend system that evaluates resumes against job descriptions and generates interview questions with AI-based scoring and feedback using Google Gemini AI.

🔥 Features
📄 Resume vs Job Description Matching
🤖 AI-powered skill gap analysis (Gemini AI)
🎤 Mock interview question generation
📊 Answer evaluation with score (0–10 / 100)
🔐 JWT Authentication system
📚 Swagger API documentation
🧠 AI-based resume improvement suggestions
💾 Database integration (MySQL)


🧠 Tech Stack
Java 17
Spring Boot
Spring Security (JWT)
Spring Data JPA
MySQL
Gemini AI API
Swagger / OpenAPI
Maven


🏗️ System Architecture
User (Postman / Swagger)
        ↓
Spring Boot REST APIs
        ↓
Business Logic Layer
        ↓
Gemini AI API (LLM)
        ↓
Response Processing
        ↓
MySQL Database



📌 Main Modules
1. Authentication Module
* Register user
* Login user
* JWT token generation
  
2. Resume ATS Module
* Resume analysis
* Job description matching
* Skill gap detection
  
3. Mock Interview Module
* AI-generated questions
* Answer evaluation
* Score + feedback


🔗 API Endpoints
Auth APIs
POST /auth/register
POST /auth/login

Resume APIs
POST /resume/match

Interview APIs
POST /mock-interview/evaluate

📚 Swagger API Docs
http://localhost:8080/swagger-ui/index.html

🚀 How to Run Locally
1. Clone repo
git clone https://github.com/your-username/your-repo.git
2. Configure DB
spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=root
spring.datasource.password=your_password
3. Run project
mvn spring-boot:run

🧪 Sample Request
Resume Match API
{
  "resume": "Java Developer with Spring Boot, MongoDB, REST APIs",
  "jobDescription": "Looking for Java Developer with Spring Boot, Microservices, AWS, Docker"
}

📊 Output Example
{
  "matchPercentage": 75,
  "missingSkills": "AWS, Docker",
  "suggestions": "Improve cloud and DevOps skills"
}

💡 Key Learnings
* AI integration with backend systems
* REST API design and architecture
* JWT authentication
* Prompt engineering with Gemini AI
* Spring Boot production structure

🚀 Future Improvements
* React frontend dashboard
* Resume PDF upload
* Deployment on AWS/Render
* Docker containerization
* CI/CD pipeline (GitHub Actions)
  

👨‍💻 Author
Luv Kumar

📬 Contact

- Email: your-email@gmail.com  
- LinkedIn: https://linkedin.com/in/your-profile  
- GitHub: https://github.com/your-username

## 📌 Project Status

✔ Backend Completed  
✔ AI Integration Done  
✔ Swagger Added  
🚀 Deployment Coming Soon

## 📄 License

This project is open-source and available for learning purposes.

## 🙏 Thank You

Thank you for checking out this project.
