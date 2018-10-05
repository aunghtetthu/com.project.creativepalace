<section id="navigation-section">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
			    <li class="nav-item">
			        <a class="btn btn-success my-2 my-sm-0" href="course_detail.html?courseID=#agkt{courseID}"><i class="far fa-arrow-alt-circle-left"></i> Back</a>
			    </li>
		    </ul>
		  </div>
		</nav>
	</div> <!-- .container -->
</section> <!-- #navigation-section -->

<section id="form-section">
	<div class="container">
		<div class="form-wrapper">
			<form action="lecture_edit" method="POST">
				<div class="form-title">
					Edit Lecture '#agkt{lectureTitle}'
				</div>
				<input type="hidden" name="lectureID" value="#agkt{lectureID}">
				<div class="form-group">
					<label>Description:</label>
					<textarea name="description" class="form-control" id="exampleFormControlTextarea1" rows="5" placeholder="Write description for the course" required>#agkt{lectureDescription}</textarea>
				</div>
				<div class="text-left">
					<button type="submit" name="btnSubmit" class="btn btn-success" value="Submit">Submit</button>
				</div>
			</form>
		</div> <!-- .form-wrapper -->
	</div><!-- .container -->
</section> <!-- #form-section -->

#if(#agkt{success})
<script>
	alert('#agkt{successMessage}');
	location.assign('#agkt{locationAssign}');
</script>
#endIf