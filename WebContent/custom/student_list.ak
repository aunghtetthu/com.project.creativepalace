<section id="navigation-section">
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		  	<ul class="navbar-nav mr-auto">
			    
		    </ul>
		    <form action="student_list" method="POST" class="form-inline my-2 my-lg-0">
		    	<input name="studentEmail" class="form-control mr-sm-2" type="search" placeholder="Student Email" aria-label="Search" required>
		        <button name="btnSubmit" class="btn btn-outline-success my-2 my-sm-0" type="submit" value="submit">Search</button>
		    </form>
		  </div>
		</nav>
	</div> <!-- .container -->
</section> <!-- #navigation-section -->

<section id="table-section">
	<div class="container">
	
		#if(#agkt{noResult})
			<div class="my-title">Search Result by #agkt{searchKey}</div>
			
			<div class="my-not-found">
				<p><span>No Result is found.</span></p>
			</div>
		#endIf
		
		#if(#agkt{showSearch})
		<div id="search-result">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="my-header" scope="col" colspan="6">Search By: #agkt{searchKey}</th>
					</tr>
				    <tr>
				        <th scope="col">ID</th>
				        <th scope="col">Name</th>
				        <th scope="col">Email</th>
				        <th scope="col">Phone</th>
				        <th scope="col">Address <br>(Home/Street/Township/City)</th>
				        <th scope="col"></th>
				    </tr>
				</thead>
				<tbody>
					#akStartLoop{searchList}
				    <tr>
				        <th scope="row">#akLoopItem{searchList[studentID]}</th>
				        <td>#akLoopItem{searchList[studentName]}</td>
				        <td>#akLoopItem{searchList[studentEmail]}</td>
				        <td>#akLoopItem{searchList[studentPhone]}</td>
				        <td>#akLoopItem{searchList[studentHome]} <br>
					        #akLoopItem{searchList[studentStreet]}<br>
						    #akLoopItem{searchList[studentTownship]}<br>
							#akLoopItem{searchList[studentCity]}</td>
				        <td><img class="img-fluid img-thumbnail staff-profile" src="#agkt{baseUrl}/student_photo/#akLoopItem{searchList[studentPhoto]}"></td>
				    </tr>
				    #akEndLoop{searchList}
				</tbody>
			</table>
		</div> <!-- #search-result -->
		#endIf
		#if(#agkt{noStudent})
			<div class="my-title">Student List</div>
			
			<div class="my-not-found">
				<p><span>There is no student.</span></p>
			</div>
		#endIf
		
		#if(#agkt{showStudent})
		<div class="my-title">All Student List</div>
		
		<div id="student-table">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="my-header" scope="col" colspan="6">Total Student: #agkt{totalStudent}</th>
					</tr>
				    <tr>
				        <th scope="col">ID</th>
				        <th scope="col">Name</th>
				        <th scope="col">Email</th>
				        <th scope="col">Phone</th>
				        <th scope="col">Address <br>(Home/Street/Township/City)</th>
				        <th scope="col"></th>
				    </tr>
				</thead>
				<tbody>
				    #akStartLoop{sList}
				    <tr>
				        <th scope="row">#akLoopItem{sList[studentID]}</th>
				        <td>#akLoopItem{sList[studentName]}</td>
				        <td>#akLoopItem{sList[studentEmail]}</td>
				        <td>#akLoopItem{sList[studentPhone]}</td>
				        <td>#akLoopItem{sList[studentHome]} <br>
					        #akLoopItem{sList[studentStreet]}<br>
						    #akLoopItem{sList[studentTownship]}<br>
							#akLoopItem{sList[studentCity]}</td>
				        <td><img src="#agkt{baseUrl}/student_photo/#akLoopItem{sList[studentPhoto]}" class="img-fluid img-thumbnail staff-profile" ></td>
				    </tr>
				    #akEndLoop{sList}
				</tbody>
			</table>
		</div> <!-- #student-table -->
		#endIf
	</div> <!-- .container -->
</section> <!-- #table-section -->