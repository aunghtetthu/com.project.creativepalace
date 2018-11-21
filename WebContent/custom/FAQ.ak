<section id="FAQ-section">
	<div class="container">
		<div class="FAQ-wrapper">
			<div class="my-header">FAQ (Frequently Asked Questions)</div>
			
			#if(#agkt{noFAQ})
			<div class="my-not-found">
				<p><span>There is no FAQ.</span></p>
			</div>
			#endIf
			
			#if(#agkt{faqShow})
			#akStartLoop{fList}
			<div class="FAQ-box">
				<div class="FAQ-question font-weight-bold">
					#akLoopItem{fList[question]}
				</div> <!-- .FAQ-question -->
				<div class="FAQ-answer">
					#akLoopItem{fList[answer]}
				</div> <!-- .FAQ-answer -->
				<div><a href="FAQ_delete?faqid=#akLoopItem{fList[faqID]}" class="btn btn-danger">Delete</a></div>
			</div> <!-- .FAQ-box -->
			#akEndLoop{fList}
			#endIf
			
		</div> <!-- .FAQ-wrapper -->
	</div> <!-- .container -->
</section> <!-- #FAQ-section -->
