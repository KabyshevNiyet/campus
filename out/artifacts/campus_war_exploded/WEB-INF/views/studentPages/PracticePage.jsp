<%--
  Created by IntelliJ IDEA.
  User: kuanyshsalyk
  Date: 07.03.2019
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta charset="utf-8">
    <title>SB Admin - Dashboard</title>


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
                <a _ngcontent-c3="" aria-haspopup="true" class="nav-link dropdown-toggle" href="javascript:void(0)" ngbdropdowntoggle="" aria-expanded="false">
                    <i _ngcontent-c3="" class="fa fa-language"></i>
                    Русский <b _ngcontent-c3="" class="caret"></b></a>
                <div _ngcontent-c3="" class="dropdown-menu dropdown-menu-right">
                    <a _ngcontent-c3="" href="javascript:void(0)" class="dropdown-item active"> Русский </a>
                    <a _ngcontent-c3="" href="javascript:void(0)" class="dropdown-item "> Англиский </a>
                    <a _ngcontent-c3="" href="javascript:void(0)" class="dropdown-item "> Казахский </a></div></li>

            <li _ngcontent-c3="" class="nav-item dropdown" ngbdropdown="">
                <a _ngcontent-c3="" aria-haspopup="true" class="nav-link dropdown-toggle" href="javascript:void(0)" ngbdropdowntoggle="" aria-expanded="false">
                    <i _ngcontent-c3="" class="fa fa-user"></i> Madina Saparbayeva <b _ngcontent-c3="" class="caret">
                </b></a>
                <div _ngcontent-c3="" class="dropdown-menu dropdown-menu-right">
                    <a _ngcontent-c3="" class="dropdown-item" href="#/profile">
                        <i _ngcontent-c3="" class="fa fa-fw fa-user"></i> Профиль </a>
                    <a _ngcontent-c3="" class="dropdown-item" href="#/login">
                        <i _ngcontent-c3="" class="fa fa-fw fa-power-off"></i> Выйти </a></div></li></ul></div>

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
    </ul>



    <div id="content-wrapper">

        <div class="container-fluid">

            <!-- Breadcrumbs-->
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <i class="fa fa-home w3-xxlarge"></i>
                    <a href="#">Рабочая область</a>
                </li>
                <li class="breadcrumb-item ">
                    <a href="/studentFirstPage">Мои дневники</a>
                </li>
                <li class="breadcrumb-item active">
                    Практическая работа</li>



            </ol>

            <!-- DataTables Example -->

            <!--/.1st table-->
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

                        <thead>
                        <tr>
                            <th>№</th>
                            <th>Название практики </th>
                            <th>Формат</th>
                            <th>Куратор</th>
                            <th>Руководитель</th>
                            <th>Место прохождения практики</th>
                            <th>Дата</th>
                            <th>Оценка</th>
                        </tr>
                        </thead>

                        <tbody>
                        <tr>
                            <td>1</td>
                            <td>Практическая работа</td>
                            <td>Практика</td>
                            <td>Бауыржанов Д.С</td>
                            <td>Молын Е.К</td>
                            <td>ТОО "Rainbek</td>
                            <td>15.05.19-24.05.19</td>
                            <td>100</td>
                        </tr>
                        </tbody>
                    </table>

                </div>
            </div>

            <!--/.2nd table-->
            <div class="card-body">
                <h3>Дневник</h3><br>
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable2" width="100%" cellspacing="0">

                        <thead>
                        <tr>
                            <th>Отчет</th>
                            <th width="150px">Дата</th>
                            <th width="120px">Действия</th>
                        </tr>
                        </thead>

                        <tbody>
                        <tr>
                            <td> <textarea class="form-control" id="exampleFormControlTextarea1" rows="4"></textarea></td>
                            <td>16.05.19</td>
                            <td><button class="btn btn-success" onclick="alert('ADDED')">Добавить</button></td>
                        </tr>
                        <tr>
                            <td>Первый день на практике</td>
                            <td>15.05.19</td>
                            <td></td>
                        </tr>
                        </tbody>

                    </table>
                </div>
            </div>

            <!--/.3rd table-->
            <div class="card-body">
                <h3>Оценка куратора</h3><br>
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable3" width="100%" cellspacing="0">

                        <thead>
                        <tr>
                            <th>Отчет</th>
                            <th width="150px">Дата</th>
                            <th width="120px">Оценка</th>
                        </tr>
                        </thead>

                        <tbody>
                        <tr>
                            <td>Фидбек от куратора</td>
                            <td>24.05.19</td>
                            <td>100</td>
                        </tr>
                        </tbody>

                    </table>
                </div>
            </div>



        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">=
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

</body>

</html>

