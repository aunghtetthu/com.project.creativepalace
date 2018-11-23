<section id="navigation-section">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
			    <li class="nav-item">
			        <a class="nav-link" href="FAQ">FAQ</a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link menu-active" href="FAQ_add">Upload FAQ</a>
			    </li>
		    </ul>
		  </div>
		</nav>
	</div> <!-- .container -->
</section> <!-- #navigation-section -->

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
					<textarea name="question" class="form-control" id="exampleFormControlTextarea1" rows="5" placeholder="Enter FAQ question." required></textarea>
				</div>
				<div class="form-group"> <!-- ###need to change### -->
					<label>Answer:</label>
					<textarea name="answer" class="form-control" id="exampleFormControlTextarea1" rows="5" placeholder="Enter FAQ answer." required></textarea>
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