<section id="navigation-section">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
			    <li class="nav-item">
			        <a class="nav-link" href="course_all">All</span></a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="course_application">Application</a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link menu-active" href="course_professional">Professional</a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="course_upload">Upload Course</a>
			    </li>
		    </ul>
		    <form action="course_all" method="POST" class="form-inline my-2 my-lg-0">
		    	<select name="searchType" class="form-control" id="exampleFormControlSelect1" required>
			        <option value="course_id">Course ID</option>
			        <option value="course_name">Name</option>
			    </select>
		        <input name="searchKey" class="form-control mr-sm-2" type="search" placeholder="Search course" aria-label="Search" required>
		        <button name="btnSubmit" class="btn btn-outline-success my-2 my-sm-0" type="submit" value="submit">Search</button>
		    </form>
		  </div>
		</nav>
	</div> <!-- .container -->
</section> <!-- #navigation-section -->

<section id="table-section">
	<div class="container">
		
		<div id="allActiveProfessional-table">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="my-header" scope="col" colspan="3">Active Professional Course Result: #agkt{activeCount}</th>
					</tr>
				    <tr>
				        <th scope="col">ID</th>
				        <th scope="col">Course Name</th>
				        <th scope="col"></th>
				    </tr>
				</thead>
				<tbody>
				
				#akStartLoop{activeList}
				    <tr>
				        <th scope="row">#akLoopItem{activeList[courseID]}</th>
				        <td>#akLoopItem{activeList[courseName]}</td>
				        <td><a class="btn btn-success" href="course_detail?courseID=#akLoopItem{activeList[courseID]}">View Detail</a></td>
				    </tr>
				#akEndLoop{activeList}
				
				    <tr>
				        <th scope="row">-</th>
				        <td>-</td>
				        <td>-</td>
				    </tr>
				</tbody>
			</table>
		</div> <!-- #allActiveProfessional-table -->

		<div id="allInactiveProfessional-table">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="my-header" scope="col" colspan="3">Inactive Professional Course Result: #agkt{inactiveCount}</th>
					</tr>
				    <tr>
				        <th scope="col">ID</th>
				        <th scope="col">Course Name</th>
				        <th scope="col"></th>
				    </tr>
				</thead>
				<tbody>
				
				#akStartLoop{inactiveList}
				    <tr>
				        <th scope="row">#akLoopItem{inactiveList[courseID]}</th>
				        <td>#akLoopItem{inactiveList[courseName]}</td>
				        <td><a class="btn btn-success" href="course_detail?courseID=#akLoopItem{inactiveList[courseID]}">View Detail</a></td>
				    </tr>
				#akEndLoop{inactiveList}
				
				    <tr>
				        <th scope="row">-</th>
				        <td>-</td>
				        <td>-</a></td>
				    </tr>
				</tbody>
			</table>
		</div> <!-- #allInactiveProfessional-table -->

	</div> <!-- .container -->
</section> <!-- #table-section -->