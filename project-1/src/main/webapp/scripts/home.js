let userNav = document.getElementById('my-nav');

let userString = sessionStorage.getItem('currentUser');

let mainPage = document.getElementById('homePage');

if (userString === null) {
	// window.location = "http://localhost:8080/project-1/";
} else {
	
	let currentUser = JSON.parse(userString); // parse the data that we see == to that attribute
	
	if (currentUser.userRole != 1) {
		userNav.innerHTML = 
			`<ul class="navbar-nav mr-auto"> 
				<li class="nav-item">
					<a class="nav-link" onclick="viewPendingReimbursements()"; ">View Reimbursements<span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" onclick="logout()">Logout</a>
				</li>
			</ul>`;
		mainPage.innerHTML= `
			<div id="sectional">
				<a id="subReimb" onclick="viewPendingReimbursements()">Submit New Reimbursement Request</a>
			</div>
			<div id="sectional">
				<a id="viewReq" onclick="">View Pending Requests</a>
			</div>
			<div id="sectional">
				<a id="myAccount" onclick="myAccount()">View Account</a>
			</div>`;
	}
}

const getEmpPending = () => {
	let activeEmployee = JSON.parse(userString);
	let employee = {id: activeEmployee.id};
	console.log(activeEmployee.id);
	let xhr = new XMLHttpRequest();
	xhr.open("GET", "http://localhost:8080/project-1/myReimbursements")
	xhr.send(JSON.stringify(employee))

}



const viewPendingReimbursements = () => {
	let xhr = new XMLHttpRequest();

	xhr.open("GET", "http://localhost:8080/project-1/allReimbursements")
	
}
			
const reimbursementApp = () => {
    window.location = "http://localhost:8080/project-1/newreimbursement.html";
}

const submitForm = () => {
	let xhr = new XMLHttpRequest();
	
}

const logout = () => {
		
	let xhr = new XMLHttpRequest();
	
	xhr.open("POST", "http://localhost:8080/project-1/logout");
	xhr.send();
	
	sessionStorage.removeItem('currentUser');
	window.location = "http://localhost:8080/project-1/";
	
}
