<section id="navigation-section">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
			    <li class="nav-item">
			        <a class="btn btn-success my-2 my-sm-0" href="course_detail?courseID=#agkt{courseID}"><i class="far fa-arrow-alt-circle-left"></i> Back</a>
			    </li>
		    </ul>
		  </div>
		</nav>
	</div> <!-- .container -->
</section> <!-- #navigation-section -->

<section id="form-section">
	<div class="container">
		<div class="form-wrapper">
			<form action="course_edit" method="POST">
				<div class="form-title">
					Edit Course "#agkt{courseName}"
				</div>
				<input type="hidden" name="courseID" value="#agkt{courseID}">
				<div class="form-group">
					<label>Duration:</label>
					<input type="text" name="duration" class="form-control" placeholder="Edit course duration" value="#agkt{courseDuration}" required/>
				</div>
				<div class="form-group">
					<label>Description:</label>
					<textarea name="description" class="form-control" id="exampleFormControlTextarea1" rows="5" placeholder="Write description for the course" required>#agkt{courseInfo}</textarea>
				</div>
				<div class="form-group"> <!-- ###need to change### -->
					<label>Syllabus:</label>
					<textarea name="syllabus" class="form-control" id="exampleFormControlTextarea1" rows="5" placeholder="Write syllabus of the course" required>#agkt{courseSyllabus}</textarea>
				</div>
				<div class="form-group">
					<label>Price (Kyats):</label>
					<input type="number" name="price" class="form-control" placeholder="Edit price" value="#agkt{coursePrice}" required/>
				</div>
				<div class="form-group"> <!-- ###need to change### -->
					<label>Status:</label>
					<select name="status" class="form-control">
						<option value="#agkt{courseStatus}">
							#agkt{courseStatus}
						</option>
					    <option value="active">Active</option>
					    <option value="inactive">Inactive</option>
				    </select>
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