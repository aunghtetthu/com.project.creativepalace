<section id="navigation-section">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
			    <li class="nav-item">
			        <a class="btn btn-success my-2 my-sm-0" href="course_all"><i class="far fa-arrow-alt-circle-left"></i> Back</a>
			    </li>
			     <li class="nav-item">
			        <a class="nav-link" href="exam_question?courseID=#agkt{courseID}">Questions</span></a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="exam_question_upload?courseID=#agkt{courseID}">Add Question</a>
			    </li>
		    </ul>
		  </div>
		</nav>
	</div> <!-- .container -->
</section> <!-- #navigation-section -->

<section id="form-section">
	<div class="container">
		<div class="form-wrapper">
			<form action="exam_question_edit" method="POST">
				<div class="form-title">
					Edit Question for "#agkt{courseName}"
				</div>
				<input type="hidden" name="courseID" value="#agkt{courseID}">
				<input type="hidden" name="examQuestionID" value="#agkt{examQuestionID}">
				<div class="form-group">
					<label>Question Number: </label>
					<input type="number" name="questionNumber" class="form-control" placeholder="Enter the qeustion number." value="#agkt{questionNumber}" required/>
				</div>
				<div class="form-group">
					<label>Question:</label>
					<textarea name="question" class="form-control" rows="2" placeholder="Enter the question." required>#agkt{question}</textarea>
				</div>
				<div class="form-group">
					<label>Choice 1:</label>
					<textarea name="choice1" class="form-control" rows="2" placeholder="Enter the answer for choice 1." required>#agkt{choice1}</textarea>
				</div>
				<div class="form-group">
					<label>Choice 2:</label>
					<textarea name="choice2" class="form-control" rows="2" placeholder="Enter the answer for choice 2." required>#agkt{choice2}</textarea>
				</div>
				<div class="form-group">
					<label>Choice 3:</label>
					<textarea name="choice3" class="form-control" rows="2" placeholder="Enter the answer for choice 3." required>#agkt{choice3}</textarea>
				</div>
				<div class="form-group">
					<label>Choice 4:</label>
					<textarea name="choice4" class="form-control" rows="2" placeholder="Enter the answer for choice 4." required>#agkt{choice4}</textarea>
				</div>
				<div class="form-group">
					<label>Choice 5:</label>
					<textarea name="choice5" class="form-control" rows="2" placeholder="Enter the answer for choice 5." required>#agkt{choice5}</textarea>
				</div>
				<div class="form-group">
					<label>Answer:</label><br>
					<input type="radio" name="answer" value="#agkt{answer}" checked> 
					#agkt{answer}<br>
					<input type="radio" name="answer" value="choice1" required> choice1<br>
					<input type="radio" name="answer" value="choice2"> choice2<br>
					<input type="radio" name="answer" value="choice3"> choice3<br>
					<input type="radio" name="answer" value="choice4"> choice4<br>
					<input type="radio" name="answer" value="choice5"> choice5<br>
				</div>
				<div class="form-group">
					<label>Mark: </label>
					<input type="number" name="mark" class="form-control" placeholder="Enter the mark." value="#agkt{mark}" required/>
				</div>
				<div class="text-left">
					<button type="submit" name="btnSubmit" class="btn btn-success" value="Submit">Edit Question</button>
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