<section id="navigation-section">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
			    <li class="nav-item">
			        <a class="nav-link menu-active" href="dashboard_course">My Courses</span></a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="dashboard_payment">Payment History</a>
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
			<p><span>You haven't joined the course yet.</span></p>
		</div>
		#endIf
		
		#if(#agkt{courseShow})
		<div class="my-header">My Courses</div>
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
						<ul>
							<li>#akLoopItem{courseList[courseDuration]}</li>
							<li>#akLoopItem{courseList[coursePrice]} Kyats</li>
						</ul>
						<a class="btn btn-success btn-block" href="course_detail?courseID=#akLoopItem{courseList[courseID]}&back=dashboard">Detail</a>
					</div> <!-- .course-box-bottom -->
				</div> <!-- .course-box -->
			</div> <!-- .col-4 -->
		#akEndLoop{courseList}
		
		</div> <!-- .row -->
		#endIf
	</div> <!-- .container -->
</section> <!-- #course-content -->