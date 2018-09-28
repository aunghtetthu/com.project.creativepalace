<section id="navigation-section">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
			    <li class="nav-item">
			        <a class="nav-link" href="course_all">All</span></a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="course_application">Application</a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="course_professional">Professional</a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="course_upload">Upload Course</a>
			    </li>
		    </ul>
		    <form action="course_all" method="POST" class="form-inline my-2 my-lg-0">
		    	<select name="searchType" class="form-control" id="exampleFormControlSelect1" required>
			        <option value="course_id">Course ID</option>
			        <option value="course_name">Name</option>
			    </select>
		        <input name="searchKey" class="form-control mr-sm-2" type="search" placeholder="Search course" aria-label="Search" required>
		        <button name="btnSubmit" class="btn btn-outline-success my-2 my-sm-0" type="submit" value="submit">Search</button>
		    </form>
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
			<div class="uploader">
				Uploaded by 
				<a href="staff_detail?staffID=#agkt{staffID}">
					#agkt{staffName}
				</a>
			</div> <!-- .uploader -->
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
				<a class="btn btn-success" href="course_edit?courseID=#agkt{courseID}" role="button">Edit</a>
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
				<div class="col-6 text-right">
					<a class="btn btn-success" href="lecture_upload" role="button">Add Lecture</a>
				</div> <!-- .col-6 -->
			</div>
			
			#if(#agkt{showMessage})
			<div class="my-title">No Lecture to Show.</div>
			#endIf
			
			#if(#agkt{showLecture})
			<table class="table table-bordered">
				<tbody>
				
				#akStartLoop{lectureList}
				    <tr>
				        <td>
					        <a href="lecture_detail?lectureID=#akLoopItem{lectureList[lectureID]}">
					    	    #akLoopItem{lectureList[lectureTitle]}
					        </a>
					    </td>
				        <td class="text-right">
				        	<a class="btn btn-success" href="lecture_edit?lectureID=#akLoopItem{lectureList[lectureID]}" role="button">Edit</a>
							<a class="btn btn-danger" href="lecture_delete?lectureID=#akLoopItem{lectureList[lectureID]}" role="button">Delete</a>
				        </td>
				    </tr>
				#akEndLoop{lectureList}
				</tbody>
			</table>
			#endIf
		</div>
	</div> <!-- .container -->
</section> <!-- #lecture-list -->