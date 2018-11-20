<section id="form-section">
	<div class="container">
		<div class="form-wrapper">
			<form action="student_edit" method="POST">
				<div class="form-title">
					Edit Profile
				</div>
				<input type="hidden" name="email" value="#agkt{email}">
				<div class="form-group">
					<label>Name:</label>
					<input type="text" name="name" class="form-control" placeholder="Enter your name:" value="#agkt{name}" required/>
				</div>
				<div class="form-group">
					<label>Phone Number:</label>
					<input type="text" name="phoneNum" class="form-control" placeholder="Enter your phone number:" value="#agkt{phone}" required/>
				</div>
				<div class="form-group address-input">
					<label>Address:</label>
					<input type="text" name="homeno" class="form-control first" placeholder="Enter your home number:" value="#agkt{home}" required/>
					<input type="text" name="street" class="form-control" placeholder="Enter your street:" value="#agkt{street}" required/>
					<input type="text" name="township" class="form-control" placeholder="Enter your township:" value="#agkt{township}" required/>
					<input type="text" name="city" class="form-control" placeholder="Enter your city:" value="#agkt{city}" required/>
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
