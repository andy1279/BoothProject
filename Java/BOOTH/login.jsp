<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <title>로그인 & 회원가입</title>

  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/logincss.css" rel="stylesheet">
  

</head>

<body style="background-color: #EDD575;">

  <!-- 상단 바 -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">
        <img class="p-0 m-0" src="img/logo.png" alt="booth" style="width:100px;">
      </a>
    </div>
  </nav>

  <div class="container py-5">
    <div class="form">
      
        <ul class="nav nav-pills nav-justified">
          <li class="tab active"><a href="#signup">Sign Up</a></li>
          <li class="tab"><a href="#login">Log In</a></li>
        </ul>
        
        <div class="tab-content">
          <div id="signup">   
            <h1>회원가입</h1>
            
            <form action="/" id="joinForm">
            
            <div class="top-row">
              <div class="field-wrap">
                <label>
                  닉네임<span class="req">*</span>
                </label>
                <input type="text" name="userNick" required autocomplete="off" />
              </div>
              
              <div class="field-wrap">
                <label>
                  아이디<span class="req">*</span>
                </label>
                <input type="text" name="userId" required autocomplete="off" />
              </div>
          
              <div class="field-wrap">
                <label>
                  패스워드<span class="req">*</span>
                </label>
                <input type="password" name="userPw" required autocomplete="off"/>
              </div>
              
              <div class="field-wrap">
                <label>
                  패스워드 확인<span class="req">*</span>
                </label>
                <input type="password" name="userPwChk" required autocomplete="off"/>
              </div>
            </div>
  
            <div class="field-wrap">
              <label>
                이메일<span class="req">*</span>
              </label>
              <input type="email" name="userEmail" required autocomplete="off"/>
            </div>
            
            <div class="field-wrap">
              <label>
                휴대폰 번호<span class="req">*</span>
              </label>
              <input type="text" name="userPhoneNum" required autocomplete="off"/>
            </div>
            
            <button type="submit" class="button button-block"/>회원가입</button>
            
            </form>
  
          </div>
          
          <div id="login">   
            <h1>Welcome Back!</h1>
            
            <form action="/" id="loginForm">
            
              <div class="field-wrap">
              <label>
                아이디<span class="req">*</span>
              </label>
              <input type="text" name="userId" required autocomplete="off"/>
            </div>
            
            <div class="field-wrap">
              <label>
                패스워드<span class="req">*</span>
              </label>
              <input type="password" name="userPw" required autocomplete="off"/>
            </div>
            
            <p class="forgot"><a href="#">Forgot Password?</a></p>
            
            <button class="button button-block"/>로그인</button>
            
            </form>
  
          </div>
          
        </div><!-- tab-content -->
        
  </div> <!-- /form -->
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
  <script src="js/login.js"></script>
</body>
<script>
$( "#joinForm" ).submit(function( event ) {	 
	  // Stop form from submitting normally
	  event.preventDefault();
	  // Send the data using post
	  var joinXHR = $.post( "./member/join", $("#joinForm").serialize());
	  // Put the results in a div
	  joinXHR.done(function( data ) {
	    alert(data);
	  });
	});
$( "#loginForm" ).submit(function( event ) {
	  event.preventDefault();
	  var loginXHR = $.post( "./member/login", $("#loginForm").serialize());
	  loginXHR.done(function( data ) {
	   		if(data=="SUCCESS")
		   	{
	   			location.reload();
		   	}
	   		else
		   	{
			   	//실패 처리
		   	}
	  });
	});
</script>
</html>