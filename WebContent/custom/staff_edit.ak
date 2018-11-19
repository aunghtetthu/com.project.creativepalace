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

<section id="form-section">
	<div class="container">
		<div class="form-wrapper">
			<form action="staff_edit" method="POST">
				<div class="form-title">
					Edit Your Data
				</div>
				<input type="hidden" name="staffID" value="#agkt{staffID}">
				<div class="form-group">
					<label>Name:</label>
					<input type="text" name="name" class="form-control" placeholder="Enter your name:" value="#agkt{name}" required/>
				</div>
				<div class="form-group">
					<label>Email:</label>
					<input type="email" name="email" class="form-control" placeholder="Enter your email:" value="#agkt{email}" required/>
				</div>
				<div class="form-group">
					<label>Phone Number:</label>
					<input type="text" name="phone" class="form-control" placeholder="Enter your phone number:" value="#agkt{phonenumber}" required/>
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