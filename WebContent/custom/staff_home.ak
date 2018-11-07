<!-- ==========================================================================
#user-profile-section starts here
=========================================================================== -->
<section id="user-profile-section">
	<div class="container">
		<div class="row">
			<div class="col-7">
				<div class="user-profile">
					<h1 class="my-header">Your Profile:</h1>
					<ul>
						<li>Name: #agkt{name}</li>
						<li>Role: #agkt{role}</li>
						<li>Email: #agkt{email}</li>
						<li>Phone: #agkt{phone}</li>
					</ul>
					<a href="#" class="btn btn-success">Edit</a>
				</div>
			</div> <!-- .col-7 -->
			<div class="col-5">
				<div class="profile-photo text-right">
					<!-- <img class="img-fluild img-thumbnail" src="http://localhost:8080/com.project.creativepalace/#agkt{photo}">  -->
					<img class="img-fluid img-thumbnail" src="#agkt{photo}">
				</div>
			</div> <!-- .col-5 -->
		</div> <!-- .row -->
	</div> <!-- .container -->
</section> <!-- #user-profile-section -->
<!-- ==========================================================================
#user-profile-section ends here
=========================================================================== -->

<!-- ==========================================================================
#task-section starts here
=========================================================================== -->
<section id="categorized-section">
	<div class="container">
		<div class="text-center">
			<h1 class="my-title">Your Task</h1>
		</div> <!-- .task-center -->
		<div class="row">
		
		#if(#agkt{adminTask})
			<div class="col-4">
				<a href="staff_list" class="category text-center">
					<i class="fas fa-user-tie"></i>
					<p class="my-header">Staff List</p>
				</a>
			</div> <!-- .col-4 -->
			<div class="col-4">
				<a href="course_all" class="category text-center">
					<i class="fas fa-book"></i>
					<p class="my-header">Courses</p>
				</a>
			</div> <!-- .col-4 -->
			<div class="col-4">
				<a href="#" class="category text-center">
					<i class="far fa-question-circle"></i>
					<p class="my-header">FAQ</p>
				</a>
			</div> <!-- .col-4 -->
			<div class="col-4">
				<a href="#" class="category text-center">
					<i class="fas fa-user-graduate"></i>
					<p class="my-header">Students</p>
				</a>
			</div> <!-- .col-4 -->
			<div class="col-4">
				<a href="#" class="category text-center">
					<i class="fas fa-certificate"></i>
					<p class="my-header">Certificate</p>
				</a>
			</div> <!-- .col-4 -->
		#endIf
		
		#if(#agkt{adminTeacherTask})
			<div class="col-4">
				<a href="#" class="category text-center">
					<i class="fas fa-users"></i>
					<p class="my-header">Discussion Forum</p>
				</a>
			</div> <!-- .col-4 -->
		#endIf
		
		#if(#agkt{financeTask})
			<div class="col-4">
				<a href="payment_enrollment" class="category text-center">
					<i class="far fa-credit-card"></i>
					<p class="my-header">Payment</p>
				</a>
			</div> <!-- .col-4 -->
		#endIf
		</div> <!-- .row -->
	</div> <!-- .container -->
</section> <!-- #task-section -->
<!-- ==========================================================================
#task-section ends here
=========================================================================== -->