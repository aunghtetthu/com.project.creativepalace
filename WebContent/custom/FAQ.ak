<section id="navigation-section">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
			    <li class="nav-item">
			        <a class="nav-link menu-active" href="FAQ">FAQ</a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="FAQ_add">Upload FAQ</a>
			    </li>
		    </ul>
		  </div>
		</nav>
	</div> <!-- .container -->
</section> <!-- #navigation-section -->


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
