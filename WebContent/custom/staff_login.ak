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
				<h2>A new staff? <a href="#">Create an account.</a></h2>
			</div> <!-- .question-text -->
			<form action="staff_login" method="POST">
				<div class="form-title">
					Staff Log in
				</div>
				<div class="form-group">
					<label>Email:</label>
					<input type="text" name="email" class="form-control" placeholder="Enter your email" required/>
				</div>
				<div class="form-group">
					<label>Password:</label>
					<input type="password" name="password" class="form-control" placeholder="Enter password" required/>
				<div class="text-left">
					<button type="submit" name="btnSubmit" class="btn btn-success" value="Submit">Submit</button>
				</div>
			</form>
		</div> <!-- .form-wrapper -->
	</div><!-- .container -->
</section> <!-- #form-section -->