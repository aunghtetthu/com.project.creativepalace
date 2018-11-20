<section id="navigation-section">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
			    <li class="nav-item">
			        <a class="nav-link menu-active" href="certificate_candidate">Canditate</span></a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="certificate_certified_student">Certified Student</a>
			    </li>
		    </ul>
		    <form action="certificate_candidate" method="POST" class="form-inline my-2 my-lg-0">
		    	<input name="studentEmail" class="form-control mr-sm-2" type="search" placeholder="Student Email" aria-label="Search" required>
		        <button name="btnSubmit" class="btn btn-outline-success my-2 my-sm-0" type="submit" value="submit">Search</button>
		    </form>
		  </div>
		</nav>
	</div> <!-- .container -->
</section> <!-- #navigation-section -->

<section id="payment-enrollment">
	<div class="container">
		#if(#agkt{noResult})
			<div class="my-title">Search Result</div>
			
			<div class="my-not-found">
				<p><span>No Result is found.</span></p>
			</div>
		#endIf
		
		#if(#agkt{showSearch})
		<div class="my-title">Search Result</div>

			#akStartLoop{searchList}
			<div class="enrollment-box">
				<div class="row">
					<div class="col-6">
						<div class="my-header">Student Data</div>
						<div><strong>Name: </strong>#akLoopItem{searchList[studentName]}</div>
						<div><strong>Email: </strong>#akLoopItem{searchList[studentEmal]}</div>
						<div><strong>Phone: </strong>#akLoopItem{searchList[studentPhone]}</div>
					</div> <!-- .col-6 -->
					<div class="col-6">
						<div class="my-header">Course Data</div>
						<div><strong>ID: </strong>#akLoopItem{searchList[courseID]}</div>
						<div><strong>Name: </strong>#akLoopItem{searchList[courseName]}</div>
						<div><strong>Student's Mark: </strong>#akLoopItem{searchList[studentMark]}</div>
					</div> <!-- .col-6 -->
					<div class="col-12">
						<form action="certificate_upload" method="POST" enctype="multipart/form-data">
							<input type="hidden" name="studentCourseID" value="#akLoopItem{searchList[studentCourseID]}">
							<div class="form-group">
							    <label for="exampleFormControlFile1"><strong>Upload Certificate: </strong></label>
							    <input type="file" name="certificate" class="form-control-file" id="exampleFormControlFile1" required>
							</div>
							<div class="text-left">
								<button type="submit" name="btnSubmit" class="btn btn-success" value="Submit">Submit</button>
							</div>
						</form>
					</div> <!-- .col-12 -->
				</div> <!-- .row -->
			</div> <!-- .enrollment-box -->
			#akEndLoop{searchList}
		#endIf
		
		#if(#agkt{noCandidate})
			<div class="my-title">Candidate List</div>
			
			<div class="my-not-found">
				<p><span>There is no candidate.</span></p>
			</div>
		#endIf
		
	#if(#agkt{showCandidate})
		<div class="my-title">Candidate List</div>

		#akStartLoop{icList}
		<div class="enrollment-box">
				<div class="row">
					<div class="col-6">
						<div class="my-header">Student Data</div>
						<div><strong>Name: </strong>#akLoopItem{icList[studentName]}</div>
						<div><strong>Email: </strong>#akLoopItem{icList[studentEmal]}</div>
						<div><strong>Phone: </strong>#akLoopItem{icList[studentPhone]}</div>
					</div> <!-- .col-6 -->
					<div class="col-6">
						<div class="my-header">Course Data</div>
						<div><strong>ID: </strong>#akLoopItem{icList[courseID]}</div>
						<div><strong>Name: </strong>#akLoopItem{icList[courseName]}</div>
						<div><strong>Student's Mark: </strong>#akLoopItem{icList[studentMark]}</div>
					</div> <!-- .col-6 -->
					<div class="col-12">
						<form action="certificate_upload" method="POST" enctype="multipart/form-data">
							<input type="hidden" name="studentCourseID" value="#akLoopItem{icList[studentCourseID]}">
							<div class="form-group">
							    <label for="exampleFormControlFile1"><strong>Upload Certificate: </strong></label>
							    <input type="file" name="certificate" class="form-control-file" id="exampleFormControlFile1" required>
							</div>
							<div class="text-left">
								<button type="submit" name="btnSubmit" class="btn btn-success" value="Submit">Submit</button>
							</div>
						</form>
					</div> <!-- .col-12 -->
				</div> <!-- .row -->
			</div> <!-- .enrollment-box -->
		#akEndLoop{icList}
	#endIf
		
	</div> <!-- .container -->
</section> <!-- #payment-enrollment -->
