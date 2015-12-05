<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Home</title>

        <!-- css -->
        <link rel="stylesheet" href="css/style.css">

        <!-- scripts -->
        <script src="js/lib/jquery.min.js"></script>
    </head>

    <body>

        <!-- ================================================== -->
        <!-- wrapper -->
        <!-- ================================================== -->
        <div id="home_main_screen">

            <!-- title, description and login/sign up -->
            <div id="home_info_container">

                <!-- title -->
                <h1 id="home_title">DokuAdmin</h1>

                <!-- description -->
                <span id="home_description">The best place to learn is wherever you want</span>

                <!-- login/sign up -->
                <div id="home_buttons_container">
                
                    <a id="home_login_button" href="#!">Login</a>
                    
                </div>
            </div>
        </div>




        <!-- ================================================== -->
        <!-- login window -->
        <!-- ================================================== -->
        <div id="home_dark_foreground"></div>

        <div class="home_form_window" id="home_login_window">

            <h1>Login</h1>

            <form id="login_form" action="RedirectAfterLogin" method = "post">

                <div class="home_form_window_input_container">

                    <input class="home_form_window_input" type="text" placeholder="Username" name="username" required>
                    <input class="home_form_window_input" type="password" placeholder="Password" name="password" required>
                </div>

                <div class="home_form_window_form_buttons_container" id="home_login_form_buttons_container">

                    <input class="home_form_window_send_button" id="home_login_send_button" type="submit" value="Enter">
                    <a class="home_form_window_cancel_button" id="home_login_cancel_button" href="#!">Cancel</a>
                </div>
            </form>
        </div>




       

        <!-- ================================================== -->
        <!-- scripts -->
        <!-- ================================================== -->
        <script src="js/access_page/login_window.js"></script>
        <script src="js/access_page/custom_input.js"></script>

        <!-- typejs -->
        <style>

            body {
                font-size: 1.2vw;
                max-font-size: 16px;
                min-font-size: 14px;
            }


            /*main screen*/
            #home_title {
                font-size: 6vw;
                max-font-size: 70px;
                min-font-size: 50px;
            }

            #home_description {
                font-size: 2vw;
                max-font-size: 20px;
                min-font-size: 18px;
            }


            /*form screen*/
            .home_form_window h1 {
                font-size: 3vw;
                max-font-size: 30px;
                min-font-size: 25px;
            }

            .home_form_window_input {
                font-size: 1.4vw;
                max-font-size: 18px;
                min-font-size: 16px;
            }

            .home_form_window_send_button,
            .home_form_window_cancel_button,
            #home_login_button {
                font-size: 1.2vw;
                max-font-size: 14px;
                min-font-size: 12px;
            }
        </style>
        <script src="js/lib/type.js"></script>

    </body>
</html>
