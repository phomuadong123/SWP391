<%-- 
    Document   : home
    Created on : Jan 9, 2024, 9:29:06 PM
    Author     : tuant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home | E-Shopper</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </head><!--/head-->

    <body>
        <%@include file="common/header.jsp" %>
        <section id="slider"><!--slider-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div id="slider-carousel" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
                                <li data-target="#slider-carousel" data-slide-to="1"></li>
                                <li data-target="#slider-carousel" data-slide-to="2"></li>
                            </ol>

                            <div class="carousel-inner" >
                                <c:forEach items="${requestScope.slider}" var="s">
                                    <div class="item <c:if test="${s.sid==1}">active</c:if>" >
                                        <div class="col-sm-11" style="background-image: url('${s.image}'); background-size: cover; background-repeat: repeat; margin-top: 50px ">
                                            <a href="#">
                                                <div style="height: 320px;"></div>
                                            </a>
                                        </div>

                                    </div>
                                </c:forEach>

                            </div>

                            <a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
                                <i class="fa fa-angle-left"></i>
                            </a>
                            <a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </div>

                    </div>
                </div>
            </div>
        </section><!--/slider-->

        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="left-sidebar">
                            <h2>Category</h2>

                            <div class="panel-group category-products " id="accordian" ><!--category-productsr-->
                                <c:forEach items="${requestScope.category}" var="c">
                                    <div class="panel panel-default">

                                        <div class="panel-heading">

                                            <h4 class="panel-title">

                                                <a data-toggle="collapse" data-parent="#accordian" href="#${c.id}" class="collapsed">


                                                    <span class="badge pull-right">
                                                        <i class="fa fa-plus"></i>
                                                    </span>
                                                    ${c.categoryName}
                                                </a>


                                            </h4>

                                        </div>
                                        <div id="${c.id}" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <ul>
                                                    <c:forEach items="${c.subCategory}" var="c1">
                                                        <li><a href="#">${c1.categoryName}</a></li>
                                                        </c:forEach>

                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div><!--/category-products-->


                            <div class="brands_products" ><!--brands_products-->
                                <h2 style="margin-top: 30px">Brands</h2>
                                <div class="brands-name">
                                    <ul class="nav nav-pills nav-stacked">
                                        <c:forEach items="${requestScope.brand}" var="b">
                                            <li><a href="#"> <span class="pull-right">(${b.brandNumber})</span>${b.categoryName}</a></li>
                                            </c:forEach>
                                    </ul>
                                </div>
                            </div><!--/brands_products-->

                            <div class="price-range" style="padding: 0 30px"><!--price-range-->
                                <h2>Price Range</h2>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Từ</span>
                                    </div>
                                    <input type="text" class="form-control" placeholder="Username" aria-label="Amount (to the nearest dollar)">
                                    <div class="input-group-append">
                                        <span class="input-group-text"></span>
                                    </div>
                                </div><div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Ðến</span>
                                    </div>
                                    <input type="text" class="form-control" placeholder="Username" aria-label="Amount (to the nearest dollar)">
                                    <div class="input-group-append">
                                        <span class="input-group-text"></span>
                                    </div>
                                    <button type="button" class="btn btn-warning">Áp dụng</button>
                                </div> 
                            </div><!--/price-range-->

                            <div class="shipping text-center"><!--shipping-->
                                <img src="https://profiledata.net/file/img/media/video-thumb-7209964848887729410.jpeg" alt="" />
                            </div><!--/shipping-->

                        </div>
                    </div>

                    <div class="col-sm-9 padding-right">
                        <div class="features_items"><!--features_items-->
                            <h2 class="title text-center">Features Items</h2>

                            <!-- Pagination -->
                            <nav aria-label="Page navigation example" class="d-flex justify-content-center mt-3" style="height: 100px">
                                <ul class="pagination ">
                                    <li class="page-item">
                                        <a class="page-link  ${tagindex<=1 ? "isDisabled" : ""} " href="home?index=${tagindex-1}" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>

                                    <c:forEach begin="1" end="${endpage}" var="i">
                                        <li  class="page-item ${(tagindex==i)?"active":""}"><a class="page-link" href="home?index=${i}"><span aria-hidden="true">${i}</span></a></li>
                                            </c:forEach>



                                    <li class="page-item" >
                                        <a  class="page-link ${tagindex==endpage?"isDisabled":""}" href="home?index=${tagindex+1}" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                </ul>
                            </nav>  
                            <!-- Pagination -->
                            <c:forEach items="${requestScope.product}" var="p">
                                <div class="col-sm-4">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <img src="${p.images.url}" alt="" style=" height: 180px"/>
                                                <h2>$${p.price}</h2>
                                                <p>${p.productName}</p>
                                                <a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                            </div>
                                            <div class="product-overlay">
                                                <div class="overlay-content">
                                                    <h2>$56</h2>
                                                    <p>Easy Polo Black Edition</p>
                                                    <a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="choose">
                                            <ul class="nav nav-pills nav-justified">
                                                <li><a href="#"><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
                                                <li><a href="#"><i class="fa fa-plus-square"></i>Add to compare</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>


                        </div><!--features_items-->

                        <div class="category-tab"><!--category-tab-->
                            <div class="col-sm-12">
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="#tshirt" data-toggle="tab">T-Shirt</a></li>
                                    <li><a href="#blazers" data-toggle="tab">Blazers</a></li>
                                    <li><a href="#sunglass" data-toggle="tab">Sunglass</a></li>
                                    <li><a href="#kids" data-toggle="tab">Kids</a></li>
                                    <li><a href="#poloshirt" data-toggle="tab">Polo shirt</a></li>
                                </ul>
                            </div>

                        </div><!--/category-tab-->

                        <div class="recommended_items"><!--recommended_items-->
                            <h2 class="title text-center">recommended items</h2>

                            <div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
                                <div class="carousel-inner">
                                    <c:forEach begin="1" end="2" var="i">
                                        <div class="item <c:if test="${i==1}">active</c:if>">	
                                            <c:forEach items="${requestScope.products}" var="p">
                                                <div class="col-sm-4">
                                                    <div class="product-image-wrapper">
                                                        <div class="single-products">
                                                            <div class="productinfo text-center">
                                                                <img src="${p.images.url}" alt="" style="height: 200px"/>
                                                                <h2>$${p.price}</h2>
                                                                <p>${p.productName}</p>
                                                                <a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                                            </div>

                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </c:forEach>

                                </div>
                                <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
                                    <i class="fa fa-angle-left"></i>
                                </a>
                                <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
                                    <i class="fa fa-angle-right"></i>
                                </a>			
                            </div>
                        </div><!--/recommended_items-->

                    </div>
                </div>
            </div>
        </section>

        <%@include file="common/footer.jsp" %>



    </body>
</html>
