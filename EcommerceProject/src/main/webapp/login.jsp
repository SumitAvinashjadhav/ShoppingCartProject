<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Login | Furni</title>
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap');

  /* Reset */
  * {
    margin: 0; padding: 0; box-sizing: border-box;
  }

  body {
    font-family: 'Poppins', sans-serif;
    background-color: #365249; /* Dark green from image */
    color: #f0f0f0;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .container {
    background-color: #4b6b5f; /* Slightly lighter green */
    padding: 40px 50px;
    border-radius: 20px;
    width: 350px;
    box-shadow: 0 20px 40px rgba(0,0,0,0.3);
  }

  h2 {
    font-weight: 600;
    margin-bottom: 30px;
    font-size: 28px;
    text-align: center;
    color: #f9bf29; /* Gold/yellow accent */
  }

  label {
    display: block;
    margin-bottom: 8px;
    font-weight: 600;
    font-size: 14px;
    color: #e4e4e4;
  }

  input[type="email"],
  input[type="password"] {
    width: 100%;
    padding: 12px 15px;
    margin-bottom: 25px;
    border-radius: 10px;
    border: none;
    font-size: 16px;
    outline: none;
    background-color: #2f483f;
    color: #f0f0f0;
    transition: background-color 0.3s ease;
  }

  input[type="email"]:focus,
  input[type="password"]:focus {
    background-color: #3e5c4a;
  }

  button {
    width: 100%;
    padding: 12px;
    background-color: #f9bf29; /* gold accent */
    border: none;
    border-radius: 12px;
    font-weight: 600;
    font-size: 16px;
    cursor: pointer;
    color: #365249;
    transition: background-color 0.3s ease;
  }

  button:hover {
    background-color: #c89b21;
  }

  p {
    text-align: center;
    margin-top: 20px;
    color: #e4e4e4;
  }

  a {
    color: #f9bf29;
    font-weight: 600;
    text-decoration: none;
  }

  a:hover {
    text-decoration: underline;
  }
</style>
</head>
<body>

<div class="container">
  <h2>User Login</h2>
  <form action="LoginServlet" method="get">
    <label for="email">Email address</label>
    <input type="email" id="email" name="email" placeholder="Enter email" required />

    <label for="password">Password</label>
    <input type="password" id="password" name="password" placeholder="Password" required />

    <button type="submit">Login</button>

    <p>Don't have an account? <a href="register.jsp">Register here</a></p>
  </form>
</div>

</body>
</html>
