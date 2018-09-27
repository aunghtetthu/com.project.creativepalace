<section id="navigation-section">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
			    <ul class="navbar-nav mr-auto">
				    <li class="nav-item">
				        <div><i class="fas fa-info-circle"></i> You are now uploading lecture for the course "#agkt{courseName}".</div>
				    </li>
			    </ul>
		    </div>
		</nav>
	</div> <!-- .container -->
</section> <!-- #navigation-section -->

#if(#agkt{successBox})
<section id="message-section">
	<div class="container">
		<div class="message-box success-box">
			<div class="message-icon success-icon-bg">
				<i class="far fa-check-circle"></i>
			</div>
			<div class="message-text">
				<span class="font-weight-bold">Done!</span> '#agkt{lectureTitle}' has been uploaded successfully. Please continue upload if there are still more lectures for the course. 
			</div>
			<div class="clearfix"></div>
		</div> <!-- .message-box -->
	</div> <!-- .container -->
</section> <!-- #message-section -->
#endIf

#if(#agkt{error})
<section id="message-section">
	<div class="container">
		<div class="message-box error-box">
			<div class="message-icon error-icon-bg">
				<i class="far fa-times-circle"></i>
			</div>
			<div class="message-text">
				<span class="font-weight-bold">Error:</span> #agkt{errorMessage}
			</div>
			<div class="clearfix"></div>
		</div> <!-- .message-box -->
	</div> <!-- .container -->
</section> <!-- #message-section -->
#endIf

<section id="form-section">
	<div class="container">
		<div class="form-wrapper">
			<div class="question-text">
				<h2>No more lecture to upload? <a href="course_all">Go 'Course' page.</a></h2>
			</div> <!-- .question-text -->
			<form action="lecture_upload" method="POST" enctype="multipart/form-data">
				<div class="form-title">
					Upload Lecture
				</div>
				<div class="form-group">
					<label>Lecture Title:</label>
					<input type="text" name="title" class="form-control" placeholder="Enter lecture title" required/>
				</div>
				<div class="form-group">
					<label>Description:</label>
					<textarea name="description" class="form-control" id="exampleFormControlTextarea1" rows="5" placeholder="Write description for the lecture" required></textarea>
				</div>
				<div class="form-group">
					<label>Lecture pdf:</label>
					<input type="file" name="lecturepdf" class="form-control-file" required/>
				</div>
				<div class="form-group">
					<label>Lecture video:</label>
					<input type="file" name="lecturevideo" class="form-control-file" required/>
				</div>
				<div class="text-left">
					<button type="submit" name="btnSubmit" class="btn btn-success" value="Submit">Submit</button>
				</div>
			</form>
		</div> <!-- .form-wrapper -->
	</div><!-- .container -->
</section> <!-- #form-section -->

