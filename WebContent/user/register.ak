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
				<h2>Already have an account? <a href="login">Log in.</a></h2>
			</div> <!-- .question-text -->
			<form action="register" method="POST" enctype="multipart/form-data">
				<div class="form-title">
					Student Register Form
				</div>
				<div class="form-group">
					<label>Name:</label>
					<input type="text" name="name" class="form-control" placeholder="Enter your name:" required/>
				</div>
				<div class="form-group">
					<label>Email:</label>
					<input type="email" name="email" class="form-control" placeholder="Enter your email:" required/>
				</div>
				<div class="form-group">
					<label>Phone Number:</label>
					<input type="text" name="phoneNum" class="form-control" placeholder="Enter your phone number:" required/>
				</div>
				<div class="form-group address-input">
					<label>Address:</label>
					<input type="text" name="homeno" class="form-control first" placeholder="Enter your home number:" required/>
					<input type="text" name="street" class="form-control" placeholder="Enter your street:" required/>
					<input type="text" name="township" class="form-control" placeholder="Enter your township:" required/>
					<input type="text" name="city" class="form-control" placeholder="Enter your city:" required/>
				</div>
				<div class="form-group">
					<label>Password:</label>
					<input type="password" name="password" class="form-control" placeholder="Enter password" required/>
				</div>
				<div class="form-group">
					<label>Confirm Password:</label>
					<input type="password" name="confrimPassword" class="form-control" placeholder="Re-enter password" required/>
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

#if(#agkt{success})
<script>
	alert('#agkt{successMessage}');
	location.assign('#agkt{locationAssign}');
</script>
#endIf