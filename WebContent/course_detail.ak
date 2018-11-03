<section id="navigation-section">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
			    <li class="nav-item">
			        <a class="btn btn-success my-2 my-sm-0" href="course_all"><i class="far fa-arrow-alt-circle-left"></i> Back</a>
			    </li>
		    </ul>
		  </div>
		</nav>
	</div> <!-- .container -->
</section> <!-- #navigation-section -->

<section id="course-detail">
	<div class="container">
		<div class="course-content-wrapper">
			<div class="my-header">
				#agkt{courseName}
			</div> <!-- .my-header -->
			<div class="course-coverphoto">
				<img class="img-fluid" src="#agkt{courseCoverPhoto}">
			</div> <!-- .course-coverphoto -->
			<div class="content-group">
				<div class="content-title">About the Course</div>
				<p>#agkt{courseInfo}</p>
			</div> <!-- .content-group -->
			<div class="content-group">
				<div class="content-title">Syllabus</div>
				<p>#agkt{courseSyllabus}</p>
			</div>
			<div class="content-group">
				<div><span class="content-title">Duration:</span> #agkt{courseDuration}</div>
				<div><span class="content-title">Price:</span> #agkt{coursePrice} kyats</div>
			</div> <!-- .content-group -->
			<div class="content-group text-left">
				<a class="btn btn-success btn-lg" href="enroll_course?courseID=#agkt{courseID}" role="button">Enroll Now</a>
			</div> <!-- .content-group -->
		</div> <!-- .course-content-wrapper -->
	</div> <!-- .container -->
</section> <!-- #course-detail -->

<section id="lecture-list">
	<div class="container">
		<div class="lecture-list-wrapper">
			<div class="row">
				<div class="col-6">
					<div class="my-header">
						Lecture
					</div> <!-- .my-header -->
				</div> <!-- .col-6 -->
			</div>

			<table class="table table-bordered">
				<tbody>
				
				#akStartLoop{lectureList}
				    <tr>
				        <td><a href="lecture?lectureID=#akLoopItem{lectureList[lectureID]}">
					    	    #akLoopItem{lectureList[lectureTitle]}
					        </a></td>
				    </tr>
				#akEndLoop{lectureList}
				
				</tbody>
			</table>
		</div>
	</div> <!-- .container -->
</section> <!-- #lecture-list -->