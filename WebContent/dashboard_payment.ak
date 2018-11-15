<section id="navigation-section">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
			    <li class="nav-item">
			        <a class="nav-link" href="dashboard_course">My Courses</span></a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link menu-active" href="dashboard_payment">Payment History</a>
			    </li>
		    </ul>
		  </div>
		</nav>
	</div> <!-- .container -->
</section> <!-- #navigation-section -->

<section id="payment-enrollment">
	<div class="container">
		
		<div class="my-title">Dashboard</div>
		#if(#agkt{noPayment})
		<div class="my-not-found">
			<p><span>No payment history.</span></p>
		</div>
		#endIf
		
		#if(#agkt{paymentShow})
		<div class="my-header mb-3">Payment History</div>
		
		#akStartLoop{pdList}
		<div class="enrollment-box">
			<div class="row">
				<div class="col-6">
					<div class="my-header">Payment Data</div>
					<div><strong>Status: </strong>Paid</div>
					<div><strong>Amount: </strong>#akLoopItem{pdList[amount]}</div>
					<div><strong>Date: </strong>#akLoopItem{pdList[date]}</div>
				</div> <!-- .col-6 -->
				<div class="col-6">
					<div class="my-header">Course Data</div>
					<div><strong>ID: </strong>#akLoopItem{pdList[courseID]}</div>
					<div><strong>Name: </strong>#akLoopItem{pdList[courseName]}</div>
					<div><strong>Enroll Date: </strong>#akLoopItem{pdList[enrollDate]}</div>
				</div> <!-- .col-6 -->
			</div> <!-- .row -->
		</div> <!-- .enrollment-box -->
		#akEndLoop{pdList}
		
		#endIf
	</div> <!-- .container -->
</section> <!-- #payment-enrollment -->