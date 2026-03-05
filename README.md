# Job Seekers Platform

A Spring Boot application for managing job seekers, job postings, and employer interactions with Neo4j graph database support.

## 🚀 Tech Stack

- **Backend**: Spring Boot 3.x
- **Database**: Neo4j (Graph Database)
- **Build**: Maven
- **Java**: 17+
- **Container**: Docker & Kubernetes

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.8+
- Neo4j 4.4+ (or Docker)
- Git

## ⚙️ Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/YOUR_USERNAME/jobseekers.git
cd jobseekers
```

### 2. Configure Neo4j Connection

Edit `src/main/resources/application.properties`:

```properties
spring.neo4j.uri=bolt://localhost:7687
spring.neo4j.authentication.username=neo4j
spring.neo4j.authentication.password=your-password

spring.application.name=jobseekers
server.port=8080
```

### 3. Start Neo4j

**Option A: Using Docker**
```bash
docker run -d \
  --name neo4j \
  -p 7687:7687 \
  -p 7474:7474 \
  -e NEO4J_AUTH=neo4j/password \
  neo4j:4.4.39-community
```

**Option B: Local Installation**
- Download from [neo4j.com/download](https://neo4j.com/download/)
- Start the service

### 4. Build & Run

```bash
# Build the project
mvn clean package

# Run the application
mvn spring-boot:run

# Or run the JAR
java -jar target/jobseekers-0.0.1-SNAPSHOT.jar
```

The application will be available at `http://localhost:8080`

## 📦 Project Structure

```
jobseekers/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/jobseekers/
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       ├── model/
│   │   │       └── JobSeekersApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── k8s/
│   ├── neo4j-statefulset.yaml
│   └── deployment.yaml
├── pom.xml
├── README.md
└── .gitignore
```

## 🛠️ Key Features

- [x] Job Seeker Management
- [x] Job Posting Management
- [x] Neo4j Integration
- [x] RESTful APIs
- [ ] Authentication & Authorization
- [ ] Job Recommendation Engine
- [ ] Kubernetes Deployment

## 📝 API Endpoints

### Job Seekers
```
GET    /api/jobseekers           - List all job seekers
GET    /api/jobseekers/{id}      - Get specific job seeker
POST   /api/jobseekers           - Create new job seeker
PUT    /api/jobseekers/{id}      - Update job seeker
DELETE /api/jobseekers/{id}      - Delete job seeker
```

### Job Postings
```
GET    /api/jobs                 - List all jobs
GET    /api/jobs/{id}            - Get specific job
POST   /api/jobs                 - Create new job posting
```

## 🐳 Docker Deployment

### Build Docker Image
```bash
docker build -t jobseekers:latest .
docker run -p 8080:8080 \
  --link neo4j:neo4j \
  -e SPRING_NEO4J_URI=bolt://neo4j:7687 \
  jobseekers:latest
```

### Kubernetes Deployment
```bash
kubectl apply -f k8s/neo4j-statefulset.yaml
kubectl apply -f k8s/deployment.yaml
```

## 📊 Database Schema

### Node Types
- **JobSeeker**: User profile with skills, experience
- **Job**: Job posting with requirements
- **Company**: Employer company details

### Relationships
- `JobSeeker -[:HAS_SKILL]-> Skill`
- `JobSeeker -[:APPLIED_FOR]-> Job`
- `Job -[:POSTED_BY]-> Company`

## 🔐 Security Notes

- Never commit `application-prod.properties` with credentials
- Use environment variables for sensitive data
- Implement Spring Security for production
- Use Secret management in Kubernetes

## 🧪 Testing

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=JobSeekerRepositoryTest
```

## 🚀 Future Enhancements

- [ ] Advanced search and filtering
- [ ] Job recommendations using Neo4j queries
- [ ] Real-time notifications
- [ ] User authentication with JWT
- [ ] Admin dashboard

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👥 Contributors

- Your Name (@your-github-username)

## 📧 Contact

For questions or suggestions, please reach out to your-email@example.com

## 📚 Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data Neo4j](https://spring.io/projects/spring-data-neo4j)
- [Neo4j Documentation](https://neo4j.com/docs/)
- [Kubernetes Documentation](https://kubernetes.io/docs/)
