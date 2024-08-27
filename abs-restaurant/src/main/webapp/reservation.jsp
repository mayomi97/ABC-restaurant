<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Make a Reservation - Culture Colombo</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="reservation-container">
        <h2>Make a Reservation</h2>
        <form action="ReservationServlet" method="post">
            <label for="type">Reservation Type</label>
            <select id="type" name="type" required>
                <option value="dine-in">Dine-In</option>
                <option value="delivery">Delivery</option>
            </select>
            <label for="date">Date</label>
            <input type="date" id="date" name="date" required>
            <label for="time">Time</label>
            <input type="time" id="time" name="time" required>
            <button type="submit" class="btn">Reserve</button>
        </form>
    </div>
</body>
</html>
