<section id="navigation-section">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
			    <li class="nav-item">
			        <a class="btn btn-success my-2 my-sm-0" href="staff_home"><i class="far fa-arrow-alt-circle-left"></i> Back</a>
			    </li>
		    </ul>
		  </div>
		</nav>
	</div> <!-- .container -->
</section> <!-- #navigation-section -->

#if(#agkt{error})
<section id="error-message">
	<div class="container">
		<div class="error-box">
			<span class="font-weight-bold">Error:</span> #agkt{errorMessage}
		</div>
	</div> <!-- .container -->
</section> <!-- #error-message -->
#endIf

<section id="form-section">
	<div class="container">
		<div class="form-wrapper">
			<form action="course_upload" method="POST" enctype="multipart/form-data">
				<div class="form-title">
					Upload Course
				</div>
				<div class="form-group">
					<label>Course Name:</label>
					<input type="text" name="name" class="form-control" placeholder="Enter course name" required/>
				</div>
				<div class="form-group">
					<label>Duration:</label>
					<input type="text" name="duration" class="form-control" placeholder="Enter course duration" required/>
				</div>
				<div class="form-group">
					<label>Description:</label>
					<textarea name="description" class="form-control" rows="5" placeholder="Write description for the course" required></textarea>
				</div>
				<div class="form-group"> <!-- ###need to change### -->
					<label>Syllabus:</label>
					<textarea name="syllabus" class="form-control" rows="5" placeholder="Write syllabus of the course" required></textarea>
				</div>
				<div class="form-group">
					<label>Price (Kyats):</label>
					<input type="number" name="price" class="form-control" placeholder="Enter price" required/>
				</div>
				<div class="form-group"> <!-- ###need to change### -->
					<label>Category:</label>
					<select name="category" class="form-control">
					    <option value="application">Application Course</option>
					    <option value="professional">Professional Course</option>
				    </select>
				</div>
				<div class="form-group">
					<label>Cover Photo:</label>
					<input type="file" name="photo" class="form-control-file" required/>
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