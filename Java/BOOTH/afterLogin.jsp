<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>그룹만들기+그룹선택</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">

</head>

<body style="background-color: #EDD575;">

    <!-- 상단 바 -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="#">
                <img class="p-0 m-0" src="img/logo.png" alt="booth" style="width:100px;">
            </a>

            <!-- 그룹 검색 -->
            <div class="card-body p-0 m-0">
                <div class="input-group">
                    <input type="text" class="form-control mr-2" placeholder="원하는 키워드를 검색하세요:)">
                    <span class="input-group-append">
                        <button class="btn p-0 m-0"><img id="myImg" src="img/search.png"
                                style="width:30px; height:30px;"></button>
                    </span>
                </div>
            </div>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">AAA</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">BBB</a>
                    </li>
                    <li class="nav-item">
                        <div class="dropdown">
                            <button type="button" class="btn btn-dark dropdown-toggle" data-toggle="dropdown">
                                <img src="img/profile.jpg" alt="profile" class="rounded-circle" style="width:30px;">
                            </button>
                            <div class="dropdown-menu">
                                <h5 class="dropdown-header"><span>꽁치</span>, Welcome!</h5>
                                <a class="dropdown-item" href="#">프로필 관리</a>
                                <a class="dropdown-item" href="./member/logout">로그아웃</a>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container py-5">

        <div class="row">

            <!-- 내가 그룹장인 BOOTH ---------------------------------------------------------------------------------------------------------------->
            <div class="py-3">
                <h3>I am Boss in these BOOTH</h3>

                <div id="iamBoss" class="carousel slide" data-ride="carousel">
                    <!-- The slideshow -->
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div class="row d-flex justify-content-around">
                                <!-- 그룹 1개 -->
                                <div class="card p-1 bg-dark col-md-2">
                                    <img class="card-img-top " src="https://placeimg.com/300/300/person"
                                        alt="Card image">
                                    <div class="card-body bg-white">
                                        <h5 class="card-title">1</h4>
                                    </div>
                                </div>
                                <!-- 그룹 1개 -->
                                <div class="card p-1 bg-dark col-md-2">
                                    <img class="card-img-top " src="https://placeimg.com/300/300/person"
                                        alt="Card image">
                                    <div class="card-body bg-white">
                                        <h5 class="card-title">2</h4>
                                    </div>
                                </div>
                                <!-- 그룹 1개 -->
                                <div class="card p-1 bg-dark col-md-2">
                                    <img class="card-img-top " src="https://placeimg.com/300/300/person"
                                        alt="Card image">
                                    <div class="card-body bg-white">
                                        <h5 class="card-title">3</h4>
                                    </div>
                                </div>
                                <!-- 그룹 1개 -->
                                <div class="card p-1 bg-dark col-md-2">
                                    <img class="card-img-top " src="https://placeimg.com/300/300/person"
                                        alt="Card image">
                                    <div class="card-body bg-white">
                                        <h5 class="card-title">3</h4>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- ---------------------------------------------------------------------------- -->
                        <div class="carousel-item">
                            <div class="row d-flex justify-content-around">
                                <!-- 그룹 1개 -->
                                <div class="card p-1 bg-dark col-md-2">
                                    <img class="card-img-top " src="https://placeimg.com/300/300/any" alt="Card image">
                                    <div class="card-body bg-white">
                                        <h5 class="card-title">1</h4>
                                    </div>
                                </div>
                                <!-- 그룹 1개 -->
                                <div class="card p-1 bg-dark col-md-2">
                                    <img class="card-img-top " src="https://placeimg.com/300/300/any" alt="Card image">
                                    <div class="card-body bg-white">
                                        <h5 class="card-title">3</h4>
                                    </div>
                                </div>
                                <!-- 그룹 1개 -->
                                <div class="card p-1 bg-dark col-md-2">
                                    <img class="card-img-top " src="https://placeimg.com/300/300/any" alt="Card image">
                                    <div class="card-body bg-white">
                                        <h5 class="card-title">1</h4>
                                    </div>
                                </div>
                                <!-- 그룹 1개 -->
                                <div class="card p-1 bg-dark col-md-2">
                                    <img class="card-img-top " src="https://placeimg.com/300/300/any" alt="Card image">
                                    <div class="card-body bg-white">
                                        <h5 class="card-title">3</h4>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Left and right controls -->
                    <a class="carousel-control-prev" href="#iamBoss" data-slide="prev" style="left:-10%">
                        <span class="carousel-control-prev-icon"></span>
                    </a>
                    <a class="carousel-control-next" href="#iamBoss" data-slide="next" style="right:-10%">
                        <span class="carousel-control-next-icon"></span>
                    </a>
                </div>
                <hr>
            </div>
            <!-- End of '내가 그룹장인 BOOTH' -->

            <!-- 모든 BOOTH ---------------------------------------------------------------------------------------------------------------->
            <div class="">
                <h3>All BOOTH</h3>

                <div id="allBooth" class="carousel slide" data-ride="carousel">
                    <!-- The slideshow -->
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div class="row d-flex justify-content-around">
                                <!-- 그룹 1개 -->
                                <div class="card p-1 bg-dark col-md-2">
                                    <img class="card-img-top " src="https://placeimg.com/300/300/person"
                                        alt="Card image">
                                    <div class="card-body bg-white">
                                        <h5 class="card-title">1</h4>
                                    </div>
                                </div>
                                <!-- 그룹 1개 -->
                                <div class="card p-1 bg-dark col-md-2">
                                    <img class="card-img-top " src="https://placeimg.com/300/300/person"
                                        alt="Card image">
                                    <div class="card-body bg-white">
                                        <h5 class="card-title">2</h4>
                                    </div>
                                </div>
                                <!-- 그룹 1개 -->
                                <div class="card p-1 bg-dark col-md-2">
                                    <img class="card-img-top " src="https://placeimg.com/300/300/person"
                                        alt="Card image">
                                    <div class="card-body bg-white">
                                        <h5 class="card-title">3</h4>
                                    </div>
                                </div>
                                <!-- 그룹 1개 -->
                                <div class="card p-1 bg-dark col-md-2">
                                    <img class="card-img-top " src="https://placeimg.com/300/300/person"
                                        alt="Card image">
                                    <div class="card-body bg-white">
                                        <h5 class="card-title">3</h4>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- ---------------------------------------------------------------------------- -->
                        <div class="carousel-item">
                            <div class="row d-flex justify-content-around">
                                <!-- 그룹 1개 -->
                                <div class="card p-1 bg-dark col-md-2">
                                    <img class="card-img-top " src="https://placeimg.com/300/300/any" alt="Card image">
                                    <div class="card-body bg-white">
                                        <h5 class="card-title">1</h4>
                                    </div>
                                </div>
                                <!-- 그룹 1개 -->
                                <div class="card p-1 bg-dark col-md-2">
                                    <img class="card-img-top " src="https://placeimg.com/300/300/any" alt="Card image">
                                    <div class="card-body bg-white">
                                        <h5 class="card-title">3</h4>
                                    </div>
                                </div>
                                <!-- 그룹 1개 -->
                                <div class="card p-1 bg-dark col-md-2">
                                    <img class="card-img-top " src="https://placeimg.com/300/300/any" alt="Card image">
                                    <div class="card-body bg-white">
                                        <h5 class="card-title">1</h4>
                                    </div>
                                </div>
                                <!-- 그룹 1개 -->
                                <div class="card p-1 bg-dark col-md-2">
                                    <img class="card-img-top " src="https://placeimg.com/300/300/any" alt="Card image">
                                    <div class="card-body bg-white">
                                        <h5 class="card-title">3</h4>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Left and right controls -->
                    <a class="carousel-control-prev" href="#allBooth" data-slide="prev" style="left:-10%">
                        <span class="carousel-control-prev-icon"></span>
                    </a>
                    <a class="carousel-control-next" href="#allBooth" data-slide="next" style="right:-10%">
                        <span class="carousel-control-next-icon"></span>
                    </a>
                </div>
                <hr>
            </div>
            <!-- End of '모든 BOOTH' -->


            <!-- Join BOOTH ---------------------------------------------------------------------------------------------------------------->
            <div class="col-md-8">
                <h3>Join BOOTH</h3>
                <!-- 게시글 검색 -->
                <div class="card-body p-0 m-0">
                    <div class="input-group">
                        <input type="text" class="form-control mr-2" placeholder="그룹코드를 입력하세요">
                        <span class="input-group-append">
                            <button class="btn p-0 m-0"><img id="myImg" src="img/search.png"
                                    style="width:30px; height:30px;"></button>
                        </span>
                    </div>
                </div>
            </div>
             <!-- Create BOOTH ---------------------------------------------------------------------------------------------------------------->
             <div class="col-md-4">
                <h3>Create BOOTH</h3>
                <!-- 게시글 검색 -->
                <div class="card-body p-0 m-0">
                    <button class="btn btn-dark" type="button" style="width: 40%;">+</button>
                </div>
            </div>
        </div>

    </div>
    <!-- End of 'row' -->

    </div>
    <!-- End of 'container' -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
        <div class="container">
            <p class="m-0 text-center text-white"><b>Hangout with your friends, Booth</b></p>
            <p class="m-0 text-center text-white">Copyright &copy; Yuna Han, JaeWan Seo 2020</p>
        </div>
    </footer>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
</body>

</html>