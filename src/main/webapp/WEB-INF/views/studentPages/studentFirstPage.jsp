    <%--
      Created by IntelliJ IDEA.
      User: kuanyshsalyk
      Date: 07.03.2019
      Time: 11:25 AM
      To change this template use File | Settings | File Templates.
    --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <meta charset="utf-8">
        <title>Student Page</title>


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

        <a class="navbar-brand mr-1" href="/studentFirstPage">IITU CAMPUS</a>

        <!-- Navbar -->
        <div _ngcontent-c3="" class="collapse navbar-collapse">
            <ul _ngcontent-c3="" class="navbar-nav ml-auto">
            <li class="nav-item dropdown no-arrow mx-1">
                <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">

                    <i class="fa fa-language"></i>
                    Русский <b _ngcontent-c3="" class="caret"></b>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown">
                    <a _ngcontent-c3="" href="javascript:void(0)" class="dropdown-item active"> Русский </a>
                    <a _ngcontent-c3="" href="javascript:void(0)" class="dropdown-item "> Англиский </a>
                    <a _ngcontent-c3="" href="javascript:void(0)" class="dropdown-item "> Казахский </a>
                </div>
            </li>
            <li class="nav-item dropdown no-arrow">
                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fa fa-user">${student.name} ${student.surname}</i>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                    <a class="dropdown-item" href="#">Профиль</a>
                    <a class="dropdown-item" href="#">Настройки</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Выйти</a>
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
                <li class="nav-item">
                    <a class="nav-link" href="/index">
                        <i _ngcontent-c4="" class="fa fa-fw fa-object-group"></i>
                        <span>Выйти</span></a>
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
                    <li class="breadcrumb-item active">
                       Мои дневники
                    </li>
                </ol>

                <form action="/studentAddPracticePage" method="get">
                    <button class="btn btn-primary">Добавить новую практику</button>
                </form>

                    <!-- DataTables Example -->
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>№</th>
                                    <th>Название практики</th>
                                    <th>Формат</th>
                                    <th>Куратор</th>
                                    <th>Руководитель</th>
                                    <th>Место прохождения практики</th>
                                    <th>Дата начало</th>
                                    <th>Дата окончания</th>
                                    <th>Оценка</th>
                                </tr>
                                </thead>

                                <c:forEach items="${practiceArray}" var="practice">
                                <tbody onclick="window.location='/studentPracticePage?practiceID=${practice.practice_id}'">
                                    <%--<form action="/studentPracticePage" onclick="this">--%>
                                <tr >
                                    <td>${practice.practice_id}</td>
                                    <td>${practice.name}</td>
                                    <td>Практика</td>
                                    <td>${practice.advisor_id.name}</td>
                                    <td>${practice.company_id.compName}</td>
                                    <td>${practice.company_id.name}</td>
                                    <td>${practice.date_start}</td>
                                    <td>${practice.date_finish}</td>
                                    <td>${practice.score}</td>
                                </tr>
                                        <%--<input type="hidden" value="${practice.practice_id}" name="practiceID">--%>
                                    <%--</form>--%>
                                </c:forEach>
                                </tbody>

                            </table>
                        </div>
                    </div>


                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                </div>

                <p class="small text-center text-muted my-5">
                    <em>More table examples coming soon...</em>
                </p>

            </div>
            <!-- /.container-fluid -->

            <!-- Sticky Footer -->
            <footer class="sticky-footer">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright © Your Website 2019</span>
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
                    <a class="btn btn-primary" href="/index">Logout</a>
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

