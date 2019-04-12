<%--
  Created by IntelliJ IDEA.
  User: kuanyshsalyk
  Date: 07.03.2019
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin - Tables</title>


    <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="">
    <!-- Page level plugin CSS-->
    <link href="/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/resources/css/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top">

<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
    </button>
    <a class="navbar-brand mr-1" href="index.html">IITU CAMPUS</a>





    <!-- Navbar -->
    <div _ngcontent-c3="" class="collapse navbar-collapse">
        <ul _ngcontent-c3="" class="navbar-nav ml-auto">
            <li _ngcontent-c3="" class="nav-item dropdown" ngbdropdown="">
                <a _ngcontent-c3="" aria-haspopup="true" class="nav-link dropdown-toggle" href="javascript:void(0)"  id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">

                    <i _ngcontent-c3="" class="fa fa-language"></i>
                    Русский <b _ngcontent-c3="" class="caret"></b></a>
                <div _ngcontent-c3="" class="dropdown-menu dropdown-menu-right">
                    <a _ngcontent-c3="" href="javascript:void(0)" class="dropdown-item active"> Русский </a>
                    <a _ngcontent-c3="" href="javascript:void(0)" class="dropdown-item "> Англиский </a>
                    <a _ngcontent-c3="" href="javascript:void(0)" class="dropdown-item "> Казахский </a></div></li>
            <li class="nav-item dropdown no-arrow">
                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-user-circle fa-fw"></i>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">

                    <a class="dropdown-item" href="#">Profile</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
                </div>
            </li>
        </ul>

    </div>
</nav>

<div id="wrapper">


    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="#">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Рабочая область</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">
                <i class="fa fa-book"></i>
                <span>Учебный план</span>
            </a>
        </li>


        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown1" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-fw fa-folder"></i>
                <span>Бизнес-процесс</span>
            </a>
            <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                <h6 class="dropdown-header">Login Screens:</h6>
                <a class="dropdown-item" href="login.html">Login</a>
                <a class="dropdown-item" href="register.html">Register</a>
                <a class="dropdown-item" href="forgot-password.html">Forgot Password</a>
                <div class="dropdown-divider"></div>
                <h6 class="dropdown-header">Other Pages:</h6>
                <a class="dropdown-item" href="404.html">404 Page</a>
                <a class="dropdown-item active" href="blank.html">Blank Page</a>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">
                <i _ngcontent-c4="" class="fa fa-fw fa-object-group"></i>
                <span>Мои справки</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">
                <i _ngcontent-c4="" class="fa fa-book"></i>
                <span>Мои транскрипты</span></a>
        </li>
    </ul>

    <div id="content-wrapper">

        <div class="container-fluid">

            <!-- Page Content -->
            <h2>Мои дневники</h2>
            <hr>


            <!-- Breadcrumbs-->
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="#">Рабочая область</a>
                </li>
                <li class="breadcrumb-item">
                    <a href="/studentFirstPage">Мои дневники</a>
                </li>
                <li class="breadcrumb-item active">Практическая работа</li>
            </ol>

            <!-- DataTables Example -->


            <form action="/add_real_practice" method="get">
                <table border='0' width='480px' cellpadding='0' cellspacing='0'>
                    <tr>
                        <td><h5>Данные о практике</h5></td>
                    </tr>
                    <table border='0' width='480px' cellpadding='0' cellspacing='0'>
                        <tr>
                            <td>Название практики</td>
                            <td><input type='text' id="name_of_practice" name='name_of_practice' required></td>
                        </tr>
                        <tr> <td>&nbsp;</td> </tr>
                        <tr>
                            <td>Куратор</td>
                            <td>  <select>
                                <option>Молын Е.К</option>
                                <option>Молын Е.К</option>
                                <option>Молын Е.К</option>
                                <option>Молын Е.К</option>
                                <option>Молын Е.К</option>
                                <option>Молын Е.К</option>
                                <%--add some backend functions--%>
                            </select>

                            </td>

                        </tr>
                        <tr> <td>&nbsp;</td> </tr>
                        <tr>
                            <td>Руководитель</td>
                            <td><input type='text' id="boss" name='boss' required></td>
                        </tr>
                        <tr> <td>&nbsp;</td> </tr>
                        <tr>
                            <td>Место прохождения практики</td>
                            <td><input type='text' id="location_of_practice" name='location_of_practice' required></td>
                        </tr>
                        <tr> <td>&nbsp;</td> </tr>
                        <tr>
                            <td>Дата</td>
                            <td><input type='date' id="date" placeholder="yyyy-mm-dd" name='date' required></td>
                        </tr>
                        <tr> <td>&nbsp;</td> </tr>
                    </table>
                </table>
                </table>
                <p>
                    <b>Договор</b> Раздел о соглашении принять данного студента на стажировку
                </p>
                <p>
                    <b>ЭЦП</b>  <a href="javascript:alert('Hello World!');"> Создать ссылку</a>
                </p>

                        <input type='submit' value="Добавить">
            </form>

            <!-- Sticky Footer -->
            <footer class="sticky-footer">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Техническая поддержка IITU Campus</span>

                        <li class="breadcrumb-item">Email
                            <a href="index.html">campus.iitu@gmail.com</a>
                        </li>
                    </div>
                </div>
            </footer>
        </div>
        <!-- /.content-wrapper -->
    </div>
    <!-- /#wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>
    <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Page level plugin JavaScript-->
    <script src="/resources/vendor/chart.js/Chart.min.js"></script>
    <script src="/resources/vendor/datatables/jquery.dataTables.js"></script>
    <script src="/resources/vendor/datatables/dataTables.bootstrap4.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/resources/js/sb-admin.min.js"></script>

    <!-- Demo scripts for this page-->
    <script src="/resources/js/demo/datatables-demo.js"></script>
    <script src="/resources/js/demo/chart-area-demo.js"></script>
</div>
</body>

</html>
