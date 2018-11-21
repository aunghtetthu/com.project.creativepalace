<section id="form-section">
	<div class="container">
		<div class="form-wrapper">
			<form action="FAQ_add" method="POST">
				<div class="form-title">
					Add FAQ
				</div>
				<input type="hidden" name="staffID" value="#agkt{staffID}">
				<div class="form-group">
					<label>Question:</label>
					<textarea name="question" class="form-control" id="exampleFormControlTextarea1" rows="5" placeholder="Write description for the course" required></textarea>
				</div>
				<div class="form-group"> <!-- ###need to change### -->
					<label>Answer:</label>
					<textarea name="answer" class="form-control" id="exampleFormControlTextarea1" rows="5" placeholder="Write syllabus of the course" required></textarea>
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