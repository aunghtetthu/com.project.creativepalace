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
			        <a class="nav-link menu-active" href="exam_question?courseID=#agkt{courseID}">Questions</span></a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="exam_question_upload?courseID=#agkt{courseID}">Add Question</a>
			    </li>
		    </ul>
		  </div>
		</nav>
	</div> <!-- .container -->
</section> <!-- #navigation-section -->

<section id="exam-questions">
	<div class="container">
	<div class="my-header">Course Name: #agkt{courseName}</div>
	
	#akStartLoop{eqList}
		<div class="question-box">
			<div class="my-header">Question #akLoopItem{eqList[questionNumber]}</div>
			<div class="question-group">
				<div><strong>Question: </strong>#akLoopItem{eqList[question]}</div>
				<div><strong>Answer: </strong>#akLoopItem{eqList[answer]}</div>
				<div><strong>Mark: </strong>#akLoopItem{eqList[mark]}</div>
			</div>
			<div class="question-group">
				<div><strong>Answer Choices</strong></div>
				<div>
					<ol>
						<li>#akLoopItem{eqList[choice1]}</li>
						<li>#akLoopItem{eqList[choice2]}</li>
						<li>#akLoopItem{eqList[choice3]}</li>
						<li>#akLoopItem{eqList[choice4]}</li>
						<li>#akLoopItem{eqList[choice5]}</li>
					</ol>
				</div>
			</div>
			<div>
				<a class="btn btn-success" href="exam_question_edit?examQuestionID=#akLoopItem{eqList[examQuestionID]}&
				courseID=#agkt{courseID}">Edit</a>
				<a class="btn btn-danger" href="exam_question_delete?examQuestionID=#akLoopItem{eqList[examQuestionID]}&
				courseID=#agkt{courseID}">Delete</a>
			</div>
		</div> <!-- .question-box -->
	#akEndLoop{eqList}	
	
	</div> <!-- .container -->
</section> <!-- #exam-questions -->