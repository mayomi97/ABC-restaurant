<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>About Taste of Home</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        /* Custom styles for the About page */
        body {
            font-family: Arial, sans-serif;
            color: #333;
            background-color: #fff;
            margin: 0;
            padding: 0;
        }

        .about-container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 50px 20px;
        }

        .about-header {
            font-size: 48px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        .about-content {
            font-size: 18px;
            line-height: 1.6;
        }

        .about-content p {
            margin-bottom: 20px;
        }

        .footer {
            background-color: #000;
            color: #fff;
            padding: 20px;
            text-align: center;
        }

        .footer a {
            color: #fff;
            text-decoration: none;
        }

        .footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="about-container">
        <h1 class="about-header">Why ABC Restaurant?</h1>
        <div class="about-content">
        
        	<p>Two simple reasons. One simple Answer.</p>
            <p>
				We've created "Taste of Home," an experience that transcends dining and allows you to relive the coziness and cosiness of a classic home-cooked dinner. Our vision is to become the community's culinary hub, where the essence of regional cuisines and home cooking customs are cherished.Using only fresh seasonal ingredients sourced from local farms and the freshest catches from our seas, we take classic favorite dishes to the next level: spicy, rich curries versus the cool, creamy delight of buffalo curd.            </p>
            <p>
				Our space was designed to echo with the same charm and nostalgia one might find a bygone era when old-world elegance in the image of a traditional Walawwa met modern comforts. Be it the surroundings of colonial-inspired architecture or the soaking vintage ambiance, we want you to feel like you're dining in the warmth of home.            </p>
            <p>
				Our mural walls tell a story, a fusion from the colonial past to the cultural dynamism and flavors you taste on your plate. At the Taste of Home Restaurant, with every meal we prepare, there's that one thing we want you to experience: that reminiscence of the simplest and happiest experiences of home-cooked food. We are delighted that you chose to come along with us on this ride to share our passion and make our story a part of your own. We will not make it without you.            </p>
        </div>
    </div>

    <div class="footer">
        <div class="footer-container">
            <div class="footer-address">
                <h4>Taste of Home</h4>
                <p>Lotus Rd,Colombo 20010</p>
                <p>Email: reservations@tasteofhome.lk</p>
                <p>Phone: (+94) 76 222 4444</p>
            </div>
            <div class="footer-links">
                <a href="index.jsp">Home</a> | 
                <a href="menu.jsp">Menu</a> | 
                <a href="gallery.jsp">Gallery</a> | 
                <a href="reservation.jsp">Reservation</a> | 
                <a href="blog.jsp">Blog</a> | 
                <a href="contact.jsp">Contact</a>
            </div>
            <div class="footer-signup">
                <form>
                    <label for="email">Sign up for our newsletter:</label>
                    <input type="email" id="email" name="email" placeholder="Enter Your Email Address">
                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>
    </div>
</body>
</html>
