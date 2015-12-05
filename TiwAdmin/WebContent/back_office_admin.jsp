<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beansPackage.*, beansPackage.CourseBean, beansPackage.DataStore, java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


   <%session = request.getSession();
   AdminBean bean = ((AdminBean) session.getAttribute("validated_bean_session"));%>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DokuAdmin</title>

        <!-- css -->
        <link rel="stylesheet" href="css/style.css">

        <!-- scripts -->
        <script src="js/lib/jquery.min.js"></script>
    </head>

    <body>


        <!-- ================================================== -->
        <!-- nav -->
        <!-- ================================================== -->
        <nav class="desktop_nav">

            <!-- logo -->
            <span class="desktop_nav_logo">DokuAdmin</span>

            <div class="desktop_nav_buttons_container">

                <!-- search -->
                <form action="" class="desktop_nav_search_form">
                    <input id="desktop_nav_search_input" type="text" placeholder="Search courses" name="search">
                    <a href="#!"><img src="img/nav_menu/search.png" alt="search"></a>
                    <input type="hidden" value="submit">
                </form>

                <!-- menu -->
                <a class="desktop_nav_open_menu open_menu" id="open_desktop_menu" href="#!"><img src="img/nav_menu/open_menu.png" alt="open_menu"></a>
            </div>
        </nav>




        <!-- ================================================== -->
        <!-- menu -->
        <!-- ================================================== -->
        <div id="desktop_menu">

            <!-- close button -->
            <a id="close_desktop_menu" href="#!"><img src="img/nav_menu/close.png" alt="close menu"></a>

            <!-- menu list -->
            <ul>
                <li><a href="#!">
                    <img src="img/nav_menu/list.png" alt="list">
                    <span>Course list</span>
                </a></li>

                <!-- if it is admin, do not show this list element -->
                <li><a href="#!">
                    <img src="img/nav_menu/user.png" alt="profile">
                    <span>Public profile</span>
                </a></li>

                <!-- if it is teacher or admin, show this list element -->
                <li><a href="#!">
                    <img src="img/nav_menu/settings.png" alt="back_office">
                    <span>Back office</span>
                </a></li>

                <li><a href="LogOut">
                    <img src="img/nav_menu/log_out.png" alt="log_out">
                    <span>Log out</span>
                </a></li>
            </ul>
        </div>




        <!-- ================================================== -->
        <!-- main wrapper -->
        <!-- ================================================== -->
       <%
       	List<Object> courses = (List<Object>) session.getAttribute("courses");
		%>
       
        <div class="main_wrapper admin_wrapper">

            <h1 class="main_wrapper_title">DokuAdmin</h1>

            <!-- courses section -->
            <section class="admin_courses_section">

                <!-- courses table -->
                <h2 class="section_title">Courses</h2>

                <div class="admin_table_container">

                    <table id="admin_courses_table">

                        <!-- table head -->
                        <thead>
                            <tr>
                                <th>Course</th>
                                <th>Category</th>
                                <th>Teacher</th>
                                <th>Duration (hours)</th>
                                <th>Income (€)</th>
                                <th>Validated</th>
                                <th>Action</th>
                            </tr>
                        </thead>

                        <!-- table body -->
                        <tbody>
                      <%  
                         for (Object course:courses){
                      %>
                            <tr>
                                <td><a href="#!"><%=((CourseBean)course).getTitle()%></a></td>
                                <td><a href="#!"><%=((CourseBean)course).getSyllabus()%></a></td>
                                <td><a href="#!"><%=((CourseBean)course).getProfessorID()%></a></td>
                                <td><%=((CourseBean)course).getDuration()%></td>
                                <td><%=((CourseBean)course).getPrice()%></td>
                                <%if(((CourseBean)course).isValidated()){%>
                                	<td> Yes</td>
                                <%} else {%>
                                	<td class="not_validated_course">
	                                    <form action="ValidateCourse" method = "post">
	                                        <input type="hidden" name="Validate" value="<%=((CourseBean)course).getID()%>">
	                                        <input class="validate_course_button" type="submit" value="Validate">
	                                    </form>
                                    </td>
                                <%}%>
                                  <td class="delete_course">
                                    <form  action="DeleteCourse"  method = "post">
                                        <input type="hidden" name ="Delete" value="<%=((CourseBean)course).getID()%>">
                                        <input class="delete_course_button" type="submit" value="Delete">
                                    </form>
                                </td>
                            </tr>
                            
                    <%
                		}
               		%>
                        </tbody>
                    </table>
                </div>


            </section>


		<%
       		List<Object> users = (List<Object>) session.getAttribute("users");
		%>


            <!-- users section -->
            <section class="admin_users_section">

                <!-- courses table -->
                <h2 class="section_title">Users</h2>

                <div class="admin_table_container">

                    <table id="admin_users_table">

                        <!-- table head -->
                        <thead>
                            <tr>
                                <th>Username</th>
                                <th>Role</th>
                                <th>Action</th>
                            </tr>
                        </thead>

                        <!-- table body -->
                        <tbod>                    
                         	<%  
                         		for (Object user:users){
                     		 %>
                            <tr>
                                <td><a href="#!"><%=((UserBean) user).getName()%></a></td>
                                <%if(((UserBean) user).getCategory() == '1'){%>
                               		<td>Teacher</td>
                                 <%} else {%>
                                 	<td>Student</td>
                                 	<%}%>
                                <td class="delete_user">
                                     <form action="DeleteUser" method = "post">
										<input type="hidden" name ="DeleteUser" value="<%=((UserBean) user).getNickname()%>">                                      
                                    	<input class="delete_user_button" type="submit" value="Delete">
                                    </form>
                                </td>
                            </tr>
							<%
	                			}
	               			%>
                        </tbod>
                    </table>
                </div>


            </section>
        </div>




        <!-- ================================================== -->
        <!-- footer -->
        <!-- ================================================== -->
        <footer>
            <span>DokuLearning, 2015</span>
        </footer>




        <!-- ================================================== -->
        <!-- scripts -->
        <!-- ================================================== -->
        <!-- menu -->
        <script src="js/nav_menu/search_input.js"></script>
        <script src="js/nav_menu/menu.js"></script>

        <!-- typejs -->
        <style>

            /*global*/
            body {
                font-size: 1.2vw;
                max-font-size: 16px;
                min-font-size: 14px;
            }

            .section_title {
                font-size: 2vw;
                max-font-size: 30px;
                min-font-size: 25px;
            }

        </style>
        <script src="js/lib/type.js"></script>
    </body>
</html>