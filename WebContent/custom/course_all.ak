<section id="navigation-section">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
			    <li class="nav-item">
			        <a class="nav-link menu-active" href="course_all">All</span></a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="course_application">Application</a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="course_professional">Professional</a>
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
	
	#if(#agkt{showSearch})
		<div id="search-result">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="my-header" scope="col" colspan="2">Search Result: #agkt{searchResultCount}</th>
						<th class="my-header" scope="col" colspan="1">Search by: #agkt{searchBy}</th>
						<th class="my-header" scope="col" colspan="1">Keyword: #agkt{keyword}</th>
					</tr>
				    <tr>
				        <th scope="col">ID</th>
				        <th scope="col">Course Name</th>
				        <th scope="col">Status</th>
				        <th scope="col"></th>
				    </tr>
				</thead>
				<tbody>
				
				#akStartLoop{searchResult}
				    <tr>
				        <th scope="row">#akLoopItem{searchResult[courseID]}</th>
				        <td>#akLoopItem{searchResult[courseName]}</td>
				        <td>#akLoopItem{searchResult[courseStatus]}</td>
				        <td>
				        	<a class="btn btn-success" href="course_detail?courseID=#akLoopItem{searchResult[courseID]}">View Detail</a>
				        	<a class="btn btn-success" href="exam_question?courseID=#akLoopItem{searchResult[courseID]}">Exam Question</a>
				        </td>
				    </tr>
				#akEndLoop{searchResult}
				
				    <tr>
				        <td>-</td>
				        <td>-</td>
				        <td>-</td>
				        <td>-</td>
				    </tr>
				</tbody>
			</table>
		</div> <!-- #search-result -->
	#endIf

	#if(#agkt{showAll})
		<div id="allActiveCourse-table">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="my-header" scope="col" colspan="4">All Active Course Result: #agkt{activeCourseCount}</th>
					</tr>
				    <tr>
				        <th scope="col">ID</th>
				        <th scope="col">Course Name</th>
				        <th scope="col">Category</th>
				        <th scope="col"></th>
				    </tr>
				</thead>
				<tbody>
				
				#akStartLoop{activeCourseList}
				    <tr>
				        <th scope="row">#akLoopItem{activeCourseList[courseID]}</th>
				        <td>#akLoopItem{activeCourseList[courseName]}</td>
				        <td>#akLoopItem{activeCourseList[courseCategory]}</td>
				        <td>
				        	<a class="btn btn-success" href="course_detail?courseID=#akLoopItem{activeCourseList[courseID]}">View Detail</a>
				        	<a class="btn btn-success" href="exam_question?courseID=#akLoopItem{activeCourseList[courseID]}">Exam Question</a>
				        </td>
				    </tr>
				#akEndLoop{activeCourseList}
				
				    <tr>
				        <td>-</td>
				        <td>-</td>
				        <td>-</td>
				        <td>-</td>
				    </tr>
				</tbody>
			</table>
		</div> <!-- #allActiveCourse-table -->

		<div id="allInactiveCourse-table">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="my-header" scope="col" colspan="4">All Inactive Course Result: #agkt{inactiveCourseCount}</th>
					</tr>
				    <tr>
				        <th scope="col">ID</th>
				        <th scope="col">Course Name</th>
				        <th scope="col">Category</th>
				        <th scope="col"></th>
				    </tr>
				</thead>
				<tbody>
				
				#akStartLoop{inactiveCourseList}
				    <tr>
				        <th scope="row">#akLoopItem{inactiveCourseList[courseID]}</th>
				        <td>#akLoopItem{inactiveCourseList[courseName]}</td>
				        <td>#akLoopItem{inactiveCourseList[courseCategory]}</td>
				        <td>
				        	<a class="btn btn-success" href="course_detail?courseID=#akLoopItem{inactiveCourseList[courseID]}">View Detail</a>
				        	<a class="btn btn-success" href="exam_question?courseID=#akLoopItem{inactiveCourseList[courseID]}">Exam Question</a>
				        </td>
				    </tr>
				#akEndLoop{inactiveCourseList}
				
				    <tr>
				        <td>-</td>
				        <td>-</td>
				        <td>-</td>
				        <td>-</td>
				    </tr>
				</tbody>
			</table>
		</div> <!-- #allInactiveCourse-table -->
	#endIf

	</div> <!-- .container -->
</section> <!-- #table-section -->