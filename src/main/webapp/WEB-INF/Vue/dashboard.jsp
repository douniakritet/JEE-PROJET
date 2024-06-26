<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
    <title></title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- <link rel="preconnect" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"> -->
    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous"> -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous"> -->
    <link rel="stylesheet" href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



</head>
<style>
    @import url("https://fonts.googleapis.com/css2?family=Nunito:wght@400;600;700&display=swap");

    :root {
        --header-height: 3rem;
        --nav-width: 68px;
        --first-color: #BED2FE;
        --first-color-light: #6c53d0;
        --white-color: #F7F6FB;
        --body-font: 'Nunito', sans-serif;
        --normal-font-size: 1rem;
        --z-fixed: 100
    }

    *,
    ::before,
    ::after {
        box-sizing: border-box
    }

    body {
        position: relative;
        margin: var(--header-height) 0 0 0;
        padding: 0 1rem;
        font-family: var(--body-font);
        font-size: var(--normal-font-size);
        transition: .5s
    }

    a {
        text-decoration: none
    }

    .header {
        width: 100%;
        height: var(--header-height);
        position: fixed;
        top: 0;
        left: 0;
        display: flex;
        align-items: center;
        justify-content: space-between;
        padding: 0 1rem;
        background-color: var(--white-color);
        z-index: var(--z-fixed);
        transition: .5s
    }

    .header_toggle {
        color: var(--first-color);
        font-size: 1.5rem;
        cursor: pointer
    }

    .header_img {
        width: 35px;
        height: 35px;
        display: flex;
        justify-content: center;
        border-radius: 50%;
        overflow: hidden
    }

    .header_img img {
        width: 40px
    }

    .l-navbar {
        position: fixed;
        top: 0;
        left: -30%;
        width: var(--nav-width);
        height: 100vh;
        background-color: var(--first-color);
        padding: .5rem 1rem 0 0;
        transition: .5s;
        z-index: var(--z-fixed)
    }

    .nav {
        height: 100%;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        overflow: hidden
    }

    .nav_logo,
    .nav_link {
        display: grid;
        grid-template-columns: max-content max-content;
        align-items: center;
        column-gap: 1rem;
        padding: .5rem 0 .5rem 1.5rem
    }

    .nav_logo {
        margin-bottom: 2rem
    }

    .nav_logo-icon {
        font-size: 1.25rem;
        color: var(--white-color)
    }

    .nav_logo-name {
        color: var(--white-color);
        font-weight: 700
    }

    .nav_link {
        position: relative;
        color: var(--first-color-light);
        margin-bottom: 1.5rem;
        transition: .3s
    }

    .nav_link:hover {
        color: var(--white-color)
    }

    .nav_icon {
        font-size: 1.25rem
    }

    .show {
        left: 0
    }

    .body-pd {
        padding-left: calc(var(--nav-width) + 1rem)
    }

    .active {
        color: var(--white-color)
    }

    .active::before {
        content: '';
        position: absolute;
        left: 0;
        width: 2px;
        height: 32px;
        background-color: var(--white-color)
    }

    .height-100 {
        height: 100vh
    }

    @media screen and (min-width: 768px) {
        body {
            margin: calc(var(--header-height) + 1rem) 0 0 0;
            padding-left: calc(var(--nav-width) + 2rem)
        }

        .header {
            height: calc(var(--header-height) + 1rem);
            padding: 0 2rem 0 calc(var(--nav-width) + 2rem)
        }

        .header_img {
            width: 40px;
            height: 40px
        }

        .header_img img {
            width: 45px
        }

        .l-navbar {
            left: 0;
            padding: 1rem 1rem 0 0
        }

        .show {
            width: calc(var(--nav-width) + 156px)
        }

        .body-pd {
            padding-left: calc(var(--nav-width) + 188px)
        }
    }
</style>

<body>

    <body id="body-pd">
        <header class="header" id="header">
            <div class="header_toggle"> <i class='bx bx-menu' id="header-toggle"></i> </div>
            <!-- <div class=" bg-gray-200" style="height:100% ;"> -->
      
                <div class="container h-screen flex justify-center items-center px-4 sm:px-6 lg:px-8" style="height:100% ;position:relative;left: 35%;margin-top:1%;">
         	<form action="chercherindexdepartement" method="post" class="search-wrap">

         
                 <div class="relative">

         
                   <input name="nameUser" type="text" class="h-14 w-96 pr-8 pl-5 rounded z-0 focus:shadow focus:outline-none" placeholder="Search anything...">
         
                   <div class="absolute top-4 right-3">
                   <button class="search-button" type="submit">									
                     <i class="fa fa-search text-gray-400 z-20 hover:text-gray-500"></i>
                     </button>
                   </div>
                   
                 </div>
                                </form>
         
                
                <!-- </div> -->
             </div>        </header>
        <div class="l-navbar" id="nav-bar">
            <nav class="nav">
                <div> <a href="<%=request.getContextPath()%>/dashboard" class="nav_logo"> <i class='bx bx-layer nav_logo-icon'></i> 
                <spanclass="nav_logo-name">Galerie d'Art</span> </a>
                
                <div class="nav_list"> 
                <a href="<%=request.getContextPath()%>/artiste" class="nav_link active"> 
                <i class='bx bxs-user'></i>
                   <span class="nav_name">Artists</span> </a> 
                   
                     <a href="<%=request.getContextPath()%>/tableau" class="nav_link"> 
                     <i class='bx bx-file-blank'></i> 
                     <span class="nav_name">ArtWorks</span> </a>
                     
                      <a href="<%=request.getContextPath()%>/exposition" class="nav_link"> 
                      <i class='bx bxs-show'></i> 
                      <span class="nav_name">Exposition</span></a>
                      
                       <a href="<%=request.getContextPath()%>/transaction" class="nav_link"> 
                     <i class='bx bxs-send'></i> <span class="nav_name">Transaction</span> </a>
                                
                    </div>
                </div> <a href="<%=request.getContextPath()%>/Login" class="nav_link"> <i class='bx bx-log-in nav_icon'></i> <span
                        class="nav_name">Login</span> </a>
            </nav>
        </div>
        <!--Container Main start-->
        <div class="" style="position:relative; top: 10%;">
        <table class="table">
            <thead>
              <tr>
                <th scope="col">ID</th>
                <th scope="col">ID OEUVRE</th>
                <th scope="col">ID EXPOSITION</th>
                <th scope="col">Nom Client</th>
                <th scope="col">Date de Vente</th>
                <th scope="col">Status</th>
                
              </tr>
            </thead>
            <tbody>
            <c:forEach var="transaction" items="${Transaction}">
    <tr>
        <td><c:out value="${transaction.idT}" /></td>
        <td><c:out value="${transaction.idOeuvre}" /></td>
        <td><c:out value="${transaction.idExposition}" /></td>
        <td><c:out value="${transaction.nomClient}" /></td>
        <td><c:out value="${transaction.dateVente}" /></td>
        <c:choose>
            <c:when test="${transaction.statut == 'en cours'}">
                <td style="color: blue;"><c:out value="${transaction.statut}" /></td>
            </c:when>
            <c:when test="${transaction.statut == 'annulée'}">
                <td style="color: red;"><c:out value="${transaction.statut}" /></td>
            </c:when>
            <c:when test="${transaction.statut == 'terminé'}">
                <td style="color: green;"><c:out value="${transaction.statut}" /></td>
            </c:when>
            <c:otherwise>
                <td><c:out value="${transaction.statut}" /></td>
            </c:otherwise>
        </c:choose>
    </tr>
</c:forEach>

                 
               </tbody>
          </table>         
        
</div>
        <!--Container Main end-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <script>
            document.addEventListener("DOMContentLoaded", function (event) {

                const showNavbar = (toggleId, navId, bodyId, headerId) => {
                    const toggle = document.getElementById(toggleId),
                        nav = document.getElementById(navId),
                        bodypd = document.getElementById(bodyId),
                        headerpd = document.getElementById(headerId)

                    // Validate that all variables exist
                    if (toggle && nav && bodypd && headerpd) {
                        toggle.addEventListener('click', () => {
                            // show navbar
                            nav.classList.toggle('show')
                            // change icon
                            toggle.classList.toggle('bx-x')
                            // add padding to body
                            bodypd.classList.toggle('body-pd')
                            // add padding to header
                            headerpd.classList.toggle('body-pd')
                        })
                    }
                }

                showNavbar('header-toggle', 'nav-bar', 'body-pd', 'header')

                /*===== LINK ACTIVE =====*/
                const linkColor = document.querySelectorAll('.nav_link')

                function colorLink() {
                    if (linkColor) {
                        linkColor.forEach(l => l.classList.remove('active'))
                        this.classList.add('active')
                    }
                }
                linkColor.forEach(l => l.addEventListener('click', colorLink))

                // Your code to run since DOM is loaded and ready
            });
        </script>
    </body>

</html>