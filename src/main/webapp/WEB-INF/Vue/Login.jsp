<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<title></title>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- <link rel="preconnect" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"> -->
    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous"> -->
    <link rel="stylesheet" href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

</head>
<style>
input:focus~label,input:valid~label{
    top:14px;
    left:0;
    color:blue;
}
input:focus{
    border:1px solid blue !important;
}

</style>
<body>
    <div class="min-h-screen flex justify-center items-center bg-indigo-200">
        <div class="h-auto relative my-12 p-3 bg-white font-sans rounded-lg" style="width:340px"> 
         <div class="form"> 
          <!-- <div class="signup_form hidden">
            <h1 class="text-2xl mt-3">Let's Get Started</h1>
            <div class="relative"> 
                <input class="h-12 outline-none px-2 w-full bg-gray-100 mt-8 rounded-md  border border-gray-100 transition-all " type="text" required> 
                <label class="text-sm absolute top-11 text-gray-400 left-2 pointer-events-none transition-all">Name*</label> 
            </div>
            <div class="relative"> 
                <input class="h-12 outline-none px-2 w-full bg-gray-100 mt-8 rounded-md  border border-gray-100 transition-all " type="text" required> 
                <label class="text-sm absolute top-11 text-gray-400 left-2 pointer-events-none transition-all">Website URL*</label> 
            </div>
            <div class="relative"> 
                <input class="h-12 outline-none px-2 w-full bg-gray-100 mt-8 rounded-md  border border-gray-100 transition-all " type="text" required> 
                <label class="text-sm absolute top-11 text-gray-400 left-2 pointer-events-none transition-all">E-mail Address*</label> 
            </div>
            <div class="relative"> 
                <input class= "pass_type h-12 outline-none px-2 w-full bg-gray-100 mt-8 rounded-md  pr-8 border border-gray-100 transition-all " type="password" required> 
                <label class="text-sm absolute top-11 text-gray-400 left-2 pointer-events-none transition-all">Password(8+ characters)*</label> 
                <span onClick={eyeChange()}><i class="slash_eye fa fa-eye-slash absolute top-12 right-2 cursor-pointer text-gray-400"></i></span>
            </div>
            <div class="mt-10 flex justify-center">
                <button class="outline-none h-12 rounded-lg w-full bg-blue-500 text-sm text-white hover:bg-blue-700 transition-all">Start My Free Trial</button>
            </div>
            <p class="mt-5 mb-10 text-xs font-semibold">Already have an account? <a href="#" class="signin_toggle text-blue-400">Log in</a></p>
          </div> -->
          
          <div class="signin_form">
            <h1 class="text-2xl mt-3">Sign in</h1>
            <p class="mt-3 text-sm text-pink-600"></p>
            <form action="login" method="post">
            <div class="relative"> 
                <input name="username" class="h-12 outline-none px-2 w-full bg-gray-100 mt-8 rounded-md  border border-gray-100 transition-all " type="text" required> 
                <label class="text-sm absolute top-12 text-gray-400 left-2 pointer-events-none transition-all">E-mail Address*</label> 
            </div>
            <div class="relative"> 
                <input class= "pass_type_signin h-12 outline-none px-2 w-full bg-gray-100 mt-8 rounded-md  pr-8 border border-gray-100 transition-all " name="password" type="password" required> 
                <label class="text-sm absolute top-12 text-gray-400 left-2 pointer-events-none transition-all">Password(8+ characters)*</label> 
                <span onClick={eyeChangeSignin()}><i class="slash_eye_signin fa fa-eye-slash absolute top-12 right-2 cursor-pointer text-gray-400"></i></span>
            </div>
            <div class="mt-10 flex justify-center">
                <button class=" outline-none h-12 rounded-lg w-full bg-blue-500 text-sm text-white hover:bg-blue-700 transition-all">Sign in</button>
            </div>
        </form>
            <!-- <p class="mt-5 mb-10 text-xs font-semibold">Don't have an account? <a href="#" class="signup_toggle text-blue-400">Sign up</a></p> -->
          </div>
         </div>
        </div>
    </div>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
      <script>var slash_eye=document.querySelector(".slash_eye");
        var pass_type=document.querySelector(".pass_type");
        var set_slash_eye=document.querySelector(".slash_eye");
        
        var slash_eye_signin=document.querySelector(".slash_eye_signin");
        var pass_type_signin=document.querySelector(".pass_type_signin");
        var set_signin_eye=document.querySelector(".slash_eye_signin");
        
        var signup_toggle=document.querySelector(".signup_toggle");
        var signin_toggle=document.querySelector(".signin_toggle");
        
        var signup_form=document.querySelector(".signup_form");
        var signin_form=document.querySelector(".signin_form");
        
        // signup_toggle.addEventListener('click',function(){
        //     signup_form.classList.toggle('hidden'); 
        //     signin_form.classList.toggle('hidden');
        // });
            
        // signin_toggle.addEventListener('click',function(){
        //   signup_form.classList.toggle('hidden');  
        //     signin_form.classList.toggle('hidden');
        // }); 
        
        
         function eyeChange(){
             if(pass_type.type=="password"){
                 pass_type.type="text";
                 slash_eye.classList.remove('fa-eye-slash');
                 slash_eye.classList.add('fa-eye');
             }
             else{
                 pass_type.type="password";
                 slash_eye.classList.add('fa-eye-slash');
                 slash_eye.classList.remove('fa-eye');
             }
         }
         function eyeChangeSignin(){
             if(pass_type_signin.type=="password"){
                 pass_type_signin.type="text";
                 set_signin_eye.classList.remove('fa-eye-slash');
                 set_signin_eye.classList.add('fa-eye');
             }
             else{
                 pass_type_signin.type="password";
                 set_signin_eye.classList.add('fa-eye-slash');
                 set_signin_eye.classList.remove('fa-eye');
             }
         }</script>
</body>
</html>







