<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	session = request.getSession();
	entities.Admin admin = (entities.Admin) session.getAttribute("validated_session");
	double totalSystemMoney = 0;
%>
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
       	List<entities.Course> courses = (List<entities.Course>) session.getAttribute("courses");
		%>
       
        <div class="main_wrapper admin_wrapper">

            <h1 class="main_wrapper_title">DokuAdmin</h1>

            <!-- courses section -->
            <section class="admin_courses_section">

                <!-- courses table -->
                <h2 class="section_title">Courses</h2>
                
                <!-- create special offer -->
                <p id="current_special_offer_text">Current Special Offer: <span>none</span></p>
                <form id="special_offer_form" action="">
                    <input required type="text" placeholder="Special Offer Code">
                    <input id="create_special_offer_button" type="submit" value="Create">
                </form>

                <div class="admin_table_container">

                    <table id="admin_courses_table">

                        <!-- table head -->
                        <thead>
                            <tr>
                                <th>Course</th>
                                <th>Category</th>
                                <th>Teacher</th>
                                <th>Duration (hours)</th>
                                <th>Price (€)</th>
                                <th>Income (€)</th>
                                <th>Validated</th>
                                <th>Action</th>
                            </tr>
                        </thead>

                        <!-- table body -->
                        <tbody>
                      <%  
                         for (entities.Course course:courses){
                      %>
                            <tr>
                                <td><a href="#!"><%=course.getTitle()%></a></td>
                                <td><a href="#!"><%=course.getSyllabus()%></a></td>
                                <td><a href="#!"><%=course.getProfessor()%></a></td>
                                <td><%=course.getDuration()%></td>
                                <td><%=course.getPrice()%></td>
                                <td><%=course.getMoneyForSystem() %></td>
                                <% totalSystemMoney += course.getMoneyForSystem(); %>
                                <%if(course.getValidated() == 1){%>
                                	<td> Yes</td>
                                <%} else {%>
                                	<td class="not_validated_course">
	                                    <form action="ValidateCourse" method = "post">
	                                        <input type="hidden" name="Validate" value="<%=course.getIdCourse()%>">
	                                        <input class="validate_course_button" type="submit" value="Validate">
	                                    </form>
                                    </td>
                                <%}%>
                                  <td class="delete_course">
                                    <form  action="DeleteCourse"  method = "post">
                                        <input type="hidden" name ="Delete" value="<%=course.getIdCourse()%>">
                                        <input class="delete_course_button" type="submit" value="Delete">
                                    </form>
                                </td>
                            </tr>
                            
                    <%
                		}
               		%>
                        </tbody>
                        
                        <tfoot>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td id="total_cell">Total</td>
                                <td><%=totalSystemMoney %></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </tfoot>
                    </table>
                </div>


            </section>


		<%
       		List<entities.Student> students = (List<entities.Student>) session.getAttribute("students");
			List<entities.Teacher> teachers = (List<entities.Teacher>) session.getAttribute("teachers");
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
                         		for (entities.Teacher teacher:teachers){
                     		 %>
                            <tr>
                                <td><a href="#!"><%=teacher.getNameTeacher()%></a></td>
                               	<td>Teacher</td>
                                <td class="delete_user">
                                     <form action="DeleteUser" method = "post">
										<input type="hidden" name ="DeleteUser" value="<%=teacher.getIdTeacher()%>">
										<input type="hidden" name ="UserType" value="1">                                       
                                    	<input class="delete_user_button" type="submit" value="Delete">
                                    </form>
                                </td>
                            </tr>
							<%
	                			}
	               			%>
	               			
	               			<%  
                         		for (entities.Student student:students){
                     		 %>
                            <tr>
                                <td><a href="#!"><%=student.getNameStudent()%></a></td>
                               	<td>Student</td>
                                <td class="delete_user">
                                     <form action="DeleteUser" method = "post">
										<input type="hidden" name ="DeleteUser" value="<%=student.getIdStudent()%>">
										<input type="hidden" name ="UserType" value="0">                                  
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