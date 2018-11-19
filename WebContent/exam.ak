<section id="exam-section">
	<div class="container">
		<div class="exam-question-wrapper">
			<form action="exam" method="POST">

				<div class="my-header">#agkt{courseName} Exam</div>
				<input type="hidden" name="courseID" value="#agkt{courseID}">
				
				#akStartLoop{eqList}
				<div class="question-wrapper">
					<div><strong>Question #akLoopItem{eqList[questionNumber]}: </strong></div>
					<div>#akLoopItem{eqList[question]}</div>
					<div class="answer-wrapper">
						<input type="radio" name="answer#akLoopItem{eqList[questionNumber]}" value="choice1" required> 
						#akLoopItem{eqList[choice1]}<br>
						<input type="radio" name="answer#akLoopItem{eqList[questionNumber]}" value="choice2"> 
						#akLoopItem{eqList[choice2]}<br>
						<input type="radio" name="answer#akLoopItem{eqList[questionNumber]}" value="choice3"> 
						#akLoopItem{eqList[choice3]}<br>
						<input type="radio" name="answer#akLoopItem{eqList[questionNumber]}" value="choice4"> 
						#akLoopItem{eqList[choice4]}<br>
						<input type="radio" name="answer#akLoopItem{eqList[questionNumber]}" value="choice5"> 
						#akLoopItem{eqList[choice5]}<br>
					</div> <!-- .answer-wrapper -->
				</div> <!-- .question-wrapper -->
				#akEndLoop{eqList}

				<div class="text-left">
					<button type="submit" name="btnSubmit" class="btn btn-success" value="Submit">Submit</button>
				</div>

			</form>
		</div> <!-- .exam-question-wrapper -->
	</div> <!-- .container -->
</section> <!-- #exam-section -->

#if(#agkt{success})
<script>
	alert('#agkt{successMessage}');
	location.assign('#agkt{locationAssign}');
</script>
#endIf