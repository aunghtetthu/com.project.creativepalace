<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Creative Palace</title>
	<link rel="shortcut icon" href="#agkt{baseUrl}/assets/img/favicon.ico">
	<link rel="stylesheet" type="text/css" href="#agkt{baseUrl}/assets/library/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="#agkt{baseUrl}/assets/css/style.css">
</head>
<body>
<header>
	<div class="container-fluid">
		<div class="row">
			<div class="col-2 text-left">
				<div class="logo">
					<a href="index"><img src="#agkt{baseUrl}/assets/img/logo.png"></a>
				</div> <!-- .logo -->
			</div> <!-- .col-4 .text-left -->
			<div class="col-7 text-center">
				<div class="menu-wrapper">
					<ul>
						<li><a href="course_all">Courses</a></li>
						<li><a href="#">Discussion Forum</a></li>
						<li><a href="#">FAQ</a></li>
						<li><a href="#">Contact Us</a></li>
					</ul>
				</div> <!-- .menu-wrapper -->
			</div> <!-- .col-4 .text-center -->
			<div class="col-3 text-right">
				<div class="student-btns">
				#if(#agkt{guest})
					<a href="login">Log In</a>  
					<a href="register" class="btn btn-success">Register</a>
				#endIf
				#if(#agkt{student})
					<a class="account-link" href="#">#agkt{studentName}</a>

					<div class="menu-control">
						<i class="fas fa-caret-down"></i>
					</div> <!-- .menu-control -->

					<div class="student-menu d-none">
						<ul>
							<li><a href="#">Dashboard</a></li>
							<li><a href="#">Profile</a></li>
							<li><a href="logout">Log Out</a></li>
						</ul>
					</div>
				#endIf
				</div> <!-- .student-btns -->
			</div> <!-- .col-4 .text-right -->
		</div> <!-- .row -->
	</div> <!-- .container -->
</header>