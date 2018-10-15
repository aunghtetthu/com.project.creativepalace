<section id="navigation-section">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
			    <li class="nav-item">
			        <a class="nav-link menu-active" href="course_all">All Courses</span></a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="course_application">Application Courses</a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="course_professional">Professional Courses</a>
			    </li>
		    </ul>
		    <form action="course_all" method="POST" class="form-inline my-2 my-lg-0">
		    	<input type="hidden" name="searchType" value="course_name">
		        <input name="searchKey" class="form-control mr-sm-2" type="search" placeholder="Search course" aria-label="Search" required>
		        <button name="btnSubmit" class="btn btn-outline-success my-2 my-sm-0" type="submit" value="submit">Search</button>
		    </form>
		  </div>
		</nav>
	</div> <!-- .container -->
</section> <!-- #navigation-section -->

<section id="course-content">
	<div class="container">
	
	#if(#agkt{noResult})
		<div class="my-header">Search Result by #agkt{keyword}: 
		#agkt{searchResultCount}</div>
		<div class="my-not-found">
			<p>No course found for <span>#agkt{keyword}</span>.</p>
		</div>
	#endIf

	#if(#agkt{showSearch})
		<div class="my-header">Search Result by #agkt{keyword}: 
		#agkt{searchResultCount}</div>

		<div class="row">
		
		#akStartLoop{searchResult}
			<div class="col-4">
				<div class="course-box">
					<div class="text-center course-box-category">
						#akLoopItem{searchResult[courseCategory]}
					</div>
					<div>
						<img src="#agkt{baseUrl}/course_coverPhoto/
						#akLoopItem{searchResult[courseCoverPhoto]}" class="img-fluid">
					</div>
					<div class="course-box-name my-header">
						#akLoopItem{searchResult[courseName]}
					</div>
					<div class="course-box-bottom">
						<ul>
							<li>#akLoopItem{searchResult[courseDuration]}</li>
							<li>#akLoopItem{searchResult[coursePrice]} Kyats</li>
						</ul>
						<a class="btn btn-success btn-block" href="course_detail?courseID=#akLoopItem{searchResult[courseID]}">Detail</a>
					</div> <!-- .course-box-bottom -->
				</div> <!-- .course-box -->
			</div> <!-- .col-4 -->
		#akEndLoop{searchResult}
		
		</div> <!-- .row -->
	#endIf
	
		<div class="my-header">Total Courses: #agkt{courseCount}</div>

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
						<a class="btn btn-success btn-block" href="course_detail?courseID=#akLoopItem{courseList[courseID]}">Detail</a>
					</div> <!-- .course-box-bottom -->
				</div> <!-- .course-box -->
			</div> <!-- .col-4 -->
		#akEndLoop{courseList}
		
		</div> <!-- .row -->
	</div> <!-- .container -->
</section> <!-- #course-content -->