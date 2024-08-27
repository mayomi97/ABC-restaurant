<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - Culture Colombo</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="register-container">
        <h2>Register</h2>
        <form action="RegisterServlet" method="post">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" required>
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>
            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>
            <label for="phone">Phone</label>
            <input type="text" id="phone" name="phone" required>
            <button type="submit" class="btn">Register</button>
        </form>
    </div>
</body>
</html>
