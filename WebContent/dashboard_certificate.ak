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
			        <a class="nav-link" href="dashboard_payment">Payment History</a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="dashboard_exam">Exam</a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link menu-active" href="dashboard_certificate">Certificate</a>
			    </li>
		    </ul>
		  </div>
		</nav>
	</div> <!-- .container -->
</section> <!-- #navigation-section -->

<section id="course-content">
	<div class="container">

		<div class="my-title">Dashboard</div>
	
		#if(#agkt{noCertificate})
		<div class="my-not-found">
			<p><span>You do not have any certificate yet.</span></p>
		</div>
		#endIf
		
		#if(#agkt{certificateShow})
		<div class="my-header">Certificate</div>
		<table class="table">
			<thead class="thead-dark">
			    <tr>
				    <th scope="col">Course Name</th>
				    <th scope="col">Mark</th>
				    <th scope="col">Certificate</th>
			    </tr>
			</thead>
			<tbody>
			#akStartLoop{icList}
			    <tr>
				    <td>#akLoopItem{icList[courseName]}</td>
				    <td>#akLoopItem{icList[studentMark]}</td>
				    <td><a href="#agkt{baseUrl}/certificate/
				    #akLoopItem{icList[certificatePDF]}" target="_blank">Click here.</a></td>
			    </tr>
			#akEndLoop{icList}
			</tbody>
		</table>
		#endIf
	</div> <!-- .container -->
</section> <!-- #course-content -->