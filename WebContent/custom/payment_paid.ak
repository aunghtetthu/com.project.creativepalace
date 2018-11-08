<section id="navigation-section">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
			    <li class="nav-item">
			        <a class="nav-link" href="payment_enrollment">Enrollment</span></a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link menu-active" href="payment_paid">Payment List</a>
			    </li>
		    </ul>
		    <form action="payment_paid" method="POST" class="form-inline my-2 my-lg-0">
		    	<input name="studentEmail" class="form-control mr-sm-2" type="search" placeholder="Student Email" aria-label="Search" required>
		        <input name="courseID" class="form-control mr-sm-2" type="search" placeholder="CourseID" aria-label="Search" required>
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
					<div><strong>Email: </strong>#akLoopItem{searchList[studentEmail]}</div>
					<div><strong>Phone: </strong>#akLoopItem{searchList[studentPhone]}</div>
				</div> <!-- .col-6 -->
				<div class="col-6">
					<div class="my-header">Course Data</div>
					<div><strong>ID: </strong>#akLoopItem{searchList[courseID]}</div>
					<div><strong>Name: </strong>#akLoopItem{searchList[courseName]}</div>
					<div><strong>Price: </strong>#akLoopItem{searchList[coursePrice]} kyats</div>
				</div> <!-- .col-6 -->
				<div class="col-12">
					This payment is confirmed by <a href="staff_detail?staffID=#akLoopItem{searchList[staffID]}">
					#akLoopItem{searchList[staffName]}
					</a>.
				</div> <!-- .col-12 -->
				<div class="col-12">
					<a class="btn btn-danger" href="payment_cancel?studentCourseID=#akLoopItem{searchList[studentCourseID]}">Cancel Payment</a>
				</div> <!-- .col-12 -->
			</div> <!-- .row -->
		</div> <!-- .enrollment-box -->
		#akEndLoop{searchList}
	#endIf

	#if(#agkt{showEnrollment})
		<div class="my-title">Payment List</div>

		#akStartLoop{enrollmentList}
		<div class="enrollment-box">
			<div class="row">
				<div class="col-6">
					<div class="my-header">Student Data</div>
					<div><strong>Name: </strong>#akLoopItem{enrollmentList[studentName]}</div>
					<div><strong>Email: </strong>#akLoopItem{enrollmentList[studentEmail]}</div>
					<div><strong>Phone: </strong>#akLoopItem{enrollmentList[studentPhone]}</div>
				</div> <!-- .col-6 -->
				<div class="col-6">
					<div class="my-header">Course Data</div>
					<div><strong>ID: </strong>#akLoopItem{enrollmentList[courseID]}</div>
					<div><strong>Name: </strong>#akLoopItem{enrollmentList[courseName]}</div>
					<div><strong>Price: </strong>#akLoopItem{enrollmentList[coursePrice]} kyats</div>
				</div> <!-- .col-6 -->
				<div class="col-12">
					This payment is confirmed by <a href="staff_detail?staffID=#akLoopItem{enrollmentList[staffID]}">
					#akLoopItem{enrollmentList[staffName]}
					</a>.
				</div> <!-- .col-12 -->
				<div class="col-12">
					<a class="btn btn-danger" href="payment_cancel?studentCourseID=#akLoopItem{enrollmentList[studentCourseID]}">Cancel Payment</a>
				</div> <!-- .col-12 -->
			</div> <!-- .row -->
		</div> <!-- .enrollment-box -->
		#akEndLoop{enrollmentList}
	#endIf

	</div> <!-- .container -->
</section> <!-- #payment-enrollment -->