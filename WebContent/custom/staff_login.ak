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
				<h2>A new staff? <a href="staff_register">Create an account.</a></h2>
			</div> <!-- .question-text -->
			<form action="staff_login" method="POST">
				<div class="form-title">
					Staff Log in
				</div>
				<div class="form-group">
					<label>Email:</label>
					<input type="email" name="email" class="form-control" placeholder="Enter your email" required/>
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