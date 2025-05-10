# 🎓 Student Bonus Management System
This is a full-stack web application that allows instructors to manage student bonuses, which reduce the student's next-year inscription (registration) fees. It also includes a secure login system for both instructors and students.

Built with **Spring Boot**, **React**, **PostgreSQL**, and **Axios**.
## ✨ Features:
### 🔐 Authentication
- Instructor login
- Student login  
  
### 🧑‍🏫 Instructor Panel
- ➕ Add a student
- ❌ Delete a student
- 🎁 Attribute bonuses
- 📉 Apply fee reductions
- 📧 **Notify students by email when a bonus is attributed (JavaMailSender)**
### 👨‍🎓 Student Panel
- 📜 View bonus history (instructor, amount, date)  

## 🛠️ Tech_Stack:
- **Frontend**: React.js,
- **Backend**: Spring Boot, Jakarta Servlet API (for HttpSession management)
- **Database**: PostgreSQL
- **communication client_server: Axios**
- **Email Service**: JavaMailSender (Spring Boot Starter Mail)
- **Other**: CORS configuration
## ⚙️ Setup_Instructions:
### Java Mail configuration:
To use this project, you need to add your own email credentials for authentication.
Follow these steps:  
Open the config or properties file .  
Add your email address.  
Generate a Google App Password and add it in place of the email password.  
Note: Do not use your regular Google account password. Instead, generate an App Password by going to:
https://myaccount.google.com/apppasswords
You must have 2-Step Verification enabled to create an App Password.  

⚠️ For security reasons, do not share your credentials or commit them to the repository.  
### DataBase Configuration:
Make sure PostgreSQL is installed and running on your system.  
Create a local PostgreSQL database named student_bonus_db.  
Make sure your database credentials (host, port, user, password) are correctly set in your configuration file.
### 🖥️ Backend (Spring Boot):
1-Clone the repository:  
git clone https://github.com/zayneb-hamdi/BonusAppProject.git  
cd BonusAppProject/backend
2-Run the Spring Boot application:  
./mvnw spring-boot:run  
### 💻 Frontend (React):
cd ../frontend  
npm install  
npm start
## GUI:
![image](https://github.com/user-attachments/assets/efff992d-4f79-4932-8c3d-c6643abe4df3)
![image](https://github.com/user-attachments/assets/988c1579-2cff-4ec4-aec4-ad208d57a96a)
![image](https://github.com/user-attachments/assets/6321f538-ddfa-433c-a084-1652b37c1110)
![image](https://github.com/user-attachments/assets/0a990432-3017-4c8d-8eb0-a3355ec541f4)
![image](https://github.com/user-attachments/assets/52a5bb9d-0b99-40d7-8ea8-8331a0402f7d)


 ## Author:
 zayneb hamdi
