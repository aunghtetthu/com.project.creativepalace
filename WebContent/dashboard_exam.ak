<section id="navigation-section">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
			    <li class="nav-item">
			        <a class="nav-link" href="dashboard_course">My Courses</span></a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="dashboard_payment">Payment History</a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link menu-active" href="dashboard_exam">Exam</a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="dashboard_certificate">Certificate</a>
			    </li>
		    </ul>
		  </div>
		</nav>
	</div> <!-- .container -->
</section> <!-- #navigation-section -->

<section id="course-content">
	<div class="container">

		<div class="my-title">Dashboard</div>

		#if(#agkt{noCourse})
		<div class="my-not-found">
			<p><span>You don't have any exam yet.</span></p>
		</div>
		#endIf
		
		#if(#agkt{courseShow})
		
		<section id="message-section">
			<div class="container">
				<div class="message-box info-box">
					<div class="message-icon info-icon-bg">
						<i class="fas fa-info-circle"></i>
					</div>
					<div class="message-text">
						<span class="font-weight-bold">Warning!</span> You can take each exam only once. Please make sure that you will take exam seriously before you click "Take Exam" button.  
					</div>
					<div class="clearfix"></div>
				</div> <!-- .message-box -->
			</div> <!-- .container -->
		</section> <!-- #message-section -->
		
		<div class="my-header">Exam</div>
		<div class="row">
		
		#akStartLoop{courseList}
			<div class="col-4">
				<div class="course-box">
					<div class="text-center course-box-category">
						#akLoopItem{courseList[courseCategory]} course
					</div>
					<div>
						<img src="#agkt{baseUrl}/course_coverPhoto/
						#akLoopItem{courseList[courseCoverPhoto]}" class="img-fluid">
					</div>
					<div class="course-box-name my-header">
						#akLoopItem{courseList[courseName]}
					</div>
					<div class="course-box-bottom">
						<a class="btn btn-danger btn-block btn-lg font-weight-bold" href="exam?courseID=#akLoopItem{courseList[courseID]}&
						courseName=#akLoopItem{courseList[courseName]}">Take Exam</a>
					</div> <!-- .course-box-bottom -->
				</div> <!-- .course-box -->
			</div> <!-- .col-4 -->
		#akEndLoop{courseList}
		
		</div> <!-- .row -->
		#endIf
	</div> <!-- .container -->
</section> <!-- #course-content -->