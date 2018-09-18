<section id="navigation-section">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
			    <li class="nav-item">
			        <a class="nav-link" href="#admin-table">Admin</span></a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="#finance-staff-table">Finance-Staff</a>
			    </li>
			    <li class="nav-item">
			        <a class="nav-link" href="#teacher-table">Teacher</a>
			    </li>
		    </ul>
		     <form action="staff_list" class="form-inline my-2 my-lg-0">
		    	<select name="searchType" class="form-control" id="exampleFormControlSelect1" required>
			        <option value="staff_id">ID</option>
			        <option value="staff_name">Name</option>
			        <option value="staff_email">Email</option>
			    </select>
		        <input name="searchKey" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" required>
		        <button name="btnSubmit" class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		        <a class="btn btn-outline-success my-2 my-sm-0" href="staff_list">Show All</a>
		    </form>
		  </div>
		</nav>
	</div> <!-- .container -->
</section> <!-- #navigation-section -->

<section id="table-section">
	<div class="container">
	
	#if(#agkt{searchResult})
		<div id="search-result">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="my-header" scope="col" colspan="2">Search Result: #agkt{resultCount}</th>
						<th class="my-header" scope="col" colspan="2">Search by: #agkt{fieldName}</th>
						<th class="my-header" scope="col" colspan="2">Keyword: #agkt{data}</th>
					</tr>
				    <tr>
				        <th scope="col">ID</th>
				        <th scope="col">Name</th>
				        <th scope="col">Email</th>
				        <th scope="col">Phone</th>
				        <th scope="col">Role</th>
				        <th scope="col"></th>
				    </tr>
				</thead>
				<tbody>
				
					#akStartLoop{resultList}
						<tr>
					        <th scope="row">#akLoopItem{resultList[staffID]}</th>
					        <td>#akLoopItem{resultList[staffName]}</td>
					        <td>#akLoopItem{resultList[staffEmail]}</td>
					        <td>#akLoopItem{resultList[staffPhone]}</td>
					        <td>#akLoopItem{resultList[staffRole]}</td>
					        <td><a class="btn btn-success" href="#">View Detail</a></td>
					    </tr>
					#akEndLoop{resultList}
								
				</tbody>
			</table>
		</div> <!-- #search-result -->
	#endIf
	
	#if(#agkt{showAll})
		<div id="admin-table">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="my-header" scope="col" colspan="3">Amdin</th>
						<th class="my-header" scope="col" colspan="3">Total Result: #agkt{adminCount}</th>
					</tr>
				    <tr>
				        <th scope="col">ID</th>
				        <th scope="col">Name</th>
				        <th scope="col">Email</th>
				        <th scope="col">Phone</th>
				        <th scope="col">Role</th>
				        <th scope="col"></th>
				    </tr>
				</thead>
				<tbody>
				
				#akStartLoop{adminList}
					<tr>
				        <th scope="row">#akLoopItem{adminList[staffID]}</th>
				        <td>#akLoopItem{adminList[staffName]}</td>
				        <td>#akLoopItem{adminList[staffEmail]}</td>
				        <td>#akLoopItem{adminList[staffPhone]}</td>
				        <td>#akLoopItem{adminList[staffRole]}</td>
				        <td><a class="btn btn-success" href="#">View Detail</a></td>
				    </tr>
				#akEndLoop{adminList}
				
				<tr>
			        <th scope="row"></th>
			        <td></td>
			        <td></td>
			        <td></td>
			        <td></td>
			        <td></td>
			    </tr>
				
				</tbody>
			</table>
		</div> <!-- #admin-table -->

		<div id="finance-staff-table">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="my-header" scope="col" colspan="3">Finance-Staff</th>
						<th class="my-header" scope="col" colspan="3">Total Result: #agkt{financeCount}</th>
					</tr>
				    <tr>
				        <th scope="col">ID</th>
				        <th scope="col">Name</th>
				        <th scope="col">Email</th>
				        <th scope="col">Phone</th>
				        <th scope="col">Role</th>
				        <th scope="col"></th>
				    </tr>
				</thead>
				<tbody>
				
				#akStartLoop{financeList}
					<tr>
				        <th scope="row">#akLoopItem{financeList[staffID]}</th>
				        <td>#akLoopItem{financeList[staffName]}</td>
				        <td>#akLoopItem{financeList[staffEmail]}</td>
				        <td>#akLoopItem{financeList[staffPhone]}</td>
				        <td>#akLoopItem{financeList[staffRole]}</td>
				        <td><a class="btn btn-success" href="#">View Detail</a></td>
				    </tr>
				#akEndLoop{financeList}
				
				<tr>
			        <th scope="row"></th>
			        <td></td>
			        <td></td>
			        <td></td>
			        <td></td>
			        <td></td>
			    </tr>
				
				</tbody>
			</table>
		</div> <!-- #finance-staff-table -->

		<div id="teacher-table">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="my-header" scope="col" colspan="3">Teacher</th>
						<th class="my-header" scope="col" colspan="3">Total Result: #agkt{teacherCount}</th>
					</tr>
				    <tr>
				        <th scope="col">ID</th>
				        <th scope="col">Name</th>
				        <th scope="col">Email</th>
				        <th scope="col">Phone</th>
				        <th scope="col">Role</th>
				        <th scope="col"></th>
				    </tr>
				</thead>
				<tbody>
				    
				#akStartLoop{teacherList}
					<tr>
				        <th scope="row">#akLoopItem{teacherList[staffID]}</th>
				        <td>#akLoopItem{teacherList[staffName]}</td>
				        <td>#akLoopItem{teacherList[staffEmail]}</td>
				        <td>#akLoopItem{teacherList[staffPhone]}</td>
				        <td>#akLoopItem{teacherList[staffRole]}</td>
				        <td><a class="btn btn-success" href="#">View Detail</a></td>
				    </tr>
				#akEndLoop{teacherList}
				
				<tr>
			        <th scope="row"></th>
			        <td></td>
			        <td></td>
			        <td></td>
			        <td></td>
			        <td></td>
			    </tr>
				
				</tbody>
			</table>
		</div> <!-- #teacher-table -->
	#endIf
	
	</div> <!-- .container -->
</section> <!-- #table-section -->