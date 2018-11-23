<section id="navigation-section">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
			    <li class="nav-item">
			        <a class="btn btn-success my-2 my-sm-0" href="course_detail?courseID=#agkt{courseID}"><i class="far fa-arrow-alt-circle-left"></i> Back to Course</a>
			    </li>
		    </ul>
		  </div>
		</nav>
	</div> <!-- .container -->
</section> <!-- #navigation-section -->

<section id="lecture-detail">
	<div class="container">
		<div class="lecture-detail-wrapper">
			<div class="course-name my-title">
				#agkt{courseName}
			</div> 
			<div class="lecture-content">
				<div class="lecture-name">
					<div class="row">
						<div class="col-2 text-center">
							<!-- <a class="btn btn-light" href="#"><i class="fas fa-chevron-left"></i> Previous</a> -->
						</div> <!-- .col-2 -->
						<div class="col-8 text-center">
							<div class="my-header">#agkt{lectureTitle}</div>
						</div> <!-- .col-8 -->
						<div class="col-2 text-center">
							<!-- <a class="btn btn-light" href="#">Next <i class="fas fa-chevron-right"></i></a> -->
						</div> <!-- .col-2 -->
					</div> <!-- .row -->
				</div> <!-- .lecture-name -->
				<div class="content-group">
					<div class="my-header">Description</div>
					<p>#agkt{lectureDescription}</p>
				</div> <!-- .content-group -->
				<div class="lecture-video">
					<video class="img-fluid" controls>
						<source src="#agkt{lectureVideo}" type="video/mp4">
						Your browser can't run this video.
					</video>
				</div> <!-- .lecture-video -->
				<div class="content-group">
					<div class="my-header">Lecture PDF</div>
					<ul class="lecture-pdf">
						<li><a href="#agkt{lecturePDF}" target="_blank">Lecture pdf</a></li>
					</ul> <!-- .lecture-pdf -->
				</div> <!-- .content-group -->
			</div>
		</div> <!-- .lecture-detail-wrapper -->
	</div> <!-- .container -->
</section> <!-- #lecture-detail -->