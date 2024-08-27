<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us - Culture Colombo</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="contact-container">
        <h2>Contact Us</h2>
        <form action="QueryServlet" method="post">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" required>
            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>
            <label for="phone">Phone</label>
            <input type="text" id="phone" name="phone" required>
            <label for="message">Message</label>
            <textarea id="message" name="message" required></textarea>
            <button type="submit" class="btn">Submit</button>
        </form>
    </div>
</body>
</html>
