# 🪑 Furniture Shopping Cart Web Application

## 📌 Project Overview

This project is a **Furniture Shopping Cart Web Application** developed using **Java (JSP & Servlets)**.
The system allows users to browse furniture products like **tables, sofas, and wooden items**, add them to a cart, and manage their shopping experience.

---

## 🚀 Features

* 🛒 Add to Cart functionality
* 🪑 View Furniture Products (Tables, Sofas, Wooden Items)
* ❌ Remove items from cart
* 🔄 Update quantity
* 👤 User session management
* 💰 Total price calculation

---

## 🛠️ Technologies Used

* Java (JSP, Servlets)
* HTML, CSS
* JavaScript
* MySQL Database
* Apache Tomcat Server

---

## 📂 Project Structure

FurnitureShoppingCart/
│── src/
│   ├── servlet/
│   ├── dao/
│   ├── model/
│── WebContent/
│   ├── jsp/
│   ├── css/
│   ├── js/
│── database/
│   └── furniture.sql

---

## 🧑‍💻 Modules

### 1. Product Module

* Display all furniture items
* Categories: Table, Sofa, Wooden Products

### 2. Cart Module

* Add product to cart
* Remove product
* Update quantity

### 3. User Module

* Session handling
* Login (optional if added)

---

## 🗄️ Database Design

### Table: products

* id (int)
* name (varchar)
* price (double)
* category (varchar)
* image (varchar)

### Table: cart

* id (int)
* product_id (int)
* quantity (int)

---

## ⚙️ How to Run Project

1. Install Apache Tomcat
2. Install MySQL
3. Import database using `furniture.sql`
4. Deploy project on Tomcat server
5. Run project in browser:
   http://localhost:8081/EcommerceProject/

---

## 📸 Screenshots

### 🏠 Home Page

![Home](screenshots/home.png)
![login](screenshots/login.png)
![registration](screenshots/registration.png)
![product](screenshots/product.png)
![contactus](screenshots/contactus.png)
![Services](screenshots/services.png)
![Add to Cart](screenshots/addtocart.png)
---

## 🎯 Future Enhancements

* Online payment integration
* Admin panel
* Product search & filter
* User authentication system

---

## 🙋‍♂️ Author

**Sumit Avinash Jadhav**
MCA Graduate | Java Developer

---

## 📌 Conclusion

This project demonstrates a complete **E-commerce Shopping Cart system** using Java technologies and helps understand real-world web development concepts.

---
