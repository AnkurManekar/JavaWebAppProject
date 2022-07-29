<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Student Rating Project</title>

<!-- Font Icon -->
<link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="main">

		
		<!-- Create Assignment -->
		<section>
			<div class="container">
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="images/image.jpg" alt="sing up image">
						</figure>
						<a href="login.jsp" class="image-link">Back to Creating Assignment Page</a>
					</div>

					<div class="signin-form">
						<h2 class="form-title">Update Date Of Submission and Points</h2>
						<form action="updatingServlet" method="Post">
							
							<div class="form-group">
								 Enter Student Name: <input type="text" name="studentname" id="studentname" placeholder="Enter Student Name" />
							</div>
							
							<div class="form-group">
							 	Enter Subject Name: <input type=text name="subject" id="subject" placeholder="Enter Subject Name" />
							</div>
							
							<div class="form-group">
								 Enter Assignment Category: <input type="text" name="assignmentCategory" id="assignmentCategory" placeholder="Enter Assignment Category" />
							</div>
							
							<div class="form-group">
								 Enter New Date Of Submission for Update: <input type="text" name="dateOfSubmission" id="dateOfSubmission" placeholder="Enter Date Of Submission" />
							</div>
							
							<div class="form-group">
								 Enter New Points for Update: <input type="text" name="points" id="points" placeholder="Enter Points" />
							</div>
							<div class="form-group form-button">
								<input type="submit" name="click" id="click" class="form-submit" value="Update"/>
							</div>					
							
						</form>
					</div>
				</div>
			</div>
		</section>
	</div>
 
</body>
</html>