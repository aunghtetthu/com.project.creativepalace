<section id="navigation-section">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
			    <li class="nav-item">
			        <a class="btn btn-success my-2 my-sm-0" href="#agkt{back}"><i class="far fa-arrow-alt-circle-left"></i> Back</a>
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
				#if(#agkt{showEnrollMessage})
				<div><span class="content-title">Course ID Code:</span> #agkt{courseID}</div>
				#endIf
			</div> <!-- .content-group -->
			
			#if(#agkt{showEnrollButton})
			<div class="content-group text-left">
				<a class="btn btn-success btn-lg" href="enroll_course?courseID=#agkt{courseID}" role="button">Enroll Now</a>
			</div> <!-- .content-group -->
			#endIf
			
			#if(#agkt{showEnrollMessage})
			
			<div class="content-group">
				<div class="bank-account">
					<div class="content-title">Bank Account</div>
					<div>
						<p><strong>KBZ Bank account:</strong> 8273 8273 8472 4153 7352</p>
						<p><strong>CB Bank account:</strong> 1923 5352 8493 4725 7384</p>
						<p><strong>Ayeyarwady Bank account:</strong> 9205 1634 2522 3953 2739</p>
					</div>
				</div> <!-- .bank-account -->
			</div> <!-- .content-group -->
			<div class="content-group">
				<div class="enroll-message">
					<p>Your enrollment has been recorded. We will contact you soon by either phone or email. Please pay course fee to one of above mentioned bank accounts. After the payment is confirmed, you can learn the lectures. Pleace contact for more information.</p>
					<p><strong>Email:</strong> enroll@creativepalace.com <br>
					<strong>Phone:</strong> 09-97354637</p>
				</div> <!-- .enroll-message -->
			</div> <!-- .content-group -->
			#endIf
			
		</div> <!-- .course-content-wrapper -->
	</div> <!-- .container -->
</section> <!-- #course-detail -->

#if(#agkt{showLecture})
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
#endIf