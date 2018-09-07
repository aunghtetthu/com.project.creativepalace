#if(#agkt{errorExistence})
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
			<div class="question-text">
				<h2>Already have an account? <a href="#">Sign in.</a></h2>
			</div> <!-- .question-text -->
			<form action="staff_register" method="POST" enctype="multipart/form-data">
				<div class="form-title">
					Staff Register Form
				</div>
				<div class="form-group">
					<label>Name:</label>
					<input type="text" name="name" class="form-control" placeholder="Enter your name:" required/>
				</div>
				<div class="form-group">
					<label>Email:</label>
					<input type="text" name="email" class="form-control" placeholder="Enter your email:" required/>
				</div>
				<div class="form-group">
					<label>Phone Number:</label>
					<input type="text" name="phone" class="form-control" placeholder="Enter your phone number:" required/>
				</div>
				<div class="form-group"> <!-- ###need to change### -->
					<label>Role:</label>
					<select name="role" class="form-control">
					    <option value="admin">Admin</option>
					    <option value="finance-staff">Finance Staff</option>
					    <option value="teacher">Teacher</option>
				    </select>
				</div>
				<div class="form-group">
					<label>Password:</label>
					<input type="password" name="password" class="form-control" placeholder="Enter password" required/>
				</div>
				<div class="form-group">
					<label>Confirm Password:</label>
					<input type="password" name="confirmPassword" class="form-control" placeholder="Re-enter password" required/>
				</div>
				<div class="form-group">
					<label>Profile Photo:</label>
					<input type="file" name="photo" class="form-control-file" required/>
				</div>
				<div class="text-left">
					<button type="submit" name="btnSubmit" class="btn btn-success" value="Submit">Submit</button>
				</div>
			</form>
		</div> <!-- .form-wrapper -->
	</div><!-- .container -->
</section> <!-- #form-section -->