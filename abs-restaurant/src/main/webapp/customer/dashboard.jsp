<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Submit Query - Culture Colombo</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <div class="submit-query-container">
        <h2>Submit a Query</h2>
        <form action="QueryServlet" method="post">
            <label for="message">Message</label>
            <textarea id="message" name="message" required></textarea>
            <button type="submit" class="btn">Submit</button>
        </form>
    </div>
</body>
</html>
