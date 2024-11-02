<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Invalid Customer Password</title>
    <style>
        /* Body styling to center the form vertically and horizontally */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f4f4f9;
            font-family: 'Arial', sans-serif;
        }

        /* Form container */
        form {
            background-color: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }

        /* Table layout inside the form */
        table {
            width: 100%;
        }

        /* Label cells for UserName, Password, etc. */
        td:first-child {
            text-align: right;
            font-weight: bold;
            padding-right: 15px;
            color: #333;
            width: 30%;
        }

        /* Input fields styling */
        input[type="text"] {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
            box-sizing: border-box;
        }

        /* Submit button styling */
        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 18px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        /* Hover effect for submit button */
        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        /* Error message styling */
        .error-message {
            color: red;
            font-size: 16px;
            font-weight: bold;
            text-align: center;
            margin-bottom: 20px;
        }

        /* Placeholder styling */
        input::placeholder {
            color: #aaa;
        }

        /* Responsive design for smaller screens */
        @media (max-width: 600px) {
            td:first-child {
                text-align: left;
                padding-bottom: 5px;
            }

            input[type="submit"] {
                font-size: 16px;
            }
        }
    </style>
</head>
<body>
    <form action="/car-service-system1/CustomerLogin">
        <!-- Error message for invalid password -->
        <div class="error-message">Invalid customer password. Please try again.</div>

        <table>
            <tr>
                <td>UserName</td>
                <td><input type="text" name="username" placeholder="Enter your username"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="password" placeholder="Enter your password"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Login">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
